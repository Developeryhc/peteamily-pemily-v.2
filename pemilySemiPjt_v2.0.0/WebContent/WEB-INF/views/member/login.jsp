<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/js/jquery-3.3.1.js"></script>
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Yanone+Kaffeesatz&display=swap" rel="stylesheet">
    <style>
  .content{
        width: 100%;
        height: 900px;
        position: relative;
        }
        .wrap{
        height:100%;
        width:100%;
        background-image: url(img/login.jpg);
        background-position: center;
        background-size: cover;
        position: absolute;
        }
        .login-bg{
        position: absolute;
        width: 100%;
        height: 100%;
        }
        .login-wrap{
        background-color: rgba(255,255,255,0.9);
        width: 600px;
        height: 600px;
        margin: 0 auto;
        border-radius: 5px;
        margin-top: 130px;
        }
        .login-wrap>form{
        padding-top: 10px;
        }
        .login-wrap>form>h1{
        text-align: center;
        font-size: 39px;
        margin: 0px;
        padding-top:40px;
        }
        .login-wrap>form>div{
        margin: 0 auto;
        margin-top: 80px;
        width: 400px;
        font-size:16px ;
        }
        .input-box>input{
        width: 360px;
        height: 50px;
        border: 1px solid rgb(232,69,86);
        }
        .join-box>ul{
        list-style-type: none;
        }
        .join-box>ul>li{
        float: left;
        text-align: center;
        margin-left:27px ;
        }
        .join-box>ul>li>a{
        text-decoration: none;
        color: #221e1e;
        font-weight: bold;
        font-size: 14px;
        }
        .join-box>ul>li>a:hover{
        text-decoration: underline;
        }
        .search-box>ul{
        list-style-type:none;
        }
        .search-box>ul>li{
        float:left;
        text-align:center;
        margin-left: 65px;
        }
        .search-box>ul>li>a{
        text-decoration:none;
        color:black;
        font-size:14px;
        }
        #login-btn {
        background-color: rgba(238, 140, 148, 0.60);
        color: black;
        font-size: 20px;
        padding: 1px 2px;
        box-sizing: content-box;
        }
        #login-btn:hover{
        cursor: pointer;
        }

    </style>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp"%>
	 <div class="wrap">
        <div class="content">
            <div class="login-bg">
                <div class="login-wrap">
                    <form action="/login" method="post" name="loginFrm" autocomplete="off">
                        <h1>login</h1>
                        <div class="input-box">
                            <h3>아이디</h3>
                            <input type="text" name="memberId" placeholder="아이디를 입력해주세요"><br>
                            <h3>비밀번호</h3>
                            <input type="password" name="memberPw" placeholder="비밀번호를 입력해주세요"><br><br>
                            <input type="submit" id="login-btn" value="로그인"><br><br>
                        <div class="join-box">
                            <ul>	
               	                 <li>아이디가 없으신가요? <a href="/joinFrm">회원 가입</a></li>
                            </ul>
                        </div>
                        <div>
                        	<ul><br></ul>
                        </div>
                        <div class="search-box">
                        	<ul>
                        		<li><a href="/searchIdFrm">아이디찾기</a> | <a href="/searchPwFrm">비밀번호 찾기</a></li>
                        	</ul>
                        </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
      </div>
</head>
</html>