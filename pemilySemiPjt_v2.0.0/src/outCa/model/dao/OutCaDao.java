package outCa.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import inca.model.vo.Inca;
import outCa.model.vo.OutCa;
import outCa.model.vo.OutCaTable;

public class OutCaDao {

	public ArrayList<OutCa> selectAllInPro(Connection conn, int start, int end) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<OutCa> list = new ArrayList<OutCa>();
		String query = "select * from(select rownum as sort, outca.* from(select * from outca order by outca_no desc) outca) where sort between ? and ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				OutCa oca = new OutCa();
				oca.setOutCaAn(rset.getInt("outCa_an"));
				oca.setOutCaCon(rset.getString("outCa_con"));
				oca.setOutCaDate(rset.getString("outCa_date"));
				oca.setOutCaEmp(rset.getString("outCa_emp"));
				oca.setOutCaMi(rset.getString("outCa_mi"));
				oca.setOutCaNo(rset.getInt("outCa_no"));
				oca.setOutCaPath(rset.getString("outCa_path"));
				oca.setOutCaPrice(rset.getInt("outCa_price"));
				oca.setOutCaStore(rset.getInt("outCa_store"));
				oca.setSort(rset.getInt("sort"));
				list.add(oca);
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
		String query = "select count(*) as count from outca";
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

	public int updateOutCa(Connection conn, int memberNo, int incaNo, Inca i) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "INSERT INTO outca VALUES(outca_seq.NEXTVAL, ?, ?";
		return 0;
	}

	public OutCaTable selectOneOutCaTable(Connection conn, int memberNo, int incaNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		OutCaTable oct = null;
		String query = "SELECT I.inca_no, I.inca_store, I.inca_price, C.ca_writer, M.member_id FROM inca I, (SELECT ca_an, ca_writer FROM ca) C, (SELECT member_no, member_id FROM member) M WHERE M.member_no = ? AND C.ca_an = ? AND I.inca_no = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memberNo);
			pstmt.setInt(2, incaNo);
			pstmt.setInt(3, incaNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				oct = new OutCaTable();
				oct.setOutcaNo(rset.getInt("inca_no"));
				oct.setOutcaStore(rset.getInt("inca_store"));
				oct.setOutcaPrice(rset.getInt("inca_price"));
				oct.setOutcaEmp(rset.getString("ca_writer"));
				oct.setOutcaMember(rset.getString("member_id"));
				System.out.println(oct.getOutcaMember());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return oct;
	}

	public int updateMember(Connection conn, OutCaTable oct) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "UPDATE member SET member_an =? WHERE member_id = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, oct.getOutcaNo());
			pstmt.setString(2, oct.getOutcaMember());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int insertOutCa(Connection conn, OutCaTable oct) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "INSERT INTO outca VALUES(outca_seq.NEXTVAL, ?, ?, ?, ?, DEFAULT, ?, 0, 0)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, oct.getOutcaNo());
			pstmt.setString(2, oct.getOutcaMember());
			pstmt.setInt(3, oct.getOutcaPrice());
			pstmt.setInt(4, oct.getOutcaStore());
			pstmt.setString(5, oct.getOutcaEmp());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

}
