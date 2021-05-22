<%@page import="ca.model.vo.Adopt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    Adopt adopt = (Adopt)request.getAttribute("adopt");
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
	<div class="container">
		<%@include file="/WEB-INF/views/ca/caMenu.jsp" %>
		<div class="main-left">
			<img src="/upload/inca/'<%= adopt.getInca().getIncaPath()%>'">
			<div>
				<p>이름 : <%=adopt.getInca().getIncaName()%></p>
				<p>개월 : <%=adopt.getInca().getIncaMonth()%></p>
				<p>성별 : <%=adopt.getInca().getIncaGender() %></p>
				<p>★ 이런분이 가족이였으면 좋겠어요 ! ☆</p>
				<p><%=adopt.getCa().getCaContent() %></p>
			</div>
		</div>
	</div>
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>