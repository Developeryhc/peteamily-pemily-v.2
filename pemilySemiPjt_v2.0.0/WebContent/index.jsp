<%@page import="member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Pemily에 오신것을 환영합니다.</title>
</head>
<link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Yanone+Kaffeesatz&display=swap" rel="stylesheet">
<script type="text/javascript" src="/js/jquery-3.3.1.js"></script>
<style>
	body{
		margin: 0;
		padding: 0;
	}
	.content-top{
		position: relative;
		width:100vw;
		height:50vh;
	}
	.content-bottom{
		position: relative;
		width:100vw;
		height:50vh;
	}
	.content-top>.content-left{
		width:50%;
		height:50vh;
		background-image:url(img/adopt.jpg);
		background-size: cover;
		position: absolute;
		left:0;
	}
	.content-top>.content-right{
		width:50%;
		height:50vh;
		background-image:url(img/goods.jpg);
		background-size: cover;
		position: absolute;
		right:0;
		
	}
	.content-bottom>.content-left{
		width:50%;
		height:50vh;
		background-image:url(img/notice.jpg);
		background-size: cover;
		position: absolute;
		left:0;
	}
	.content-bottom>.content-right{
		width:50%;
		height:50vh;
		background-image:url(img/contact.jpg);
		background-size: cover;
		position: absolute;
		right:0;
	}
	.content-wrap{
		position: relative;
	}
	.main-modal{
		display: none;
		background-color: rgba(246,246,246,0.8);
		position: absolute;
		top: 0;
		width: 100%;
		height: 100%;
	}
	.main-modal a{
		width:100%;
		heigth:100%;
		padding: 100px;
		line-height: 50vh;
		font-size: 80px;
		text-decoration: none;
		color: rgb(232,69,86);
		font-family: 'Do Hyeon', sans-serif;
	}
</style>
<body>
	<div class="content">
		<div class="content-top">
			<div class="content-wrap content-left"><input type="hidden" value="ca"><div class="main-modal"><a href="/ca">반려동물</a></div></div>
			<div class="content-wrap content-right"><input type="hidden" value="goods"><div class="main-modal"><a href="/buyProduct">반려물품</a></div></div>
		</div>
		<div class="content-bottom">
			<div class="content-wrap content-left"><input type="hidden" value="noticeList"><div class="main-modal"><a href="community?reqPage=1&noticeCom=2">커뮤니티</a></div></div>
			<div class="content-wrap content-right"><input type="hidden" value="partner"><div class="main-modal"><a href="/view/contactMain.jsp">컨택트</a></div></div>
		</div>
	</div>
	<script>
		var a;
		$(".content-wrap").mouseover(function(){
			$(this).children().eq(1).css("display", "block");
		});
		$(".content-wrap").mouseout(function(){
			$(this).children().eq(1).css("display", "none");
		});
		$(".main-modal").children().click(function(){
			$(this).css("color", "rgba(174, 215, 232, 0.73)");
		});
		// 페이지 이동할 수 있게 작성
	</script>
</body>
</html>