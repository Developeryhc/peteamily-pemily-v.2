<%@page import="outCa.model.vo.OutCa"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    ArrayList<OutCa> list = (ArrayList<OutCa>)request.getAttribute("list");
    String navigation = (String)request.getAttribute("navigation");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.empMenu:nth-child(4)>a{
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
		<h2 class="section-headline">분양</h2>
	    <table id="outCaList" class="printList">
	        <thead>
	            <tr>
	                <th>No</th><th>입양동물</th><th>입양자</th><th>분양가</th><th>분양지점</th><th>담당 매니저</th><th>분양일</th><th>계약서</th>
	            </tr>
	        </thead>
	        <tbody>
	            <%for(OutCa oCa : list){ %>
	            <%
	            	String store = oCa.getOutCaStore() == 1 ? "본사" : (oCa.getOutCaStore() == 2 ? "강남" : "부산");
	            	String ani = oCa.getOutCaAn()==1?"강아지":(oCa.getOutCaAn()==2?"고양이":(oCa.getOutCaAn()==3?"어류":(oCa.getOutCaAn()==4?"도마뱀":(oCa.getOutCaAn()==5?"설치류":(oCa.getOutCaAn()==6?"뱀":(oCa.getOutCaAn()==7?"절지류":"기타"))))));
	            %>
	            <tr>
	            	<td><%=oCa.getSort() %></td><td><%=ani %></td><td><%=oCa.getOutCaMi() %></td><td><%=oCa.getOutCaPrice() %><span class="won">원</span></td><td><%=store %></td><td><%=oCa.getOutCaEmp() %></td><td><%=oCa.getOutCaDate() %></td><td><button class="mdBtn downBtn">Down</button></td>
	            </tr>
	            <%} %>
	        	<%if(list.isEmpty()) {%>
       			<tr><td colspan="8">분양 내역이 없습니다...</td></tr>
	        	<%} %>
	        </tbody>
	    </table>
	    <%=navigation %>
	</section>
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>