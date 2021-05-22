package ca.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import ca.model.vo.Adopt;
import inca.model.service.IncaService;

/**
 * Servlet implementation class CaOneViewServlet
 */
@WebServlet(name = "CaOneView", urlPatterns = { "/caOneView" })
public class CaOneViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CaOneViewServlet() {
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
		int incaNo = Integer.parseInt(request.getParameter("incaNo"));
		// 3.
		Adopt adopt = new IncaService().selectOneCa(incaNo);
		// 4.
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		new Gson().toJson(adopt, response.getWriter());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
