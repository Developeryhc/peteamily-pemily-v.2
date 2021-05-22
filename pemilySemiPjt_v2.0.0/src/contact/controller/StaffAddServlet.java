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
import contact.model.vo.Emp;

/**
 * Servlet implementation class StaffAddServlet
 */
@WebServlet(name = "StaffAdd", urlPatterns = { "/staffAdd" })
public class StaffAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StaffAddServlet() {
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
			request.setAttribute("msg", "추가 작성오류[enctype]");
			request.setAttribute("loc", "/");
			rd.forward(request, response);	
		}
		//파일 업로드 준비
		//1)파일 업로드 경로 지정
		String root = getServletContext().getRealPath("/");		//WebContent 폴더 가져오는 경로
		String saveDirectory = root+"upload/staff";			//파일 저장경로 지정
		//2)파일 최대크기 지정
		int maxSize = 10*1024*1024;
		//3)request->MultipartRequest객체로 변환
		MultipartRequest mrequest = new MultipartRequest(request, saveDirectory,maxSize,"UTF-8",new DefaultFileRenamePolicy());
		
		Emp e = new Emp();
		e.setEmpEnter(mrequest.getParameter("empEnter"));
		e.setEmpGender(mrequest.getParameter("empGender"));
		e.setEmpGrade(Integer.parseInt(mrequest.getParameter("empGrade")));
		e.setEmpId(mrequest.getParameter("empId"));
		e.setEmpJob(mrequest.getParameter("empJob"));
		e.setEmpName(mrequest.getParameter("empName"));
		e.setEmpPhone(mrequest.getParameter("phone"));
		e.setEmpPw(mrequest.getParameter("empPw"));
		e.setEmpStore(Integer.parseInt(mrequest.getParameter("empStore")));
		e.setFilename(mrequest.getOriginalFileName("filename"));
		e.setFilepath(mrequest.getFilesystemName("filename"));
		e.setEmpAddr(mrequest.getParameter("addr"));
		//3.로직 처리
		int result = new ContactService().insertEmp(e);
		//4.결과처리
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if(result>0) {
			request.setAttribute("msg", "추가가 정상적으로 완료되었습니다.");
		}else {
			request.setAttribute("msg", "추가에 실패했습니다.");
		}
		request.setAttribute("loc", "/staffAddFrm");
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
