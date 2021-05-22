<%@page import="java.util.ArrayList"%>
<%@page import="faq.model.vo.Faq"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
 	ArrayList<Faq> list = (ArrayList<Faq>)request.getAttribute("list");
 	
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
<script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=axdor4twe0&submodules=geocoder"></script>

<style>
	
	     .faq-wrap {
        width: 100%;
        height: 200px;
        margin: 10px auto;
       background-color : rgba(182, 215, 168, 0.54);
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
	  
       .que>li{
            border-top: 1px solid #bcbcbc;
            border-bottom: 1px solid transparent;
            list-style: none;
            width: 80%;
             margin:0 auto;
        }
        li>a{
            text-decoration: none;
            color: black;
            margin-left: 5px;
        }
       
        .a{
            line-height: 40px;
            
         
        }
        .bbb{
            height: 100px;
            background-color:rgba(241, 235, 235, 0.904);
            display: none;
            background-color: 
        }
       
        li:hover>b{
            display: block;
        }
        #map{
        margin:0 auto;}
    
    	a{
    	text-align: center;}
    	.bolder{
 	font-weight: bolder;
 	font-size: 15px;}
 	p>a{
 	margin : 20px;
 	color:black;}
   
</style>
  <script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.js"></script>
     <script>
           $(function(){
            $(".a").append("<span class='more'></span>"); //+버튼 추가 ul태그를 가진 태그 전의 a태그에만 +가 있어야댐
            $(".more").click(function(event){  //more를 클릭했을때 + 돌리고 메뉴 보여줌
                $(this).parent().next().slideToggle();     //more기준으로 부모의 형제임
                
                event.stopPropagation();//버블링제거
            });
            $(".more").parent().click(function(){ //more sapn을 가진 a태그만 클릭시
                $(this).children().last().click();
            });
        });
     </script>
 

</head>
<body>
	
	
		<%@include file="/WEB-INF/views/common/header.jsp" %>
		<div class="container">
			  <div class="faq-wrap">
        		<div class="faq-image"></div>
        	  	<div class="faq-text">
        	  	<p>
        	  	<a href="/noticeList?reqPage=1&noticeCom=2">공지사항</a>
            	<a class="bolder">자주하는 질문, 확인해보세요 :)</a>
            	<a href="/careList?reqPage=1">분양후기</a>
             	</p>
             	</div>
             	</div>
    
			
			<%for(Faq faq :list) {%>
				<ul class="que">
					<li class="a">Q.
					<%=faq.getFaqTitle() %>
					</li>
					<li class="bbb">A.
					<%=faq.getFaqContent() %>
					
					<%--<%if(emp != null){ %>
        	 	<p class="del"><a href="/faqDelete?faqNo=<%=faq.getFaqNo() %>">삭제하기</a> </p>
      			<%} %>
				 --%>
					
					
					<p class="del"><a href="/faqDelete?faqNo=<%=faq.getFaqNo() %>">삭제하기</a> </p>
					</li>
				</ul>
				<%} %>
				  
				<div id="map" style="width:600px; height:300px;"></div>
				
				
				<%--<%if(emp != null){ %>
        	 	<div><a class="btn btn btn-default" href="/faqWriteFrm">질문등록</a></div>
      			<%} %>
				 --%>
				
				
				
				
				<a class="btn btn btn-default" href="/faqWriteFrm">질문등록</a>
		</div>
	</div>
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
	
<script>
			//네이버지도 사용
			window.onload=function(){
				//아무 설정없이 지도객체를 만드는 경우 서울시청이 지도의 중심
				var map = new naver.maps.Map('map',{
					center : new naver.maps.LatLng(37.533807,126.896772),
					zoom : 17,
					zoomControl:true,
					zoomControlOptions : {
						position : naver.maps.Position.TOP_RIGHT,
						style :  naver.maps.ZoomControlStyle.SMALL
					}
				});
				var marker = new naver.maps.Marker({
					position : new naver.maps.LatLng(37.533807,126.896772),
					map : map
				});
				var contentString = [
					'<div class="iw_inner">',
					'	<h3>Pemily</h3>',
					'	<p>서울특별시 영등포구 양평동 이레빌딩 19F,20F</p>',
					'</div>'
				].join("");
				var infoWindow = new naver.maps.InfoWindow();
				naver.maps.Event.addListener(marker,"click",function(e){
					if(infoWindow.getMap()){
						infoWindow.close();	
					}else{
						infoWindow = new naver.maps.InfoWindow({
							content : contentString
						});
						infoWindow.open(map,marker);
						}
					});
					naver.maps.Event.addListener(map,"click",function(e){
						marker.setPosition(e.coord);	//클릭한 곳으로 마커 위치를 이동
						if(infoWindow.getMap()){
							infoWindow.close();
						}
						
						//reverseGeocoder를 이용해서 위/경도값을 주소로 변환
						naver.maps.Service.reverseGeocode({
							location : new naver.maps.LatLng(e.coord.lat(),e.coord.lng()),
						},function(status,response){
							if(status != naver.maps.Service.Status.OK){
								return alert("주소를 찾을 수 없습니다.");
							}
							var result = response.result;
							items = result.items;
							var address = items[1].address;
							contentString = [
								'<div class=iw_inner">',
								'<p>'+address+'</p>',
								'</div>'
							].join("");
						});
					});
				
				
				
				
				}
</script>
</body>
</html>