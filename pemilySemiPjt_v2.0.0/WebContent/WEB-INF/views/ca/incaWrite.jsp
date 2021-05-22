<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>

</style>
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
	<div class="container">
		<h1 style="text-align:center;">IncaWriter</h1>	
		<form action="/incaWrite" method="post" enctype="multipart/form-data">
			<input type="text" name="an" placeholder="종번호">
			<input type="text" name="name" placeholder="이름">
			<input type="text" name="gender" placeholder="성별">
			<input type="text" name="month" placeholder="개월">
			<input type="text" name="condition" placeholder="접종">
			<input type="text" name="price" placeholder="분양가">
			<input type="text" name="store" placeholder="지점">
			<input type="file" name="filename" placeholder="사진">
			<button type="submit">업로드</button>
		</form>
	</div>
</body>
</html>