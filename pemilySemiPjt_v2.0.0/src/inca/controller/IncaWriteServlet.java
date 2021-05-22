package inca.controller;

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

import inca.model.service.IncaService;
import inca.model.vo.Inca;

/**
 * Servlet implementation class IncaWriteServlet
 */
@WebServlet(name = "IncaWrite", urlPatterns = { "/incaWrite" })
public class IncaWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IncaWriteServlet() {
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
		// 파일 업로드를 하는 경우 enctype="multipart/form-data"로 처리해야하므로 enctype이 정상인지 확인
		if(!ServletFileUpload.isMultipartContent(request)) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
			request.setAttribute("msg", "Notice Error[enctype]");
			request.setAttribute("loc", "/");
			rd.forward(request, response);
			return;
		}
		// 파일 업로드 준비
		// a) 파일 업로드 경로 지정
		String root = getServletContext().getRealPath("/"); // Web 폴더 경로 가져오는 코드 (workspace)
		String saveDirectory = root+"upload/inca";		// 파일 저장 경로 지정
		System.out.println("파일 저장 결로 : "+saveDirectory);
		// b) 업로드 파일의 최대크기 지정 (일반적으로 웹은 10Mb 정도 사용)
		int maxSize = 10*1024*1024;
		// c) request → MultipartRequest 객체로 변환 (파일은 다른 형태라서 그럼)
		// 파라미터 5개 = request객체, 파일 저장 경로, 최대 크기, 인코딩 타입, 파일명 중복 처리 객체
		// 파일이 업로드 되는 코드
		MultipartRequest mRequest = new MultipartRequest(request, saveDirectory, maxSize, "UTF-8", new DefaultFileRenamePolicy());
		Inca i = new Inca();
		i.setIncaAn(Integer.parseInt(mRequest.getParameter("incaAn")));
		i.setIncaName(mRequest.getParameter("incaName"));
		i.setIncaGender(mRequest.getParameter("incaGender"));
		i.setIncaMonth(Integer.parseInt(mRequest.getParameter("incaMonth")));
		i.setIncaCondition(Integer.parseInt(mRequest.getParameter("incaCondition")));
		i.setIncaPrice(Integer.parseInt(mRequest.getParameter("incaPrice")));
		i.setIncaStore(Integer.parseInt(mRequest.getParameter("incaStore")));
		i.setIncaPic(mRequest.getOriginalFileName("incaPic"));	// 사용자가 업로드한 파일 명
		i.setIncaPath(mRequest.getFilesystemName("incaPic"));	// 실제 업로드 된 파일 이름
		// getOriginalFileName, getFilesystemName 매개변수는 <input type="file" name=""> name 속성값
		// 3. 비즈니스 로직
		int result = new IncaService().insertInca(i);
		// 4. 결과 처리
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if(result>0) {
			request.setAttribute("msg", "Inca Register Complete");
		}else {
			request.setAttribute("msg", "Inca Register Falied");
		}
		request.setAttribute("loc", "/caList?reqPage=1");
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
