package employee.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import employee.model.vo.Employee;

public class EmployeeDao {

	public ArrayList<Employee> selectAllEmployee(Connection conn, int start, int end) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Employee> list = new ArrayList<Employee>();
		String query = "select * from(select rownum as sort, emp.* from(select * from emp order by emp_no desc) emp) where sort between ? and ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Employee e = new Employee();
				e.setEmpAddr(rset.getString("emp_addr"));
				e.setEmpEnter(rset.getString("emp_enter"));
				e.setEmpGender(rset.getString("emp_gender"));
				e.setEmpGrade(rset.getInt("emp_grade"));
				e.setEmpId(rset.getString("emp_id"));
				e.setEmpName(rset.getString("emp_name"));
				e.setEmpNo(rset.getInt("emp_no"));
				e.setEmpPath(rset.getString("emp_path"));
				e.setEmpPhone(rset.getString("emp_phone"));
				e.setEmpPic(rset.getString("emp_pic"));
				e.setEmpPw(rset.getString("emp_pw"));
				e.setEmpStore(rset.getInt("emp_store"));
				e.setSort(rset.getInt("sort"));
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

	public int totalListCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int count = 0;
		String query = "select count(*) as count from emp";
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				count = rset.getInt("count");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return count;
	}

}
