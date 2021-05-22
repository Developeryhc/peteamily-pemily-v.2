<%@page import="inPro.model.vo.InPro"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    InPro inPro = (InPro)request.getAttribute("inPro");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
	<%@include file="/WEB-INF/views/common/empDefault.jsp" %>
	<%@include file="/WEB-INF/views/employee/employeeNavi.jsp" %>
	<section>
		<%=inPro.getInProName() %>
		<%=inPro.getInProPrice() %>
	<%@include file="/WEB-INF/views/employee/empModal.jsp" %>
        <span class="hiddenTextChk">inca</span>
	</section>
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>