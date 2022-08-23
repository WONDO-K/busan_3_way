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
<link rel="stylesheet"  href="/css/main.css" />
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
<div id="main">
  <div id="main1">
    <input type="text" value="" style="height:30px;">
    <input type="button" value="검색">
  </div>
  <div id="main2">
    <div id="main3">
 	  <a href=""><img src ="/img/img1.png" width="300px" height="300px"></a>
 	  <h2>볼거리 평점</h2>
 	</div>
 	<div id="main4">
      <a href=""><img src ="/img/img2.png" width="300px" height="300px" ></a>
 	  <h2>놀거리 평점</h2>
 	</div>
 	<div id="main5">
	  <a href=""><img src ="/img/img3.png" width="300px" height="300px"></a>
 	  <h2>먹거리 평점</h2>
 	</div>
  </div>
  <div id="main6">
 	<h5>고객센터 : 김남묵 집</h5>
 	<h5>주소 : 부산 사상구 엄궁동 신흥동백 104동 403호</h5>
 	<h5>전화번호 : 010-9928-6198</h5>
  </div>
</div>
</body>
</html>