package employee.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import employee.model.service.EmployeeService;
import employee.model.vo.Employee;

/**
 * Servlet implementation class EmpLoginChkServlet
 */
@WebServlet(name = "EmpLoginChk", urlPatterns = { "/empLoginChk" })
public class EmpLoginChkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpLoginChkServlet() {
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
		String empId = request.getParameter("empId");
		String empPw = request.getParameter("empPw");
		//3.
		Employee emp = new EmployeeService().selectOneEmployee(empId,empPw);
		//4.
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		if(emp != null) {
			HttpSession session =  request.getSession();
			session.setAttribute("e", emp);
			new Gson().toJson(emp,response.getWriter());
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
