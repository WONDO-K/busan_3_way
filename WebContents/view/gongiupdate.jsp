<%@page import="vo.GongiVo"%>
<%@page import="dao.GongiDao"%>
<%@ page import="vo.QnaVo"%>
<%@ page import="dao.QnaDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int notice_idx = Integer.parseInt(request.getParameter("notice_idx"));
	System.out.print("상세정보에서 넘어온 글번호 : " + notice_idx);
    String member_id = (String) request.getParameter("member_id");
    System.out.print("상세정보에서 넘어온 로그인 id : " + member_id);
    
    GongiDao gongiDao = new GongiDao();
    GongiVo gongivo = gongiDao.getGongiDetail(notice_idx);   
    
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
  <h1>공지사항 수정</h1>
  <form action="/busanway?cmd=GONGIUPDATEA&member_id=${ loginUser.member_id }&notice_idx=<%=gongivo.getNotice_idx() %>" method="POST">
  <input type="hidden" name="n_idx" value="<%=gongivo.getNotice_idx()%>"/>
	<table border="1">
		<tr>
			<th>제목</th>
			<td><input type="text" name="n_jtile" value="<%=gongivo.getNotice_title() %>"/></td>
		</tr>
		<tr>
			<th>조회수</th>
			<td readonly="readonly"><%=gongivo.getNotice_readcount() %></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td readonly="readonly"><%=gongivo.getNotice_member_id() %></td>
		</tr>
		<tr>
			<th>내용</th>
			<td>
				<textarea cols="60" rows="30" name="ncont"><%=gongivo.getNotice_cont() %></textarea>
			</td>
		</tr>
	</table>
	<input type="submit" id="back" value="수정완료" style="margin: 0 0 0 340px;"/>
	<input type="button" id="back" value="취소" onclick="location.href='/busanway?cmd=GONGI&member_id=${ loginUser.member_id }'" style="margin: 0 0 0 438px;"/>
  </form>
</div>
</main>
</body>
</html>