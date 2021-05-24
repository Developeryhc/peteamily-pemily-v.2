<%@page import="order.model.vo.Order"%>
<%@page import="java.util.ArrayList"%>
<%@page import="member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Member member = (Member) request.getAttribute("member");
	ArrayList<Order> list = (ArrayList<Order>)request.getAttribute("list");
	
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<script type="text/javascript" src="/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp"%>
	<div class="container">
	<br>
		<form action="/updateMember" method="post">
			<div class="mypage">
				<h3>내정보</h3>
				<div class="memberId">
					<label class="control-label" for="memberId">아이디</label> <input
						type="text" id="memberId" name="memberId" class="form-control"
						value="<%=member.getMemberId()%>" readonly>
				</div>
				<div class="form-group">

					<label class="control-label" for="memberPw">비밀번호</label> <input
						type="password" id="memberPw" name="memberPw" class="form-control"
						value="<%=member.getMemberPw()%>">
				</div>
				<div class="form-group">

					<label class="control-label" for="memberName">이름</label> <input
						type="text" id="memberName" name="memberName" class="form-control"
						value="<%=member.getMemberName()%>" readonly>
				</div>
				<div class="form-group">
					<label class="control-label" for="memberPhone">전화번호</label> <input
						type="text" id="memberPhone" name="memberPhone"
						class="form-control" value="<%=member.getMemberPhone()%>">
				</div>
				<div class="form-group">

					<label class="control-label" for="memberAddr">주소</label> <input
						type="text" id="memberAddr" name="memberAddr" class="form-control"
						value="<%=member.getMemberAddr()%>">
				</div>
				<div class="form-group">

					<label class="control-label" for="memberEnter">가입일</label> <input
						type="text" id="memberEnter" name="memberEnter"
						class="form-control" value="<%=member.getMemberEnter()%>" readonly>
				</div>
				<div class="form-group">
					<button type="submit" class="btn btn-outline-primary">정보수정</button>
					<a href="/deleteMember?memberNo=<%=member.getMemberNo()%>"
						class="btn btn-outline-danger">회원탈퇴</a>
				</div>
			</div>
		</form><br>
		<div class="order">
		<h3>주문목록</h3>
			<table class="table table-striped">
				<tr>
					<td>거래번호</td>
					<td>상품명</td>
					<td>상품금액</td>
					<td>상품수량</td>
				</tr>
				<%for(int i = 0; i<list.size();i++){ %>
				<tr>
					<td><%=list.get(i).getOrderNo()%> </td>
					<td><%=list.get(i).getOrderName() %></td>
					<td><%=list.get(i).getOrderPrice() %></td>
					<td><%=list.get(i).getOrderAmount() %></td>
				</tr>
			</table>
		</div><br>
		<div class="shopping">
		<h3>장바구니</h3>
			<table class="table table-striped">
				<tr>
					<td>상품명</td>
					<td>상풍금액</td>
					<td>상품수량</td>
				</tr>
				<tr> 
					<td>상품2</td>
					<td>200</td>
					<td>2</td>
				</tr>
				<%} %>
			</table>
		</div>
	</div>
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>