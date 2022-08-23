<%@page import="dao.ReviewBDao"%>
<%@page import="vo.ReviewBVo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String attraction_id = (String) request.getAttribute("attraction_id");
    System.out.println("reviewB Factory에서 받아온 id : " + attraction_id);
    ReviewBDao reviewBDao = new ReviewBDao();
    
    Integer nowPage = (Integer)request.getAttribute("page");
    Integer maxPage = (Integer)request.getAttribute("maxPage");
    Integer startPage = (Integer) request.getAttribute("startPage");
    Integer endPage = (Integer) request.getAttribute("endPage");
    Integer listCount = (Integer) request.getAttribute("listCount");
    
    ArrayList<ReviewBVo> reviewBList = new ArrayList<>();
    reviewBList = (ArrayList<ReviewBVo>)request.getAttribute("reviewBList");
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
  <h2>볼거리 리뷰</h2>
    <table>
      <col width="50px" />
	  <col width="100px"/>
	  <col width="300px"/>
	  <col width="100px"/>
      <tr>
        <td>번호</td>
        <td>작성자</td>
        <td>내용</td>
        <td>평점</td>

      </tr>
<%
      for(int i = 0; i<reviewBList.size(); i++){
    	  ReviewBVo reviewBVo = reviewBList.get(i);
    	  if(attraction_id.equals(reviewBVo.getAttraction_id())) {
%>
      <tr>
	    <td><%= reviewBList.get(i).getR_idx() %></td>
		<td><%= reviewBList.get(i).getMem_id() %></td>
		<td><%= reviewBList.get(i).getR_cont() %></td>
		<td><%
		if(reviewBList.get(i).getScore() == 1) {
			out.println("좋아요");
		} else if (reviewBList.get(i).getScore() == 2) {
			out.println("싫어요");
		}
		 %></td>
	  </tr>
<%
	}
%>	
<%
	}
%>	
      <tr align="center">
	    <td colspan="4">
		  <%if(nowPage <= 1) { %>
		    [이전]&nbsp;
			  <%} else { %>
				<a href="/busanway?cmd=REVIEW&attraction_id=<%=attraction_id %>&page=<%=nowPage - 1 %>">[이전]</a>&nbsp;
				<%} %>
				
				<%for(int i = startPage; i <= endPage; i++) { %>
				  <%if(i == nowPage) { %>
					[<%=i %>]&nbsp;
					<%} else { %>
					  <a href="/busanway?cmd=REVIEW&attraction_id=<%=attraction_id %>&page=<%=i %>">[<%=i %>]</a>&nbsp;
				  <%} %>
				<%} %>
				
				<%if(nowPage >= maxPage) { %>
				  [다음]&nbsp;
				<%} else { %>
				  <a href="/busanway?cmd=REVIEW&attraction_id=<%=attraction_id %>&page=<%=nowPage + 1 %>">[다음]</a>&nbsp;
		   	<%} %>
		  </td>
		</tr>
		<tr>
			<td colspan="4" align="right">
				<input type="button" onclick="location.href='/view/inreviewBuser.jsp?attraction_id=<%=attraction_id %>&member_id=${ loginUser.member_name }'" value="리뷰작성"/>
			</td>
		</tr>
    </table>
</main>
</body>
</html>