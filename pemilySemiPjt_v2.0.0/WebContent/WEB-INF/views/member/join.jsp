<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/js/jquery-3.3.1.js"></script>
<script>
	function vaild(){
		var re = /^[a-zA-z0-9]{4,12}$	//아이디,패스워드 
	    var id = document.getElementById("memberId");
	    var pw = document.getElementById("memberPw");
	    if(!check(re,id,"아이디는 4~12자의 영문 대소문자와 숫자로만 입력하세요")){
	    	return false;
	    }
	    if(!check(re,pw,"패스워드는 4~12자의 영문 대소문자와 숫자로만 입력하세요")) {
	           return false;
	       }
	}
</script>
<style>
.content {
	width: 100%;
	height: 900px;
	position: relative;
}

.wrap {
	height: 100%;
	width: 100%;
	background-image: url(img/login.jpg);
	background-position: center;
		background-repeat: repeat;
	background-size: cover;
	position: absolute;
}

.jogin-wrap {
	background-color: rgba(255, 255, 255, 0.9);

	width: 600px;
	height: 1400px;
	margin: 0 auto;
	border-radius: 5px;
	margin-top: 130px;
	border-color: rgb(232, 69, 86);
}

.jogin-wrap>form {
	padding-top: 10px;
}

.jogin-wrap>form>h1 {
	text-align: center;
	font-size: 39px;
	margin: 0px;
	padding-top: 40px;
}

.jogin-wrap>form>div {
	margin: 0 auto;
	margin-top: 80px;
	width: 400px;
	font-size: 16px;
}

.input-box>input {
	width: 400px;
	height: 50px;
	border: 1px solid rgb(232, 69, 86);
}

.search-box>ul {
	list-style-type: none;
}

.search-box>ul>li {
	float: left;
	text-align: center;
	margin-left: 27px;
}

.search-box>ul>li>a {
	text-decoration: none;
	color: #221e1e;
	font-weight: bold;
	font-size: 14px;
}

.search-box>ul>li>a:hover {
	text-decoration: underline;
}

#join-btn {
	background-color: rgba(238, 140, 148, 0.60);
	color: black;
	font-size: 20px;
	padding: 1px 2px;
	box-sizing: content-box;
}

#join-btn:hover {
	cursor: pointer;
}

.input-box>table {
	width: 500px;
}
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp"%>
	<div class="wrap">
		<div class="content">
			<div class="jogin-bg">
				<div class="jogin-wrap">
					<form name="join" action="/join" method="post" autocomplete="off">
						<h1>회원가입</h1>
						<div class="input-box">
							<h3>아이디</h3>
							<input type="text" name="memberId" id="memberId"
								placeholder="아이디를 입력해주세요"><br>
							<h3>비밀번호</h3>
							<input type="password" name="memberPw" id="pw" class="pw"
								placeholder="비밀번호를 입력해주세요"><br>
							<h3>비밀번호 확인</h3>
							<input type="password" name="pwre" id="pwre" class="pw"
								placeholder="비밀번호를 입력해주세요"><br> <br> <span
								id="alert-success" style="display: none;">비밀번호가 일치합니다.</span> <span
								id="alert-danger"
								style="display: none; color: #d92742; font-weight: bold;">비밀번호가
								일치하지 않습니다.</span>
							<h3>이름</h3>
							<input type="text" name="memberName" id="memberName"
								class="memberName">
							<h3>전화번호</h3>
							<input type="tel" name="memberPhone" placeholder="전화번호를 입력해주세요"><br>
							<h3>이메일 주소</h3>
							<input type="email" name="memberEmail" placeholder="이메일을 입력해주세요"><br>
							<h3>주소</h3>
							<input type="text" name="memberAddr" placeholder="주소를 입력해주세요"><br>
							<br>
							<table>
								<tr>
									<td><input type="radio" name="memberGender"
										name="memberGender" value="M" id="memberGender"> <label
										for="M">남</label> <input type="radio" name="memberGender"
										name="memberGender" value="F" id="memberGender"> <label
										for="F">여</label><br> <br> <input type="checkbox"
										id="checkall" class="chk">모두 동의 합니다.<br> <br>
										<input type="checkbox" id="c1" class="chk" name="chk">(필수)<a
										href="/serviceFrm" target="_blank">이용약관</a>과&nbsp;<a
										href="/privacyFrm" target="_blank">개인정보 수집 및 이용</a>에<br>&emsp;동의합니다.<br>
										<br> <input type="checkbox" id="c2" class="chk"
										name="chk">(필수) 만 14세 이상입니다.<br>&emsp;<small>만
											19세 미만의 미성년자가 결제 시 법정 대리인이 거래를<br> &emsp;취소할 수 있습니다
									</small><br> <br> <input type="checkbox" id="c3" class="chk"
										name="chk">(선택) 이메일 및 SMS 마케팅 정보 수신에 동의합니다.<br>&emsp;<small>회원은
											언제든지 회원 정보에서 수신 거부할 수 있습니다.</small></td>
								</tr>
							</table>
							<br> <input type="submit" id="join-btn" value="가입하기">
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

	<script>
		$(document).ready(function() {
			//최상단 체크박스 클릭
			$("#checkall").click(function() {
				//클릭되었으면
				if ($("#checkall").prop("checked")) {
					//input태그의 name이 chk인 태그들을 찾아서 checked옵션을 true로 정의
					$("input[name=chk]").prop("checked", true);
					//클릭이 안되있으면
				} else {
					//input태그의 name이 chk인 태그들을 찾아서 checked옵션을 false로 정의
					$("input[name=chk]").prop("checked", false);
				}
			})
		});
		$(".pw").focusout(function() {
			var pwd1 = $("#pw").val();
			var pwd2 = $("#pwre").val();
			if (pwd1 != "" && pwd2 == "") {
				null;
			} else if (pwd1 != "" || pwd2 != "") {
				if (pwd1 == pwd2) {
					$("#alert-success").css('display', 'inline-block');
					$("#alert-danger").css('display', 'none');
				} else {
					alert("비밀번호가 일치하지 않습니다. 비밀번호를 재확인해주세요.");
					$("#alert-success").css('display', 'none');
					$("#alert-danger").css('display', 'inline-block');
				}
			}
		});
	</script>

</body>
</html>