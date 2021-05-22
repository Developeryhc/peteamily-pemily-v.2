<%@page import="member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	Member m1 = (Member)session.getAttribute("member");
    %>
	<!-- 직원페이지 메뉴 css -->
<nav class="emp-nav-Wrap">
    <ul class="emp-nav">
	    <li class="empMenu"><a href="/noticeEmpList?reqPage=1&noticeCom=1">공지사항</a></li>
	    <li class="empMenu"><a href="/caList?reqPage=1">반려동물 목록</a></li>
	    <li class="empMenu"><a href="/productList?reqPage=1">물품 재고</a></li>
	    <!-- 밑의 메뉴는 관리자 계정만 가능 -->
	    <%if(m1 != null && m1.getMemberGrade() == 1){ %>
	    <li class="empMenu"><a href="/staffAddFrm">노예 등록</a>
	    <%} %>
	    <li class="empMenu"><a href="/outCaList?reqPage=1">분양 내역</a></li>
	    <li class="empMenu"><a href="/outProList?reqPage=1">판매 내역</a></li>
	    <li class="empMenu"><a href="/empList?reqPage=1">직원 목록 </a></li>
	    <li class="empMenu"><a href="/memberList?reqPage=1">회원 목록</a></li>
	    <li class="empMenu"><a href="/insertPage">등록하기</a></li>
    </ul>
</nav>