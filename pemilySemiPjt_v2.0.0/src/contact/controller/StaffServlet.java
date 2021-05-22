package contact.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import contact.model.service.ContactService;
import contact.model.vo.Emp;

/**
 * Servlet implementation class StaffServlet
 */
@WebServlet(name = "Staff", urlPatterns = { "/staff" })
public class StaffServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StaffServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//2.데이터 추출
		int store = Integer.parseInt(request.getParameter("store"));
		
		//로직처리
		ArrayList<Emp> list = new ContactService().selectAllEmp(store);
		//결과처리
		if(store ==1) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/staff/staffIntro.jsp");
			request.setAttribute("list", list);
			rd.forward(request, response);
		}else if(store==2) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/staff/staffIntro2.jsp");
			request.setAttribute("list", list);
			rd.forward(request, response);
		}else if(store==3) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/staff/staffIntro3.jsp");
			request.setAttribute("list", list);
			rd.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
