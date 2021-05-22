<%@page import="notice.model.vo.Notice"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
     pageEncoding="UTF-8"%>
     <%
    	ArrayList<Notice> list = (ArrayList<Notice>)request.getAttribute("list");
     	String pageNavi = (String)request.getAttribute("pageNavi");
     %>
 <!DOCTYPE html>
 <html>
 <head>
 <meta charset="UTF-8">
 <title>Insert title here</title>
 <style>
 	.empMenu:first-child>a{
 		color:#555;
     	background-color:rgb(246,246,246);;
 	}
 </style>
 </head>
 <body>
 	<%@include file="/WEB-INF/views/common/header.jsp" %>
 	<%@include file="/WEB-INF/views/common/empDefault.jsp" %>
 	<%@include file="/WEB-INF/views/employee/employeeNavi.jsp" %>
 	<section>
 		<h2 class="section-headline">직원 공지사항</h2>
 		<table id="notice-table" class="printList">
             <thead>
                 <tr>
                 	<%-- 
                 	<%if(emp != null && emp.getEmpGrade == 1){ %>
                     <th>제목</th><th>작성자</th><th>작성일</th>
                 	<%}else{ %>
                     <th>제목</th><th>작성자</th><th>작성일</th>
                 	<%} %>
                 	--%>
                     <th>제목</th><th>작성자</th><th>작성일</th><th colspan="2"></th>
                 </tr>
             </thead>
             <tbody>
             	<%for(Notice n : list){ %>
             	<%--if(emp != null && emp.getGrade() == 1){ --%>
             		<%-- 여기가 수정/삭제 버튼이 추가된 tr자리 --%>
             		<%--<td><a href="/noticeEmpWriteFrm?noticeNo=<%=n.getNoticeNo()%>"><%=n.getNoticeTitle() %></a></td><td><%=n.getNoticeWriter() %></td><td><%=n.getNoticeDate() %></td> --%>
             	<%--} --%>
             	<tr>
             		<td><a href="/noticeEmpView?noticeNo=<%=n.getNoticeNo()%>"><%=n.getNoticeTitle() %></a></td><td><%=n.getNoticeWriter() %></td><td><%=n.getNoticeDate() %></td><td><button type="button" value="<%=n.getNoticeNo() %>" class="mdBtn modifyBtn">수정</button></td><td><button type="button" value="<%=n.getNoticeNo() %>" class="mdBtn deleteBtn">삭제</button></td>
             	</tr>
             	<%} %>
             </tbody>
         </table>
         <%=pageNavi %>
         <%@include file="/WEB-INF/views/employee/empModal.jsp" %>
         <input type="hidden" class="hiddenModiChk" value="1">
         <input type="hidden" class="hiddenDelChk" value="11">
 	</section>
 	<%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>