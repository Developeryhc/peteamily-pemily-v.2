package notice.model.controller;

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

import notice.model.service.NoticeService;
import notice.model.vo.Notice;

/**
 * Servlet implementation class NoticeWriteServlet
 */
@WebServlet(name = "NoticeWrite", urlPatterns = { "/noticeWrite" })
public class NoticeWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				request.setCharacterEncoding("utf-8");
//				String content = request.getParameter("noticeContent");
//				String title = request.getParameter("noticeTitle");
				
				int noticeCom = Integer.parseInt(request.getParameter("noticeChoice"));
				String noticeWriter = request.getParameter("noticeWriter");
				String noticeTitle = request.getParameter("noticeTitle");
				String noticeContent = request.getParameter("noticeContent");
				
				Notice n = new Notice();
				n.setNoticeContent((noticeContent));
				n.setNoticeTitle((noticeTitle));
				n.setNoticeCom((noticeCom));
				n.setNoticeWriter((noticeWriter));
				
				//4
				int result = new NoticeService().insertNotice(n);
				
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
				if(result>0) {
					request.setAttribute("msg", "공지사항 등록 성공");
				}else {
					request.setAttribute("msg", "공지사항 등록 실패");
				}
				if(noticeCom==1) {
					request.setAttribute("loc", "/noticeEmpList?reqPage=1&noticeCom=1");
				}else if(noticeCom==2) {
					request.setAttribute("loc", "/community?reqPage=1&noticeCom=2");
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
