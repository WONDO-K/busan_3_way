<%@page import="dao.MemberDao"%>
<%@page import="vo.MemberVo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String member_id = (String) request.getAttribute("member_id");
    System.out.println("Q&a Factory에서 받아온 id : " + member_id);
    MemberDao memberDao = new MemberDao();
    
    Integer nowPage = (Integer)request.getAttribute("page");
    Integer maxPage = (Integer)request.getAttribute("maxPage");
    Integer startPage = (Integer) request.getAttribute("startPage");
    Integer endPage = (Integer) request.getAttribute("endPage");
    Integer listCount = (Integer) request.getAttribute("listCount");
    
    ArrayList<MemberVo> memberList = new ArrayList<>();
    memberList = (ArrayList<MemberVo>)request.getAttribute("memberList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel ="stylesheet" href="/css/gongi.css" />
<style>
</style>
</head>
<body>

<!-- login_header 목록 -->
<%@ include file="/include/loginbar.jsp" %>

<main>
  <h2>회원관리</h2>
    <table>
      <col width="100px" />
	  <col width="100px"/>
	  <col width="100px"/>
	  <col width="100px"/>
	  <col width="100px"/>
	  <col width="100px"/>
	  <col width="100px"/>
	  <col width="100px"/>
      <tr>
        <td>아이디</td>
        <td>이름</td>
        <td>닉네임</td>
        <td>이메일</td>
        <td>주소</td>
        <td>전화번호</td>
        <td>가입날짜</td>
        <td>레벨</td>
      </tr>
<%
      for(int i = 0; i<memberList.size(); i++){
    	  MemberVo memberVo = memberList.get(i);
%>
      <tr>
	    <td><%= memberList.get(i).getMember_id() %></td>
		<td><%= memberList.get(i).getMember_name() %></td>
		<td><%= memberList.get(i).getMember_nick_name() %></td>
		<td><%= memberList.get(i).getMember_email() %></td>
		<td><%= memberList.get(i).getMember_addr() %></td>
		<td><%= memberList.get(i).getMember_tel() %></td>
		<td><%= memberList.get(i).getMember_joindate() %></td>
		<td><%= memberList.get(i).getMember_member_level() %></td>
	  </tr>
<%
	}
%>	
      <tr align="center">
	    <td colspan="8">
		  <%if(nowPage <= 1) { %>
		    [이전]&nbsp;
			  <%} else { %>
				<a href="/busanway?cmd=USERSLIST&member_id=${ loginUser.member_name }&page=<%=nowPage - 1 %>">[이전]</a>&nbsp;
				<%} %>
				
				<%for(int i = startPage; i <= endPage; i++) { %>
				  <%if(i == nowPage) { %>
					[<%=i %>]&nbsp;
					<%} else { %>
					  <a href="/busanway?cmd=USERSLIST&member_id=${ loginUser.member_name }&page=<%=i %>">[<%=i %>]</a>&nbsp;
				  <%} %>
				<%} %>
				
				<%if(nowPage >= maxPage) { %>
				  [다음]&nbsp;
				<%} else { %>
				  <a href="/busanway?cmd=USERSLIST&member_id=${ loginUser.member_name }&page=<%=nowPage + 1 %>">[다음]</a>&nbsp;
		   	<%} %>
		  </td>
		</tr>
		<tr>
			<td colspan="8" align="right">
			<%-- 	<input type="button" onclick="location.href='/user/inqnauser.jsp?member_id=${ loginUser.member_id }'" value="글쓰기"/> --%>
			</td>
		</tr>
    </table>
</main>
</body>
</html>