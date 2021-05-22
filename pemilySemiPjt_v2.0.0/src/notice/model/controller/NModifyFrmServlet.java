package notice.model.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.model.service.NoticeService;
import notice.model.vo.Notice;

/**
 * Servlet implementation class NModifyFrmServlet
 */
@WebServlet(name = "NModifyFrm", urlPatterns = { "/nModifyFrm" })
public class NModifyFrmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NModifyFrmServlet() {
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
		String noticeWriter = request.getParameter("noticeWriter");
		String noticeTitle = request.getParameter("noticeTitle");
		String noticeContent = request.getParameter("noticeContent");
		Notice n = new Notice();
		n.setNoticeContent(noticeContent);
		n.setNoticeTitle(noticeTitle);
		n.setNoticeWriter(noticeWriter);
		//3.
		int result = new NoticeService().modifyEmpNotice(noticeNo,n);
		//4.
		PrintWriter out = response.getWriter();
		out.print(result);
		/*
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if(result>0) {
			request.setAttribute("msg", "수정 완료");
			request.setAttribute("loc", "/noticeEmpView?noticeNo="+noticeNo);
		}else {
			request.setAttribute("msg", "수정 실패");
			request.setAttribute("loc", "/noticeEmpView?noticeNo="+noticeNo);
		}
		rd.forward(request, response);
		*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
