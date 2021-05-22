package ca.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import ca.model.dao.CaDao;
import ca.model.vo.Ca;
import common.JDBCTemplate;

public class CaService {
	public ArrayList<Ca> CaAllSelect() {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Ca> ca = new CaDao().CaAllSelect(conn);
		JDBCTemplate.close(conn);
		return ca;
	}

	public ArrayList<Ca> CaOneTypeSelect(int incaNo) {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Ca> ca = new CaDao().CaOneTypeSelect(conn, incaNo);
		JDBCTemplate.close(conn);
		return ca;
	}

	public int totalCount(int incaNo) {
		Connection conn = JDBCTemplate.getConnection();
		int totalCount = new CaDao().totalCount(conn, incaNo);
		JDBCTemplate.close(conn);
		return totalCount;
	}
	
	



}
