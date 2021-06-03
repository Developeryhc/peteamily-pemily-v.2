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
	.empMenu:nth-child(5)>a{
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
		<h2 class="section-headline">분양 내역</h2>
	    <table id="outCaList" class="printList">
	        <thead>
	            <tr>
	                <th>No</th><th>입양동물</th><th>입양자</th><th>분양가</th><th>분양지점</th><th>담당 매니저</th><th>분양일</th><th>계약서</th>
	            </tr>
	        </thead>
	        <tbody>
	            <%for(OutCa oCa : list){
	            	String store = oCa.getOutCaStore() == 1 ? "본사" : (oCa.getOutCaStore() == 2 ? "강남" : "부산");
	            	String ani = oCa.getIncaAn()==2?"강아지":(oCa.getIncaAn()==3?"고양이":(oCa.getIncaAn()==4?"어류":(oCa.getIncaAn()==5?"도마뱀":(oCa.getIncaAn()==6?"설치류":(oCa.getIncaAn()==7?"뱀":(oCa.getIncaAn()==7?"절지류":"기타"))))));%>
		            <%if(oCa.getSort()%2==0){ %>
		            <tr class="stripeTr1">
		            <%}else{ %>
		            <tr class="stripeTr2">
		            <%} %>
		            	<td><%=oCa.getSort() %></td><td>[ <%=ani %> ] <%=oCa.getIncaName() %></td><td><%=oCa.getOutCaMi() %></td><td><span class="priceFormat"><%=oCa.getOutCaPrice() %></span><span class="won">원</span></td><td><%=store %></td><td><%=oCa.getOutCaEmp() %></td><td><%=oCa.getOutCaDate() %></td><td><button class="mdBtn downBtn">Down</button></td>
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