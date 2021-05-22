package inProduct.model.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import inPro.model.vo.InPro;
import inProduct.model.service.InProductService;

/**
 * Servlet implementation class InProModifyMoveServlet
 */
@WebServlet(name = "InProModifyMove", urlPatterns = { "/inProModifyMove" })
public class InProModifyMoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InProModifyMoveServlet() {
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
		int inProNo = Integer.parseInt(request.getParameter("inProNo"));
		//3.
		InPro inPro = new InProductService().selectOneInPro(inProNo);
		//4.
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/employee/inProModify.jsp");
		request.setAttribute("inPro", inPro);
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
