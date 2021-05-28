<%@page import="notice.model.vo.Notice"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
     pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
                 <c:choose>
                 	<c:when test="${not empty sessionScope.e && sessionScope.e.empGrade <= 3 }">
                     	<th>제목</th><th>작성자</th><th>작성일</th><th colspan="2"></th>
                 	</c:when>
                 	<c:otherwise>
	                     <th>제목</th><th>작성자</th><th>작성일</th>
                 	</c:otherwise>
                 </c:choose>
                 </tr>
             </thead>
             <tbody>
           	<c:forEach items="${list }" var="n" varStatus="i">
           		<c:choose>
	           		<c:when test="${i.count % 2 == 0 }">
			           	<tr class="stripeTr1">
		           	</c:when>
		           	<c:otherwise>
			           	<tr class="stripeTr2">
		           	</c:otherwise>
	           	</c:choose>
		                   	<td><a href="/noticeEmpView?noticeNo=${n.noticeNo }">${n.noticeTitle }</a></td><td>${n.noticeWriter }</td><td>${n.noticeDate }</td>
		               	<c:if test="${not empty sessionScope.e && sessionScope.e.empGrade <= 3 }">
		                   	<td><button type="button" value="${n.noticeNo }" class="mdBtn modifyBtn">수정</button></td><td><button type="button" value="${n.noticeNo }" class="mdBtn deleteBtn">삭제</button></td>
		               	</c:if>
			           	</tr>
           	</c:forEach>
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