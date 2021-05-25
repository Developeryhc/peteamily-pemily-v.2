package ca.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.model.service.CaService;
import ca.model.vo.Ca;

/**
 * Servlet implementation class CaWriteServlet
 */
@WebServlet(name = "CaWrite", urlPatterns = { "/caWrite" })
public class CaWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CaWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 인코딩
		request.setCharacterEncoding("UTF-8");
		// 2. 값 추출
		Ca c = new Ca();
		c.setCaAn(Integer.parseInt(request.getParameter("incaNo")));
		c.setCaTitle(request.getParameter("caTitle"));
		c.setCaContent(request.getParameter("caContent"));
		c.setCaWriter(request.getParameter("empId"));
		// 3. 비즈니스 로직
		int result = new CaService().insertCa(c);
		// 4. 결과처리
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if(result > 0) {
			request.setAttribute("msg", "Ca 등록 완료");
			request.setAttribute("loc", "/employeeMain");
		}else {
			request.setAttribute("msg", "Ca 등록 실패");
			request.setAttribute("loc", "/caWriteFrm?="+c.getCaAn());
		}
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
