<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="preconnect" href="https://fonts.gstatic.com">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/.1.3/css/bootstrap.min.css">
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
        .findId-bg{
        position: absolute;
        width: 100%;
        height: 100%;
        }
        .findId-wrap{
        background-color: rgba(255,255,255,0.9);
        width: 600px;
        height: 650px;
        margin: 0 auto;
        border-radius: 5px;
        margin-top: 130px;
        }
        .findId-wrap>form{
        padding-top: 10px;
        }
        .findId-wrap>form>h1{
        text-align: center;
        font-size: 39px;
        margin: 0px;
        padding-top:40px;
        }
        .findId-wrap>form>div{
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
        .findId-box>ul{
        list-style-type: none;
        }
        .findId-box>ul>li{
        float: left;
        text-align: center;
        margin-left:27px ;
        }
        .findId-box>ul>li>a{
        text-decoration: none;
        color: #221e1e;
        font-weight: bold;
        font-size: 14px;
        }
        .findId-box>ul>li>a:hover{
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
        #findId-btn {
        background-color: rgba(238, 140, 148, 0.60);
        color: black;
        font-size: 20px;
        padding: 1px 2px;
        box-sizing: content-box;
        }
        #findId-btn:hover{
        cursor: pointer;
        }

    </style>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp"%>
	<div class="wrap">
		<div class="content">
			<div class="findId-bg">
				<div class="findId-wrap">
					<form action="/findPw" method="post" autocomplete="off">
						<h1>비밀번호 찾기</h1>
						<div class="input-box">
							<h3>아이디</h3>
							<input type="text" name="memberId" class="from-control" placeholder="아이디를 입력해주세요"><br>
							<h3>이메일</h3>
							<input type="email" name="memberEmail" id="memberEmail" class="memberEmail" placeholder="이메일을 입력해주세요"><br> 	
							<h3>전화번호</h3>
							<input type="tel" name="memberPhone" id="memberPhone" class="memberPhone" placeholder="전화번호를 입력해주세요"><br>
							<br>
							<br> <input type="submit" id="findId-btn" value="비밀번호 찾기">
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="/WEB-INF/views/common/footer.jsp"%>
</body>
</html>