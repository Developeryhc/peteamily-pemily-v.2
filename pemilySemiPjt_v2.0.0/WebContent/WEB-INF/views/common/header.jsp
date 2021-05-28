<%@page import="member.model.vo.MemberList"%>
<%@page import="employee.model.vo.Employee"%>
<%@page import="javax.mail.Session"%>
<%@page import="org.apache.catalina.SessionListener"%>
<%@page import="member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- jstl core tag  -->
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	MemberList m = null;
	if((Member)session.getAttribute("m") == null){
		m = (Employee)m;
		m = (Employee)session.getAttribute("e");
	}else{
		m = (Member)m;
		m = (Member)session.getAttribute("m");		
	}
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>header</title>
    <!-- jQuery 라이브러리 추가 (2개) -->
<script type="text/javascript" src="/js/jquery-3.3.1.js"></script>
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Yanone+Kaffeesatz&display=swap" rel="stylesheet">
	<!-- 서머노트 편집기 라이브러리 -->
<script src="/js/summernote/summernote-lite.js"></script>
<script src="/js/summernote/lang/summernote-ko-KR.js"></script>
<link rel="stylesheet" href="/css/summernote/summernote-lite.css">
    <style>
        body{
            margin: 0;
            min-width:1280px;
            background-color: rgb(246,246,246);
        }
        header{
            display: flex;
            justify-content: center;
            background-color: rgb(246,246,246);
            border-bottom:3px solid rgb(232,69,86);
            margin-bottom: 30px;
            padding-bottom: 20px;
        }
        .header{
            display:flex;
            flex-direction: column;
            /* height:200px; */
            /* line-height:200px; */
            justify-content: space-evenly;
            /* position:fixed; */
            /* top:0; */
        }
        .header>ul{
            list-style:none;
            margin:0;
            padding:0;
            display:flex;
            align-items: flex-end;
            flex-direction: row;
            font-size: 24px;
			font-family: 'Yanone Kaffeesatz', sans-serif;
        }
        .menu{
            width:100px;
            text-align:center;
        }
        .menu a{        	
            text-decoration: none;
            color:black;
        }
        .container{
        	width:1280px;
        	margin: 0 auto;
        }
        .empLink{
        	position : absolute;
        	top:0;
        	right:0;
        	color: rgb(246,246,246);
        	display:block;
        	width:100px;
        	height:100px;
        }
        .testWrap{
	        position:relative;
	        z-index:10000;
	    }
	    .test{
	        width:100px;
	        height:320px;
	        margin-top:130px;
	        background-color:rgba(182, 215, 168, 0.54);
	        position:fixed;
	        top:130px;
	        right:0;
	        border-top-left-radius: 30px;
	        border-bottom-left-radius: 30px;
	    }
	    .test ul{
	    	padding: 0;
	    }
	    .test li, .login-li{
	    	text-align: center;
	    	list-style-type: none;
	    }
	    .test img, .login-li img{
	    	width: 70%;
	    	border-radius: 50px;
	        cursor:pointer;
	    }
	    .login-li p{
    		font-family: 'Do Hyeon', sans-serif;
    		font-size: 30px;
    		margin: 20px 0;
	    }
	    .go-top{
	        width:50px;
	        height:50px;
	        background-color: rgba(182, 215, 168, 0.54);
	        position:fixed;
	        bottom:100px;
	        left:100px;
	        cursor:pointer;
	        border-radius: 50px;
	    }
    </style>
</head>
<body>
    <header>
        <div class="header">
            <ul>
                <li class="menu"><a href="/ca">Adopt</a></li>
                <li class="menu"><a href="/buyProduct">Goods</a></li>
                <li><a href="/"><img src="img/logo.JPG.jpg" class="logo" style="width:200px;"></a></li>
                <li class="menu"><a href="/community?reqPage=1&noticeCom=2">Community</a></li>
                <li class="menu"><a href="/contactMain">Contact</a></li>
            </ul>
        </div>
        <c:choose>
	        <c:when test="${empty sessionScope.e }">
	        <a class="empLink" href="/empLoginFrm">직원페이지</a>
			</c:when>
			<c:otherwise>			
	        <a class="empLink" href="/noticeEmpList?reqPage=1&noticeCom=1">직원페이지</a>
			</c:otherwise>
        </c:choose>
    </header>
    <div class="testWrap">
		<div class="test">
			<ul>
				<%if(m == null){ %>
				<li class="test-li"><img src="/img/login.png"></li>
				<li class="test-li"><img src="/img/join.png"></li>
				<%}else{ %>
					<li class="login-li">
						<p>
							<%if(m.getMemberName() == null){ %>
							<%=m.getEmpName() %>
							<%}else{ %>
							<%=m.getMemberName() %>
							<%} %>
						</p>
					</li>
					<li class="login-li"><img src="/img/logout.png"></li>
					<li class="login-li"><img src="/img/mypage.png"></li>
					<li class="login-li"><img src="/img/cart.png"></li>
				<%} %>
				<li class="test-li"><img src="/img/talk.png"></li>
			</ul>
		</div>
   		<div class="go-top"><img class="go-top" src="/img/moveButton/arrow.png"></div>
	</div>
<script>
$(function(){
	<%if(m==null){%>
	$(".test").css("height", "250px");
	<%}else{%>
	$(".test").css("height", "390px");
	<%}%>
});
$('.go-top').click(function(){
    window.scrollTo(0,0);
});
$(".test-li").mouseover(function(){
	$(this).children().css("background-color", "rgb(232,69,86)");
});
$(".test-li").mouseout(function(){
	$(this).children().css("background-color", "");
});
$(".login-li").mouseover(function(){
	$(this).children().css("background-color", "rgb(232,69,86)");
});
$(".login-li").mouseout(function(){
	$(this).children().css("background-color", "");
});
$(".test-li").click(function(){
	var index = $(".test-li").index(this);
	if(index == 0){
		<%if(m==null){%>
		location.href="loginFrm";		
		<%}else{%>
		window.open('https://open.kakao.com/o/s7Krolfd','_blink','width=1000px,height=600px,top=100px,left=200px');
		<%}%>
	}else if(index == 1){
		location.href="joinFrm";
	}else if(index == 2){
		window.open('https://open.kakao.com/o/s7Krolfd','_blink','width=1000px,height=600px,top=100px,left=200px');
	}
});
$(".login-li").click(function(){
	var index = $(".login-li").index(this);
	if(index == 1){
		location.href="logout";
	}else if(index == 2){
		location.href="mypage";
	}else if(index == 3){
		location.href="#";
	}else if(index == 4){
		location.href="#";
	}
});
</script>
</body>
</html>