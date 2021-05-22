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
<title>구매하기</title>
 <link rel="stylesheet" a href="/css/product/buy.css">
<link rel="stylesheet" href="/css/product/baguni.css">
<style>
	.price_left{
		margin-left: 30px;
	}
</style>
</head>
<body>

	<%@include file="/WEB-INF/views/common/header.jsp" %>
	 <div class="order_list">
	 	
	 	
	 	<p style="font-size: 12px;">장바구니에 담긴 상품</p>
        <table width="100%" class="tb_1" >
            <tr>
                <th width="10%">
                    번호
                </th>
                <th>
                    이름
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
                   <%= name %>
                </td>
                <td>
                    <%= count %> 개
                </td>
                <td>
                   <%=price %> * <%=count %> = <%=sum %> 원
                </td>
            </tr>
        </table>
        <table width=100% class="tb_2">
            <tr><td>
                총 주문금액   <%=sum %> + 3000(배송비)  = <%=cong %>
            </td></tr>
        </table>
	 	
	 	
	 	
	 	<br><br>
    
        <table width="100%">
            <tr><td colspan="2">주문자정보 </td></tr>
            <tr><td width="10%">이름 </td><td><input type="text" name="email"> </td></tr>
            <tr><td>이메일</td> <td><input type="text" name="email"> </td></tr>
            <tr><td>연락처 </td> <td><input type="text" name="email"> </td></tr>
        </table>
        <br><br><Br>
        <table width="100%">
            <tr><td colspan="2">배송정보 </td></tr>
            <tr><td width="10%">이름 </td> <td><input type="text" name="email"> </td></tr>
            <tr><td>연락처 </td> <td><input type="text" name="email"> </td></tr>
            <tr><td>주소 </td> <td><input type="text" name="email"> </td></tr>
            <tr><td>주문메세지 </td> <td><textarea></textarea></td></tr>
        </table>

        <table>
            <tr>
                <td width="10%">최종결제금액</td>
                <td><p class="pay price_left">  <%=cong %> won</p></td>
            </tr>
        </table>
    
    
            <div class="btn">
                <div><a href="/pay">결제하기</a></div>
                <div><a href="/payCancel">주문취소</a></div>
            </div>
    </div>

</body>
</html>