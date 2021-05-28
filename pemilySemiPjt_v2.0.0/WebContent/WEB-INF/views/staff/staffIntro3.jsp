<%@page import="contact.model.vo.Emp"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    ArrayList<Emp> list = (ArrayList<Emp>)request.getAttribute("list");
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	
	.top{
		width:78%;
		margin:0 auto;
		
		overflow:hidden;
	}
	.body{
		width:78%;
		margin:0 auto;
		
		overflow:hidden;
	}
	.middle{
		width:78%;
		height:100px;
		margin:0 auto;
		border:1px solid black;
		overflow:hidden;
	}
	.top>div{
		width:49%;
		
		float:left;
		height:400px;
	}
	.divide{
		float:left;
		width:33%;
		
	}
	
	.text>*{
		color : rgba(182, 215, 168, 1.00);
	}
	.staff{
		width:49%;
		
		float:left;
	}
	.image{
		height:60%;
	}
	
	.img>img{
		height:500px;
		width:95%;
	}
	.divide>a{
		text-decoration:none;
		display:block;
		text-align:center;
		line-height:100px;
		font-size:23px;
		color: black;
	}
	a:hover{
		color:rgba(182, 215, 168, 1.00);
	}
</style>
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
	<br><br>
	
		<div class="top">
		<div class="text">
			<br><br><br><br>
			<h1>Pemily 전 직원들은</h2>
			<h3>반려동물 관련 자격증을 보유하고 있습니다.</h4>
			<h3>고객님이 안심하고 맡겨주실 수 있도록</h4>
			<h3>전문 자격증을 소유한 직원들만이 반려동물을 관리합니다.</h4>
		</div>
		<div class="topimg">
			<img src="/img/staff1.png" id="top">
		</div>
	</div><br>
	<div class="middle">
		<div class="divide"><a href="/staff?store=1">당산 본점</a></div>
		<div class="divide"><a href="/staff?store=2">강남점</a></div>
		<div class="divide"><a href="#" style="color:rgba(182, 215, 168, 1.00);">부산점</a></div>
	</div><br>
	<div class="body">
		<%for(int i =0;i<list.size();i++) {%>
			<div class="staff">
			<div class="img">
				<img src="/upload/staff/<%=list.get(i).getFilepath() %>">
			</div>
			<div class="intro">
				<h2><%=list.get(i).getEmpJob() %></h5>
				<h5>이름 : <%=list.get(i).getEmpName() %></h5>
				<h5>연락처 : <%=list.get(i).getEmpPhone() %></h5>
				<h5>주소 : <%=list.get(i).getEmpAddr() %></h5>
				<h5>입사일 : <%=list.get(i).getEmpEnter() %></h5>
			</div>
		</div>
		<%} %>
		
		
	</div><br><br>
	<%@include file="/WEB-INF/views/common/footer.jsp"%>
</body>
</html>