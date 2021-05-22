<%@page import="inPro.model.vo.InPro"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	ArrayList<InPro> list = (ArrayList<InPro>)request.getAttribute("list");
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
	.hides{
		display:none;	
		width:50px;
	}
	.hideBtn{
		display:none;
	}

</style>
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
	<%@include file="/WEB-INF/views/common/empDefault.jsp" %>
	<%@include file="/WEB-INF/views/employee/employeeNavi.jsp" %>
	<section>
		<h2 class="section-headline">등록 상품 목록</h2>
	   	<table id="inProductList" class="printList">
	       <thead>
	           <tr>
	               <th>No</th><th>분류</th><th>상품명</th><th>판매가</th><th>수량</th><th colspan="2"></th>
	           </tr>
	       </thead>
	       <tbody>
	           <%
	           	for(InPro inPro : list){
	           		 String proKinds = inPro.getInProSn()==10?"Snack":(inPro.getInProSn()==20?"Toy":(inPro.getInProSn()==30?"Clothes":"기타"));
	           %>
	           <tr>
	           	   <td><%=inPro.getSort() %></td><td><%=proKinds %></td><td><%=inPro.getInProName() %></td>
	           	   <td>
	           	   		<span><%=inPro.getInProPrice() %></span><span class="won">원</span>
	           	   		<input type="text" id="inProPriceFake" name="inProPriceFake" class="hides inProInputs" value="<%=inPro.getInProPrice() %>">
	           	   		<input type="hidden" id="inProPrice" name="inProPrice" value="<%=inPro.getInProPrice() %>">
	           	   </td>
	           	   	<td>
	           	   		<span><%=inPro.getInProAmount() %></span><span class="won">개</span>
	           	   		<input type="text" id="inProAmount" name="inProAmount" class="hides inProInputs" value="<%=inPro.getInProAmount() %>">
	           	   </td>
	           	   <td>
	           	   		<button type="button" class="mdBtn modifyBtn" value="<%=inPro.getInProNo() %>">수정</button>
	           	   		<button type="button" class="mdBtn completeBtn hideBtn" value="<%=inPro.getInProNo() %>">완료</button>
	           	   	</td>
	           	   <td>
	           	   		<button type="button" class="mdBtn deleteBtn" value="<%=inPro.getInProNo() %>" >삭제</button>
	           	   		<button type="button" class="mdBtn cancelBtn hideBtn" value="<%=inPro.getInProNo() %>" >취소</button>
	           	   	</td>
	           </tr>
	           <%} %>
	       </tbody>
	   	</table>
   		<%=navigation %>
    <%@include file="/WEB-INF/views/employee/empModal.jsp" %>
    	<input type="hidden" class="hiddenModiChk" value="3">
        <input type="hidden" class="hiddenDelChk" value="33">
	</section>
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>