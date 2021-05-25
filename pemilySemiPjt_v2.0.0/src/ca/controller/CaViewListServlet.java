package ca.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.model.service.CaService;

/**
 * Servlet implementation class DogViewServlet
 */
@WebServlet(name = "CaViewList", urlPatterns = { "/caViewList" })
public class CaViewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CaViewListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.
		request.setCharacterEncoding("UTF-8");
		// 2.
		int incaAn = Integer.parseInt(request.getParameter("incaAn"));
		// 3.
		int totalCount = new CaService().totalCount(incaAn);
		// 4.
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/ca/caViewList.jsp");
		request.setAttribute("incaAn", incaAn);
		request.setAttribute("totalCount", totalCount);
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
