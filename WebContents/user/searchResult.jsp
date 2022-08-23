<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="api.dao.AttractionDao" %>   
<%@page import="api.vo.AttractionVo" %>
<%
    String member_id = (String) request.getAttribute("member_id");
    System.out.println("attraction: " + member_id);
    
    AttractionDao attractionDao = new AttractionDao();

    Integer nowPage = (Integer)request.getAttribute("page");
    Integer maxPage = (Integer)request.getAttribute("maxPage");
    Integer startPage = (Integer) request.getAttribute("startPage");
    Integer endPage = (Integer) request.getAttribute("endPage");
    Integer listAttractionNameCount = (Integer) request.getAttribute("listAttractionNameCount");

    ArrayList<AttractionVo> attractionList = new ArrayList<>();
    attractionList = (ArrayList<AttractionVo>)request.getAttribute("attractionList");
    
    ArrayList<AttractionVo> searchAttractionNameList = new ArrayList<>();
    searchAttractionNameList = (ArrayList<AttractionVo>)request.getAttribute("searchAttractionNameList");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
 div {
 	text-align: center;
 }
 table{
 	text-align: center;
 	margin: 0 auto;
 }
</style>
</head>
<body>

<!-- login_header 목록 -->
<%@ include file="/include/loginbar.jsp" %>

    <div>
    	<h3 >검색 결과</h3>
    	<table border="1" >
    		<thead>
    			<tr>
    				<th>등록번호</th>
    				<th>명소이름</th>
    				<th>전화번호</th>
    				<th>지역구</th>
    				<th>주소</th>
    			</tr>
    		</thead>
    		<tbody>
    			  <% for(int i=0;i<searchAttractionNameList.size();i++) { 
    				  AttractionVo attractionVo = searchAttractionNameList.get(i);
    			  %>
    			  <tr>
    			  	<td><a href="busanway?cmd=DETAILATTRACTION&attraction_id=<%= searchAttractionNameList.get(i).getAttraction_id()%>"><%=searchAttractionNameList.get(i).getAttraction_id()%></a></td>
    			  	<td><%=searchAttractionNameList.get(i).getAttraction_place()%></td>
    			  	<td><%=searchAttractionNameList.get(i).getAttraction_tel()%></td>
    			  	<td><%=searchAttractionNameList.get(i).getAttraction_gugun()%></td>
    			  	<td><%=searchAttractionNameList.get(i).getAttraction_addr1()%></td>
    			  </tr>
    			  <% 
    			  } 
    			  %>
    			  
    		</tbody>
    	</table>
    		<%if(nowPage <= 1) { %>
		    	[이전]&nbsp;
			  <%} else { %>
				<a href="/busanway?cmd=SEARCHNAMEATTRACTION&page=<%=nowPage - 1 %>">[이전]</a>&nbsp;
				<%} %>
				
				<%for(int i = startPage; i <= endPage; i++) { %>
				  <%if(i == nowPage) { %>
					[<%=i %>]&nbsp;
					<%} else { %>
					  <a href="/busanway?cmd=SEARCHNAMEATTRACTION&page=<%=i %>">[<%=i %>]</a>&nbsp;
				  <%} %>
				<%} %>
				
				<%if(nowPage >= maxPage) { %>
				  [다음]&nbsp;
				<%} else { %>
				  <a href="/busanway?cmd=SEARCHNAMEATTRACTION&page=<%=nowPage + 1 %>">[다음]</a>&nbsp;
		   	<%} %>
    </div>
</body>
</html>