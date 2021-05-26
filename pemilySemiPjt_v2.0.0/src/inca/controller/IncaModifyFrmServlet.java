package inca.controller;

import java.io.IOException;
import java.io.PrintWriter;

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
 * Servlet implementation class IncaModifyFrmServlet
 */
@WebServlet(name = "IncaModifyFrm", urlPatterns = { "/incaModifyFrm" })
public class IncaModifyFrmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IncaModifyFrmServlet() {
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
		//파일 업로드 > enctype = multipart/form-data , post
		if(!ServletFileUpload.isMultipartContent(request)) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
			request.setAttribute("msg", "Modify Error[enctype]");
			request.setAttribute("loc", "/caList?reqPage=1");
			rd.forward(request, response);
			return;
		}
		System.out.println("test");
		//파일 크기 제한, 경로 설정
		String root = getServletContext().getRealPath("/");
		String saveDirectory = root+"upload/inca/";
		int maxSize = 10 * 1024 * 1024;
		//파일 업로드로 요청한 경우 MultipartRequest로 data를 꺼내온다.
		MultipartRequest mRequest = new MultipartRequest(request, saveDirectory,maxSize,"UTF-8",new DefaultFileRenamePolicy());
		int incaNo = Integer.parseInt(mRequest.getParameter("incaNo"));
		int incaPrice = Integer.parseInt(mRequest.getParameter("incaPrice"));
		int incaCondition = Integer.parseInt(mRequest.getParameter("incaCondition"));
		int incaStore = Integer.parseInt(mRequest.getParameter("incaStore"));
		String incaPic = mRequest.getOriginalFileName("incaPic");
		String incaPath = mRequest.getFilesystemName("incaPic");
		String oldIncaPic = mRequest.getParameter("oldIncaPic");
		String oldIncaPath = mRequest.getParameter("oldIncaPath");
		System.out.println(incaPic);
		System.out.println(incaPath);
		System.out.println(oldIncaPic);
		System.out.println(oldIncaPath);
		if(incaPic == null || incaPath == null) {
			incaPic = oldIncaPic;
			incaPath = oldIncaPath;
		}
		//3.
		Inca inca = new Inca();
		inca.setIncaPrice(incaPrice);
		inca.setIncaCondition(incaCondition);
		inca.setIncaStore(incaStore);
		inca.setIncaPic(incaPic);
		inca.setIncaPath(incaPath);
		int result = new IncaService().incaModify(inca,incaNo);
		//4.
		PrintWriter out = response.getWriter();
		out.print(result);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
