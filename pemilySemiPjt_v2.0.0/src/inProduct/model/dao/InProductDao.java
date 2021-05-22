package inProduct.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import inPro.model.vo.InPro;

public class InProductDao {

	public int insertInProduct(Connection conn, InPro inPro) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "insert into inpro values(inpro_seq.nextval,?,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, inPro.getInProSn());
			pstmt.setString(2, inPro.getInProName());
			pstmt.setInt(3, inPro.getInProPrice());
			pstmt.setInt(4, inPro.getInProAmount());
			pstmt.setString(5, inPro.getInProPic());
			pstmt.setString(6, inPro.getInProPath());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public ArrayList<InPro> selectAllInProduct(Connection conn, int start, int end) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<InPro> list = new ArrayList<InPro>();
		String query = "select * from (select rownum as sort, inpro.* from(select * from inpro order by inpro_no desc) inpro) where sort between ? and ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				InPro inPro = new InPro();
				inPro.setInProAmount(rset.getInt("inpro_amount"));
				inPro.setInProName(rset.getString("inpro_name"));
				inPro.setInProNo(rset.getInt("inpro_no"));
				inPro.setInProPath(rset.getString("inpro_path"));
				inPro.setInProPic(rset.getString("inpro_pic"));
				inPro.setInProPrice(rset.getInt("inpro_price"));
				inPro.setInProSn(rset.getInt("inpro_sn"));
				inPro.setSort(rset.getInt("sort"));
				list.add(inPro);
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
		String query = "select count(*) as count from inpro";
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

	public InPro selectOneInPro(Connection conn, int inProNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		InPro inPro = null;
		String query = "select * from inpro where inpro_no=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, inProNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				inPro = new InPro();
				inPro.setInProAmount(rset.getInt("inpro_amount"));
				inPro.setInProName(rset.getString("inpro_name"));
				inPro.setInProNo(rset.getInt("inpro_no"));
				inPro.setInProPath(rset.getString("inpro_path"));
				inPro.setInProPic(rset.getString("inpro_pic"));
				inPro.setInProPrice(rset.getInt("inpro_price"));
				inPro.setInProSn(rset.getInt("inpro_sn"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return inPro;
	}

	public int inProDelete(Connection conn, int inProNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "delete from inpro where inpro_no=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, inProNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int modifyInPro(Connection conn, int inProNo, int inProPrice, int inProAmount) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "update inpro set inpro_price=?,inpro_amount=? where inpro_no=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, inProPrice);
			pstmt.setInt(2, inProAmount);
			pstmt.setInt(3, inProNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

}
