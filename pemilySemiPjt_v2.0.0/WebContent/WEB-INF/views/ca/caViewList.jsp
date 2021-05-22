<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    int totalCount = (Integer)request.getAttribute("totalCount");
    int incaAn = (Integer)request.getAttribute("incaNo");
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dog</title>
<style>
	.container p{
		font-family: 'Do Hyeon', sans-serif;
	}
	
	.modal{
		position: relative;
	}
	.modal-back{
		width: 800px;
		position: absolute;
		top:10vh;
		left:10vw;
		background-color: rgb(246,246,246);
		padding: 20px;
		border-radius: 30px;
		box-shadow: 2px 2px 2px rhb(246, 140, 148);
	}
	.modal-back p{
		margin: 10px;
	}
	.btn-wrap{
		text-align: center;
		background-color:rgba(174, 215, 232, 0.4);
	}
	.modal-btn{
		margin: 10px;		
		width: 120px;
		height: 50px;
		font-size: 16px;
		font-family: 'Do Hyeon', sans-serif;
	}
	.modal-main{
		background-color:rgba(174, 215, 232, 0.4);
		padding: 20px;
	}
	.modal-main img{
		border-radius: 500px;
	}
	
</style>
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
	<div class="back-color">
		<div class="container">
			<%@include file="/WEB-INF/views/ca/caMenu.jsp" %>
			<div class="modal"></div>
			<div class="main"></div>
			<button type="button" class="more-btn" value="" currentCount="" totalCount="<%=totalCount%>">더 보기</button>
		</div>
	</div>
	<script>
	$(function(){
		var incaNo = <%=incaAn%>;
		var m = "1";
		list(incaNo, 1);
		$(".more-btn").click(function(){
			list(incaNo, $(".more-btn").val());
		});
		
		$(document).on("mouseover", ".main-wrap", function(){
			$(this).css("cursor", "pointer");
		});
		
		$(document).on("click", ".main-wrap", function(){
			oneView($(this).children().eq(0).val(), m);
		});
		
	});
	
	function list(incaNo, start) {
		$.ajax({
			url : "/caView",
			data : {
				incaNo : incaNo,
				start : start
			},
			type : "post",
			success : function(data) {
				for (var i = 0; i < data.length; i++) {
					var ca = data[i].ca;
					var inca = data[i].inca;
					var html = "";
					if (i % 2 == 0 || i == 0) {
						html += "<div class='main-left main-wrap main-list'><input type='hidden' value='"+inca.incaNo+"'>";
						html += "<img src='/upload/inca/"+inca.incaPath+"'>";
						html += "<div class='p-left'><p>이름 : " + inca.incaName + "</p>";
						html += "<p>개월 : " + inca.incaMonth + "</p>";
						html += "<p>성별 : " + inca.incaGender + "</p>";
						html += "<p>★ 이런분이 가족이였으면 좋겠어요 ! ☆</p>";
						html += "<p>" + ca.caTitle + "</p></div></div>";
					} else {
						html += "<div class='main-right main-wrap main-list'><input type='hidden' value='"+inca.incaNo+"'>";
						html += "<div class='p-right'><p>이름 : " + inca.incaName + "</p>";
						html += "<p>개월 : " + inca.incaMonth + "</p>";
						html += "<p>성별 : " + inca.incaGender + "</p>";
						html += "<p>★ 이런분이 가족이였으면 좋겠어요 ! ☆</p>";
						html += "<p>" + ca.caTitle + "</p></div>";
						html += "<img src='/upload/inca/"+inca.incaPath+"'></div>";
					}
					$(".main").append(html);
						// 이미지 추가가 끝나고 나면 더보기 버튼의 value 값 조정
					$(".more-btn").val(Number(start)+4);
					var curr = Number($(".more-btn").attr("currentCount"));
					$(".more-btn").attr("currentCount", curr+data.length);
					var totalCount = $(".more-btn").attr("totalCount");
					var currCount = $(".more-btn").attr("currentCount");
					if(currCount == totalCount){
						$(".more-btn").attr("disabled", true);		// 비활성화
					}
				}
			}
		});
	}
	
	function oneView(incaNo, m){
		$.ajax({
			url : "/caOneView",
			data : {incaNo:incaNo},
			type : "post",
			success : function(data){
				var ca = data.ca;
				var inca = data.inca;
				var html = "";
				// 폼태그로 변경해서 submit ? onclick ?
				html += "<div class='modal-back'><div class='main-left main-wrap modal-main'><form action='/caApply' method='get'><input type='hidden' name='memberNo' value='"+m+"'><input type='hidden' name='incaNo' value='"+inca.incaNo+"'>";
				html += "<img src='/upload/inca/"+inca.incaPath+"'>";
				html += "<div class='p-left'><p>이름 : " + inca.incaName + "</p>";
				html += "<p>개월 : " + inca.incaMonth + "</p>";
				html += "<p>성별 : " + inca.incaGender + "</p>";
				html += "<p>★ 이런분이 가족이였으면 좋겠어요 ! ☆</p>";
				html += "<p>" + ca.caTitle + "</p>";
				html += "<p>" + ca.caContent + "</p></div>";
				html += "<div class='btn-wrap'><button type='submit' class='modal-btn adopt-btn'>분양신청하기</button><button type='button' class='modal-btn' onclick='cancel();'>돌아가기</button></div></form></div></div>";
				$(".modal").append(html);
				// 배경 불투명화 넣기
				$(".back-color").css("background-color", "rgba(0, 0, 0, 0.5)");
			}
		});
	}
	
	function cancel(){
		$(".modal-back").remove();
		$(".back-color").css("background-color", "rgba(255, 255, 255, 1)");
	}
	
	</script>
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>