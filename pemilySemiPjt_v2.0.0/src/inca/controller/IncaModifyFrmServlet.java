package inca.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import inca.model.service.IncaService;
import inca.model.vo.Inca;

/**
 * Servlet implementation class IncaModifyFrmServlet
 */
@WebServlet(name = "IncaModifyFrm", urlPatterns = { "/incaModifyFrm" })
public class IncaModifyFrmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IncaModifyFrmServlet() {
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
		int incaPrice = Integer.parseInt(request.getParameter("incaPrice"));
		int incaCondition = Integer.parseInt(request.getParameter("incaCondition"));
		int incaStore = Integer.parseInt(request.getParameter("incaStore"));
		//3.
		Inca inca = new Inca();
		inca.setIncaPrice(incaPrice);
		inca.setIncaCondition(incaCondition);
		inca.setIncaStore(incaStore);
		int result = new IncaService().incaModify(inca,incaNo);
		//4.
		PrintWriter out = response.getWriter();
		out.print(result);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
