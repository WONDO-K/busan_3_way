<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String attraction_id = (String) request.getParameter("attraction_id");
    String member_id     = (String) request.getParameter("member_id");
    System.out.println("inreviewBuser : " + attraction_id);    // 여기까지 출력 
    System.out.println("inreviewBuser : " + member_id); 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"  href="/css/inreview.css" />
</head>
<body>

<!-- login_header 목록 -->
<%@ include file="/include/loginbar.jsp" %>

 <main>
 	<h2>리뷰쓰기</h2>
 	<form action="/busanway?cmd=REVIEWINSERT&attraction_id=<%=attraction_id %>&member_id=${ loginUser.member_id }" method="post">
	
		<table border="1">
			 <tr>
			 	<th>작성자</th>
			 	<td><%=member_id %></td> <!-- name=key, 값=value -->
			 </tr>
			 <tr>
			 	<th>내용</th>
			 	<td><input type="text" name="rtitle"/></td>
			 </tr>
			 <tr>
			 	<th>평점</th>
			 	<td>
			 	  <input type="radio" name="rating" value="1" checked/>좋아요
   			      <input type="radio" name="rating" value="2"/> 싫어요
   			    </td>
			 </tr>
			 <tr>
			 	<td colspan="2" align="right">
			 		<input type="button" value="취소" onclick="location.href='/busanway?cmd=REVIEW&attraction_id=<%=attraction_id %>'"/>
			 		<input type="submit" value="작성"/>
			 	</td>
			 </tr>	
		</table>
	</form>
 </main>
</body>
</html>







