<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
@import url ( 'https://fonts.googleapis.com/css2? family = Jua & display = swap');
	.top{
		text-align:center;
	}
	
	.moto{
		text-align:center;
		
	}
	.moto2{
		overflow:hidden;
	}
	.moto2>div{
		float:left;
		width:24%;
		border:2px solid rgba(238, 140, 148, 0.80);
	}
	.introduce>img{
		width:100%;
		height:500px;
	}
	.introduce{
		text-align:center;
		
	}
	.introduce>h1{
		margin-bottom:0;
	}
	#pre1{
		font-size:50px;
		margin:0;
	}
	#pre2{
		font-size:15px;
		font-weight: bold;
		font-family : 'Jua', sans-serif;
	}
	.introduce2>div>div{
		float:left;
		
	
	}
	.introduce2>div{
		overflow:hidden;
	}
	.image>img{
		width:500px;
	}
	.text{
		padding-left:50px;
	}
	.text>pre{
		font-weight: bold;
	}
	.top{
		background-image: url(/img/intro-body.jpg);
		background-size:cover;
		height:700px;
		
	}
	.top>h1{
		padding-top:100px;
	}
	.introduce{
		background-image: url(/img/intro-body.jpg);
		background-size:cover;
		height:700px;
	}
	.text>pre{
		font-size:13px; font-family : 'Jua', sans-serif;
	}
</style>
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
	<%-- <%@include file="/WEB-INF/views/contact/contactMain.jsp"%> --%>
	<div class="container">
		<div class="top">
			<h1>회사소개</h1>
			<h2>Pemily의 신념,고객을 위한 약속</h2>
		</div>
		<div class="body">
			<div class="moto">
			<br><br><br>
				<h4>Pemily의 4가지 모토</h4>
				<h1>Motto</h1>
				<div class="moto2">
					<div>
						<h2>봉사</h2>
						<h4>주기적인 유기동물보호소</h4>
						<h4>봉사와 후원으로 사회적 </h4>
						<h4>공헌 및 활동</h4>
					</div>
					<div>
						<h2>전문</h2>
						<h4>반려동물 관련분야 전문가들과</h4>
						<h4>유기적인 협력으로 반려문화 선진화에</h4>
						<h4>기여</h4>
					</div>
					<div>
						<h2>소통</h2>
						<h4>입양플래너, 수의사 등 전문가와</h4>
						<h4> 함께하는 실시간 소통, 지속적인 </h4>
						<h4>사후케어서비스</h4>
					</div>
					<div>
						<h2>진심</h2>
						<h4>진실된 마음으로 반려동물과 </h4>
						<h4>고객을 대하며, 반려인의 목소리에</h4>
						<h4>귀를 기울이는 자세</h4>
					</div>
				</div>
			</div><br><br>
			<div class="introduce">
				
				<h1>최초의 도전, 최선의 노력, 최고의 가치</h1>
				<pre id="pre1">P E M I L Y</pre>
				<pre id="pre2">
2001년 당산동의 조그마한 매장으로 시작한 Pemily가 한국뿐만 아니라 아시아 전역의
분양 문화를 선도하는 기업으로 성장할 수 있었던 건 반려문화 선진화를 향한 끊임없는
열정과 노력이 있었기 때문입니다.

Pemily는 기존 주먹구구식 무분별한 분양과 반려동물에 관한 지식이 전무하던 시절부터
관련 인재들을 채용. 분야별 올바른 지식을 지닌 전문가 양성에 힘써왔습니다.

이는 지금 Pemily의 건강한 반려동물의 선별부터 케어 입양까지 체계적인 관리 시스템의 기반이 되어
Pemily의 모든 구성원들이 지키고 추구하는 '생명존중'의 가치와 연결되어 있습니다.
				</pre>
			</div><br><br>
			<div class="introduce2">
				<div class="certified">
					<div class="image">
						<img src="/img/certified.jpg">
					</div>
					<div class="text">
						<h1>01. 공식인증된 안심분양업체</h1>
						<h3>Pemily는 국내 최초로 반려동물 공식협회에 인증을 받은</h3>
						<h3>믿을 수 있는 안심분양 업체입니다.</h3>
						<pre>
반려동물 분양관련 8년연속 소비자만족도 1위를 차지한 Pemily는
소비자 애견 피해보상 규정과 동물보호법을 준수하며, 
나아가 도의적인 책임까지 최대한 소비자의 입장에서 
생각함으로써 대한민국 반려문화 선진화에 앞장서고
있습니다.
						</pre>
					</div>
				</div><br>
				<div class="respect">
					<div class="image">
						<img src="/img/respect.jpg">
					</div>
					<div class="text">
						<h1>02. 생명에 대한 존중</h1>
						<h3>기존 주먹구구식 교배와 출산, 분양에서 탈피</h3>
						<pre>
반려동물 선진화를 위해 꾸준히 힘써온 결과, 
많은 반려인들의 사랑을 받으며
성장할 수 있었습니다.
						</pre>
					</div>
				</div><br>
				<div class="promise">
					<div class="image">
						<img src="/img/promise.jpg">
					</div>
					<div class="text">
						<h1>03. 약속을 소중히</h1>
						<h3>저희 Pemily는 분양에만 급급한 일부 업체와는 다르게,</h3>
						<pre>
Pemily의 모토이자 목표인 4가지 약속을 항상  
실천하며 평생의 반려가족을 맞이할 고객님들께
차별화된 가치를 제공하고자 노력하고 있습니다.
						</pre>
					</div>
				</div>
			</div>
		</div><br><br>
	</div>
	<%@include file="/WEB-INF/views/common/footer.jsp"%>
</body>
</html>