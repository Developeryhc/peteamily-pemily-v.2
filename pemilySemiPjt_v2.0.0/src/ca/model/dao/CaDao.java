package ca.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ca.model.vo.Ca;
import common.JDBCTemplate;

public class CaDao {

	public ArrayList<Ca> CaAllSelect(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Ca> ca = new ArrayList<Ca>();
		String query = "SELECT * FROM ca";
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Ca c = new Ca();
				c.setCaNo(rset.getInt("ca_no"));
				c.setCaAn(rset.getInt("ca_an"));
				c.setCaWriter(rset.getString("ca_writer"));
				c.setCaTitle(rset.getString("ca_title"));
				c.setCaContent(rset.getString("ca_content"));
				c.setCaDate(rset.getString("ca_date"));
				ca.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return ca;
	}

	public ArrayList<Ca> CaOneTypeSelect(Connection conn, int incaNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Ca> ca = new ArrayList<Ca>();
		String query = "SELECT * FROM ca WHERE ca_an = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, incaNo);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Ca c = new Ca();
				c.setCaNo(rset.getInt("ca_no"));
				c.setCaAn(rset.getInt("ca_an"));
				c.setCaWriter(rset.getString("ca_writer"));
				c.setCaTitle(rset.getString("ca_title"));
				c.setCaContent(rset.getString("ca_content"));
				c.setCaDate(rset.getString("ca_date"));
				ca.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return ca;
	}

	public int totalCount(Connection conn, int incaAn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int totalCount = 0;
		String query = "SELECT COUNT(*) CNT FROM (SELECT * FROM INCA JOIN CA ON INCA_NO = CA.CA_AN WHERE INCA_AN = ? AND INCA_CONDITION BETWEEN 1 AND 3)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, incaAn);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				totalCount = rset.getInt("CNT");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return totalCount;
	}

	public int insertCa(Connection conn, Ca ca) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "INSERT INTO ca VALUES(ca_seq.NEXTVAL, ?, ?, ?, ?, DEFAULT)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, ca.getCaAn());
			pstmt.setString(2, ca.getCaTitle());
			pstmt.setString(3, ca.getCaWriter());
			pstmt.setString(4, ca.getCaContent());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public ArrayList<Ca> selectAllCa(Connection conn, int start, int end) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT rownum AS rnum , I.inca_no, I.inca_an, I.inca_name, I.inca_price, I.inca_store, C.ca_writer, C.ca_date FROM inca I, (SELECT ca_an, ca_writer, ca_date FROM ca) C WHERE I.inca_condition = 4 AND I.inca_no = C.ca_an AND rownum BETWEEN ? AND ? ORDER BY I.inca_no DESC";
		ArrayList<Ca> list = new ArrayList<Ca>();
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Ca c = new Ca();
				c.setCaAn(rset.getInt("inca_no"));
				c.setCaKindNo(rset.getInt("inca_an"));
				c.setCaName(rset.getString("inca_name"));
				c.setCaDate(rset.getString("ca_date"));
				c.setCaEmp(rset.getString("ca_writer"));
				c.setCaPrice(rset.getInt("inca_price"));
				c.setCaStore(rset.getInt("inca_store"));
				c.setRnum(rset.getInt("rnum"));
				list.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public int selectTotalListCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT COUNT(*) AS COUNT FROM ca";
		int totalCount = 0;
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				totalCount = rset.getInt("COUNT");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return totalCount;
	}
}
