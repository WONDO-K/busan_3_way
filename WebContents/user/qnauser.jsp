<%@page import="java.util.ArrayList"%>
<%@ page import="dao.QnaDao"%>
<%@ page import="vo.QnaVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String member_id = (String) request.getAttribute("member_id");
    System.out.println("Q&a Factory에서 받아온 id : " + member_id);
    QnaDao qnaDao = new QnaDao();
    
    Integer nowPage = (Integer)request.getAttribute("page");
    Integer maxPage = (Integer)request.getAttribute("maxPage");
    Integer startPage = (Integer) request.getAttribute("startPage");
    Integer endPage = (Integer) request.getAttribute("endPage");
    Integer listCount = (Integer) request.getAttribute("listCount");
    
    ArrayList<QnaVo> qnaList = new ArrayList<>();
    qnaList = (ArrayList<QnaVo>)request.getAttribute("qnaList");
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
  <h2>Q & A</h2>
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
      for(int i = 0; i<qnaList.size(); i++){
    	  QnaVo qnaVo = qnaList.get(i);
%>
      <tr>
	    <td><%= qnaList.get(i).getQna_idx() %></td>
		<td><a href="/busanway?cmd=QNAVIEW&member_id=<%=member_id %>&qna_idx=<%=qnaList.get(i).getQna_idx() %>"><%= qnaList.get(i).getQna_title() %></a></td>
		<td><%= qnaList.get(i).getQna_member_id() %></td>
		<td><%= qnaList.get(i).getQna_regdate() %></td>
		<td><%= qnaList.get(i).getQna_readcount() %></td>
	  </tr>
<%
	}
%>	
      <tr align="center">
	    <td colspan="5">
		  <%if(nowPage <= 1) { %>
		    [이전]&nbsp;
			  <%} else { %>
				<a href="/busanway?cmd=QNA&member_id=${ loginUser.member_id }&page=<%=nowPage - 1 %>">[이전]</a>&nbsp;
				<%} %>
				
				<%for(int i = startPage; i <= endPage; i++) { %>
				  <%if(i == nowPage) { %>
					[<%=i %>]&nbsp;
					<%} else { %>
					  <a href="/busanway?cmd=QNA&member_id=${ loginUser.member_id }&page=<%=i %>">[<%=i %>]</a>&nbsp;
				  <%} %>
				<%} %>
				
				<%if(nowPage >= maxPage) { %>
				  [다음]&nbsp;
				<%} else { %>
				  <a href="/busanway?cmd=QNA&member_id=${ loginUser.member_id }&page=<%=nowPage + 1 %>">[다음]</a>&nbsp;
		   	<%} %>
		  </td>
		</tr>
		<tr>
			<td colspan="5" align="right">
				<input type="button" onclick="location.href='/user/inqnauser.jsp?member_id=${ loginUser.member_id }'" value="글쓰기"/>
			</td>
		</tr>
    </table>
</main>
</body>
</html>