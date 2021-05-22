<%@page import="inca.model.vo.Inca"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	Inca inca = (Inca)request.getAttribute("inca");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.empMenu:nth-child(2)>a{
		color:#555;
    	background-color:rgb(246,246,246);
	}
	.caDiv{
		background-color:#ddd;
	}
	.iiimg{
		width:100%;
		hwight:100%;
	}
</style>
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
	<%@include file="/WEB-INF/views/common/empDefault.jsp" %>
	<%@include file="/WEB-INF/views/employee/employeeNavi.jsp" %>
	<%
		String condition = inca.getIncaCondition() == 0 ? "1차" : (inca.getIncaCondition() == 1 ? "2차" : "완료");
		String ani = inca.getIncaAn()==1?"강아지":(inca.getIncaAn()==2?"고양이":(inca.getIncaAn()==3?"어류":(inca.getIncaAn()==4?"도마뱀":(inca.getIncaAn()==5?"설치류":(inca.getIncaAn()==6?"뱀":(inca.getIncaAn()==7?"절지류":"기타"))))));            		
		String adopt = inca.getIncaCondition()<2?"불가":"가능";
		String store = inca.getIncaStore()==1?"본사":(inca.getIncaStore()==2?"강남":"부산");
		String gender = inca.getIncaGender() == "F"?"여아":"남아";
	%>
	<section>
        <div class="caModify-wrap">
        	<form action="/incaModifyFrm" class="incaModifyFrm" method="post">
	            <div class="caTopBox">
	                <h3><%=inca.getIncaName() %></h3><span><%=ani %></span>
            	</div>
	            <div class="caImg-wrap">
	            <img class="iiimg"src="/upload/inca/<%=inca.getIncaPath()%>"></div>
	            <div class="caInfo-wrap">
	                <div class="caInfo">
	                    <span class="caInfoText">분양가</span><input type="text" id="incaPriceFake" value="<%=inca.getIncaPrice() %>" class="caInputs"><span class="caInfoText">건강</span>
	                    <select id="incaConditionSel" class="caInputs">
	                    	<option value="0" selected>상태</option>
	                    	<option value="1">1차 접종</option>
	                    	<option value="2">2차 접종</option>
	                    	<option value="3">3차 접종</option>
	                    </select>
	                </div>
	                <div class="caInfo">
	                    <span class="caInfoText">개월</span><div class="caInputs caDiv"><%=inca.getIncaMonth() %><span class="won">개월</span></div><span class="caInfoText">지점</span>
	                    <select id="incaStoreSel" class="caInputs">
	                    	<option value="0" selected>지점</option>
	                    	<option value="1">본사</option>
	                    	<option value="2">강남</option>
	                    	<option value="3">부산</option>
	                    </select>
	                </div>
	                <div class="caInfo">
	                    <span class="caInfoText">성별</span><div class="caInputs caDiv"><%=gender %></div><span class="caInfoText">등록일</span><div class="caInputs caDiv"><%=inca.getIncaDate() %></div>
	                </div>
	            </div>
	            <input type="hidden" id="incaNo" name="incaNo" value="<%=inca.getIncaNo()%>">
	            <input type="hidden" id="incaPrice" name="incaPrice" value="<%=inca.getIncaPrice()%>">
				<input type="hidden" id="incaCondition" name="incaCondition" value="<%=inca.getIncaCondition()%>">
				<input type="hidden" id="incaStore" name="incaStore" value="<%=inca.getIncaStore()%>">	            
	            <div class="btnBox"><button type="button" class="mdBtn completeBtn" value="<%=inca.getIncaNo()%>">완료</button><button type="button" class="mdBtn cancelBtn" value="<%=inca.getIncaNo()%>">취소</button></div>
	       	</form>
        </div>
	<%@include file="/WEB-INF/views/employee/empModal.jsp" %>
        
        <input type="hidden" class="hiddenModiChk" value="2">
        <input type="hidden" class="hiddenDelChk" value="22">
	</section>
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>