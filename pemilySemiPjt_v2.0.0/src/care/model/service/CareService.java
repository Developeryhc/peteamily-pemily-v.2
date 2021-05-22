package care.model.service;

import java.sql.Connection;

import java.util.ArrayList;

import care.model.dao.CareDao;
import care.model.vo.Care;
import care.model.vo.CarePageData;
import common.JDBCTemplate;


public class CareService {

	public CarePageData selectCareList(int reqPage) {
		Connection conn = JDBCTemplate.getConnection();
		int numPerPage = 10;	//1.한페이지에 게시물을 몇개 보여줄지 : 한페이지당 10개씩 보여줌
		
		//reqPage를 통해서 게시물 시작-rnum 끝-rum 계산 1page(1-10),2page(11-20),3page(21-30)	
		int end = reqPage*numPerPage;
		int start = end - numPerPage + 1;
		
		System.out.println(conn);
	
		CareDao dao = new CareDao();
		ArrayList<Care> list = dao.selectCareList(conn,start,end);
//		for(Care c : list){
//			System.out.println(c.getCareTitle());
//		}
		int totalCount = dao.totalCount(conn); //쿼리문 select * count ->전달해줄 인자 없음!
		
		//전체 페이지 수 계산
		int totalPage = 0;
		if(totalCount%numPerPage == 0) {
			totalPage = totalCount/numPerPage;	//85개면 한페이지당 10개씩 봄! 그럼 나머지는5 근데 80개나 90이면 딱 떨어지니까 몫만!
		}else {
			totalPage = totalCount/numPerPage+1;  //'+1'은 나머지가 있으면 나머지처리용 페이지를 하나 더해준다.라고 생각혀
		}
		
		//페이지 네비 길이지정
		int pageNaviSize = 5; //밑에 목록이 최대 1부터5 그다음 페이지는 6-10 //변수처리하는 이유는 나중에 값이 변경될때 변수값만 바꿔도 한번에 처리 되니까용~!
		//1~5페이지 요청시 페이지 네비 시작번호는 : 1
		//6~10페이지 요청시 페이지 네비 시작번호는 : 6
		//11~15페이지 요청시 페이지 네비 시작번호는 : 11
		int pageNo = ((reqPage-1)/pageNaviSize)*pageNaviSize+1; //req=2 ((2-1)/5)*5 자바에선 0으로 처리 함  그럼 1이니까 계속 1페이지!
		
		//페이지 네비 시작
		String pageNavi  = "<ul class='pagination pagination-lg'>";
		//페이지 네비 시작번호가 1이 아닌경우는 이전버튼 생성
		if(pageNo !=1) {
			pageNavi += "<li class='page-item'>";
			pageNavi += "<a class='page-link' href='/careList?reqPage="+(pageNo-1)+"'>&lt;</a></li>";
			
		}
		//페이지 숫자 생성
		for(int i=0;i<pageNaviSize;i++) {
			if(pageNo == reqPage) {			//목록번호가 12345에서 번호도 3이고 내가 보고있는 페이지도 3일때
				pageNavi += "<li class='page-item active'>";
	            pageNavi += "<a class='page-link' href='/careList?reqPage="+pageNo+"'>"+pageNo+"</a></li>";
			}else {
				pageNavi += "<li class ='page-item'>";
	            pageNavi += "<a class='page-link' href='/careList?reqPage="+pageNo+"'>"+pageNo+"</a></li>";
			}
			pageNo++;
			if(pageNo>totalPage) {
				break;
			}
		}
		//다음버튼 생성
		if(pageNo <= totalPage) {
			pageNavi += "<li class='page-item'>";
			pageNavi += "<a class='page-link' href='/careList?reqPage="+(pageNo)+"'>&gt;</a></li>";
		}
		pageNavi += "</ul>";
		JDBCTemplate.close(conn);
		CarePageData cpd = new CarePageData(list, pageNavi);
		return cpd;
	}

	public Care selectOneCare(int careNo) {
		Connection conn = JDBCTemplate.getConnection();
		CareDao dao = new CareDao();
		Care c = dao.selectOneCare(conn, careNo);
		JDBCTemplate.close(conn);
		return c;
	}

	public int deleteCare(int careNo) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new CareDao().deleteCare(conn,careNo);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}JDBCTemplate.close(conn);
		return result;
	}

	public int totalCount() {
		Connection conn = JDBCTemplate.getConnection();
		int totalCount = new CareDao().totalCount(conn);
		JDBCTemplate.close(conn);
		return totalCount;
	}

	public int insertCare(Care c) {
		Connection conn = JDBCTemplate.getConnection();
		System.out.println(2);
		int result = new CareDao().insertCare(conn,c);
		System.out.println(3);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		return result;
	}

	public int updateCare(Care c) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new CareDao().updateCare(conn,c);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

}
