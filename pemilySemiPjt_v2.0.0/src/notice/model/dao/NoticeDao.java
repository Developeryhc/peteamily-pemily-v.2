package notice.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import care.model.vo.Care;
import common.JDBCTemplate;
import notice.model.vo.Notice;
import notice.model.vo.NoticeWriteInfo;

public class NoticeDao {

	public ArrayList<Notice> selectNoticeList(Connection conn, int noticeCom, int start, int end) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Notice> list = new ArrayList<Notice>();
		String query =    "select * from (select rownum as rnum, n. * from(select * from notice where notice_com=? order by notice_no desc)n) where rnum between ? and ?";
		
		try {
			pstmt= conn.prepareStatement(query);
			pstmt.setInt(1, noticeCom);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Notice n = new Notice();
				n.setNoticeContent(rset.getString("notice_content"));
				n.setNoticeDate(rset.getString("notice_date"));
				n.setNoticeNo(rset.getInt("notice_no"));
				n.setNoticeTitle(rset.getString("notice_title"));
				n.setNoticeWriter(rset.getString("notice_writer"));
				n.setNoticeCom(rset.getInt("notice_com"));
				n.setRnum(rset.getInt("rnum"));
				list.add(n);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public int totalCount(Connection conn, int noticeCom) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select count(*) as cnt from notice where notice_com=?"; //cnt는 별칭!
		int result = 0;  //여기서 쓰는 변수 int는 count에 대한 변수임!
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, noticeCom);
			rset = pstmt.executeQuery();
			if(rset.next()) {  //count 쿼리문을 쓰면 총게시물 : 85개! 이런식으로 나와서 if임
				result = rset.getInt("cnt");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public Notice selectOneCare(Connection conn, int noticeNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from notice where notice_no=?";
		Notice n = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, noticeNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				n = new Notice();
				n.setNoticeContent(rset.getString("notice_content"));
				n.setNoticeDate(rset.getString("notice_date"));
				n.setNoticeNo(rset.getInt("notice_no"));
				n.setNoticeTitle(rset.getString("notice_title"));
				n.setNoticeWriter(rset.getString("notice_writer"));
				n.setNoticeCom(rset.getInt("notice_com"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return n;
	}
	
	public int deleteNotice(Connection conn, int noticeNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "delete from notice where notice_no=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, noticeNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	public int insertNotice(Connection conn, Notice n) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "insert into notice values(notice_seq.nextval,?,?,?,to_char(sysdate,'yyyy-mm-dd'),?)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, n.getNoticeWriter());
			pstmt.setString(2, n.getNoticeTitle());
			pstmt.setString(3, n.getNoticeContent());
			pstmt.setInt(4, n.getNoticeCom());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public NoticeWriteInfo selectOneNoticeInfo(Connection conn, int noticeNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		NoticeWriteInfo nwi = null;
		String query = "select n.*,e.emp_path,e.emp_name,e.emp_phone from notice n join emp e on notice_writer = emp_id where notice_no=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, noticeNo);
			rset = pstmt.executeQuery();
			if(rset.next()){
				nwi = new NoticeWriteInfo();
				nwi.setNoticeContent(rset.getString("notice_content"));
				nwi.setNoticeDate(rset.getString("notice_date"));
				nwi.setNoticeNo(rset.getInt("notice_no"));
				nwi.setNoticeTitle(rset.getString("notice_title"));
				nwi.setNoticeWriter(rset.getString("notice_writer"));
				nwi.setNoticeCom(rset.getInt("notice_com"));
				nwi.setEmpName(rset.getString("emp_name"));
				nwi.setEmpPath(rset.getString("emp_path"));
				nwi.setEmpPhone(rset.getString("emp_phone"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return nwi;
	}

	public int searchOneNoticeNo(Connection conn, int noticeCom) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int noticeNo = 0;
		String query = "select notice_no from(select rownum as sort, n.* from(select * from notice where notice_com=? order by notice_no desc) n) where sort=1";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, noticeCom);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				noticeNo = rset.getInt("notice_no");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return noticeNo;
	}

	public int modifyEmpNotice(Connection conn, int noticeNo, Notice n) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "update notice set notice_writer=?,notice_content=?,notice_title=? where notice_no=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, n.getNoticeWriter());
			pstmt.setString(2, n.getNoticeContent());
			pstmt.setString(3, n.getNoticeTitle());
			pstmt.setInt(4, noticeNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int deleteEmpNotice(Connection conn, int noticeNo) {
		PreparedStatement pstmt = null;
		String query = "delete from notice where notice_no=?";
		int result = 0;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, noticeNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	public Notice selectOneNotice(Connection conn, int noticeNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from notice where notice_no=?";
		Notice n = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, noticeNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				n = new Notice();
				n.setNoticeContent(rset.getString("notice_content"));
				n.setNoticeDate(rset.getString("notice_date"));
				n.setNoticeNo(rset.getInt("notice_no"));
				n.setNoticeTitle(rset.getString("notice_title"));
				n.setNoticeWriter(rset.getString("notice_writer"));
				n.setNoticeCom(rset.getInt("notice_com"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return n;
	}
	public int updateNotice(Connection conn, Notice n) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "update notice set notice_title=?, notice_content=? where notice_no=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, n.getNoticeTitle());
			pstmt.setString(2, n.getNoticeContent());
			pstmt.setInt(3, n.getNoticeNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}


}
