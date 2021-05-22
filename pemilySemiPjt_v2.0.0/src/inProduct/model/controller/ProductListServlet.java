package inProduct.model.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import inPro.model.vo.InProPage;
import inProduct.model.service.InProductService;


/**
 * Servlet implementation class ProductListServlet
 */
@WebServlet(name = "ProductList", urlPatterns = { "/productList" })
public class ProductListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductListServlet() {
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
		int reqPage =Integer.parseInt(request.getParameter("reqPage"));
		//3.
		InProPage inProPage = new InProductService().selectAllInProduct(reqPage);
		//4.
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/employee/productList.jsp");
		request.setAttribute("list", inProPage.getList());
		request.setAttribute("navigation", inProPage.getNavigation());
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
