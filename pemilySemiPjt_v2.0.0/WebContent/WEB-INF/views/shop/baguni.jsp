<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%	
	String name = (String)request.getAttribute("inProName");
	int price = Integer.parseInt((String)request.getAttribute("inProPrice"));
	int count = (Integer)request.getAttribute("count");
	
	int sum = price * count;
	int cong = sum + 3000;
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니</title>
<link rel="stylesheet" href="/css/product/baguni.css">
</head>
<body>
<%@include file="/WEB-INF/views/common/header.jsp" %>
	 <div class="baguni">
         <p style="font-size: 12px;">장바구니에 담긴 상품</p>
        <table width="100%" class="tb_1" >
            <tr>
                <th width="10%">
                    번호
                </th>
                <th>
                    제품명
                </th>
                <th width="10%">
                    수량
                </th>
                <th width="20%">
                    가격
                </th>
            </tr>
            <tr>
                <td>
                    1
                </td>
                <td>
               <%=name %>
                </td>
                <td>
                    <%=count %>
                </td>
                <td>
                    <%=sum %> 원
                </td>
            </tr>
        </table>
        <table width=100% class="tb_2">
            <tr><td>
                총 주문금액 = <%=sum %> + 3000(배송비) = <%=cong %>원
            </td></tr>
        </table>
     
        
        <div class="btn">
        
        <!--<div class="btn-buy"><a href="/buy?inProName=<%=name%>&inProPrice=<%=price%>&count=";">주문하기</a></div>-->
        <div class="btn-buy"><a href="#">주문하기</a></div>
          <!--    <div><a href="/buy">주문하기</a></div>-->
            <div><a href="#">계속쇼핑하기</a></div>
            <div><a href="#">장바구니비우기</a></div>
        </div>
    </div>
    
    

</body>
</html>