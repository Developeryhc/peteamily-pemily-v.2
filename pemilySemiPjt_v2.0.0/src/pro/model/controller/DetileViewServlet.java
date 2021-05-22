package pro.model.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import inPro.model.vo.InPro;
import pro.model.service.ProductService;

/**
 * Servlet implementation class DetileViewServlet
 */
@WebServlet(name = "DetileView", urlPatterns = { "/detileView" })
public class DetileViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetileViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//인코딩
		request.setCharacterEncoding("utf-8");
		//2값추출 ahref=로 ? 보내준 프라이머리키 
		int inpro_no = Integer.parseInt(request.getParameter("inpro_no"));
		//3비즈니스 로직
		//프라이버리키에 해당하는 정보만 가져오기
		InPro inpro = new ProductService().selectOnePro(inpro_no);
		//결과처리 디테일 페이지에 값 보내주기
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/shop/detail.jsp");
		request.setAttribute("pro", inpro);
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
