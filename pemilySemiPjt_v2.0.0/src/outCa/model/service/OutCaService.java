package outCa.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import common.JDBCTemplate;
import inca.model.vo.Inca;
import member.model.dao.MemberDao;
import outCa.model.dao.OutCaDao;
import outCa.model.vo.OutCa;
import outCa.model.vo.OutCaPage;
import outCa.model.vo.OutCaTable;

public class OutCaService {

	public OutCaPage selectAllOutCa(int reqPage) {
		Connection conn = JDBCTemplate.getConnection();
		int printList = 10;						//보여줄 게시글 갯수
		int printNavi = 10;						//보여줄 네비 길이
		int end = printList * reqPage;			//list 마지막 값
		int start = end - printList + reqPage;	//list 시작 값
		ArrayList<OutCa> list = new OutCaDao().selectAllInPro(conn,start,end);		//게시글 전부
		int totalListCount = new OutCaDao().totalListCount(conn);		//총 게시글 수
		int aReqPage = ((reqPage-1) / printNavi) * printNavi+1;
		//네비게이션 마지막 값 설정
		int totalList = totalListCount % printList == 0 ? totalListCount/printList : totalListCount/printList+1;
		//네비 생성 시작
		String navigation = "<div class=\"listPageWrap\">";
		//'<'이전버튼 생성 작업 > 처음 네비 페이지에선 이전버튼 생성 안함
		if(aReqPage != 1) {	// 이때 이전버튼 생성
			navigation += "<a href='/outCAList?reqPage="+(aReqPage-1)+"'><img src='images/moveButton/leftBtn1.png'></a>";
		}
		//지정한 길이만큼 네비 생성
		for(int i=0;i<printNavi;i++) {
			//사용자가 보고있는 네비 효과
			if(aReqPage == reqPage) {		//reqPage > 사용자가 요청한(보려는)페이지
				navigation += "<a class='activeNavi' href='/outCAList?reqPage="+aReqPage+"'>"+aReqPage+"</a>";
			}else {
				navigation += "<a href='/outCAList?reqPage="+aReqPage+"'>"+aReqPage+"</a>";				
			}
			aReqPage++;
			if(aReqPage > totalList) {
				break;
			}
		}
		if(aReqPage <= totalList) {		//11,22,33,44,... > 보다 많다면 다음 버튼 생성
			navigation += "<a href='/outCAList?reqPage"+aReqPage+"'><img src='images/moveButton/rightBtn1.png'></a>";
		}
		navigation += "</div>";
		JDBCTemplate.close(conn);
		OutCaPage opp = new OutCaPage(list, navigation);
		return opp;
	}
	public OutCaTable selectOneOutCa(int memberNo, int incaNo) {
		Connection conn = JDBCTemplate.getConnection();
		OutCaTable oct = new OutCaDao().selectOneOutCaTable(conn, memberNo, incaNo);
		JDBCTemplate.close(conn);
		return oct;
	}
	
	
	public int insertOutCa(OutCaTable oct) {
		Connection conn = JDBCTemplate.getConnection();
		int Result = new OutCaDao().updateMember(conn, oct);
		if(Result>0) {
			Result = new OutCaDao().insertOutCa(conn, oct);
			if(Result>0) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return Result;
	}
	

}
