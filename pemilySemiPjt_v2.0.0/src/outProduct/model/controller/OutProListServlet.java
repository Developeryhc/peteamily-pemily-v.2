package outProduct.model.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import outProduct.model.service.OutProService;
import outProduct.model.vo.OutProPage;

/**
 * Servlet implementation class OutProListServlet
 */
@WebServlet(name = "OutProList", urlPatterns = { "/outProList" })
public class OutProListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OutProListServlet() {
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
		int reqPage = Integer.parseInt(request.getParameter("reqPage"));
		//3.
		OutProPage opp = new OutProService().selectAllOurProduct(reqPage);
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/employee/outProList.jsp");
		request.setAttribute("list", opp.getList());
		request.setAttribute("navigation", opp.getNavigation());
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
