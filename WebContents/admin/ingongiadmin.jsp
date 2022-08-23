<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
    String admin   = request.getParameter("admin");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"  href="/css/sidebar.css" />
<link rel="stylesheet"  href="/css/in.css" />
</head>
<body>
<div class="sidebar">
  <img src="https://image.shutterstock.com/image-vector/way-vector-icon-illustration-design-600w-1577617420.jpg" 
   style="width: 30px; height: 30px;">
    <a href="/admin/adminlogin.jsp">부산 삼거리</a>
  <img src="https://image.shutterstock.com/image-vector/way-vector-icon-illustration-design-600w-1577617420.jpg" 
   style="width: 30px; height: 30px;"><br>
     <%=admin %>admin님!<br>
  <div class="btn1">
    <input type="submit" value="로그아웃">
	<input type="submit" value="마이페이지"> <!-- mypagadmin.jsp  -->
  </div>
  <div class="menu">
     <a href="/admin/gongiadmin.jsp" >공지사항</a><br>
    <a href="/admin/bolsadmin.jsp" >볼거리</a><br>
    <a href="/admin/nolsadmin.jsp" >놀거리</a><br>
    <a href="/admin/muksadmin.jsp" >먹거리</a><br>
    <a href="/admin/qnaadmin.jsp" >Q & A</a><br>
  </div>
  <div class="location">
   <h3 style="color: black">지역날씨</h3><br>
   <b>api</b>
  </div>
</div>
 <main>
 	<h2>공지사항</h2>
 	<div id="in">
	<span style="line-height:300%">
 		<lebel>제목</lebel>
 		<input type="text" value="" size=50><br> 
 		<lebel>작성자</lebel>
 		<input type="text" value="<%=admin %>" size=20><br> 
 		<input type="text" value="내용을 입력해주세요" 
 		style="width:1000px; height:500px;"><br>
 		<input id="btn" type="submit" value="작성완료" 
 		style="float:right; margin:0 29% 0 0;">
 	</span>
 	</div>
 </main>
</body>
</html>







