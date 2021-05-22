<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>
	.footer{
		border-top: 3px solid rgb(232,69,86);
		margin-top: 30px;
		background-color: rgb(245, 245, 245);
	}
	.footer-wrap{
		width: 1280px;
		margin: 0 auto;
		padding: 10px;
	}
	.f-text{
		font-family: 'Do Hyeon', sans-serif;
	}
	.connect{
		display: inline-block;
		float: right;
	}
	.connect img{
		float: left;
		width: 30px;
		heigth: 30px;
		margin-left: 5px;
		border-radius: 30px;
	}
	h5{
		display: inline-block;
		margin: 5px;
	}
</style>
<body>
    <div class="footer">
    	<div class="footer-wrap">
		   	<div class="company">
	    		<h1 class="f-text">(주) Peteamily</h1>
	    		<h4 class="f-text">사업자 등록번호 : 430-21-ACLASS | 대표자 : 페밀리</h4>
	    		<h4 class="f-text">주소 : 서울특별시 영등포구 양평동 이레빌딩 19F, 20F</h4>
	    		<hr>
	    		<h5 class="f-text">ⓒ 2021 Peteamily</h5>
    			<div class="connect"><img src="/img/facebook.png"></div>
	    		<div class="connect"><img src="/img/instagram.png"></div>
	    		<div class="connect"><img src="/img/youtube.png"></div>
	   	 		<div class="connect"><img src="/img/line.png"></div>
	   	 		<div class="connect"><img src="/img/twitter.png"></div>
	    	</div>
    	</div>
    </div>
    <script>
        $(".connect").children().mouseover(function(){
        	$(this).css("background-color", "rgb(232,69,86)");
        });
        $(".connect").children().mouseout(function(){
        	$(this).css("background-color", "");
        });
    </script>
</body>
</html>