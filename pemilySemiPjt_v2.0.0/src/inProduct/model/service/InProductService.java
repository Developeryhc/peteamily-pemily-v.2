package inProduct.model.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import common.JDBCTemplate;
import inPro.model.vo.InPro;
import inPro.model.vo.InProPage;
import inProduct.model.dao.InProductDao;

public class InProductService {

	public int insertInProduct(InPro inPro) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new InProductDao().insertInProduct(conn,inPro);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public InProPage selectAllInProduct(int reqPage) {
		Connection conn = JDBCTemplate.getConnection();
		int printList = 10;						//보여줄 게시글 갯수
		int printNavi = 10;						//보여줄 네비 길이
		int end = printList * reqPage;			//list 마지막 값
		int start = end - printList + 1;	//list 시작 값
		ArrayList<InPro> list = new InProductDao().selectAllInProduct(conn,start,end);		//게시글 전부
		int totalListCount = new InProductDao().totalListCount(conn);		//총 게시글 수
		int aReqPage = ((reqPage-1) / printNavi) * printNavi+1;
		//네비게이션 마지막 값 설정
		int totalList = totalListCount % printList == 0 ? totalListCount/printList : totalListCount/printList+1;
		//네비 생성 시작
		String navigation = "<div class=\"listPageWrap\">";
		//'<'이전버튼 생성 작업 > 처음 네비 페이지에선 이전버튼 생성 안함
		if(aReqPage != 1) {	// 이때 이전버튼 생성
			navigation += "<a href='/productList?reqPage="+(aReqPage-1)+"'><img src='images/moveButton/leftBtn1.png'></a>";
		}
		//지정한 길이만큼 네비 생성
		for(int i=0;i<printNavi;i++) {
			//사용자가 보고있는 네비 효과
			if(aReqPage == reqPage) {		//reqPage > 사용자가 요청한(보려는)페이지
				navigation += "<a class='activeNavi' href='/productList?reqPage="+aReqPage+"'>"+aReqPage+"</a>";
			}else {
				navigation += "<a href='/productList?reqPage="+aReqPage+"'>"+aReqPage+"</a>";				
			}
			aReqPage++;
			if(aReqPage > totalList) {
				break;
			}
		}
		if(aReqPage <= totalList) {		//11,22,33,44,... > 보다 많다면 다음 버튼 생성
			navigation += "<a href='/productList?reqPage"+aReqPage+"'><img src='images/moveButton/rightBtn1.png'></a>";
		}
		navigation += "</div>";
		JDBCTemplate.close(conn);
		InProPage inProPage = new InProPage(list, navigation);
		return inProPage;
	}

	public InPro selectOneInPro(int inProNo) {
		Connection conn = JDBCTemplate.getConnection();
		InPro inPro = new InProductDao().selectOneInPro(conn,inProNo);
		JDBCTemplate.close(conn);
		return inPro;
	}

	public int inProDelete(int inProNo) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new InProductDao().inProDelete(conn,inProNo);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int modifyInPro(int inProNo, int inProPrice, int inProAmount) {
		Connection conn =JDBCTemplate.getConnection();
		int result = new InProductDao().modifyInPro(conn,inProNo,inProPrice,inProAmount);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

}
