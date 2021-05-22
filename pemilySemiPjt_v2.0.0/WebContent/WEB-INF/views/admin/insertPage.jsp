<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.empMenu:last-child>a{
		color:#555;
    	background-color:#fff;
	}
	.wrap-2{
	width: 620px;
	background: white;
	border: 1px solid black;
	margin: auto;
	padding: 60px 90px 60px 90px;
	display: hidden;
	}
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	<%@include file="/WEB-INF/views/common/empDefault.jsp" %>
	<%@ include file="/WEB-INF/views/employee/employeeNavi.jsp" %>
	<section>
		<div class="category">
	        <h4>카테고리 설정</h4>
	        <select id="menuSelect">
	            <option selected>선택</option>
	            <option value="noticeFrm">공지사항</option>
	            <option value="incaFrm">반려동물 등록</option>
	            <option value="inProFrm">물품재고 등록</option>
	        </select>
		</div>
        <form class="forms" id="noticeFrm" action="/noticeEmpWrite"><!-- action="/noticeWrite" -->
        	<!-- 넘겨줄 값 : 작성자,제목,내용 -->
            <h2>공지사항 등록</h2>
            <select id="noticeChoice">
            	<option value="0" selected>공지 분류</option>
            	<option value="1">직원 공지</option>
            	<option value="2">회원 공지</option>
            </select>
            <input type="hidden" id="noticeCom" name="noticeCom" value="0">
            <input type="hidden" id="noticeWriter" name="noticeWriter" value="도베르만">
            <input type="text" id="noticeTitle" class="title" name="noticeTitle" placeholder="제목 입력" autocomplete="off">
            <textarea id="noticeContent" class="summernote" name="noticeContent"></textarea>
            <div class="btns">
	            <button type="button" id="noticeBtn">작성완료</button>
	            <button type="button" class="cancelBtn">돌아가기</button>            
            </div>
        </form>
        <form class="forms" id="faqFrm" action="javascript:void(0);">
        	<h2>자주 듣는 질문 등록</h2>
        	<input type="text" class="title" name="서블릿에 전송할 명칭" placeholder="제목 입력">
            <div id="noticeContent" class="summernote" name="noticeContent"></div>
        </form>
        <form class="forms" id="incaFrm" action="/incaWrite" method="post" enctype="multipart/form-data">
        	<h2>반려동물 등록</h2>
        	<!-- 동물 종 select -->
        	<div class="animalInfoWrap" id="animalInfoWrap">
        		<!-- 동물 등록 사진 : incaPic -->
        		<input type="file" id="incaPic" name="incaPic">
        		<label for="incaPic"></label>
        		<div>
	        		<div class="animalInfo">
			        	<div class="kindsWrap">
				        	<!-- 과 분류 -->
				        	<select id="kindChoice">
				            	<option value="0" selected>분류</option>
				            	<option value="dog">견</option><!-- dog -->
				            	<option value="cat">묘</option><!-- cat -->
				            	<option value="pisces">어류</option><!-- pisces -->
				            	<option value="arthropod">절지류</option><!-- amphibia -->
				            	<option value="rodent">설치류</option><!-- arthropod -->
				            	<option value="lizard">도마뱀</option><!-- lizard -->
				            	<option value="snake">뱀</option><!-- snake -->
				            </select>
				            <div class="kindsBox">
					            <!-- 견 -->
					            <select id="dog" class="kinds">
					            	<option value="0" selected>분류</option>
					            	<option value="2">닥스훈트</option>
					            	<option value="2">말티즈</option>
					            	<option value="2">비글</option>
					            	<option value="2">비숑 프리제</option>
					            	<option value="2">보더 콜리</option>
					            	<option value="2">시바</option>
					            	<option value="2">시추</option>
					            	<option value="2">웰시 코기</option>
					            	<option value="2">제페니즈 스피츠</option>
					            	<option value="2">치와와</option>
					            	<option value="2">퍼그</option>
					            	<option value="2">포메라니안</option>
					            	<option value="2">푸들</option>
					            </select>
					            <!-- 묘 -->
					            <select id="cat" class="kinds">
					            	<option value="0" selected>분류</option>
					            	<option value="3">러시안 블루</option>
					            	<option value="3">랙돌</option>
					            	<option value="3">먼치킨</option>
					            	<option value="3">브리티시 숏헤어</option>
					            	<option value="3">브리티시 롱헤어</option>
					            	<option value="3">봄베이</option>
					            	<option value="3">뱅골</option>
					            	<option value="3">사바나</option>
					            	<option value="3">샴</option>
					            	<option value="3">시베리안</option>
					            	<option value="3">스코티시 폴드</option>
					            	<option value="3">아메리칸 숏헤어</option>
					            	<option value="3">유러피안 숏헤어</option>
					            	<option value="3">페르시안</option>
					            </select>
					            <!-- 어류 -->
					            <select id="pisces" class="kinds">
					            	<option value="0" selected>분류</option>
					            	<option value="4">어류1</option>
					            	<option value="4">어류2</option>
					            	<option value="4">어류3</option>
					            	<option value="4">어류4</option>
					            	<option value="4">어류5</option>
					            	<option value="4">어류6</option>
					            	<option value="4">어류7</option>
					            </select>
					            <!-- 절지류 -->
					            <select id="arthropod" class="kinds">
					            	<option value="0" selected>분류</option>
					            	<option value="8">절지류1</option>
					            	<option value="8">절지류2</option>
					            	<option value="8">절지류3</option>
					            	<option value="8">절지류4</option>
					            	<option value="8">절지류5</option>
					            </select>
					            <!-- 설치류 -->
					            <select id="rodent" class="kinds">
					            	<option value="0" selected>분류</option>
					            	<option value="6">설치류1</option>
					            	<option value="6">설치류2</option>
					            	<option value="6">설치류3</option>
					            	<option value="6">설치류4</option>
					            	<option value="6">설치류5</option>
					            	<option value="6">설치류6</option>
					            </select>
					            <!-- 도마뱀 -->
					            <select id="lizard" class="kinds">
					            	<option value="0" selected>분류</option>
					            	<option value="5">종1</option>
					            	<option value="5">종2</option>
					            	<option value="5">종3</option>
					            	<option value="5">종4</option>		            	
					            </select>
					            <!-- 뱀 -->
					            <select id="snake" class="kinds">
					            	<option value="0" selected>분류</option>           	
				            		<option value="7">비단뱀</option>
				            		<option value="7">구렁이</option>
				            		<option value="7">아나콘다</option>
				            		<option value="7">살모사</option>
				            		<option value="7">블랙맘바</option>
					            </select>
				            </div>
			        	</div>
			        	<div class="animalDivWrap">
				            <!-- 동물 이름 : incaName -->
				            <input type="text" class="incaInputs" id="incaName" name="incaName" placeholder="이름(5자 이내)">
				            <!-- 동물 성별 select -->
				            <select id="incaGenderSel">
				            	<option value="0" selected>성별</option>
				            	<option value="M">남아</option>
				            	<option value="F">여아</option>
				            </select>
			        	</div>
			        	<div class="animalDivWrap">
			            	<!-- 동물 분양가 : incaPrice-->
				            <input type="text" class="incaInputs" id="incaPriceFake" placeholder="분양가">
				            <input type="hidden" id="incaPrice" name="incaPrice">
				            <!-- 동물 지점 select -->
				            <select id="incaStoreSel">
				            	<option value="0" selected>지점</option>
				            	<option value="1">당산</option>
				            	<option value="2">강남 1호점</option>
				            	<option value="3">강남 2호점</option>
				            	<option value="4">강남 3호점</option>
				            	<option value="5">종로</option>
				            	<option value="6">이태원</option>
				            	<option value="7">울산</option>
				            </select>
			        	</div>
			        	
		            	<!-- 동물 개월 수 : incaMonth-->
		            	<input type="text" class="incaInputs" id="incaMonth" name="incaMonth" placeholder="개월 수">
			       		<div class="btns" id="incaBtnWrap">
			       			<button type="button" id="incaBtn">등록</button>
			       			<button type="button" class="cancelBtn">취소</button>
			       		</div>
	        		</div>
        		</div>
        	</div>
        	<!-- 동물 종 : incaAn -->
        	<input type="hidden" id="incaAn" name="incaAn" value="0">
        	<!-- 동물 성별 : incaGender -->
        	<input type="hidden" id="incaGender" name="incaGender" value="0">
        	<!-- 동물 등록 지점 : incaStore-->
        	<input type="hidden" id="incaStore" name="incaStore" value="0">
            <!-- 동물 건강(검사) : incaCondition--><!-- 처음 등록은 '0'값을 넘겨준다. -->
            <input type="hidden" id="incaCondition" name="incaCondition" value="0">
        </form>
        
        <!-- 물품재고 등록 form -->
        <div class="wrap-2">
        <form class="forms" id="inProFrm" action="/inProductWrite" method="post" enctype="multipart/form-data">
        	<h2>물품 재고 등록</h2>
        	<div class="inProWrap">
        		<input type="file" id="inProPic" name="inProPic">
        		<label for="inProPic"></label>
        		<div class="proWrap">
        			<!-- 상품 이름 -->     
        			<input type="text" id="inProNamspe" class="inProInputs" name="inProName" placeholder="상품 이름 입력">
        			<!-- 상품 분류 -->			
		        	<select id="inProKind">
		        		<option value="0" selected>분류</option>
		        			<option value="10">Snack</option>
		        			<option value="20">Toy</option>
		        			<option value="30">Clothes</option>
		        	</select>
		        	<!-- 상품 분류 -->
		        	<input type="hidden" id="inProSn" name="inProSn" value="0">
		        	<!-- 상품 수량 -->
		        	<input type="text" id="inProAmount" class="inProInputs" name="inProAmount" placeholder="상품 수량 입력">
		        	<!-- 상품 가격 -->
		        	<input type="text" id="inProPriceFake" class="inProInputs" placeholder="상품 가격 입력">
		        	<input type="hidden" id="inProPrice" class="inProInputs" name="inProPrice">
		        	<div class="btns" id="inProBtnWrap">
		        		<button type="button" id="inProBtn">등록</button>
		        		<button type="button" class="cancelBtn">취소</button>
		        	</div>
        		</div>
        	</div>
        </form>

        </div>
        <form class="forms" id="parcelOutFrm" action="javascript:void(0);">
        	<h2>분양 등록</h2>
        	<input type="text" class="title" name="서블릿에 전송할 명칭" placeholder="제목 입력">
            <textarea id="noticeContent" class="summernote" name="noticeContent"></textarea>
        </form>
        <form class="forms" id="goodsFrm" action="javascript:void(0);">
        	<h2>물품 등록</h2>
        	<input type="text" class="title" name="서블릿에 전송할 명칭" placeholder="제목 입력">
            <textarea id="noticeContent" class="summernote" name="noticeContent"></textarea>
        </form>
    </section>
    <%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>