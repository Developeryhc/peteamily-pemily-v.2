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

	public int totalCount(Connection conn, int incaNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int totalCount = 0;
		String query = "SELECT COUNT(*) CNT FROM (SELECT * FROM INCA JOIN CA ON INCA_NO = CA.CA_AN WHERE INCA_AN = ? AND NOT INCA_CONDITION = 0)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, incaNo);
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

	

}
