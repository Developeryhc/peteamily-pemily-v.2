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
import care.model.vo.CarePageData;

/**
 * Servlet implementation class CareViewServlet
 */
@WebServlet(name = "CareView", urlPatterns = { "/careView" })
public class CareViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CareViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int careNo = Integer.parseInt(request.getParameter("careNo"));
		Care c = new CareService().selectOneCare(careNo);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/care/careView.jsp");
		request.setAttribute("c", c);
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
