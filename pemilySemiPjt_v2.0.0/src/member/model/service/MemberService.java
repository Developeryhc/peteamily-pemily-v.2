package member.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import common.JDBCTemplate;
import member.model.vo.MypageData;
import member.model.dao.MemberDao;
import member.model.vo.Member;
import member.model.vo.MemberPage;
import order.model.dao.OrderDao;
import order.model.vo.Order;
import outCa.model.dao.OutCaDao;
import outCa.model.vo.OutCaTable;

public class MemberService {
	public int inserMember(Member m) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new MemberDao().insertMember(conn,m);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		return result;
	}

	public Member selectOneMember(String memberId, String memberPw) {
		Connection conn = JDBCTemplate.getConnection();
		Member m = new MemberDao().selectOneMember(conn,memberId,memberPw);
		JDBCTemplate.close(conn);
		return m;
	}

	public Member selectOneMember(String memberId) {
		Connection conn = JDBCTemplate.getConnection();
		Member m = new MemberDao().selectOneMember(conn, memberId);
		JDBCTemplate.close(conn);
		return m;
	}

	public int updateMember(Member m) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new MemberDao().updateMember(conn,m);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int deleteMember(int memberNo) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new MemberDao().deleteMember(conn,memberNo);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public Member findId(String memberName, String memberPhone, String memberEmail) {
		Connection conn = JDBCTemplate.getConnection();
		Member m = new MemberDao().findId(conn,memberName,memberPhone,memberEmail);
		JDBCTemplate.close(conn);
		return m;
	}

	public MemberPage selectAllMember(int reqPage) {
		Connection conn = JDBCTemplate.getConnection();
		int printList = 10;						//보여줄 게시글 갯수
		int printNavi = 10;						//보여줄 네비 길이
		int end = printList * reqPage;			//list 마지막 값
		int start = end - printList + reqPage;	//list 시작 값
		ArrayList<Member> list = new MemberDao().selectAllMember(conn,start,end);		//게시글 전부
		int totalListCount = new MemberDao().totalListCount(conn);		//총 게시글 수
		int aReqPage = ((reqPage-1) / printNavi) * printNavi+1;
		//네비게이션 마지막 값 설정
		int totalList = totalListCount % printList == 0 ? totalListCount/printList : totalListCount/printList+1;
		//네비 생성 시작
		String navigation = "<div class=\"listPageWrap\">";
		//'<'이전버튼 생성 작업 > 처음 네비 페이지에선 이전버튼 생성 안함
		if(aReqPage != 1) {	// 이때 이전버튼 생성
			navigation += "<a href='/memberList?reqPage="+(aReqPage-1)+"'><img src='images/moveButton/leftBtn1.png'></a>";
		}
		//지정한 길이만큼 네비 생성
		for(int i=0;i<printNavi;i++) {
			//사용자가 보고있는 네비 효과
			if(aReqPage == reqPage) {		//reqPage > 사용자가 요청한(보려는)페이지
				navigation += "<a class='activeNavi' href='/memberList?reqPage="+aReqPage+"'>"+aReqPage+"</a>";
			}else {
				navigation += "<a href='/memberList?reqPage="+aReqPage+"'>"+aReqPage+"</a>";				
			}
			aReqPage++;
			if(aReqPage > totalList) {
				break;
			}
		}
		if(aReqPage <= totalList) {		//11,22,33,44,... > 보다 많다면 다음 버튼 생성
			navigation += "<a href='/memberList?reqPage"+aReqPage+"'><img src='images/moveButton/rightBtn1.png'></a>";
		}
		navigation += "</div>";
		JDBCTemplate.close(conn);
		MemberPage mp = new MemberPage(list, navigation);
		return mp;
	}

	public MypageData myPage(String memberId) {
		Connection conn = JDBCTemplate.getConnection();
		Member m = new MemberDao().selectOneMember(conn, memberId);
		ArrayList<Order> list = new OrderDao().order(conn, memberId);
		MypageData md = new MypageData(m, list);
		JDBCTemplate.close(conn);
		return md;
	}

	public Member findPw(String memberId, String memberPhone, String memberEmail) {
		Connection conn = JDBCTemplate.getConnection();
		Member m = new MemberDao().findPw(conn,memberId,memberPhone,memberEmail);
		JDBCTemplate.close(conn);
		return m;
	}

}
