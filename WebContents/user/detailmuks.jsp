<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>    
<%@page import="api.dao.StoreDao" %>    
<%@page import="api.vo.StoreVo" %>        
<%
	String store_id = (String) request.getAttribute("store_id");
    String member_id = (String) request.getAttribute("member_id");
    System.out.println("store: " + member_id);
    
    
    StoreVo storeVo = (StoreVo) request.getAttribute("storeVo");
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
   <input type="text" value="<%=storeVo.getStore_name() %>" /><br> <!-- 가게이름 -->
   </div>
   <div>
   <div class="img">
     <input type="image" src="<%=storeVo.getStore_img() %>" /><!-- 음식사진 -->
     <div class="img2">
     <input type="text" value="<%=storeVo.getStore_ex() %>" /><br><!-- 부제 -->
     <input type="text" value="<%=storeVo.getStore_addr() %>" /><br><!-- 주소 -->
     <input type="text" value="<%=storeVo.getStore_menu() %>" /><br><!-- 메뉴 -->
     <input type="text" value="<%=storeVo.getStore_tel() %>" /><br><!-- 부제 -->
     <input type="text" value="<%=storeVo.getStore_time() %>" /><br><!-- 부제 -->
     <input type="text" value="<%=storeVo.getStore_site() %>" /><br><!-- 부제 -->
     </div>
   </div> 
   </div>
   <div class="store">
    
   </div>
   <div class="ex">
     <textarea rows="20" cols="50" ><%= storeVo.getStore_cont() %></textarea>
     <div>
     <input type="button" value="리뷰" style="width: 50px; height: 30px;"/>
     </div>
   </div>
  </div>
 </div>
</body>
</html>