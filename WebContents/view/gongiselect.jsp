<%@ page import="vo.GongiVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    int notice_idx = Integer.parseInt(request.getParameter("notice_idx"));
    System.out.print("조회된 Factory에서 넘어온 글번호 : " + notice_idx);
    String member_id = (String) request.getAttribute("member_id");
    System.out.print("조회된 Factory에서 넘어온 글 id : " + member_id);
    GongiVo gongiVo = (GongiVo) request.getAttribute("gongiVo");
    
    String n_cont = gongiVo.getNotice_cont();
    String replaceCont = n_cont.replaceAll("\r\n", "<br/>");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"  href="/css/qna.css" />
<style>
</style>
</head>
<body>

<!-- login_header 목록 -->
<%@ include file="/include/loginbar.jsp" %>

<main>
<div id="tab">
  <h1>Q & A 상세정보</h1>
  
	<table border="1">
		<tr>
			<th>제목</th>
			<td><%=gongiVo.getNotice_title() %></td>
		</tr>
		<tr>
			<th>조회수</th>
			<td><%=gongiVo.getNotice_readcount() %></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td><%=gongiVo.getNotice_member_id() %></td>
		</tr>
		<tr>
			<th>내용</th>
			<td>
				<textarea cols="60" rows="30" readonly="readonly"><%=gongiVo.getNotice_cont() %></textarea>
			</td>
		</tr>
	</table>
	<input type="button" id="back" value="목록으로" onclick="location.href='/busanway?cmd=GONGI&member_id=${ loginUser.member_id }'" style="margin: 0 0 0 438px;"/>
  </div>
</main>
</body>
</html>