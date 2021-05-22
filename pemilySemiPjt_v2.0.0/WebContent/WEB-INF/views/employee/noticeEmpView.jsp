<%@page import="notice.model.vo.NoticeWriteInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    NoticeWriteInfo nwi = (NoticeWriteInfo)request.getAttribute("nwi");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.empMenu:first-child>a{
		color:#555;
    	background-color:#fff;
	}
</style>
<style>
	.noticeView-wrap{
		margin-top:100px;
		width:800px;
		/* background-color:lightgray; */
		display:flex;
		flex-direction:column;
		box-shadow:3px 3px 7px black;
	}
	.writerInfo-wrap{
		border-bottom:1px solid #eee;
		display:flex;
		margin:0 10px;
	}
	.writerImg{
		width:100px;
		height:100px;
		box-sizing:border-box;
		padding:10px;
	}
	.writerImg>img{
		width:100%;
		height:100%;
	}
	.noticeViewTitle{
		display:block;
		width:100%;
		padding:20px 10px;
		font-size:1.6rem;
		box-sizing:border-box;
	}
	.noticeViewTitle+div{
		padding:0 10px;
		font-size:0.8rem;
	}
	.writerInfo{
		width:700px;
	}
	
	.noticeViewDate{
		float:right;
	}
	.nInfo{
		margin-right:10px;
	}
	.noticeViewContent{
		min-height:500px;
		margin:10px 20px;
		font-size:0.9rem;
		border-bottom:1px solid #eee;
	}
	.mdBtn-wrap{
		margin-bottom:10px;
		text-align:center;
	}
	.comment-wrap{
		margin-top:50px;
		width:800px;
		height:400px;
		background-color:lightblue;
	}
</style>
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
	<%@include file="/WEB-INF/views/common/empDefault.jsp" %>
	<%@include file="/WEB-INF/views/employee/employeeNavi.jsp" %>
	<section>
		<div class="noticeView-wrap">
			<div class="writerInfo-wrap">
				<div class="writerImg">
					<img src="/upload/employee/de bruyne.png" alt="직원사진">
				</div>
				<div class="writerInfo">
					<span class="noticeViewTitle"><%=nwi.getNoticeTitle() %></span>
					<div>
						<span class="nInfo noticeViewWriter"><%=nwi.getNoticeWriter() %></span>
						<span class="nInfo noticeViewName"><%=nwi.getEmpName() %></span>
						<span class="nInfo noticeViewPhone"><%=nwi.getEmpPhone() %></span>
						<span class="noticeViewDate"><%=nwi.getNoticeDate() %></span>
					</div>
				</div>
			</div>
			<div class="noticeViewContent">
				<%=nwi.getNoticeContent() %>
			</div>
			<div class="mdBtn-wrap"><button type="button" class="mdBtn goBackBtn">뒤로</button><button type="button" class="mdBtn modifyBtn" value="<%=nwi.getNoticeNo() %>">수정</button><button type="button" class="mdBtn deleteBtn" value="<%=nwi.getNoticeNo() %>">삭제</button></div>
		</div>
		<%-- 
		<div class="comment-wrap">
			<div class="commentWrite-wrap">
				<div class="commentWriterinfo"></div>
				<div class="commentWrite">
					<textarea id=""></textarea>
				</div>
			</div>
		</div>
		--%>
	<%@include file="/WEB-INF/views/employee/empModal.jsp" %>
		<input type="hidden" class="hiddenModiChk" value="1">
		<input type="hidden" class="hiddenDelChk" value="11">
	</section>
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>