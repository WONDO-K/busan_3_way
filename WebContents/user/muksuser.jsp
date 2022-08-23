<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="api.dao.StoreDao" %>    
<%@page import="api.vo.StoreVo" %>    
<%
    String member_id = (String) request.getAttribute("member_id");
    System.out.println("store: " + member_id);
    
    StoreDao storeDao = new StoreDao();
    
    Integer nowPage = (Integer)request.getAttribute("page");
    Integer maxPage = (Integer)request.getAttribute("maxPage");
    Integer startPage = (Integer) request.getAttribute("startPage");
    Integer endPage = (Integer) request.getAttribute("endPage");
    Integer listCount = (Integer) request.getAttribute("listStoreCount");
    
    ArrayList<StoreVo> storeList = new ArrayList<>();
    storeList = (ArrayList<StoreVo>)request.getAttribute("storeList");
%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"  href="/css/bolmuknols.css" />
<style></style>
<script>
</script>
</head>
<body>

<!-- login_header 목록 -->
<%@ include file="/include/loginbar.jsp" %>

<div class="allpanel">
  <div class="panel1">
    <h2>먹거리</h2>
    <%for(int i = 0; i<storeList.size(); i++){
    	StoreVo storeVo = storeList.get(i);
    %>
    <div class="box">
      <label class="imgbox">
       <a href="/busanway?cmd=DETAILSTORE&store_id=<%=storeList.get(i).getStore_id() %>&member_id=${loginUser.member_id}" > <input type="image" src="<%= storeList.get(i).getStore_thumb() %>"  style="width: 200px; height: 150px;"/></a>
      </label>
       <input type="text" value="<%= storeList.get(i).getStore_name() %>" />
       <textarea rows="4" cols="20" ><%= storeList.get(i).getStore_addr() %></textarea>
    </div>
      
   <%
   
    }
   
   %>
     <%if(nowPage <= 1) { %>
		    [이전]&nbsp;
			  <%} else { %>
				<a href="/busanway?cmd=STORELIST&page=<%=nowPage - 1 %>">[이전]</a>&nbsp;
				<%} %>
				
				<%for(int i = startPage; i <= endPage; i++) { %>
				  <%if(i == nowPage) { %>
					[<%=i %>]&nbsp;
					<%} else { %>
					  <a href="/busanway?cmd=STORELIST&page=<%=i %>">[<%=i %>]</a>&nbsp;
				  <%} %>
				<%} %>
				
				<%if(nowPage >= maxPage) { %>
				  [다음]&nbsp;
				<%} else { %>
				  <a href="/busanway?cmd=STORELIST&page=<%=nowPage + 1 %>">[다음]</a>&nbsp;
		   	<%} %>
  </div>
  
  <div class="panel2">
    <div class="search">
      <input type="text" value="검색어" />
    </div>
    <div class="search_btn">
      <input type="button" value="검색" />
    </div>
    <div class="check_box1">
      <label>
        <input type="checkbox" value="" />강서구
      </label>
      <br>
      <label>
        <input type="checkbox" value="" />금정구
      </label>
      <br>
      <label>
        <input type="checkbox" value="" />기장군
      </label>
      <br>
      <label>
        <input type="checkbox" value="" />사상구
      </label>
      <br>
      <label>
        <input type="checkbox" value="" />사하구
      </label>
      <br>
      <label>
        <input type="checkbox" value="" />서구
      </label>
      <br>
      <label>
        <input type="checkbox" value="" />남구
      </label>
      <br>
      <label>
        <input type="checkbox" value="" />수영구
      </label>
    </div>
    <div class="check_box2">
      <label>
        <input type="checkbox" value="" />동구
      </label>
      <br>
      <label>
        <input type="checkbox" value="" />연제구
      </label>
      <br>
      <label>
        <input type="checkbox" value="" />동래구
      </label>
      <br>
      <label>
        <input type="checkbox" value="" />부산진구
      </label>
      <br>
      <label>
        <input type="checkbox" value="" />중구
      </label>
      <br>
      <label>
        <input type="checkbox" value="" />북구
      </label>
      <br>
      <label>
        <input type="checkbox" value="" />해운대구
      </label>
      <br>
      <label>
        <input type="checkbox" value="" />영도구
      </label>
    </div>
  </div>
  <div id="main6">
 	<h5>고객센터 : 그린컴퓨터아카데미 경성대점</h5>
 	<h5>주소 : 부산광역시 남구 부전동 194-7</h5>
 	<h5>전화번호 : 051.912.1000</h5>
  </div>
</div>
</body>
</html>