<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="api.dao.AttractionDao" %>    
<%@page import="api.vo.AttractionVo" %>       
<%
	String attraction_id = (String) request.getAttribute("attraction_id");
    System.out.println("attraction_id: " + attraction_id);
    String member_id = (String) request.getAttribute("member_id");
    System.out.println("attraction: " + member_id);
 
   	AttractionVo attractionVo = (AttractionVo) request.getAttribute("attractionVo");

%>  
     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"  href="/css/switch.css" />
<link rel="stylesheet"  href="/css/infom.css" />
<style></style>
<script>
function isEmpty(value){

    if(value == null || value.length === 0) {

           return "";

     } else{

            return value;

     }

}
</script>
</head>
<body>

<!-- login_header 목록 -->
<%@ include file="/include/loginbar.jsp" %>

 <div class="allpanel">
  <div class="infom">
   <div class="wrapper">
    <input type="checkbox" id="switch">
    <label for="switch" class="switch_label">
      <span class="onf_btn"></span>
    </label><br>
   <input type="text" value="<%=attractionVo.getAttraction_place() %>" /><br>
   </div>
   <div>
   <div class="img">
     <input type="image" src="<%=attractionVo.getAttraction_img() %>" />
     <div class="img2">
     <input type="text" value="<%=attractionVo.getAttraction_place() %>" /><br> 			<!-- 장소 -->
     <input type="text" value="<%=attractionVo.getAttraction_title() %>" /><br>				<!-- 주제 -->
     <input type="text" value="<%=attractionVo.getAttraction_subtitle() %>" /><br>			<!-- 부제 -->
     <input type="text" value="<%=attractionVo.getAttraction_addr1() %>" /><br>				<!-- 주소 -->
     <input type="text" value="<%=attractionVo.getAttraction_tel() %>" /><br>				<!-- 전화번호 -->
     <input type="text" value="<%=attractionVo.getAttraction_site() %>" /><br>				<!-- 홈페이지 -->
     <input type="text" value="<%=attractionVo.getAttraction_trfc_info() %>" /><br> 		<!-- 교통정보 -->
     <input type="text" value="<%=attractionVo.getAttraction_usageday() %>" /><br>			<!-- 운영기간 -->
     <input type="text" value="<%=attractionVo.getAttraction_hldy_info() %>" /><br>			<!-- 휴일정보 -->
     <input type="text" value="<%=attractionVo.getAttraction_time() %>" /><br>				<!-- 운영시간 -->
     <input type="text" value="<%=attractionVo.getAttraction_usage_amount() %>" /><br>		<!-- 이용요금 -->
     <input type="text" value="<%=attractionVo.getAttraction_convenient() %>" /><br>		<!-- 편의시설 -->
     </div>
   </div> 
   </div>
   <div class="store">
    
   </div>
   <div class="ex">
      <textarea rows="20" cols="50" ><%= attractionVo.getAttraction_cont1()+attractionVo.getAttraction_cont2()+attractionVo.getAttraction_cont3()+attractionVo.getAttraction_cont4() %></textarea>
     <div>
     <input type="button" value="리뷰" onclick="location.href='/busanway?cmd=REVIEW&attraction_id=<%=attractionVo.getAttraction_id() %>'" style="width: 50px; height: 30px;"/>
     </div>
   </div>
  </div>
 </div>
</body>
</html>