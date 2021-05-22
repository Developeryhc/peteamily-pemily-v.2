package contact.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import contact.model.vo.Contact;
import contact.model.vo.Emp;

public class ContactDao {

	public int insertPartner(Connection conn, Contact c) {
		PreparedStatement pstmt = null;
		int result =0;
		String query = "insert into partner values(partner_seq.nextval,?,?,?,?,?,1,?,?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, c.getPartnerName());
			pstmt.setString(2, c.getPartnerEmp());
			pstmt.setString(3, c.getPhone());
			pstmt.setString(4, c.getEmail());
			pstmt.setString(5, c.getContent());
			pstmt.setString(6, c.getPartnerSort());
			pstmt.setString(7, c.getFilepath());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public ArrayList<Emp> selectAllEmp(Connection conn,int store) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Emp> list = new ArrayList<Emp>();
		String query = "select * from emp where emp_store ="+store;
		
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Emp e = new Emp();
				e.setEmpEnter(rset.getString("emp_enter"));
				e.setEmpGender(rset.getString("emp_gender"));
				e.setEmpGrade(rset.getInt("emp_grade"));
				e.setEmpName(rset.getString("emp_name"));
				e.setEmpNo(rset.getInt("emp_no"));
				e.setEmpPhone(rset.getString("emp_phone"));
				e.setEmpStore(rset.getInt("emp_store"));
				e.setFilepath(rset.getString("emp_path"));
				e.setEmpJob(rset.getString("emp_job"));
				e.setEmpAddr(rset.getString("emp_addr"));
				list.add(e);
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

	public ArrayList<Contact> selectAllPartner(Connection conn,String sort) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Contact> list = new ArrayList<Contact>();
		String query = "select * from partner where partner_sort = '"+sort+"'";
		
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Contact c = new Contact();
				c.setContent(rset.getString("partner_content"));
				c.setEmail(rset.getString("partner_email"));
				c.setPartnerEmp(rset.getString("partner_emp"));
				c.setPartnerName(rset.getString("partner_name"));
				c.setPartnerSort(rset.getString("partner_sort"));
				c.setPhone(rset.getString("partner_phone"));
				c.setFilepath(rset.getString("filepath"));
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

	public int insertEmp(Connection conn, Emp e) {
		PreparedStatement pstmt = null;
		int result =0;
		String query = "insert into emp values(emp_seq.nextval,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, e.getEmpId());
			pstmt.setString(2, e.getEmpPw());
			pstmt.setString(3, e.getEmpName());
			pstmt.setInt(4, e.getEmpGrade());
			pstmt.setString(5, e.getEmpGender());
			pstmt.setString(6, e.getEmpPhone());
			pstmt.setString(7, e.getEmpAddr());
			pstmt.setInt(8, e.getEmpStore());
			pstmt.setString(9, e.getEmpEnter());
			pstmt.setString(10, e.getFilename());
			pstmt.setString(11, e.getFilepath());
			pstmt.setString(12, e.getEmpJob());
			result = pstmt.executeUpdate();
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	

	

}
