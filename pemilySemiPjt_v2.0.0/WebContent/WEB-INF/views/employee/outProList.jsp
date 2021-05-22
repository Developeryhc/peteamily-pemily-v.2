<%@page import="outProduct.model.vo.OutPro"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	ArrayList<OutPro> list = (ArrayList<OutPro>)request.getAttribute("list");
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
    	background-color:rgb(246,246,246);
	}
</style>
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
	<%@include file="/WEB-INF/views/common/empDefault.jsp" %>
	<%@include file="/WEB-INF/views/employee/employeeNavi.jsp" %>
	<section>
	    <h2 class="section-headline">상품 판매 내역</h2>
	    <table id="outPro" class="printList">
	        <thead>
	            <tr>
	                <th>No</th><th>상품번호</th><th>구매자</th><th>판매수량</th><th>판매가</th><th>거래일</th>
	            </tr>
	        </thead>
	        <tbody>
	            <%
	            	for(OutPro outPro : list){
	            %>
	            <tr>
	            	<td><%=outPro.getSort() %></td><td><%=outPro.getOutProPn() %></td><td><%=outPro.getOutProMi() %></td><td><%=outPro.getOutProAmount() %><span class="won">개</span></td><td><%=outPro.getOutProPrice() %><span class="won">원</span></td><td><%=outPro.getOutProDate() %></td>
	            </tr>
	            <%} %>
	        </tbody>
	    </table>
	    <%=navigation %>
	</section>
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>