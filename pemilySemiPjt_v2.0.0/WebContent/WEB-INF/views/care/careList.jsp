<%@page import="care.model.vo.Care"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    ArrayList<Care> list = (ArrayList<Care>)request.getAttribute("list");
    String pageNavi = (String)request.getAttribute("pageNavi");
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<style>
    .write>a{
      color : black;
      font-weight: bolder;
     
    }
	#pageNavi{
        text-align: center;
	}
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
     .photo {
            margin: 20px;
            border: 1px solid #ccc;
            float: left;
            width: 180px;
            
        }
        
        .photo:hover {
            border: 1px solid #777;
        }
        
        .photo>img {
            width: 100%;
            height:100px;
        }
    
        .content {
           
            text-align: center;
        }
        .wrap{
        width:1200px;
        overflow: hidden;
        }
       .bolder{
 	font-weight: bolder;
 	font-size: 20px;}
 	p>a{
 	margin : 20px;
 	color:black;}
       
</style>
</head>
<body>
	
	<%@include file="/WEB-INF/views/common/header.jsp" %>
	<div class="container">

			<div class="faq-wrap">
        		<div class="faq-image"></div>
        		<div class="faq-text">
            		<p>
				
				<a href="/noticeList?reqPage=1&noticeCom=2">공지사항</a>
				<a class="bolder" href="/careList?reqPage=1">분양후기</a>
				<a href="/faqList">FAQ	</a>
			
			</p>
        		</div>
    		</div>
    		
    <div class="wrap">
    		<%for(Care c : list) {%>
        <div class="photo">
            	<img src='/upload/care/<%=c.getCarePath() %>'>
            	
            <div class="content">
                <div class="title">
                 <a href="/careView?careNo=<%=c.getCareNo()%>"><%=c.getCareTitle()%></a>
                </div>
                <div class="writer"><%=c.getCareWriter()%></div>
                <div class="date"> <%=c.getCareDate() %></div>
            </div>
        </div>
        <%} %>		
   	</div>
   	<%if(m != null){ %>
   		<div><a class="btn btn-default" href="/careWriteFrm">글쓰기</a></div>
   	<%} %>
   </div>
   
        <div id="pageNavi"><%=pageNavi %></div>
     <%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>

	