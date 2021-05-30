package ca.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import ca.model.dao.CaDao;
import ca.model.vo.Ca;
import ca.model.vo.CaPage;
import common.JDBCTemplate;
import inca.model.dao.IncaDao;
import inca.model.vo.IncaPage;

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

	public int totalCount(int incaAn) {
		Connection conn = JDBCTemplate.getConnection();
		int totalCount = new CaDao().totalCount(conn, incaAn);
		JDBCTemplate.close(conn);
		return totalCount;
	}

	public int insertCa(Ca ca) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new CaDao().insertCa(conn, ca);
		if(result > 0) {
			result = new IncaDao().updateInca(conn, ca.getCaAn());
			if(result >0) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public CaPage selectAllCa(int reqPage) {
		Connection conn = JDBCTemplate.getConnection();
		int printList = 10;
		int printNavi = 10;
		int end = printList * reqPage;
		int start = end-printList+1;
		ArrayList<Ca> list = new CaDao().selectAllCa(conn, start, end);
		int totalListCount = new CaDao().selectTotalListCount(conn);
		int totalList = totalListCount % printList == 0 ? totalListCount/printList : totalListCount/printList+1;
		String navigation = "<div class='listPageWrap'>";
		int aReqPage = ((reqPage-1)/printNavi)*printNavi+1;
		if(aReqPage != 1) {
			navigation += "<a href='/caList?reqPage="+(aReqPage-1)+"'><img src='images/moveButton/leftBtn1.png'></a>";
		}
		for(int i=0;i<printNavi;i++) {
			if(aReqPage == reqPage) {
				navigation += "<a class='activeNavi' href='/caList?reqPage="+aReqPage+"'>"+aReqPage+"</a>";
			}else {
				navigation += "<a href='/caList?reqPage="+aReqPage+"'>"+aReqPage+"</a>";				
			}
			aReqPage++;
			if(aReqPage > totalList) {
				break;
			}
		}
		if(aReqPage <= totalList) {
			navigation += "<a href='/caList?reqPage="+aReqPage+"'><img src='images/moveButton/rightBtn1.png'></a>";
		}
		navigation += "</div>";
		JDBCTemplate.close(conn);
		CaPage caPage = new CaPage(list,navigation);
		return caPage;
	}

}
