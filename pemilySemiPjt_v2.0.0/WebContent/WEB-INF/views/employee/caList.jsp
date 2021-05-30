<%@page import="ca.model.vo.Ca"%>
<%@page import="inca.model.vo.Inca"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%
    ArrayList<Ca> list = (ArrayList<Ca>)request.getAttribute("list");
    String navigation = (String)request.getAttribute("navigation");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.empMenu:nth-child(3)>a{
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
		<h2 class="section-headline">반려동물 등록목록</h2>
		<!-- 반려동물 list table -->
        <table id="com_animals" class="printList">
            <thead>
                <tr>
                    <th>No</th><th>종</th><th>이름</th><th>예상 분양가</th><th>분양 지점</th><th>담당직원</th><th>등록일</th>
                    <c:if test="${not empty sessionScope.e && sessionScope.e.empGrade <= 3 }">
                    <th>분양</th><th colspan="2"></th>
                   	</c:if>
                </tr>
            </thead>
            <tbody>
                <%for(Ca ca : list) {
            		String condition = "분양 중";
            		String ani = ca.getCaKindNo()==2?"강아지":(ca.getCaKindNo()==3?"고양이":(ca.getCaKindNo()==4?"어류":(ca.getCaKindNo()==5?"도마뱀":(ca.getCaKindNo()==6?"설치류":(ca.getCaKindNo()==7?"뱀":(ca.getCaKindNo()==8?"절지류":"기타"))))));
            		String store = ca.getCaStore()==1?"본사":(ca.getCaStore()==2?"강남":"부산");
            	%>
            	<%if(ca.getRnum()%2==0){ %>
                <tr class="stripeTr1">
            	<%}else{ %>
                <tr class="stripeTr2">
            	<%} %>
                	<td><%=ca.getRnum() %></td><td><%=ani %></td><td><%=ca.getCaName() %></td><td><span class="priceFormat"><%=ca.getCaPrice() %></span><span class="won">원</span></td><td><%=store%></td><td><%=ca.getCaEmp()%></td><td><%=ca.getCaDate()%></td>
                	<c:if test="${not empty sessionScope.e && sessionScope.e.empGrade <= 3 }">
	                	<td><button type="button" class="mdBtn modifyBtn" value="<%=ca.getCaAn()%>">수정</button></td><td><button type="button" class="mdBtn deleteBtn" value="<%=ca.getCaAn()%>">삭제</button></td>
                	</c:if>
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