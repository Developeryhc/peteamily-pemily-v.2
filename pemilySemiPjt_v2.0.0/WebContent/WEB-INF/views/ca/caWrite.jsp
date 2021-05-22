<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	.title{
		outline: none;
		border: 1px solid #00000032;
		border-radius: 3px;
		width: 99.45%;
		height: 30px;
	}
	.note-editor{
		margin: 20px 0;
	}
	button{
		border: none;
		width: 80px;
		height: 30px;
	}
	.update{
		background-color: rgba(238, 140, 148, 0.60);
		box-shadow: 1px 1px 1px 1px rgba(238, 140, 148, 0.3);
	}
	.cancel{
		background-color: rgba(242, 217, 207, 0.84);
		box-shadow: 1px 1px 1px 1px rgba(242, 217, 207, 0.3);
	}
	.btn-wrap{
		text-align: center;
	}
</style>
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
	<div class="container">
		<h1 style="text-align:center;">AdoptUpdate</h1>	
		<form action="/caInsert" method="post" enctype="multipart/form-data">
		<input type="text" class="title" name="title" placeholder=" 제목을 입력해주세요.">
		<textarea class="summernote" name="content"></textarea>
		<div class="btn-wrap">
			<button type="submit" class="update">Update</button>
			<button type="reset" class="cancel">Cancel</button>
		</div>
		</form>
	</div>
</body>
</html>