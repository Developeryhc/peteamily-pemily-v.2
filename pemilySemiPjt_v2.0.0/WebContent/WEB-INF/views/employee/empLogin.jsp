<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/header.jsp" />
		<form action="javascript:void(0)">
			<input type="text" id="empId" name="empId" placeholder="아이디">
			<input type="password" id="empPw" name="empPw" placeholder="비밀번호">
			<button type="button" class="designFrm" id="empLoignChk">로그인</button>
			<a href="/moveEmpSginUp" class="designFrm">직원가입</a>
		</form>
		<script>
			$('#empLoignChk').click(function(){
				 console.log('test');
				const empId = $('#empId').val();
				const empPw = $('#empPw').val();
				$.ajax({
					url : "/empLoginChk",
					type : "post",
					data : {empId : empId, empPw : empPw},
					success : function(data){
						if(data != null){
							//modal or alert
							alert(data.empName+'님 어서오세요');
							location.href="/noticeEmpList?reqPage=1&noticeCom=1";
						}else{
							//modal or alert
							$('#empId').val('');
							$('#empPw').val('');
						}
					}
				});
			});
		</script>
	<jsp:include page="/WEB-INF/views/common/footer.jsp" />
</body>
</html>