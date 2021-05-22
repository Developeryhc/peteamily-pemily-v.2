
<%@page import="member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Member member = (Member) request.getAttribute("member");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript" src="/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

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
        .input-box>h3{
        text-ailgn:center;
        
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
					<form action="/loginFrm" method="post" autocomplete="off">
						<h1>찾은 아이디</h1>
						<div class="input-box">
							<h3>아이디</h3>
								<input tyep="text" id="findMemberId" name="findMemberId"
									class="form-control"
									style="font-size: 30px; text-align: center; background-color: white;"
									value=" <%=member.getMemberId()%> " readonly><br>
							<br> <input type="submit" id="findId-btn" value="로그인">
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="/WEB-INF/views/common/footer.jsp"%>
</body>
</html>