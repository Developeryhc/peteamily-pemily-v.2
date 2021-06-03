<%@page import="inca.model.vo.Inca"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	Inca i = (Inca)request.getAttribute("i");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	.form-wrap{
		width: 1000px;
		margin: 0 auto;
	}
	.form-line{
		outline: none;
		border: 1px solid #00000032;
		border-radius: 3px;
		height: 30px;
	}
	.th-wrap th{
		height: 30px;
		width: 25%;
   		font-family: 'Do Hyeon', sans-serif;
   		font-size: 18px;
	}
	.th-wrap input{
		outline: none;
		width: 100%;
		height: 100%;
		border: none;
		margin:0;
		text-align: center;
		background-color: rgba(242, 217, 207, 0.84);
	}
	.th-wrap th:nth-child(2n-1){
		margin: 0;
		heigth: 100%;
		background-color: rgb(232,69,86);
		color: rgb(246,246,246);
	}
	.title{
		width: 100%;
		height: 30px;
	}
	.note-editor{
		margin: 20px 0;
	}
	button{
		border: none;
		width: 100px;
		height: 50px;
		font-size: 18px;
   		font-family: 'Do Hyeon', sans-serif;
	}
	.update{
		background-color: rgba(238, 140, 148, 0.60);
		box-shadow: 1px 1px 1px 1px rgba(238, 140, 148, 0.3);
	}
	.cancel{
		background-color: rgba(242, 217, 207, 0.84);
		box-shadow: 1px 1px 1px 1px rgba(242, 217, 207, 0.3);
	}
</style>
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
	<div class="container">
		<input type="hidden" name="empId" value="<%=m.getEmpId() %>">
		<h1 style="text-align:center; font-family:'Do Hyeon', sans-serif;">반려동물 등록</h1>	
		<form action="/caWrite" method="post">
			<table class="form-wrap">
				<tr class="th-wrap">
					<th>제목</th>
					<th colspan="3">
						<input type="text" class="form-line title" name="caTitle" style="font-family:'Do Hyeon', sans-serif;" placeholder=" 제목을 입력해주세요.">
						<input type="hidden" name="empId" value="${sessionScope.e.empId }">
					</th>
				</tr>
				<tr class="th-wrap">
					<th>수번</th>
					<th><input type="text" value="<%=i.getIncaNo()%>" name="incaNo" style="font-family:'Do Hyeon', sans-serif;" readonly></th>
					<th>이름</th>
					<th><input type="text" value="<%=i.getIncaName()%>" style="font-family:'Do Hyeon', sans-serif;" readonly></th>
				</tr >
				<tr>
					<th colspan="4">
						<textarea class="form-control" id="summernote" name="caContent" name="careContent"></textarea>
					</th>
				</tr>
				<tr>
					<th colspan="4">
						<div class="btn-wrap">
							<button type="submit" class="update">Update</button>
							<button type="button" class="cancel">Cancel</button>
						</div>
					</th>
				</tr>
			</table>
		</form>
	</div>
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
<script>
$(".btn-wrap").children().hover(function(){
	$(this).css("cursor", "pointer");
});
$(".cancel").click(function(){
	window.history.back();
});
// summernote
$(document).ready(function() {
    $('#summernote').summernote({
    	placeholder: "게시글을 작성해주세요",
            height: 200,                 // set editor height
            minHeight:400,             // set minimum height of editor
            focus: false ,                 // set focus to editable area after initializing summernote
            lang : "ko-KR",
            callbacks: { // 콜백 사용
           	   // 이미지 업로드할 경우 이벤트 발생
           	   onImageUpload:function(files) {
           	       uploadImage(files[0],this);
           	   },
           	   onPaste : function(e){
           		   var clipboardData = e.originalEvent.clipboardData;
           		   if(clipboardData && clipboardData.items && clipboardData.items.length){
           			   var item = clipboardData.items[0];
           			   	if(item.kind == 'file' && item.type.indexOf('image/') !== -1){
           			   		e.preventDefault();
           			   	}
           		   }
           	   }
       	  }	
    });
});
function uploadImage(file, editor) {
    // 파일 전송을 위한 폼생성
 data = new FormData();
    data.append("file", file);
    $.ajax({ // ajax를 통해 파일 업로드 처리
        data : data,
        type : "POST",
        url : "/uploadImage",
        cache : false,
        contentType : false,
        processData : false,
        success : function(data) { // 처리가 성공할 경우
            // 에디터에 이미지 출력
         $(editor).summernote('insertImage', data);
        }
    });    
}
function check(){
	var sCheck = $("#summernote").val().replace(/\s|/gi,'');
	if(sCheck == ""){
		alert("내용을 입력해주세요.");
		$("#summernote").val("");
		$("#summernote").focus();
		return false;
	}
	return true;
};
</script>
</body>
</html>