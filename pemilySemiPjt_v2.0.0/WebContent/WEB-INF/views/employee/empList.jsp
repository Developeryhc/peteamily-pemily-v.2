<%@page import="employee.model.vo.Employee"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    ArrayList<Employee> list = (ArrayList<Employee>)request.getAttribute("list");
    String navigation = (String)request.getAttribute("navigation");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.empMenu:nth-child(6)>a{
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
		<h2 class="section-headline">직원</h2>
	    <table id="empList" class="printList">
	        <thead>
	            <tr>
	                <th>No</th><th>직원아이디</th><th>직원이름</th><th>소속</th><th>직급</th><th>TEL</th>
	            </tr>
	        </thead>
	        <tbody>
	            <%for(Employee emp : list){ %>
	            <%
	            	String store = emp.getEmpStore() == 1 ? "본사" : (emp.getEmpStore() == 2 ? "강남" : "부산");
	            	String position = emp.getEmpGrade() == 1?"회장":(emp.getEmpStore()==2?"지점장":(emp.getEmpStore()==3?"주임":"사원"));
	            %>
	            <tr>
	            	<td><%=emp.getSort() %></td><td><%=emp.getEmpId() %></td><td><%=emp.getEmpName()%></td><td><%=store %></td><td><%=position %></td><td><%=emp.getEmpPhone() %>	
	            </tr>
	            <%} %>
	        </tbody>
	    </table>
	    <%=navigation %>
	</section>
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>