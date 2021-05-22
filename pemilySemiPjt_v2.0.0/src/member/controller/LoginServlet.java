package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(name = "Login", urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.인코딩
				request.setCharacterEncoding("utf-8");
				//2. 값 추출
				String memberId = request.getParameter("memberId");
				String memberPw = request.getParameter("memberPw");
				//3. 로직처리 -> 비지니스 로직 == 서비스 호출
				Member m = new MemberService().selectOneMember(memberId,memberPw);
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
				if(m != null) {
					if(m.getMemberGrade()==3) {
						request.setAttribute("msg", "로그인 권한이 없습니다.");
					}else {
						HttpSession session = request.getSession();
						session.setAttribute("m", m);
						request.setAttribute("msg", "로그인 성공");
					}
				}else {
					//로그인 실패한 경우
					request.setAttribute("msg", "아이디 또는 비밀번호를 확인하세요");
				}
				//alert으로 안내 후 이동할 페이지 지정
				request.setAttribute("loc", "/");
				//페이지 이동
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
