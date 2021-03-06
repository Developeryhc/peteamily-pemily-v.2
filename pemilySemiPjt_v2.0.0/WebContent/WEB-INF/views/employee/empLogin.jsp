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
	#empLoginBtn:focus{
	    background-color:#9cd0ee;
	    color:#fff;
	}
	.modalMH{
            width:100%;
            height:100%;
            background-color:rgba(0,0,0,0.4);
            position:fixed;
            top:0;
            left:0;
            display:none;
            justify-content:center;
            align-items:center;
        }
        .modalCommentWrap{
            width:200px;
            height:150px;
            background-color:#fff;
            border-radius:20px;
            text-align:center;
        }
        .modalCommentBox{
            width:100%;
            height:110px;
            box-sizing: border-box;
            padding-top:50px;
        }
        .modalBtn{
        	display:none;
            width:50px;
            height:30px;
            outline:none;
            border:1px solid #555;
            background-color:#eaee18;
            border-radius:5px;
            transition-duration: 0.2s;
            cursor: pointer;
        }
        .modalBtn:hover{
            background-color:#555;
            color:#eaee18;
        }
        .searchIdPw{
        	text-decoration:none;
        	color:#555;
        	outline:none;
        }
        .searchIdPw:hover{
        	text-decoration:underline;
        	color:#DB7093;
        }
        .searchIdPw:focus{
        	text-decoration:underline;
        	color:#DB7093;
        }
</style>
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/header.jsp" />
	<form action="javascript:void(0)" id="empLoginFrm">
        <h2>Login</h2>
        <input type="text" class="designFrm" id="empId" name="empId" placeholder="?????????" autocomplete="off">
        <input type="password" class="designFrm" id="empPw" name="empPw" placeholder="????????????">
        <div class="designFrm">
            <a href="javascript:void(0)" class="searchIdPw">????????? / ???????????? ??????</a>
        </div>
        <button type="button" id="empLoginBtn" class="designFrm">?????????</button>
    </form>
    <div class="modalMH">
        <div class="modalCommentWrap">
            <div class="modalCommentBox">
            </div>
            <button id="success1" class="modalBtn">??????</button>
            <button id="fail1" class="modalBtn">??????</button>
        </div>
    </div>
	<script>
		$('#empLoginBtn').click(function(){
			if(idCheck()){
				$('#fail1').show();
				$('.modalCommentBox').html('???????????? ??????????????????');
				openModal1();
				return;
			}else if(pwCheck()){
				$('#fail1').show();
				$('.modalCommentBox').html('??????????????? ??????????????????');
				openModal1();
				return;
			}
			const empPw = $('#empPw').val();
			const empId = $('#empId').val();
			$.ajax({
				url : "/empLoginChk",
				type : "post",
				data : {empId : empId, empPw : empPw},
				success : function(data){
					if(data != null){
						//modal or alert
						$('.modalCommentBox').html(data.empName+' ??? ???????????????!');
						$('#success1').show();
						openModal1();
					}else{
						//modal or alert
						$('.modalCommentBox').html('????????? ?????? ??????????????? ??????????????????');
						$('#fail1').show();
						openModal1();
						$('#empId').val('');
						$('#empPw').val('');
					}
				}
			});
		});
		function idCheck(){
			const empId = $('#empId').val();
			if(empId == ''){
				return true; 
			}
			return false;
		}
		function pwCheck(){
			const empPw = $('#empPw').val();				
			if(empPw == ''){
				return true; 
			}
			return false;
		}
		function openModal1(){
			$('.modalMH').css('display','flex');
		}
		$('#success1').click(function(){
			location.href="/noticeEmpList?reqPage=1&noticeCom=1";
		});
		$('#fail1').click(function(){
			$('.modalMH').css('display','none');
			$(this).hide();
		});
	</script>
	<jsp:include page="/WEB-INF/views/common/footer.jsp" />
</body>
</html>