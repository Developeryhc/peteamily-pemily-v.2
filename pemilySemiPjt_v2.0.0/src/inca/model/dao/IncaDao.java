package inca.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ca.model.vo.Adopt;
import ca.model.vo.Ca;
import common.JDBCTemplate;
import inca.model.vo.Inca;

public class IncaDao {
	
	// 한가지 타입만 조회
	public ArrayList<Adopt> selectOneTypeInca(Connection conn, int incaNo, int start, int end) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Adopt> adopt = new ArrayList<Adopt>();
		String query = "SELECT * FROM (SELECT ROWNUM AS RNUM, I.* FROM (SELECT * FROM INCA WHERE INCA_AN = ? AND NOT INCA_CONDITION = 0)I) JOIN CA ON INCA_NO = CA.CA_AN WHERE RNUM BETWEEN ? AND ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, incaNo);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Adopt a = new Adopt();
				Inca i = new Inca();
				Ca c = new Ca();
				c.setCaTitle(rset.getString("ca_title"));
				c.setCaAn(rset.getInt("ca_an"));
				i.setIncaNo(rset.getInt("inca_no"));
				i.setIncaName(rset.getString("inca_name"));
				i.setIncaGender(rset.getString("inca_gender"));
				i.setIncaMonth(rset.getInt("inca_month"));
				i.setIncaCondition(rset.getInt("inca_condition"));
				i.setIncaPrice(rset.getInt("inca_price"));
				i.setIncaDate(rset.getString("inca_date"));
				i.setIncaStore(rset.getInt("inca_store"));
				i.setIncaPic(rset.getString("inca_pic"));
				i.setIncaPath(rset.getString("inca_path"));
				a.setInca(i);
				a.setCa(c);
				adopt.add(a);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return adopt;
	}
	public int InsertInca(Connection conn, Inca i) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "INSERT INTO inca VALUES(inca_seq.NEXTVAL, ?, ?, ?, ?, ?, ?, DEFAULT, ?, ?, ?)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, i.getIncaAn());
			pstmt.setString(2, i.getIncaName());
			pstmt.setString(3, i.getIncaGender());
			pstmt.setInt(4, i.getIncaMonth());
			pstmt.setInt(5, i.getIncaCondition());
			pstmt.setInt(6, i.getIncaPrice());
			pstmt.setInt(7, i.getIncaStore());
			pstmt.setString(8, i.getIncaPic());
			pstmt.setString(9, i.getIncaPath());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	public ArrayList<Inca> selectAllInca(Connection conn, int start, int end) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Inca> list = new ArrayList<Inca>();
		String query = "select * from (select rownum as sort, inca.* from(select * from inca order by inca_no desc) inca) where sort between ? and ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Inca inca = new Inca();
				inca.setIncaAn(rset.getInt("inca_an"));
				inca.setIncaCondition(rset.getInt("inca_condition"));
				inca.setIncaDate(rset.getString("inca_date"));
				inca.setIncaGender(rset.getString("inca_gender"));
				inca.setIncaMonth(rset.getInt("inca_month"));
				inca.setIncaNo(rset.getInt("inca_no"));
				inca.setIncaPath(rset.getString("inca_path"));
				inca.setIncaPic(rset.getString("inca_pic"));
				inca.setIncaStore(rset.getInt("inca_store"));
				inca.setIncaName(rset.getString("inca_name"));
				inca.setIncaPrice(rset.getInt("inca_price"));
				inca.setSort(rset.getInt("sort"));
				list.add(inca);
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
	public int selectTotalListCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select count(*) as count from inca";
		int totalCount = 0;
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				totalCount = rset.getInt("count");
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
	public Adopt selectOneCa(Connection conn, int incaNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Adopt adopt = new Adopt();
		String query = "SELECT * FROM (SELECT * FROM INCA JOIN CA ON INCA_NO = CA.CA_AN WHERE INCA_NO = ? AND NOT INCA_CONDITION = 0)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, incaNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				Inca inca = new Inca();
				Ca ca = new Ca();
				inca.setIncaAn(rset.getInt("inca_an"));
				inca.setIncaCondition(rset.getInt("inca_condition"));
				inca.setIncaDate(rset.getString("inca_date"));
				inca.setIncaGender(rset.getString("inca_gender"));
				inca.setIncaMonth(rset.getInt("inca_month"));
				inca.setIncaNo(rset.getInt("inca_no"));
				inca.setIncaPath(rset.getString("inca_path"));
				inca.setIncaPic(rset.getString("inca_pic"));
				inca.setIncaStore(rset.getInt("inca_store"));
				inca.setIncaName(rset.getString("inca_name"));
				inca.setIncaPrice(rset.getInt("inca_price"));
				ca.setCaTitle(rset.getString("ca_title"));
				ca.setCaContent(rset.getString("ca_content"));
				adopt.setInca(inca);
				adopt.setCa(ca);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return adopt;
	}

	public Inca selectOneInca(Connection conn, int incaNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Inca inca = null;
		String query = "select * from inca where inca_no=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, incaNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				inca = new Inca();
				inca.setIncaAn(rset.getInt("inca_an"));
				inca.setIncaCondition(rset.getInt("inca_condition"));
				inca.setIncaDate(rset.getString("inca_date"));
				inca.setIncaGender(rset.getString("inca_gender"));
				inca.setIncaMonth(rset.getInt("inca_month"));
				inca.setIncaNo(rset.getInt("inca_no"));
				inca.setIncaPath(rset.getString("inca_path"));
				inca.setIncaPic(rset.getString("inca_pic"));
				inca.setIncaStore(rset.getInt("inca_store"));
				inca.setIncaName(rset.getString("inca_name"));
				inca.setIncaPrice(rset.getInt("inca_price"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return inca;
	}
	public int incaModify(Connection conn, Inca inca, int incaNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "update inca set inca_price=?, inca_condition=?, inca_store=? where inca_no=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, inca.getIncaPrice());
			pstmt.setInt(2, inca.getIncaCondition());
			pstmt.setInt(3, inca.getIncaStore());
			pstmt.setInt(4, incaNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	public int incaDelete(Connection conn, int incaNo) {
		PreparedStatement pstmt = null;
		int result=0;
		String query = "delete from inca where inca_no=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, incaNo);
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
