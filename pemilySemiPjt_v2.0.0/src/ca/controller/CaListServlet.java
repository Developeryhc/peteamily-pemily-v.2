package ca.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import inca.model.service.IncaService;
import inca.model.vo.IncaPage;

/**
 * Servlet implementation class CaListServlet
 */
@WebServlet(name = "CaList", urlPatterns = { "/caList" })
public class CaListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CaListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.
		request.setCharacterEncoding("utf-8");
		//2.
		int reqPage = Integer.parseInt(request.getParameter("reqPage"));
		//3.
		IncaPage incaPage = new IncaService().selectAllInca(reqPage);
		//4.
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/employee/caList.jsp");
		request.setAttribute("list", incaPage.getList());
		request.setAttribute("navigation", incaPage.getNavigation());
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
