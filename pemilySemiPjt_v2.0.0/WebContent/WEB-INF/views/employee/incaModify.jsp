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
		height:100%;
	}
	#incaPic+label{
		width:100%;
		height:100%;
	}
</style>
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
	<%@include file="/WEB-INF/views/common/empDefault.jsp" %>
	<%@include file="/WEB-INF/views/employee/employeeNavi.jsp" %>
	<%
		String condition = inca.getIncaCondition() == 0 ? "1차" : (inca.getIncaCondition() == 1 ? "2차" : (inca.getIncaCondition() == 3 ? "3차" : "완료"));
		String ani = inca.getIncaAn()==2?"강아지":(inca.getIncaAn()==3?"고양이":(inca.getIncaAn()==4?"어류":(inca.getIncaAn()==5?"도마뱀":(inca.getIncaAn()==6?"설치류":(inca.getIncaAn()==7?"뱀":(inca.getIncaAn()==8?"절지류":"기타"))))));            		
		String adopt = inca.getIncaCondition()<2?"불가":"가능";
		String store = inca.getIncaStore()==1?"본사":(inca.getIncaStore()==2?"강남":"부산");
		String gender = inca.getIncaGender() == "F"?"여아":"남아";
	%>
	<section>
        <div class="caModify-wrap">
        	<form action="/incaModifyFrm" id="incaModifyFrm" class="incaModifyFrm" method="post" enctype="multipart/form-data">
	            <div class="caTopBox">
	                <h3><%=inca.getIncaName() %></h3><span><%=ani %></span>
            	</div>
	            <div class="caImg-wrap">
	            	<input type="file" id="incaPic" name="incaPic">
        			<label for="incaPic" style="width:100%; height:100%;">
        				<%if(inca.getIncaPath() != ""){ %>
        					<img id="incaImg" src="/upload/inca/<%=inca.getIncaPath() %>">
        				<%} %>
        			</label>
	            </div>
	            <div class="caInfo-wrap">
	                <div class="caInfo">
	                    <span class="caInfoText">분양가</span><input type="text" id="incaPriceFake" value="<%=inca.getIncaPrice() %>" class="caInputs"><span class="caInfoText">건강</span>
	                    <select id="incaConditionSel" class="caInputs">
	                    	<%if(inca.getIncaCondition() == 0) {%>
	                    	<option value="0" selected>1차 접종</option>
	                    	<option value="1">2차 접종</option>
	                    	<%}else if(inca.getIncaCondition() == 1){ %>
	                    	<option value="1" selected>2차 접종</option>
	                    	<option value="2">3차 접종</option>
	                    	<%}else if(inca.getIncaCondition() == 2){ %>
	                    	<option value="2" selected>치료 중</option>
	                    	<option value="3">분양 전</option>
	                    	<%}else if(inca.getIncaCondition() == 3){ %>
	                    	<option value="2">치료 중</option>
	                    	<option value="3" selected>분양 전</option>
	                    	<option value="4">분양 중</option>	                    	
	                    	<%}else if(inca.getIncaCondition() == 4){ %>
	                    	<option value="2">치료 중</option>
	                    	<option value="3">분양 전</option>	                    	
	                    	<option value="4" selected>분양 중</option>	                    	
	                    	<%} %>
	                    </select>
	                </div>
	                <div class="caInfo">
	                    <span class="caInfoText">개월</span><div class="caInputs caDiv"><%=inca.getIncaMonth() %><span class="won">개월</span></div><span class="caInfoText">지점</span>
	                    <select id="incaStoreSel" class="caInputs">
	                    	<%if(inca.getIncaStore() == 1){ %>
	                    	<option value="1" selected>본사</option>
	                    	<option value="2">강남</option>
	                    	<option value="3">부산</option>
	                    	<%}else if(inca.getIncaStore() == 2){ %>
	                    	<option value="1">본사</option>
	                    	<option value="2" selected>강남</option>
	                    	<option value="3">부산</option>
	                    	<%}else if(inca.getIncaStore() == 3){ %>
	                    	<option value="1">본사</option>
	                    	<option value="2">강남</option>
	                    	<option value="3" selected>부산</option>
	                    	<%} %>
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
				<input type="hidden" name="oldIncaPic" value="<%=inca.getIncaPic() %>">                  
				<input type="hidden" name="oldIncaPath" value="<%=inca.getIncaPath() %>">                  
	            <div class="btnBox"><button type="button" class="mdBtn completeBtn" value="<%=inca.getIncaNo()%>">완료</button><button type="button" class="mdBtn cancelBtn" value="<%=inca.getIncaNo()%>">취소</button></div>
	       	</form>
        </div>
        <script>
        	$('#incaImg').click(function(){
        		$(this).remove();
        	});
        </script>
	<%@include file="/WEB-INF/views/employee/empModal.jsp" %>
        
        <input type="hidden" class="hiddenModiChk" value="2">
        <input type="hidden" class="hiddenDelChk" value="22">
	</section>
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>