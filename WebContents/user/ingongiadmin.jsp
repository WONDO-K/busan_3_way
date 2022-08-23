<%@ page import="vo.QnaVo"%>
<%@ page import="dao.QnaDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String member_id = (String) request.getParameter("member_id");	
    System.out.println("inqnauser : " + member_id);    // 여기까지 출력 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"  href="/css/in.css" />
</head>
<body>

<!-- login_header 목록 -->
<%@ include file="/include/loginbar.jsp" %>

 <main>
 	<h2>공지 글쓰기</h2>
 	<form action="/busanway?cmd=GONGIINSERT&member_id=<%=member_id %>" method="post">
	
		<table border="1">
			 <tr>
			 	<th>작성자</th>
			 	<td><%=member_id %></td> <!-- name=key, 값=value -->
			 </tr>
			 <tr>
			 	<th>제목</th>
			 	<td><input type="text" name="gtitle"/></td>
			 </tr>
			 <tr>
			 	<th>내용</th>
			 	<td><textarea rows="10" cols="60" name="gcontent" ></textarea> </td>
			 </tr>
			 <tr>
			 	<td colspan="2" align="right">
			 		<input type="button" value="취소" onclick="location.href='/busanway?cmd=GONGI&member_id=${ loginUser.member_id }'"/>
			 		<input type="submit" value="작성"/>
			 	</td>
			 </tr>	
		</table>
	</form>
 </main>
</body>
</html>







