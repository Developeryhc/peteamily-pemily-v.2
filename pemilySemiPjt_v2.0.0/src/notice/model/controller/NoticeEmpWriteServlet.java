package notice.model.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.model.service.NoticeService;
import notice.model.vo.Notice;

/**
 * Servlet implementation class NoticeEmpWriteServlet
 */
@WebServlet(name = "NoticeEmpWrite", urlPatterns = { "/noticeEmpWrite" })
public class NoticeEmpWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeEmpWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		//1.
		request.setCharacterEncoding("utf-8");
		//2.
		int noticeCom = Integer.parseInt(request.getParameter("noticeCom"));
		String noticeWriter = request.getParameter("noticeWriter");
		String noticeContent = request.getParameter("noticeContent");
		String noticeTitle = request.getParameter("noticeTitle");
		//3.
		Notice n = new Notice();
		n.setNoticeCom(noticeCom);
		n.setNoticeContent(noticeContent);
		n.setNoticeTitle(noticeTitle);
		n.setNoticeWriter(noticeWriter);
		int result = new NoticeService().insertNotice(n);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if(result>0) {
			request.setAttribute("msg", "등록 완료");
			request.setAttribute("loc", "/insertPage");			
		}else {
			request.setAttribute("msg", "등록 실패");			
			request.setAttribute("loc", "/insertPage");			
		}
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
