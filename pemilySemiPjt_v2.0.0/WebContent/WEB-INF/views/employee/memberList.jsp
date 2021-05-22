<%@page import="member.model.vo.Member"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    ArrayList<Member> list = (ArrayList<Member>)request.getAttribute("list");
    String navigation = (String)request.getAttribute("navigation");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.empMenu:nth-child(7)>a{
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
		<h2 class="section-headline">회원</h2>
	    <table id="memberList" class="printList">
	        <thead>
	            <tr>
	                <th>No</th><th>회원아이디</th><th>회원Email</th><th>전화번호</th><th>가입일</th><th>상담 결과</th>
	            </tr>
	        </thead>
	        <tbody>
	        	<%for(Member ml : list){ %>
	            <tr>
	                <td><%=ml.getSort() %></td><td><%=ml.getMemberId() %></td><td><%=ml.getMemberEmail() %></td><td><%=ml.getMemberPhone() %></td><td><%=ml.getMemberEnter() %></td>
	                <td>
	                <%
	                	String an = ml.getMemberAn() == 0 ? "입양 불가" : "입양 가능";
	                %>
	                	<select id="caCheck">
	                		<option selected><%=an %></option>
	                		<option value="0">입양 불가</option>
	                		<option value="1">입양 가능</option>
	                	</select>
	                </td>
	            </tr>
	        	<%} %>
	        </tbody>
	    </table>
		<%=navigation %>	    
	</section>
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>