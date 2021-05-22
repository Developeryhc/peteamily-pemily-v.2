package community;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.model.service.NoticeService;
import notice.model.vo.NoticePageData;

/**
 * Servlet implementation class CommunityServlet
 */
@WebServlet(name = "Community", urlPatterns = { "/community" })
public class CommunityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommunityServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.인코딩
		request.setCharacterEncoding("utf-8");
		//2.값추출(요청페이지 번호 받음)
		int reqPage = Integer.parseInt(request.getParameter("reqPage"));
		int noticeCom = Integer.parseInt(request.getParameter("noticeCom"));
		//3.비즈니스 로직 (공지사항 목록이 나오기때문에 리턴값은 ArrayList로 받음!
		NoticePageData npd = new NoticeService().selectNoticeList(reqPage,noticeCom);
		//4.결과처리
		if(noticeCom==1) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/employee/noticeList.jsp");
			request.setAttribute("list", npd.getList());
			request.setAttribute("pageNavi", npd.getPageNavi());
			rd.forward(request, response);
		}else if(noticeCom==2) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/notice/noticeList.jsp");
			request.setAttribute("list", npd.getList());
			request.setAttribute("pageNavi", npd.getPageNavi());
			rd.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
