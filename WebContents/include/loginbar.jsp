<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/header_login.css" />
</head>
<body>
<div class="header">
  <div class="header_title">
    <a href="/user/userlogin.jsp">Busan 3 way</a>
  </div>
  <div class="loginform">
  	${ loginUser.member_name }님!
  	<form action="/logoutservlet" method="get">
	  <div class="btn1">
	    <input type="submit" value="로그아웃">
		<input type="button" value="마이페이지" onclick="location.href='/busanway?cmd=GETMEMBER&member_id=${ loginUser.member_id }'"> <!-- mypageuser.jsp  -->
	  </div>
	</form>
  </div>
  <div class="header_menus">
    <a href="/busanway?cmd=GONGI&member_id=${ loginUser.member_id }" >공지사항</a>
    <a href="/busanway?cmd=ATTRACTIONLIST&member_id=${ loginUser.member_id }">볼거리</a>
    <a href="/busanway?cmd=FESTIVALLIST&member_id=${ loginUser.member_id }" >놀거리</a>
    <a href="/busanway?cmd=STORELIST&member_id=${ loginUser.member_id }" >먹거리</a>
    <a href="/busanway?cmd=QNA&member_id=${ loginUser.member_id }" >Q & A</a>
  </div>
</div>
</body>
</html>