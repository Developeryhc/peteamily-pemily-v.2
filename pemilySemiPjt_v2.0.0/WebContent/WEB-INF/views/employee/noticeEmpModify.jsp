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
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
	<%@include file="/WEB-INF/views/common/empDefault.jsp" %>
	<%@include file="/WEB-INF/views/employee/employeeNavi.jsp" %>
	<section>
		<div class="noticeView-wrap">
			<form action="/nModifyFrm" class="nModifyFrm" method="post">
				<div class="writerInfo-wrap">
					<div class="writerImg">
						<img src="/upload/employee/de bruyne.png" alt="직원사진">
					</div>
					<div class="writerInfo">
						<span class="noticeViewTitle"><input type="text" id="noticeTitle" name="noticeTitle" value="<%=nwi.getNoticeTitle() %>"></span>
						<div>
							<span class="nInfo noticeViewWriter"><%=nwi.getNoticeWriter() %></span>
							<span class="nInfo noticeViewName"><%=nwi.getEmpName() %></span>
							<span class="nInfo noticeViewPhone"><%=nwi.getEmpPhone() %></span>
							<span class="noticeViewDate"><%=nwi.getNoticeDate() %></span>
						</div>
					</div>
				</div>
				<textarea id="modifyContentNote" name="noticeContent" class="summernote">
					<%=nwi.getNoticeContent() %>
				</textarea>
				<div class="mdBtn-wrap"><button type="button" id="noticeModifyBtn" class="mdBtn completeBtn" value="<%=nwi.getNoticeNo() %>">완료</button><button type="button" class="mdBtn cancelBtn" value="<%=nwi.getNoticeNo() %>">취소</button></div>
				<input type="hidden" id="noticeNo" name="noticeNo" value="<%=nwi.getNoticeNo() %>">
				<input type="hidden" id="noticeWriter" name="noticeWriter" value="<%=nwi.getNoticeWriter() %>">
				<input type="hidden" id="modifyCheck" value="1">
				<%-- <input type="hidden" name="noticeCom" value="<%=nwi.getNoticeCom() %>"> --%>
			</form>
		</div>
		<%@include file="/WEB-INF/views/employee/empModal.jsp" %>
		<input type="hidden" class="hiddenModiChk" value="1">
	</section>
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>