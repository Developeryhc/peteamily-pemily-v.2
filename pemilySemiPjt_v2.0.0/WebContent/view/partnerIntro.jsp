<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		border: 1px solid black;
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
		color : rgba(238, 140, 148, 0.60);
	}
	.partner{
		width:49%;
		height:600px;
		float:left;
	}
	.image{
		height:60%;
	}
	.partner>*{
		color : rgba(238, 140, 148, 0.60);
	}
	
	img{
		width:95%;	
	}
	a{
		text-decoration:none;
		display:block;
		text-align:center;
		line-height:100px;
		font-size:23px;
		color: black;
	}
	a:hover{
		color: rgba(238, 140, 148, 0.60);
	}
</style>
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
	<div class="top">
		<div class="text">
			<br><br><br><br>
			<h1>Pemily Partner는</h2>
			<h3>Pemily를 이용해주시는 고객분들을 위한 서비스입니다.</h4>
			<h3>미용부터 건강검진까지 Pemily와 제휴를 맺은 업체를 통해</h4>
			<h3>합리적인 서비스를 경험하세요.</h4>
		</div>
		<div class="topimg">
			<img src="/img/top.jpg" id="top">
		</div>
	</div><br>
	<div class="middle">
		<div class="divide"><a href="#" style="color:rgba(238, 140, 148, 0.60);">뷰티</a></div>
		<div class="divide"><a href="#">라이프</a></div>
		<div class="divide"><a href="#">의료</a></div>
	</div><br>
	<div class="body">
		<div class="partner">
			<div class="img">
				<img src="/img/body1.png">
			</div>
			<div class="intro">
				<h5>벨르앙쥬 애견펜션</h5>
				<h5>대표 : 최경운</h5>
				<h5>연락처 : 010-8888-8888</h5>
				<h5>Pemily 고객 이용료 60%할인</h5>
			</div>
		</div>
		<div class="partner">
			<div class="img">
				<img src="/img/body2.jpg">
			</div>
			<div class="intro">
				<h5>메이트 동물병원</h5>
				<h5>대표 : 조정욱</h5>
				<h5>연락처 : 010-8888-8888</h5>
				<h5>Pemily 고객 진료비 80%할인</h5>
			</div>
		</div>
		<div class="partner">
			<div class="img">
			
			</div>
			<div class="intro">
			
			</div>
		</div>
		<div class="partner">
			<div class="img">
			
			</div>
			<div class="intro">
			
			</div>
		</div>
		<div class="partner">
			<div class="img">
			
			</div>
			<div class="intro">
			
			</div>
		</div>
		<div class="partner">
			<div class="img">
			
			</div>
			<div class="intro">
			
			</div>
		</div>
	</div>
</body>
</html>