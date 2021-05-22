package outProduct.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import common.JDBCTemplate;
import inPro.model.vo.InPro;
import inProduct.model.dao.InProductDao;
import outProduct.model.dao.OutProductDao;
import outProduct.model.vo.OutPro;
import outProduct.model.vo.OutProPage;

public class OutProService {

	public OutProPage selectAllOurProduct(int reqPage) {
		Connection conn = JDBCTemplate.getConnection();
		int printList = 10;						//보여줄 게시글 갯수
		int printNavi = 10;						//보여줄 네비 길이
		int end = printList * reqPage;			//list 마지막 값
		int start = end - printList + reqPage;	//list 시작 값
		ArrayList<OutPro> list = new OutProductDao().selectAllOutProduct(conn,start,end);		//게시글 전부
		int totalListCount = new OutProductDao().totalListCount(conn);		//총 게시글 수
		int aReqPage = ((reqPage-1) / printNavi) * printNavi+1;
		//네비게이션 마지막 값 설정
		int totalList = totalListCount % printList == 0 ? totalListCount/printList : totalListCount/printList+1;
		//네비 생성 시작
		String navigation = "<div class=\"listPageWrap\">";
		//'<'이전버튼 생성 작업 > 처음 네비 페이지에선 이전버튼 생성 안함
		if(aReqPage != 1) {	// 이때 이전버튼 생성
			navigation += "<a href='/outProList?reqPage="+(aReqPage-1)+"'><img src='images/moveButton/leftBtn1.png'></a>";
		}
		//지정한 길이만큼 네비 생성
		for(int i=0;i<printNavi;i++) {
			//사용자가 보고있는 네비 효과
			if(aReqPage == reqPage) {		//reqPage > 사용자가 요청한(보려는)페이지
				navigation += "<a class='activeNavi' href='/outProList?reqPage="+aReqPage+"'>"+aReqPage+"</a>";
			}else {
				navigation += "<a href='/outProList?reqPage="+aReqPage+"'>"+aReqPage+"</a>";				
			}
			aReqPage++;
			if(aReqPage > totalList) {
				break;
			}
		}
		if(aReqPage <= totalList) {		//11,22,33,44,... > 보다 많다면 다음 버튼 생성
			navigation += "<a href='/outProList?reqPage"+aReqPage+"'><img src='images/moveButton/rightBtn1.png'></a>";
		}
		navigation += "</div>";
		JDBCTemplate.close(conn);
		OutProPage opp = new OutProPage(list, navigation);
		return opp;
	}

}
