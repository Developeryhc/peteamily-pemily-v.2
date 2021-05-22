package faq.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import common.JDBCTemplate;
import faq.model.dao.FaqDao;
import faq.model.vo.Faq;

public class FaqService {

	public ArrayList<Faq> selectFaqList() {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Faq> list = new FaqDao().selectFaqList(conn);
		JDBCTemplate.close(conn);
		return list;
	}

	public int deleteFaq(int faqNo) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new FaqDao().deleteFaq(conn,faqNo);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}JDBCTemplate.close(conn);
		return result;
	}

	public int insertFaq(Faq f) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new FaqDao().insertFaq(conn, f);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

}
