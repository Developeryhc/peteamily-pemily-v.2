<%@page import="member.model.vo.Member"%>
<%@page import="ca.model.vo.Adopt"%>
<%@page import="inca.model.vo.Inca"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	//	Adopt adopt = (Adopt)session.getAttribute("adopt");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>가족이 될 준비가 된 친구들이에요 :)</title>
</head>
<style>
.container {
	margin-top: 200px;
	width: 1280px;
}

.container ul{
	padding: 0;
	display: flex;
}
.ul li{
	display: flex;
	justify-content: center;
	align-items:center;
	flex-wrap: wrap;
	width:Calc(1280px/2);
	height: 320px;
	background-position: center;
	background-size: cover;
	border: 5px dashed rgba(182, 215, 168, 0.9);
	margin: 0 10px;
}
.container ul li a{
	width: 100%;
	height: 100%;
	text-align: center;
	text-decoration: none;
	font-size: 50px;
	color: rgba(232,69,86, 0.8);
	line-height: 32vh;
	font-family: 'Do Hyeon', sans-serif; 
}
.CaImg{
	width: 100%;
	background-image: url(img/ca1.jpg);
}

</style>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp"%>
	<script type="text/javascript"></script>
	<div class="container">
		<ul class="ul">
			<li class="li"><input type="hidden" value="2"><a href="/caViewList?incaNo=2">강아지</a><input type="hidden" value="강아지"></li>
			<li class="li"><input type="hidden" value="3"><a href="/caViewList?incaNo=3">고양이</a><input type="hidden" value="고양이"></li>
			<li class="li"><input type="hidden" value="4"><a href="/caViewList?incaNo=4">물고기</a><input type="hidden" value="물고기"></li>
			<li class="li"><input type="hidden" value="5"><a href="/caViewList?incaNo=5">도마뱀</a><input type="hidden" value="도마뱀"></li>
		</ul>
		<ul class="ul">
			<li class="li"><input type="hidden" value="6"><a href="/caViewList?incaNo=6">설치류</a><input type="hidden" value="설치류"></li>
			<li class="li"><input type="hidden" value="7"><a href="/caViewList?incaNo=7">뱀류</a><input type="hidden" value="뱀류"></li>
			<li class="li"><input type="hidden" value="8"><a href="/caViewList?incaNo=8">절지류</a><input type="hidden" value="절지류"></li>
			<li class="li"><input type="hidden" value="1"><a href="/">뒤로가기</a><input type="hidden" value="뒤로가기"></li>
		</ul>
	</div>
	<script>
		$(".li").mouseout(function(){
			var obj = $(this);
			mouseout(obj, obj.children().eq(2).val());
		});
		
		$(".li").mouseover(function(){
			var obj = $(this);
			mouseoverImg(obj, obj.children().eq(0).val());
		});
		
		function mouseoverImg(obj, val){
			if(val == 1){
				obj.css("background-image", "url(img/logo.JPG.jpg)");
			}else{
				obj.css("background-image", "url(img/ca"+(val-1)+".jpg)");
			}
			obj.children().eq(1).html("");
		}
		
		function mouseout(obj, val){
			obj.css("background-image", "");
			obj.children().eq(1).html(val);
		}
	</script>
	<%@include file="/WEB-INF/views/common/footer.jsp"%>
</body>
</html>