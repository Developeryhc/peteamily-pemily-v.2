package care.model.controller;

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

import care.model.service.CareService;
import care.model.vo.Care;

/**
 * Servlet implementation class CareWriteServlet
 */
@WebServlet(name = "CareWrite", urlPatterns = { "/careWrite" })
public class CareWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CareWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//파일 업로드를 하는경우 enctype="multipart/form-data"로 처리해야하므로 enctype이 정상인치 확인
				if(!ServletFileUpload.isMultipartContent(request)) {
					RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/common/msg.jsp");
					request.setAttribute("msg", "후기글 작성오류[enctype]");
					request.setAttribute("loc", "/");
					rd.forward(request,response);
					return;
				}
				
				//파일 업로드 준비
				//1)파일 업로드 경로지정
				String root = getServletContext().getRealPath("/"); //WebContent 폴더 경로 가져오는 코드
				String saveDirectory = root+"upload/care"; //파일저장경로 지정
				System.out.println("파일저장 경로:"+saveDirectory);
				//2)업로드 파일의 최대크기 지정(일반적으로 웹은 10Mb 정도 사용)
				int maxSize = 10*1024*1024;
				//3)requset -> MutipartRequest객체로 변환
				//매개변수 requset객체,파일저장경로,최대크기,인코딩타입,파일명 중복 처리 객체
				MultipartRequest  mRequset = new MultipartRequest(request, saveDirectory,maxSize,"UTF-8",new DefaultFileRenamePolicy());
				
		Care c = new Care();
		c.setCareTitle(mRequset.getParameter("careTitle"));
		c.setCareContent(mRequset.getParameter("careContent"));
		c.setCareAn(Integer.parseInt(mRequset.getParameter("careAn")));
		c.setCareWriter(mRequset.getParameter("careWriter"));
		c.setCarePic(mRequset.getOriginalFileName("filename"));
		c.setCarePath(mRequset.getFilesystemName("filename"));
		

		int result = new CareService().insertCare(c);
	
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if(result>0) {
			request.setAttribute("msg", "후기글 등록 완료");
		}else {
			request.setAttribute("msg", "후기글 등록 실패");
		}
		request.setAttribute("loc", "/careList?reqPage=1");
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
