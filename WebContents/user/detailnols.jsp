<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="api.dao.FestivalDao" %>    
<%@page import="api.vo.FestivalVo" %>       
<%
	String festival_id = (String) request.getAttribute("festival_id");
    String member_id = (String) request.getAttribute("member_id");
    System.out.println("festival: " + member_id);
 
   	FestivalVo festivalVo = (FestivalVo) request.getAttribute("festivalVo");
   	
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
   <input type="text" value="<%= festivalVo.getFestival_place() %>" /><br>
   </div>
   <div>
   <div class="img">
     <input type="image" src="<%= festivalVo.getFestival_img() %>" />
     <div class="img2">
     <input type="text" value="<%= festivalVo.getFestival_title() %>" /><br> <!-- 주제목 -->
     <input type="text" value="<%= festivalVo.getFestival_subtitle() %>" /><br> <!-- 부제목 -->
     <input type="text" value="<%= festivalVo.getFestival_main_place() %>" /><br> <!-- 주요장소 -->
     <input type="text" value="<%= festivalVo.getFestival_addr1() %>" /><br> <!-- 주소 -->
     <input type="text" value="<%= festivalVo.getFestival_tel() %>" /><br> <!-- 연락처 -->
     <input type="text" value="<%= festivalVo.getFestival_site() %>" /><br> <!-- 홈페이지 -->
     <input type="text" value="<%= festivalVo.getFestival_trfc_info() %>" /><br> <!-- 주제목 -->
     <input type="text" value="<%= festivalVo.getFestival_usageday() %>" /><br><!-- 운영기간 -->
     <input type="text" value="<%= festivalVo.getFestival_time() %>" /><br><!-- 이용요일 및 시간 -->
     <input type="text" value="<%= festivalVo.getFestival_usage_amount() %>" /><br><!-- 이용요금 -->
     <input type="text" value="<%= festivalVo.getFestival_convenient() %>" /><!-- 편의시설 -->
     </div>
   </div> 
   </div>
   <div class="store">
    
   </div>
   <div class="ex">
     <textarea rows="20" cols="50" ><%= festivalVo.getFestival_cont() %></textarea>
     <div>
     <input type="button" value="리뷰" style="width: 50px; height: 30px;"/>
     </div>
   </div>
  </div>
 </div>
</body>
</html>