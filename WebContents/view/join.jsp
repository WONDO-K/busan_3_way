<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="js/check.js"></script>
<script type="text/javascript" src="js/joincheck.js"></script>
<title>Insert title here</title>
<link rel="stylesheet" href="/css/header.css" />
<link rel="stylesheet" href="/css/join.css" />
<script>
</script>
</head>
<body>

<!-- header 목록 -->
<%@ include file="/include/startbar.jsp" %>

<form action="/joininsert" name="joinform"  method="POST" >
<div class="join_main">
  <div class="join1">
    <div class="join_title">회원가입</div>
    <div>
      <label class="join_input">아이디</label>
        <input type="text" id="join_id" name="join_id" />
        <input type="button" value="중복확인" id="id_check" onclick="return idCheck()" style="width: 70px;"/>
        <div class="check_font" id="id_check_font"></div><br>
      <label class="join_input">비밀번호</label>
        <input type="text" id="join_pw" name="join_pw" />
        <span class="pw-lock"></span><br><br>
      <label class="join_input">비밀번호 확인</label>
        <input type="text" id="join_pwc" />
        <span class="pwc-lock"></span>
    </div>
  </div>
  <div class="line">-----------------------------------------------------</div>
  <div class="join2">
    <div>
      <label class="join_input">이름</label>
        <input type="text" id="join_name" name="join_name" /><br><br>
      <label class="join_input">생년월일</label>
        <input type="text" id="join_birth" name="join_birth" /><br><br>
      <label class="join_input">닉네임</label>
        <input type="text" id="join_nickname" name="join_nickname" />
        <input type="button" value="중복확인" id="nickname_check" onclick="return nickCheck()" style="width: 70px;"/>
        <div class="check_font" id="nickname_check_font"></div><br>
    </div>
  </div>
  <div class="line">-----------------------------------------------------</div>
  <div class="join3">
    <label class="join_input">이메일</label>
      <input type="text" id="join_email" name="join_email" />
      <input type="button" value="중복확인" id="email_check" onclick="return emailCheck()" style="width: 70px;"/>
      <div class="check_font" id="email_check_font"></div><br>
    <label class="join_input">전화번호</label>
      <input type="text" id="join_tel" name="join_tel" /><br><br>
    <label class="join_input">주소</label>
      <input type="text" id="join_address" name="join_address" /><br><br>
  </div>
  <div class="join_btn">
    <input type="submit" id="join_button" value="가입완료" />
  </div>
</div>
</form> 
</body>
</html>