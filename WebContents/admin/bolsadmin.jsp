<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
    String admin = request.getParameter("admin");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"  href="/css/sidebar.css" />
<link rel="stylesheet"  href="/css/bolmuknols.css" />
<style></style>
<script>
</script>
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
	<input type="submit" value="마이페이지"> <!-- mypageadmin.jsp  -->
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
<div class="allpanel">
  <div class="panel1">
    <h2>볼거리</h2>
    <div class="box">
      <label class="imgbox">
        <a href="/admin/detailadmin.jsp"><input type="image" src="/img/우곤쓰.jpg" /></a>
      </label>
      <br>
      <input type="text" value="평점" />
    </div>
    <div class="box">
      <label class="imgbox">
        <a href="/admin/detailadmin.jsp"><input type="image" src="/img/우곤쓰.jpg" /></a>
      </label>
      <br>
      <input type="text" value="평점" />
    </div>
    <div class="box">
      <label class="imgbox">
        <a href="/admin/detailadmin.jsp"><input type="image" src="/img/우곤쓰.jpg" /></a>
      </label>
      <br>
      <input type="text" value="평점" />
    </div>
    <div class="box">
      <label class="imgbox">
        <a href="/admin/detailadmin.jsp"><input type="image" src="/img/우곤쓰.jpg" /></a>
      </label>
      <br>
      <input type="text" value="평점" />
    </div>
    <div class="box">
      <label class="imgbox">
        <a href="/admin/detailadmin.jsp"><input type="image" src="/img/우곤쓰.jpg" /></a>
      </label>
      <br>
      <input type="text" value="평점" />
    </div>
    <div class="box">
      <label class="imgbox">
        <a href="/admin/detailadmin.jsp"><input type="image" src="/img/우곤쓰.jpg" /></a>
      </label>
      <br>
      <input type="text" value="평점" />
    </div>
    <div class="box">
      <label class="imgbox">
        <a href="/admin/detailadmin.jsp"><input type="image" src="/img/우곤쓰.jpg" /></a>
      </label>
      <br>
      <input type="text" value="평점" />
    </div>
    <div class="box">
      <label class="imgbox">
        <a href="/admin/detailadmin.jsp"><input type="image" src="/img/우곤쓰.jpg" /></a>
      </label>
      <br>
      <input type="text" value="평점" />
    </div>
    <div class="box">
      <label class="imgbox">
        <a href="/admin/detailadmin.jsp"><input type="image" src="/img/우곤쓰.jpg" /></a>
      </label>
      <br>
      <input type="text" value="평점" />
    </div>
    <div class="box">
      <label class="imgbox">
        <a href="/admin/detailadmin.jsp"><input type="image" src="/img/우곤쓰.jpg" /></a>
      </label>
      <br>
      <input type="text" value="평점" />
    </div>
  </div>
  <div class="panel2">
    <div class="search">
      <input type="text" value="검색어" />
    </div>
    <div class="search_btn">
      <input type="button" value="검색" />
    </div>
    <div class="check_box1">
      <label>
        <input type="checkbox" value="" />강서구
      </label>
      <br>
      <label>
        <input type="checkbox" value="" />금정구
      </label>
      <br>
      <label>
        <input type="checkbox" value="" />기장군
      </label>
      <br>
      <label>
        <input type="checkbox" value="" />사상구
      </label>
      <br>
      <label>
        <input type="checkbox" value="" />사하구
      </label>
      <br>
      <label>
        <input type="checkbox" value="" />서구
      </label>
      <br>
      <label>
        <input type="checkbox" value="" />남구
      </label>
      <br>
      <label>
        <input type="checkbox" value="" />수영구
      </label>
    </div>
    <div class="check_box2">
      <label>
        <input type="checkbox" value="" />동구
      </label>
      <br>
      <label>
        <input type="checkbox" value="" />연제구
      </label>
      <br>
      <label>
        <input type="checkbox" value="" />동래구
      </label>
      <br>
      <label>
        <input type="checkbox" value="" />부산진구
      </label>
      <br>
      <label>
        <input type="checkbox" value="" />중구
      </label>
      <br>
      <label>
        <input type="checkbox" value="" />북구
      </label>
      <br>
      <label>
        <input type="checkbox" value="" />해운대구
      </label>
      <br>
      <label>
        <input type="checkbox" value="" />영도구
      </label>
    </div>
  </div>
  <div class="panel3">
    <input type="text" value="내용" />
  </div> 
</div>
</body>
</html>