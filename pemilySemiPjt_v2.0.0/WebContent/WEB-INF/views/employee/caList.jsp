<%@page import="inca.model.vo.Inca"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    ArrayList<Inca> list = (ArrayList<Inca>)request.getAttribute("list");
    String navigation = (String)request.getAttribute("navigation");
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
</style>
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
	<%@include file="/WEB-INF/views/common/empDefault.jsp" %>
	<%@include file="/WEB-INF/views/employee/employeeNavi.jsp" %>
	<section>
		<h2 class="section-headline">반려동물 목록</h2>
		<!-- 반려동물 list table -->
        <table id="com_animals" class="printList">
            <thead>
                <tr>
                    <th>No</th><th>종</th><th>이름</th><th>개월</th><th>예상 분양가</th><th>검사</th><th>지점</th><th>분양</th><th colspan="2"></th>
                </tr>
            </thead>
            <tbody>
                <%for(Inca inca : list) {%>
            	<%
            		String condition = inca.getIncaCondition() == 0 ? "1차" : (inca.getIncaCondition() == 1 ? "2차" : "완료");
            		String ani = inca.getIncaAn()==2?"강아지":(inca.getIncaAn()==3?"고양이":(inca.getIncaAn()==4?"어류":(inca.getIncaAn()==5?"도마뱀":(inca.getIncaAn()==6?"설치류":(inca.getIncaAn()==7?"뱀":(inca.getIncaAn()==8?"절지류":"기타"))))));            		
            		String adopt = inca.getIncaCondition()<2?"불가":"가능";
            		String store = inca.getIncaStore()==1?"본사":(inca.getIncaStore()==2?"강남":"부산");
            	%>
                <tr>
                	<td><%=inca.getSort() %></td><td><%=ani %></td><td><%=inca.getIncaName() %></td><td><%=inca.getIncaMonth() %></td><td><%=inca.getIncaPrice() %><span class="won">원</span></td><td><%=condition %></td><td><%=store %></td><td><%=adopt %></td><td><button type="button" class="mdBtn modifyBtn" value="<%=inca.getIncaNo()%>">수정</button></td><td><button type="button" class="mdBtn deleteBtn" value="<%=inca.getIncaNo()%>">삭제</button></td>
                </tr>
                <%} %>
            </tbody>
        </table>
        <%=navigation %>
        <%@include file="/WEB-INF/views/employee/empModal.jsp" %>
        <input type="hidden" class="hiddenModiChk" value="2">
        <input type="hidden" class="hiddenDelChk" value="22">
	</section>
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
	<script>
	</script>
</body>
</html>