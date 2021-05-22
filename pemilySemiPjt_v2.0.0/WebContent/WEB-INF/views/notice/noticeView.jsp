<%@page import="notice.model.vo.Notice"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	Notice n = (Notice)request.getAttribute("n");
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.js"></script> 
<!-- jQuery받아오기 위해서 --> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<!-- 합쳐지고 최소화된 최신 CSS --> 
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css"> 
<meta name="viewport" content="width=device-width, initial-scale=1"> 
<title>Insert title here</title>
<style>
.faq-wrap {
        width: 100%;
        height: 200px;
        margin: 10px auto;
        position: relative;
        background-color: rgba(242, 217, 207, 0.84);
       
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
   width:100%;
   layout:fixed;}
  
</style> 
</head> 
<body> 
<%@include file="/WEB-INF/views/common/header.jsp" %>
<div class="container">
		<div class="faq-wrap">
        	<div class="faq-image"></div>
        	<div class="faq-text">
            	<p>공지사항</p>
        	</div>
    	</div> 

		<table class="table">
		<tr>
			<th>제목</th>
			<td colspan="3"><%=n.getNoticeTitle() %></td>
		</tr>
		<tr class="table-light">
			<th>작성자</th>
			<td><%=n.getNoticeWriter()%></td>
			<th>작성일</th>
			<td><%=n.getNoticeDate()%></td>
		</tr>
		<tr class="table-light">
			<th>내용</th>
			<td colspan="3"><%=n.getNoticeContentBr() %></td>
		</tr>
		</table>		
				
				
				<%--<%if(m!=null && m.getMemberId().equals(b.getBoardWriter())) {%>
				<a class="btn btn-info" href="/boardUpdateFrm?boardNo=<%=b.getBoardNo() %>">수정하기</a>
				<a class="btn btn-info" href="/boardDelete?boardNo=<%=b.getBoardNo() %>">삭제하기</a>
				<%} %> --%>
		<div class="bt">
		<button class="btn btn-info" onclick="history.go(-1);">이전화면</button>
		<a class="btn btn-info" href="/noticeUpdateFrm?noticeNo=<%=n.getNoticeNo()%>">수정하기</a>
		<a class="btn btn-info" href="/noticeDelete?noticeNo=<%=n.getNoticeNo() %>&noticeCom=<%=n.getNoticeCom()%>">삭제하기</a>
		</div>
	</div>
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>