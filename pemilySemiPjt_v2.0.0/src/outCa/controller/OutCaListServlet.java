package outCa.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import outCa.model.service.OutCaService;
import outCa.model.vo.OutCaPage;

/**
 * Servlet implementation class OutCAListServlet
 */
@WebServlet(name = "OutCaList", urlPatterns = { "/outCaList" })
public class OutCaListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OutCaListServlet() {
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
		OutCaPage ocap = new OutCaService().selectAllOutCa(reqPage);
		//4.
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/employee/outCaList.jsp");
		request.setAttribute("list", ocap.getList());
		request.setAttribute("navigation", ocap.getNavigation());
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
