package ca.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import inca.model.service.IncaService;
import inca.model.vo.Inca;
import member.model.service.MemberService;
import outCa.model.service.OutCaService;
import outCa.model.vo.OutCaTable;

/**
 * Servlet implementation class CaApplyServlet
 */
@WebServlet(name = "CaApply", urlPatterns = { "/caApply" })
public class CaApplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CaApplyServlet() {
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
		int memberNo = Integer.parseInt(request.getParameter("memberNo"));
		int incaNo = Integer.parseInt(request.getParameter("incaNo"));
		// 3.
		OutCaTable oct = new OutCaService().selectOneOutCa(memberNo, incaNo);
		int result = new OutCaService().insertOutCa(oct);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if(result>0){
			request.setAttribute("msg", "분양신청 완료, 영업일 1~2일 내로 담당자가 연락드릴 예정입니다. 조금만 기다려주세요:D");
		}else {
			request.setAttribute("msg", "분양신청 실패, 관리자에게 문의바랍니다.");
		}
		request.setAttribute("loc", "/ca");
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
