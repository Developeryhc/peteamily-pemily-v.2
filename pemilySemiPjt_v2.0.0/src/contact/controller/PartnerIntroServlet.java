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
import contact.model.vo.Contact;

/**
 * Servlet implementation class PartnerIntroServlet
 */
@WebServlet(name = "PartnerIntro", urlPatterns = { "/partnerIntro" })
public class PartnerIntroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PartnerIntroServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//2.데이터 추출
		String sort = request.getParameter("sort");
		//로직처리
		ArrayList<Contact> list = new ContactService().selectAllPartner(sort);
	
		//결과처리
		if(sort.equals("뷰티")) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/contact/partnerIntro.jsp");
			request.setAttribute("list", list);
			rd.forward(request, response);
		}else if(sort.equals("라이프")) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/contact/partnerIntroLife.jsp");
			request.setAttribute("list", list);
			rd.forward(request, response);
		}else if(sort.equals("의료")) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/contact/partnerIntroMedic.jsp");
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
