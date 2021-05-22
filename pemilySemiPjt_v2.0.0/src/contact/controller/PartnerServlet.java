package contact.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import contact.model.service.ContactService;
import contact.model.vo.Contact;

/**
 * Servlet implementation class PartnerServlet
 */
@WebServlet(name = "Partner", urlPatterns = { "/partner" })
public class PartnerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PartnerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		//2.데이터 추출
		//enctype이 정상인지 확인
		if(!ServletFileUpload.isMultipartContent(request)) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
			request.setAttribute("msg", "신청 작성오류[enctpye]");
			request.setAttribute("loc", "/");
			rd.forward(request, response);
			return;
		}
		//파일 업로드 준비
		//1)파일 업로드 경로지정
		String root=getServletContext().getRealPath("/");	//WebContent 폴더 가져오는 경로
		String saveDirectory = root+"upload/partner";		//파일저장경로 지정
		//2)파일 최대크기 지정
		int maxSize = 10*1024*1024;
		//3)request->MultiPartRequest객체로 변환
		MultipartRequest mrequest = new MultipartRequest(request, saveDirectory, maxSize, "UTF-8", new DefaultFileRenamePolicy());
		
		Contact c = new Contact();
		c.setContent(mrequest.getParameter("content"));
		c.setEmail(mrequest.getParameter("email"));
		c.setPartnerEmp(mrequest.getParameter("partnerEmp"));
		c.setPartnerName(mrequest.getParameter("partnerName"));
		c.setPhone(mrequest.getParameter("phone"));
		c.setPartnerSort(mrequest.getParameter("partnerSort"));
		c.setFilepath(mrequest.getFilesystemName("filename"));
		//로직처리
		int result = new ContactService().insertPartner(c);
		//결과처리
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if(result>0) {
			request.setAttribute("msg", "신청이 정상적으로 처리되었습니다.");
		}else {
			request.setAttribute("msg", "신청이 처리되지 않았습니다.");
		}
		request.setAttribute("loc", "/");
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
