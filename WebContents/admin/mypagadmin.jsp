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
<link rel="stylesheet"  href="/css/mypage.css" />
<link rel="stylesheet"  href="/css/sidebar.css" />
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
	<input type="submit" value="마이페이지">
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
 <div id="my">
   <div id="my1">
 	<h1>마이페이지</h1>
 	<span style="line-height:300%">
 	<lebel class="ss">이름</lebel>
 	<input type="text" value="수정불가"><br>
 	<lebel class="ss">썅년월일</lebel>
 	<input type="text" value="수정불가"><br>
 	<lebel class="ss">아이디</lebel>
 	<input type="text" value="수정불가"><br>
 	<lebel class="ss">닉네임</lebel>
 	<input type="text" value="수정가능"><br>
 	<lebel class="ss">비밀번호</lebel>
 	<input type="text" value="수정가능"><br>
 	<lebel class="ss">확인</lebel>
 	<input type="text" value="수정가능"><br>
 	<lebel class="ss">이메일</lebel>
 	<input type="text" value="수정가능"><br>
 	<lebel class="ss">전화번호</lebel>
 	<input type="text" value="수정가능"><br>
 	<lebel class="ss">주소</lebel>
 	<input type="text" value="수정가능"><br>
 	<lebel class="ss">가입일자</lebel>
 	<input type="text" value="수정불가"><br>
 	<input type="button" value="수정완료" >
 	</span>
 </div>
 <div id="my2">
 	<div id="my3">
      <h1>리뷰</h1>
      <input type="text" value="ㅈㄴ 맛없네요 하하 -젠탑"><br>
      <input type="text" value="그닥... -하이"><br>
      <input type="text" value="거진 내얼굴같은 맛..-김남욱"><br>
 	</div>
    <div id="my4">
      <h1>즐겨찾기한 장소</h1>
      <input type="text" value="ㅈㄴ 맛없네요 하하 -젠탑"><br>
      <input type="text" value="그닥... -하이"><br>
      <input type="text" value="거진 내얼굴같은 맛..-김남욱"><br>
 	</div>
</div>

</div>

</body>
</html>