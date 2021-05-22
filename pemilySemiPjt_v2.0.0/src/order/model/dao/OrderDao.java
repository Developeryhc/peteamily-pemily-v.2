package order.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import member.model.vo.Member;
import order.model.vo.InPro;
import order.model.vo.Order;
import order.model.vo.OutPro;

public class OrderDao {
	public ArrayList<Order> order(Connection conn,String memberId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Order> list = new ArrayList<Order>();
		String query = "select outpro_no, inpro_name, inpro_price, outpro_amount from outpro join inpro on (outpro_pn = inpro_no) where outpro_mi =?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			rset = pstmt.executeQuery();
			while(rset.next() ) {
				Order or = new Order();
				or.setOrderAmount(rset.getInt("outpro_amount"));
				or.setOrderName(rset.getString("inpro_name"));
				or.setOrderNo(rset.getInt("outpro_no"));
				or.setOrderPrice(rset.getInt("inpro_price"));
				list.add(or);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}

		return list;
	}




}
