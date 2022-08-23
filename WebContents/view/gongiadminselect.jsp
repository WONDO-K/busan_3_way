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
  <h1>공지사항 상세정보</h1>
  <form action="/busanway?cmd=GONGIUPDATEVIEW&member_id=${ loginUser.member_id }&notice_idx=<%=gongiVo.getNotice_idx()%>" method="POST">
  <input type="hidden" name="N_idx" value="<%=gongiVo.getNotice_idx()%>"/>
	<table border="1">
		<tr>
			<th>제목</th>
			<td readonly="readonly"><%=gongiVo.getNotice_title() %></td>
		</tr>
		<tr>
			<th>조회수</th>
			<td readonly="readonly"><%=gongiVo.getNotice_readcount() %></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td readonly="readonly"><%=gongiVo.getNotice_member_id() %></td>
		</tr>
		<tr>
			<th>내용</th>
			<td>
				<textarea cols="60" rows="30" readonly="readonly"><%=gongiVo.getNotice_cont() %></textarea>
			</td>
		</tr>
	</table>
	<input type="submit" id="back" value="수정" style="margin: 0 0 0 340px;"/>
	<%-- <input type="button" id="back" value="삭제" onclick="location.href='/busanway?cmd=QNADELETE&member_id=${ loginUser.member_id }&qna_idx=<%=qnaVo.getQna_idx()%>'" /> --%>
	<input type="button" id="back" value="목록으로" onclick="location.href='/busanway?cmd=GONGI&member_id=${ loginUser.member_id }'" style="margin: 0 0 0 438px;"/> 
  </form>
  </div>
</main>
</body>
</html>