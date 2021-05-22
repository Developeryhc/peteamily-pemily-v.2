package inca.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import ca.model.vo.Adopt;
import common.JDBCTemplate;
import inca.model.dao.IncaDao;
import inca.model.vo.Inca;
import inca.model.vo.IncaPage;

public class IncaService {

	public ArrayList<Adopt> selectOneTypeInca(int incaNo, int start) {
		Connection conn = JDBCTemplate.getConnection();
		int length = 4;
		int end = start+length-1;
		ArrayList<Adopt> adopt = new IncaDao().selectOneTypeInca(conn, incaNo, start, end);
		JDBCTemplate.close(conn);
		return adopt;
	}

	public int insertInca(Inca i) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new IncaDao().InsertInca(conn, i);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public IncaPage selectAllInca(int reqPage) {
		Connection conn = JDBCTemplate.getConnection();
		//화면에 출력할 게시글 수 > 10개
		//화면에 출력할 네비게이션 길이 > 10개
		int printList = 10;
		int printNavi = 10;
		//시작값 , 끝값 생성
		int end = printList * reqPage;
		int start = end-printList+1;
		//전체 게시글 객체 가져오기
		ArrayList<Inca> list = new IncaDao().selectAllInca(conn, start, end);
		//전체 게시글 수 가져오기
		int totalListCount = new IncaDao().selectTotalListCount(conn);
		//전체 게시글 수 / printList = 를 담을 변수
		int totalList = totalListCount % printList == 0 ? totalListCount/printList : totalListCount/printList+1;
//네비게이션 생성 시작
		//네비 html문서를 담고있는 변수를 생성 > 네비를 감싸는 div 시작
		String navigation = "<div class=\"listPageWrap\">";
		//2. 네비게이션(a)의 href값 을 넣어줄 변수
		int aReqPage = ((reqPage-1)/printNavi)*printNavi+1;
		//3.'<'이전버튼 생성 >  1~10 > 1 : aReqPage가 1인 경우 > 1~10인 경우 > 이전 페이지 생성 안함
		if(aReqPage != 1) {
			navigation += "<a href='/caList?reqPage="+(aReqPage-1)+"'><img src='images/moveButton/leftBtn1.png'></a>";
		}
		//1~10 네비페이지 생성 for문
		for(int i=0;i<printNavi;i++) {
			//사용자가 클릭 해 보고있는 네비페이지 효과 적용
			if(aReqPage == reqPage) {
				navigation += "<a class='activeNavi' href='/caList?reqPage="+aReqPage+"'>"+aReqPage+"</a>";
			}else {
				navigation += "<a href='/caList?reqPage="+aReqPage+"'>"+aReqPage+"</a>";				
			}
			//여기서 aReqPage++ 주며 totalList보다 높은 경우  > list가 없는경우임 > for문을 빠져나간다.
			aReqPage++;
			if(aReqPage > totalList) {
				break;
			}
		}
		//for문을 빠져나온 직후 값은 11,22,33,44,... 이다 > ex) 11,22,33이면 다음 네비페이지가 존재하는 경우 고로 다음버튼 필수
		if(aReqPage <= totalList) {
			navigation += "<a href='/caList?reqPage="+aReqPage+"'><img src='images/moveButton/rightBtn1.png'></a>";
		}
		//마지막으로 div로 시작했기 때문에 닫아주자
		navigation += "</div>";
		JDBCTemplate.close(conn);
		IncaPage incaPage = new IncaPage(list,navigation);
		return incaPage;
	}

	public Adopt selectOneCa(int incaNo) {
		Connection conn = JDBCTemplate.getConnection();
		Adopt adopt = new IncaDao().selectOneCa(conn, incaNo);
		JDBCTemplate.close(conn);
		return adopt;
	}

	public Inca selectOneInca(int incaNo) {
		Connection conn = JDBCTemplate.getConnection();
		Inca inca = new IncaDao().selectOneInca(conn,incaNo);
		JDBCTemplate.close(conn);
		return inca;
	}

	public int incaModify(Inca inca, int incaNo) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new IncaDao().incaModify(conn,inca,incaNo);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		return result;
	}

	public int incaDelete(int incaNo) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new IncaDao().incaDelete(conn, incaNo);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

}
