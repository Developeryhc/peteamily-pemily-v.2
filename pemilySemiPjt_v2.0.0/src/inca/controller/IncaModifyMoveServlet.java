package inca.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import inca.model.service.IncaService;
import inca.model.vo.Inca;

/**
 * Servlet implementation class IncaModifyMoveServlet
 */
@WebServlet(name = "IncaModifyMove", urlPatterns = { "/incaModifyMove" })
public class IncaModifyMoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IncaModifyMoveServlet() {
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
		int incaNo = Integer.parseInt(request.getParameter("incaNo"));
		//3.
		Inca inca = new IncaService().selectOneInca(incaNo);
		//4.
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/employee/incaModify.jsp");
		request.setAttribute("inca", inca);
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
