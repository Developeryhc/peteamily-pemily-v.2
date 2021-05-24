<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	int incaNo = (Integer)request.getAttribute("incaNo");
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
	.title{
		width: 100%;
		height: 30px;
	}
	.note-editor{
		margin: 20px 0;
	}
	button{
		border: none;
		width: 80px;
		height: 30px;
	}
	.update{
		background-color: rgba(238, 140, 148, 0.60);
		box-shadow: 1px 1px 1px 1px rgba(238, 140, 148, 0.3);
	}
	.cancel{
		background-color: rgba(242, 217, 207, 0.84);
		box-shadow: 1px 1px 1px 1px rgba(242, 217, 207, 0.3);
	}
	.btn-wrap{
		text-align: center;
	}
</style>
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
	<div class="container">
		<h1 style="text-align:center;">AdoptUpdate</h1>	
		<form action="/caWrite" method="post" enctype="multipart/form-data">
			<table class="form-wrap">
				<tr>
					<th>
						<input type="text" class="form-line title" name="title" placeholder=" 제목을 입력해주세요.">
					</th>
				</tr>
				<tr>
					<th>
						<input type="hidden" name="incaNo" value="<%=incaNo%>"><input type="text" value="<%=incaNo%>" readonly>
					</th>
				</tr >
				<tr>
					<th>
						<textarea class="form-control" id="summernote" value="" name="careContent"></textarea>
					</th>
				</tr>
				<tr>
					<th>
						<div class="btn-wrap">
							<button type="submit" class="update">Update</button>
							<button type="reset" class="cancel">Cancel</button>
						</div>
					</th>
				</tr>
			</table>
		</form>
	</div>
<script>
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