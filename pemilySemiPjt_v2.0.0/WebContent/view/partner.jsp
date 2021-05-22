<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	.top{
		text-align:center;
	}
	table{
		width:100%;
		padding-left :100px;
		padding-right:100px;
		
	}
	tr{
		height:60px;
		
	}
	select{
		width:210px;
		height:35px;
	}
	input{
		height:30px;
		width:200px;
	}
	th{
		background-color: rgba(174, 215, 232, 0.73) ;
		width:17%;	
		border-bottom:1px solid rgba(174, 215, 232, 0.73);
	}
	td{
		padding-left:50px;
		border-bottom:1px solid rgba(174, 215, 232, 0.73);
	}
	#button{
		text-align:center;
	}
	button{
		border:0;
		background-color: rgba(174, 215, 232, 0.73) ;
		font-size:18px;
		border-radius:5px;
		width:150px;
		height:50px;
	}
	.top{
		background-image:url(/img/intro-2.jpg);
		background-size:cover;
		height:500px;
	}
	.top>h1{
		padding-top:20px;
	}
</style>
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
	<br>
	<div class="container">
		<div class="top">
			<h1>가맹문의</h1>
			<h2>Pemily에서 함께할 파트너를 찾습니다.</h2>
			<h3>미용부터 건강검진까지 다양한 제휴업체들과의 협력을 통해 더 나은 서비스를 제공하기 위해</h3>
			<h3>여러분들의 제안을 기다립니다.</h3>
			<br>
		</div><br>
		<div class="body">
		<form action="/partner" method="post" enctype="multipart/form-data">
			<table>
				<tr>
					<th>구분</th>
					<td>
						<select name="partnerSort">
							<option value="뷰티">뷰티</option>
							<option value="라이프">라이프</option>
							<option value="의료">의료</option>
						</select>
					</td>
				</tr>
				<tr>
					<th>제목</th>
					<td>
						<input type="text" name="title">
					</td>
				</tr>
				<tr>
					<th>기업명</th>
					<td>
						<input type="text" name="partnerName">
					</td>
				</tr>
				<tr>
					<th>담당자명</th>
					<td>
						<input type="text" name="partnerEmp">
					</td>
				</tr>
				<tr>
					<th>연락처</th>
					<td>
						<input type="text" name="phone" placeholder="-포함하여 입력">
					</td>
				</tr>
				<tr>
					<th>이메일</th>
					<td>
						<input type="text" name="email">
					</td>
				</tr>
				<tr>
					<th>내용</th>
					<td>
						<input type="text" name="content">
					</td>
				</tr>
				<tr>
					<th>이미지 첨부</th>
					<td>
						<input type="file" name="filename">
					</td>
				</tr>
			</table><br><br>
			<div id="button">
				<button type="submit" >신청하기</button><br><br><br>
			</div>
			</form>
		</div>
	 </div>
</body>
</html>