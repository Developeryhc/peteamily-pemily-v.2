package inProduct.model.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import inPro.model.vo.InPro;
import inProduct.model.service.InProductService;

/**
 * Servlet implementation class InProductWriteServlet
 */
@WebServlet(name = "InProductWrite", urlPatterns = { "/inProductWrite" })
public class InProductWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InProductWriteServlet() {
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
		//2. 파일 전송이 있는 form
		String root = getServletContext().getRealPath("/");
		String saveDirectory = root+"upload/inProduct";
		int maxSize = 10 * 1024 * 1024;
		MultipartRequest mRequest = new MultipartRequest(request, saveDirectory, maxSize, "UTF-8", new DefaultFileRenamePolicy());
		InPro inPro = new InPro();
		inPro.setInProAmount(Integer.parseInt(mRequest.getParameter("inProAmount")));
		inPro.setInProName(mRequest.getParameter("inProName"));
		inPro.setInProPrice(Integer.parseInt(mRequest.getParameter("inProPrice")));
		inPro.setInProSn(Integer.parseInt(mRequest.getParameter("inProSn")));
		inPro.setInProPic(mRequest.getOriginalFileName("inProPic"));
		inPro.setInProPath(mRequest.getFilesystemName("inProPic"));
		//3.
		int result = new InProductService().insertInProduct(inPro);
		//4.
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if(result>0) {
			request.setAttribute("msg", "등록완료");			
			request.setAttribute("loc", "/productList?reqPage=1");			
		}else {
			request.setAttribute("msg", "등록실패");			
			request.setAttribute("loc", "/insertPage");			
		}
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
