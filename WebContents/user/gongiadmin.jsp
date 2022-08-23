<%@page import="java.util.ArrayList"%>
<%@ page import="dao.GongiDao"%>
<%@ page import="vo.GongiVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String member_id = (String) request.getAttribute("member_id");
    System.out.println("공지 리스트 servlet에서 받아온 id : " + member_id);
    GongiDao gongiDao = new GongiDao();
    
    Integer nowPage = (Integer)request.getAttribute("page");
    Integer maxPage = (Integer)request.getAttribute("maxPage");
    Integer startPage = (Integer) request.getAttribute("startPage");
    Integer endPage = (Integer) request.getAttribute("endPage");
    Integer listCount = (Integer) request.getAttribute("listCount");
    
    ArrayList<GongiVo> gongiList = new ArrayList<>();
    gongiList = (ArrayList<GongiVo>)request.getAttribute("gongiList");
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
    <h2>공지사항</h2>
    <table>
      <col width="50px" />
	  <col width="300px"/>
	  <col width="100px"/>
	  <col width="100px"/>
	  <col width="100px"/>
      <tr>
        <td>번호</td>
        <td>제목</td>
        <td>작성자</td>
        <td>날짜</td>
        <td>조회수</td>
      </tr>
<%
      for(int i = 0; i<gongiList.size(); i++){
     	  GongiVo gongiVo = gongiList.get(i);
%>
      <tr>
	    <td><%= gongiList.get(i).getNotice_idx() %></td>
		<td><a href="/busanway?cmd=GONGIVIEW&member_id=<%=member_id %>&notice_idx=<%=gongiList.get(i).getNotice_idx() %>"><%= gongiList.get(i).getNotice_title() %></a></td>
		<td><%= gongiList.get(i).getNotice_member_id() %></td>
		<td><%= gongiList.get(i).getNotice_regdate() %></td>
		<td><%= gongiList.get(i).getNotice_readcount() %></td>
	  </tr>
<%
	}
%>	
      <tr align="center">
	    <td colspan="5">
		  <%if(nowPage <= 1) { %>
		    [이전]&nbsp;
			  <%} else { %>
				<a href="/busanway?cmd=GONGI&member_id=${ loginUser.member_id }&page=<%=nowPage - 1 %>">[이전]</a>&nbsp;
				<%} %>
				
				<%for(int i = startPage; i <= endPage; i++) { %>
				  <%if(i == nowPage) { %>
					[<%=i %>]&nbsp;
					<%} else { %>
					  <a href="/busanway?cmd=GONGI&member_id=${ loginUser.member_id }&page=<%=i %>">[<%=i %>]</a>&nbsp;
				  <%} %>
				<%} %>
				
				<%if(nowPage >= maxPage) { %>
				  [다음]&nbsp;
				<%} else { %>
				  <a href="/busanway?cmd=GONGI&member_id=${ loginUser.member_id }&page=<%=nowPage + 1 %>">[다음]</a>&nbsp;
		   	<%} %>
		  </td>
		</tr>
       <tr>
			<td colspan="5" align="right">
				<input type="button" onclick="location.href='/user/ingongiadmin.jsp?member_id=${ loginUser.member_id }'" value="글쓰기"/>
			</td>
		</tr>
    </table>
  </main>
</body>
</html>