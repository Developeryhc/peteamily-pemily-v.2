<%@page import="care.model.vo.Care"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	Care c = (Care)request.getAttribute("c"); 
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- jQuery받아오기 위해서 --> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<!-- 합쳐지고 최소화된 최신 CSS --> 
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css"> 
<meta name="viewport" content="width=device-width, initial-scale=1"> 
<style>
.faq-wrap {
        width: 100%;
        height: 200px;
        margin: 10px auto;
       background-color: rgba(174, 215, 232, 0.73);
        position: relative;
    }
    .faq-wrap img {
        width: 100%;
        vertical-align: middle;
    }
    .faq-text {
        padding: 5px 10px;
        text-align: center;
        position: absolute;
	    top: 50%;
	    left: 50%;
        transform: translate( -50%, -50% );
    }
   .bt{
    text-align: center;}
    th{
    background-color: #f0eded;
    text-align: center;
    
    }
   table{
   width:500px;
   }
  
</style> 
</head>
<body>


	<%@include file="/WEB-INF/views/common/header.jsp" %>
	<div class="container">
		<div class="faq-wrap">
        	<div class="faq-image"></div>
        	<div class="faq-text">
            	<p>후기글</p>
        	</div>
    	</div> 

	<table class="table">
		<tr>
			<th>제목</th>
			<td colspan="3"><%=c.getCareTitle() %></td>
		</tr>
		<tr class="table-light">
			<th>작성자</th>
			<th><%=c.getCareWriter()%></th>
			<th>작성일</th>
			<th><%=c.getCareDate()%></th>
		</tr>
		<tr class="table-light">
			<th>내용</th>
			<td colspan="3"><%=c.getCareContentBr() %></td>
		</tr>
		</table>		
				
				<%--<%if(m!=null && m.getMemberId().equals(b.getBoardWriter())) {%>
				<a class="btn btn-info" href="/boardUpdateFrm?boardNo=<%=b.getBoardNo() %>">수정하기</a>
				<a class="btn btn-info" href="/boardDelete?boardNo=<%=b.getBoardNo() %>">삭제하기</a>
				<%} %> --%>
		<div class="bt">
		<button class="btn btn-info" onclick="history.go(-1);">이전화면</button>
		<a class="btn btn-info" href="/careUpdateFrm?careNo=<%=c.getCareNo()%>">수정하기</a>
		<a class="btn btn-info" href="/careDelete?careNo=<%=c.getCareNo() %>">삭제하기</a>
		</div>
	</div>
<%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>