
<%@page import="inPro.model.vo.InPro"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    InPro pro = (InPro)request.getAttribute("pro");
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" href="/css/product/detail.css"> 
    <style>
        .arrow_size{
            width: 9px;
        }
        .f_size{
        font-size: 30px;
        font-weight: bolder;
        }
        .img_size{
        	margin-top: 15px;
        	width: 450px;
        }
    </style>
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
	<div class="order_top">
	      <img src="/img/arrow.png" class="arrow_size">  <a href="javascript:history.back();">이전페이지</a>                          <span class="span_r">  home > 테이블명 > 상품이름 </span>
	    </div>
	    <div class="order">
	        <div class="red">
	         	
	            <img src="/upload/inProduct/<%=pro.getInProPic() %>" class="img_size">
	        </div>
	        <div class="blue">
	        <form action="">
	        <table class="tb">
	            <tr><td><p class="tb_p"><%=pro.getInProName() %><input type="hidden" name="inProName" value="<%=pro.getInProName()%>"></p></td></tr>
	                <tr><td class="tb_size"> 판매가격 <%=pro.getInProPrice() %>원</td></tr>
	                <tr><td class="tb_size"> 수량 
	                    <select name="count" class="select">
	                        <option>1</option>
	                        <option>2</option>
	                        <option>3</option>
	                        <option>4</option>
	                        <option>5</option>
	                        <option>6</option>
	                        <option>7</option>
	                        <option>8</option>
	                        <option>9</option>
	                    </select>
	                </td></tr>
	                <tr><td class="tb_size">
	                   <div class="btn btn-buy"><a>구매하기</a></div>
	                   <div class="btn btn-buy2"><a>장바구니  </a></div>
	                   <div class="btn"><a href="#">찜하기</a></div>
	                </td></tr>
	            </table>
	            </form>
	        </div>
	    </div>
	    <div class="order_bottom">
	        <p>PRODUCT ___ 상품 상세 보기</p>
	        <div>
	        
	        
	        	
	            <img src="/upload/inProduct/<%=pro.getInProPic() %>" class="div_center"><br><br>
	            <p class="f_size"><%= pro.getInProName() %><p>
	            
	            <br> 지금 구매하시면 단돈 ! <%=pro.getInProPrice() %>원!!<br>
	            	지금바로 구매하세요~
	            
	            <br><br>
	           
	        </div>
	    </div>
	    <script>
	    	$(".select").click(function(){
	    		var count = $(".select").val();
	    		var href = "/buy?inProName=<%=pro.getInProName()%>&inProPrice=<%=pro.getInProPrice()%>&count=";
	    		href += count;
	    		$(".btn-buy").children().attr("href", href);
	    	});
	    	$(".select").click(function(){
	    		var count = $(".select").val();
	    		var href = "/baguni?inProName=<%=pro.getInProName()%>&inProPrice=<%=pro.getInProPrice()%>&count=";
	    		href += count;
	    		$(".btn-buy2").children().attr("href", href);
	    	});
	  
	    </script>
</body>

</html>