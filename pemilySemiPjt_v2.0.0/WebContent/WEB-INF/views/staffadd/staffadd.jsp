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
		background-color:rgba(174, 215, 232, 0.73);
	}
	.top>h1{
		padding-top:20px;
	}
</style>
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
	<br><br>
	<div class="container">
		<div class="top">
			<h1>직원추가</h1>
			
			<br>
		</div><br>
		<div class="body">
		<form action="/staffAdd" method="post" enctype="multipart/form-data">
			<table>
				<tr>
					<th>구분</th>
					<td>
						<select name="empJob">
							<option value="반려동물관리사">반려동물 관리사</option>
							<option value="수의사">수의사</option>
							<option value="입양플래너">입양플래너</option>
							<option value="반려동물핸들러">반려동물 핸들러</option>
							<option value="반려동물행동교정사">반려동물 행동교정사</option>
						</select>
					</td>
				</tr>
				<tr>
					<th>아이디</th>
					<td>
						<input type="text" name="empId">
					</td>
				</tr>
				<tr>
					<th>패스워드</th>
					<td>
						<input type="text" name="empPw">
					</td>
				</tr>
				<tr>
					<th>이름</th>
					<td>
						<input type="text" name="empName">
					</td>
				</tr>
				<tr>
					<th>등급</th>
					<td>
						<input type="text" name="empGrade" placeholder="1,2,3 중 입력">
					</td>
				</tr>
				<tr>
					<th>성별</th>
					<td>
						<input type="text" name="empGender" placeholder="M 또는 F">
					</td>
				</tr>
				
				<tr>
					<th>연락처</th>
					<td>
						<input type="text" name="phone" placeholder="-포함">
					</td>
				</tr>
				
				<tr>
					<th>주소</th>
					<td>
						<input type="text" name="addr">
					</td>
				</tr>
				<tr>
					<th>근무지점</th>
					<td>
						<input type="text" name="empStore" placeholder="본점=1,강남점=2,부산점=3">
					</td>
				</tr>
				<tr>
					<th>입사일</th>
					<td>
						<input type="text" name="empEnter" placeholder="YYYY-MM-DD">
					</td>
				</tr>
				<tr>
					<th>사진 첨부</th>
					<td>
						<input type="file" name="filename">
					</td>
				</tr>
			</table><br><br>
			<div id="button">
				<button type="submit" >추가하기</button><br><br><br>
			</div>
			</form>
		</div>
	</div>  
</body>
</html>