<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/start.css" />
<link rel="stylesheet" href="css/header.css" />
<script type="text/javascript" src="js/start.js"></script>
<style></style>
<script>
</script>
</head>
<body>

<!-- header 목록 -->
<%@ include file="/include/startbar.jsp" %>

<div class="nav">
  <div class="nav_title">부산으로 떠나는 여행</div>
  <div class="nav_imgs">
    <div class="nav_img">
      <img src="img/놀거리.jpeg" width="400px;" height="400px;" /><br>
      <div class="nav_text">놀거리</div>
    </div>
    <div class="nav_img">
      <img src="img/먹거리.jpeg" width="400px;" height="400px;" /><br>
      <div class="nav_text">먹거리</div>
    </div>
    <div class="nav_img">
      <img src="img/볼거리.jpeg" width="400px;" height="400px;" /><br>
      <div class="nav_text">볼거리</div>
    </div>
  </div>
</div>
<form action="/logincheck" name="loginform" method="POST" onsubmit="return loginCheck()">
<div class="login">
  <div class="login_title">로그인</div>
  <div class="login_id">
    <label class="login_input">아이디:</label>
      <input type="text" id="input_id" name="input_id" placeholder="ID" />
  </div>
  <div class="login_pw">
    <label class="login_input">비밀번호:</label>
      <input type="password" id="input_pwd" name="input_pwd" placeholder="password" />
  </div>
  <div class="login_btn">
    <input type="submit"  id="login_button" value="로그인" />
    <input type="button"  id="login_joinbutton" value="회원가입" onclick="location.href='/busanway?cmd=JOIN'" />
  </div>
  <!-- <div class="id_keep">
    <span class="stay-check">
	  <label for="stay-checkbox" id="stay-text">Remember id</label>
	  <label for="stay-checkbox">
	  <input type="checkbox" id="stay-checkbox" name="stay-checkbox" />
	  Remember ID</label><br>
	</span> -->
	<span style="color: red;">${message}</span>
</div>
</form>
</body>
</html>