package outProduct.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import outProduct.model.vo.OutPro;

public class OutProductDao {

	public ArrayList<OutPro> selectAllOutProduct(Connection conn, int start, int end) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<OutPro> list = new ArrayList<OutPro>();
		String query = "select * from(select rownum as sort, n.* from(select * from outpro order by outpro_no desc) n) where sort between ? and ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				OutPro outPro = new OutPro();
				outPro.setOutProAmount(rset.getInt("outpro_amount"));
				outPro.setOutProDate(rset.getString("outpro_date"));
				outPro.setOutProMi(rset.getString("outpro_mi"));
				outPro.setOutProNo(rset.getInt("outpro_no"));
				outPro.setOutProPn(rset.getInt("outpro_pn"));
				outPro.setOutProPrice(rset.getInt("outpro_price"));
				outPro.setSort(rset.getInt("sort"));
				list.add(outPro);
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

	public int totalListCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		String query = "select count(*) as count from outpro";
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result = rset.getInt("count");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

}
