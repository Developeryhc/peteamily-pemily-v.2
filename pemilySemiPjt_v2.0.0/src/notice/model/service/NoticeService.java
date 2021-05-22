package notice.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import care.model.dao.CareDao;
import care.model.vo.Care;
import common.JDBCTemplate;
import notice.model.dao.NoticeDao;
import notice.model.vo.Notice;
import notice.model.vo.NoticePageData;
import notice.model.vo.NoticeWriteInfo;

public class NoticeService {

	public NoticePageData selectNoticeList(int reqPage, int noticeCom) {
				Connection conn = JDBCTemplate.getConnection();
				int numPerPage = 10;
				int end = reqPage*numPerPage;
				int start = end - numPerPage + 1;
			
				NoticeDao dao = new NoticeDao();	
				//요청한 페이지의 게시물을 조회
				ArrayList<Notice> list = dao.selectNoticeList(conn,noticeCom,start,end);
			
				//페이지 네비게이션제작
			
				//전체 게시물 수 조회
				int totalCount = dao.totalCount(conn,noticeCom); 
				
				//전체 페이지 수 계산
				int totalPage = 0;
				if(totalCount%numPerPage == 0) {
					totalPage = totalCount/numPerPage;
				}else {
					totalPage = totalCount/numPerPage+1; 
				}
				
				int pageNaviSize = 5; 
				int pageNo = ((reqPage-1)/pageNaviSize)*pageNaviSize+1;
				
				
				String pageNavi  = "<div class='listPageWrap'>";
				//페이지 네비 시작번호가 1이 아닌경우는 이전버튼 생성
				if(pageNo !=1) {
					pageNavi += "<a href='/noticeList?reqPage="+(pageNo-1)+"&noticeCom="+noticeCom+"'><img src='img/moveButton/leftBtn1.png'></a>";
					
				}
				//페이지 숫자 생성
				for(int i=0;i<pageNaviSize;i++) {
					if(pageNo == reqPage) {			//목록번호가 12345에서 번호도 3이고 내가 보고있는 페이지도 3일때
			            pageNavi += "<a class='activeNavi' href='/noticeList?reqPage="+pageNo+"&noticeCom="+noticeCom+"'>"+pageNo+"</a>";
					}else {
						pageNavi += "<a href='/noticeList?reqPage="+pageNo+"&noticeCom="+noticeCom+"'>"+pageNo+"</a>";
					}
					pageNo++;
					if(pageNo>totalPage) {
						break;
					}
				}
				//다음버튼 생성
				if(pageNo <= totalPage) {
					pageNavi += "<a href='/noticeList?reqPage="+pageNo+"&noticeCom="+noticeCom+"'><img src='img/moveButton/rightBtn1.png'></a>";
				}
				pageNavi += "</div>";
				JDBCTemplate.close(conn);
				NoticePageData npd = new NoticePageData(list, pageNavi);
				return npd;
	}
	public NoticePageData selectNoticeEmpList(int reqPage, int noticeCom) {
		Connection conn = JDBCTemplate.getConnection();
		int numPerPage = 10;
		int end = reqPage*numPerPage;
		int start = end - numPerPage + 1;
		
		NoticeDao dao = new NoticeDao();	
		//요청한 페이지의 게시물을 조회
		ArrayList<Notice> list = dao.selectNoticeList(conn,noticeCom,start,end);
		
		//페이지 네비게이션제작
		
		//전체 게시물 수 조회
		int totalCount = dao.totalCount(conn,noticeCom); 
		
		//전체 페이지 수 계산
		int totalPage = 0;
		if(totalCount%numPerPage == 0) {
			totalPage = totalCount/numPerPage;
		}else {
			totalPage = totalCount/numPerPage+1; 
		}
		
		int pageNaviSize = 5; 
		int pageNo = ((reqPage-1)/pageNaviSize)*pageNaviSize+1;
		
		
		String pageNavi  = "<div class='listPageWrap'>";
		//페이지 네비 시작번호가 1이 아닌경우는 이전버튼 생성
		if(pageNo !=1) {
			pageNavi += "<a href='/noticeEmpList?reqPage="+(pageNo-1)+"&noticeCom="+noticeCom+"'><img src='img/moveButton/leftBtn1.png'></a>";
			
		}
		//페이지 숫자 생성
		for(int i=0;i<pageNaviSize;i++) {
			if(pageNo == reqPage) {			//목록번호가 12345에서 번호도 3이고 내가 보고있는 페이지도 3일때
				pageNavi += "<a class='activeNavi' href='/noticeEmpList?reqPage="+pageNo+"&noticeCom="+noticeCom+"'>"+pageNo+"</a>";
			}else {
				pageNavi += "<a href='/noticeEmpList?reqPage="+pageNo+"&noticeCom="+noticeCom+"'>"+pageNo+"</a>";
			}
			pageNo++;
			if(pageNo>totalPage) {
				break;
			}
		}
		//다음버튼 생성
		if(pageNo <= totalPage) {
			pageNavi += "<a href='/noticeEmpList?reqPage="+pageNo+"&noticeCom="+noticeCom+"'><img src='img/moveButton/rightBtn1.png'></a>";
		}
		pageNavi += "</div>";
		JDBCTemplate.close(conn);
		NoticePageData npd = new NoticePageData(list, pageNavi);
		return npd;
	}
	

	public Notice selectOneCare(int noticeNo) {
		Connection conn = JDBCTemplate.getConnection();
		NoticeDao dao = new NoticeDao();
		Notice n= dao.selectOneCare(conn, noticeNo);
		JDBCTemplate.close(conn);
		return n;
	}
	
	public int deleteNotice(int noticeNo) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new NoticeDao().deleteNotice(conn,noticeNo);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}JDBCTemplate.close(conn);
		return result;
	}
	
	public int insertNotice(Notice n) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new NoticeDao().insertNotice(conn,n);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public Notice selectOneNotice(int noticeNo) {
		Connection conn = JDBCTemplate.getConnection();
		NoticeDao dao = new NoticeDao();
		Notice n = dao.selectOneNotice(conn,noticeNo);
		JDBCTemplate.close(conn);
		return n;
	}

	public int updateNotice(Notice n) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new NoticeDao().updateNotice(conn,n);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}
	
	public NoticeWriteInfo selectOneNoticeWriteInfo(int noticeNo) {
		Connection conn = JDBCTemplate.getConnection();
		NoticeWriteInfo nwi = new NoticeDao().selectOneNoticeInfo(conn,noticeNo);
		JDBCTemplate.close(conn);
		return nwi;
	}
 
	public int searchOneNoticeNo(int noticeCom) {
		Connection conn = JDBCTemplate.getConnection();
		int noticeNo = new NoticeDao().searchOneNoticeNo(conn,noticeCom);
		JDBCTemplate.close(conn);
		return noticeNo;
	}

	public int modifyEmpNotice(int noticeNo, Notice n) {
		Connection conn=JDBCTemplate.getConnection();
		int result = new NoticeDao().modifyEmpNotice(conn,noticeNo,n);
		if(result>0){
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int deleteEmpNotice(int noticeNo) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new NoticeDao().deleteEmpNotice(conn,noticeNo);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

}
