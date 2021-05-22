<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>
/* 컨텐츠 관련 css */
.main-left>div {
	display: inline-block;
	width: 69.35%;
}

.main-left img {
	width: 30%;
}

.main-right img {
	width: 30%;
}

.main-right>div {
	display: inline-block;
	width: 69.35%;
}

.main-right>div>p {
	text-align: right;
}

.main img {
	width: 300px;
	margin: 20px 20px 20px;
}
.main-list{
	margin: 20px 10px;
	border: 10px dashed rgba(174, 215, 232, 0.4);
	border-radius: 10px;
}
/* 버튼 css 관련 */
.more-btn {
	margin: 30px auto;
	width: 120px;
	height: 50px;
	font-size: 16px;
	display: block;
}
.menu-wrap {
	width: 1180px;
	margin: 0 auto;
}

.menu-wrap>ul {
	list-style: none;
	margin: 0;
	padding: 0;
	display: flex;
}

.menu-wrap>ul>li {
	width: 100px;
	text-align: center;
	background-color: rgba(174, 215, 232, 0.73);
	margin: 0px 15px;
	height: 30px;
	line-height: 30px;
	border-radius: 20px;
}

.menu-wrap>ul>li>a {
	text-decoration: none;
	color: rgb(246,246,246);
	font-size: 16px;
	font-weight: bolder;
}

.p-left{
	margin: 20px;
	float: right;
}

.p-right{
	margin: 20px;
	float: left;
}
</style>
<body>
	<div class="content">
		<div class="menu-wrap">
			<ul>
				<li><a href="/caViewList?incaNo=2">Dog</a></li>
				<li><a href="/caViewList?incaNo=3">Cat</a></li>
				<li><a href="/caViewList?incaNo=4">Fish</a></li>
				<li><a href="/caViewList?incaNo=5">Lizard</a></li>
				<li><a href="/caViewList?incaNo=6">Rodent</a></li>
				<li><a href="/caViewList?incaNo=7">Snake</a></li>
				<li><a href="/caViewList?incaNo=8">Arthropod</a></li>
				<li><a href="/caWrite">Ca Upload</a></li>
				<li><a href="/incaWrite">Inca Upload</a></li>
			</ul>
		</div>
	</div>
</body>
</html>