package care.model.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import care.model.service.CareService;
import care.model.vo.Care;

/**
 * Servlet implementation class CareUpdateServlet
 */
@WebServlet(name = "CareUpdate", urlPatterns = { "/careUpdate" })
public class CareUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CareUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//수정된 정보
		int careNo = Integer.parseInt(request.getParameter("careNo"));
		String careTitle = request.getParameter("careTitle");
		String careContent = request.getParameter("careContent");
		
		//
		Care c = new Care();
		c.setCareNo(careNo);
		c.setCareTitle(careTitle);
		c.setCareContent(careContent);
		c.setCareAn(Integer.parseInt(request.getParameter("careAn")));
		c.setCareWriter(request.getParameter("careWriter"));
		
		//3.비즈니스 로직
		int result = new CareService().updateCare(c);
		//4.결과처리
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if(result>0) {
			request.setAttribute("msg", "변경 성공");
		}else {
			request.setAttribute("msg", "변경 실패");
		}
		request.setAttribute("loc", "/careView?careNo="+careNo);
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
