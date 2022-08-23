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
    Integer listCount = (Integer) request.getAttribute("listAttractionCount");
    
    ArrayList<AttractionVo> attractionList = new ArrayList<>();
    attractionList = (ArrayList<AttractionVo>)request.getAttribute("attractionList");

%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"  href="/css/bolmuknols.css" />
<style></style>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
     
    $(function() { // 검색 주제에 따라서 팩토리 cmd 값을 다르게 가져갈 수 있다.
	   $('#searchkeyword').on('submit', function() {
		   var opt = $('[name=part]').val();
		   //alert(opt);
		   switch( opt ) {
		   case 'searchname':
		   	  this.action = 'busanway?cmd=SEARCHNAMEATTRACTION';
		   	  break;
		   case 'searchgugun':
		   	  this.action = 'busanway?cmd=SEARCHGUGUNATTRACTION';
		   	  break;
		   }
	   });
	   
   }) 

</script>
</head>
<body>

<!-- login_header 목록 -->
<%@ include file="/include/loginbar.jsp" %>

<div class="allpanel">
  <div class="panel1">
    <h2>볼거리</h2>
    <%for(int i = 0;i<attractionList.size();i++){
    	AttractionVo attractionVo = attractionList.get(i);
    %>
    <div class="box">
      <label class="imgbox">
        <a href="busanway?cmd=DETAILATTRACTION&attraction_id=<%= attractionList.get(i).getAttraction_id() %>&member_id=${loginUser.member_id}" ><input type="image" src="<%= attractionList.get(i).getAttraction_thumb()%>" style="width: 200px; height: 150px;"/></a>
      </label>
      <input type="text" value="<%= attractionList.get(i).getAttraction_place() %>" />
      <textarea rows="4" cols="20" ><%= attractionList.get(i).getAttraction_addr1() %>"</textarea>
    </div>
   <%
   
    }
   
   %>  
   <%if(nowPage <= 1) { %>
		    [이전]&nbsp;
			  <%} else { %>
				<a href="/busanway?cmd=ATTRACTIONLIST&page=<%=nowPage - 1 %>">[이전]</a>&nbsp;
				<%} %>
				
				<%for(int i = startPage; i <= endPage; i++) { %>
				  <%if(i == nowPage) { %>
					[<%=i %>]&nbsp;
					<%} else { %>
					  <a href="/busanway?cmd=ATTRACTIONLIST&page=<%=i %>">[<%=i %>]</a>&nbsp;
				  <%} %>
				<%} %>
				
				<%if(nowPage >= maxPage) { %>
				  [다음]&nbsp;
				<%} else { %>
				  <a href="/busanway?cmd=ATTRACTIONLIST&page=<%=nowPage + 1 %>">[다음]</a>&nbsp;
		   	<%} %>
  </div>
  <div class="panel2">
    <div class="search_keword">
    	<form id="searchkeyword" method="post">
			<fieldset>
				<legend>키워드 입력</legend>
				<label>검색 분류</label>
					<select name="part">
						<option value="searchname" >명소 이름</option>
						<option value="searchgugun" >지역구</option>
					</select>
				<label>검색어</label>	
				 <input type="text" name="keyword" value=""/>
				 <input type="submit" value="검색" />
				 
			</fieldset>
    	</form> 	
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
  
</div>
</div>
  <div id="main6">
 	<h5>고객센터 : 그린컴퓨터아카데미 경성대점</h5>
 	<h5>주소 : 부산광역시 남구 부전동 194-7</h5>
 	<h5>전화번호 : 051.912.1000</h5>
  </div>
</body>
</html>