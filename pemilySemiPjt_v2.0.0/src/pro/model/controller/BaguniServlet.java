package pro.model.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BaguniServlet
 */
@WebServlet(name = "Baguni", urlPatterns = { "/baguni" })
public class BaguniServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BaguniServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//상세페이지에서 장바구니 누르면!
		request.setCharacterEncoding("utf-8");
		//2값가져오기 이름 가격 수량
		//3비지니스로직
		//4결과처리
		String inProName = request.getParameter("inProName");
		int count = Integer.parseInt(request.getParameter("count"));
//		String count = request.getParameter("count");
		
		String inProPrice = request.getParameter("inProPrice");
		
	
		request.setAttribute("inProName", inProName);
		request.setAttribute("inProPrice", inProPrice);
		request.setAttribute("count", count);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/shop/baguni.jsp");
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
