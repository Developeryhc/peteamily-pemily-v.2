package contact.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import common.JDBCTemplate;
import contact.model.dao.ContactDao;
import contact.model.vo.Contact;
import contact.model.vo.Emp;

public class ContactService {

	public int insertPartner(Contact c) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new ContactDao().insertPartner(conn,c);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public ArrayList<Emp> selectAllEmp(int store) {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Emp> list = new ContactDao().selectAllEmp(conn,store);
		JDBCTemplate.close(conn);
		return list;
	}

	public ArrayList<Contact> selectAllPartner(String sort) {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Contact> list = new ContactDao().selectAllPartner(conn,sort);
		JDBCTemplate.close(conn);
		return list;
	}

	public int insertEmp(Emp e) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new ContactDao().insertEmp(conn,e);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	

}
