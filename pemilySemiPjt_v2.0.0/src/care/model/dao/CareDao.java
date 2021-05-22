package care.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.jsp.jstl.sql.Result;

import care.model.vo.Care;
import common.JDBCTemplate;

public class CareDao {

	public ArrayList<Care> selectCareList(Connection conn, int start, int end) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Care>list = new ArrayList<Care>();
		String query =   "select * from (select rownum as rnum, n. * from(select * from care order by care_no desc)n) where rnum between ? and ?";
		try {
			pstmt= conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Care c = new Care();
				c.setCareAn(rset.getInt("care_an"));
				c.setCareContent(rset.getString("care_content"));
				c.setCareDate(rset.getString("care_date"));
				c.setCareNo(rset.getInt("care_no"));
				c.setCarePath(rset.getString("care_path"));
				c.setCarePic(rset.getString("care_pic"));
				c.setCareTitle(rset.getString("care_title"));
				c.setCareWriter(rset.getString("care_writer"));
				c.setRnum(rset.getInt("rnum"));
				list.add(c);
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

	public int totalCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select count(*) as cnt from care"; //cnt는 별칭!
		int result = 0;  //여기서 쓰는 변수 int는 count에 대한 변수임!
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			if(rset.next()) {  //count 쿼리문을 쓰면 총게시물 : 85개! 이런식으로 나와서 if임
				result = rset.getInt("cnt");
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

	public Care selectOneCare(Connection conn, int careNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from care where care_no=?";
		Care c = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, careNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				c = new Care();
				c.setCareAn(rset.getInt("care_an"));
				c.setCareContent(rset.getString("care_content"));
				c.setCareDate(rset.getString("care_date"));
				c.setCareNo(rset.getInt("care_no"));
				c.setCarePath(rset.getString("care_path"));
				c.setCarePic(rset.getString("care_pic"));
				c.setCareTitle(rset.getString("care_title"));
				c.setCareWriter(rset.getString("care_writer"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return c;
	}

	public int deleteCare(Connection conn, int careNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "delete from care where care_no=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, careNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int insertCare(Connection conn, Care c) {
		PreparedStatement pstmt=null;
		int result =0;
		String query = "insert into care values(care_seq.nextval,?,?,?,?,to_char(sysdate,'yyyy-mm-dd'),?,?)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, c.getCareAn());
			pstmt.setString(2, c.getCareTitle());
			pstmt.setString(3, c.getCareWriter());
			pstmt.setString(4, c.getCareContent());
			pstmt.setString(5, c.getCarePic());
			pstmt.setString(6, c.getCarePath());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;

	}

	public int updateCare(Connection conn, Care c) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "update care set care_title=?, care_content=? where care_no=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, c.getCareTitle());
			pstmt.setString(2, c.getCareContent());
			pstmt.setInt(3, c.getCareNo());
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
