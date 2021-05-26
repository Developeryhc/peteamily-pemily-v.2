<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#empLoginFrm{
	    width:300px;
	    margin:auto;
	    display:flex;
	    flex-direction: column;
	    align-items:center;
	}
	.designFrm{
	    width:100%;
	    height:40px;
	    box-sizing:border-box;
	    padding:0 10px;
	    outline:none;
	    border:1px solid #ddd;
	    transition-duration:0.4s;
	}
	#empId:focus::placeholder, #empPw:focus::placeholder{
	    color: #fff;
	}
	.designFrm:nth-child(4){
	    border:none;
	    text-align:center;
	    line-height:40px;
	}
	#empId:focus, #empPw:focus{
	    background-color:#f194ce;
	    color:#fff;
	}
	#empLoginBtn{
	    padding:0;
	    margin:0;
	    background-color:#f194ce;
	    color:#fff;
	    cursor:pointer;
	    font-weight:bold;
	    font-size:1.1rem;
	    transition-duration:0.1s;
	}
	#empLoginBtn:hover{
	    background-color:#9cd0ee;
	    color:#fff;
	}
</style>
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/header.jsp" />
	<form action="javascript:void(0)" id="empLoginFrm">
        <h2>Login</h2>
        <input type="text" class="designFrm" id="empId" name="empId" placeholder="아이디" autocomplete="off">
        <input type="password" class="designFrm" id="empPw" name="empPw" placeholder="비밀번호">
        <div class="designFrm">
            <a href="javascript:void(0)">아이디 / 비밀번호 찾기</a>
        </div>
        <button type="button" id="empLoginBtn" class="designFrm">로그인</button>
    </form>
		<script>
			$('#empLoginBtn').click(function(){
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
			function idCheck(){
				const empId = $('#empId').val();
				if(empId == ''){
					return
				}
			}
			function pwCheck(){
				const empPw = $('#empPw').val();				
			}
		</script>
	<jsp:include page="/WEB-INF/views/common/footer.jsp" />
</body>
</html>