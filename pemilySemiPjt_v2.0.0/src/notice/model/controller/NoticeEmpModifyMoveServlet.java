package notice.model.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.model.service.NoticeService;
import notice.model.vo.NoticeWriteInfo;

/**
 * Servlet implementation class NoticeEmpModifyMoveServlet
 */
@WebServlet(name = "NoticeEmpModifyMove", urlPatterns = { "/noticeEmpModifyMove" })
public class NoticeEmpModifyMoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeEmpModifyMoveServlet() {
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
		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
		//3.
		NoticeWriteInfo nwi = new NoticeService().selectOneNoticeWriteInfo(noticeNo);
		//4.
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/employee/noticeEmpModify.jsp");
		request.setAttribute("nwi", nwi);
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
