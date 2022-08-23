<%@page import="java.util.ArrayList"%>
<%@page import="vo.QnaVo"%>
<%@page import="dao.QnaDao"%>
<%@ page import="vo.MemberVo" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    MemberVo memberVo = (MemberVo) request.getAttribute("memberVo");
    System.out.println(memberVo);
    
    String member_id = (String) request.getParameter("member_id");
    System.out.println(member_id);
    /* QnaDao qnaDao = new QnaDao();
    
    ArrayList<QnaVo> getQList = new ArrayList<>();
    getQList = ( ArrayList<QnaVo>)request.getAttribute("getQList");
    System.out.println(getQList); 
    */
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"  href="/css/mypageadmin.css" />
</head>
<body>

<!-- login_header 목록 -->
<%@ include file="/include/loginbar.jsp" %>

 <div id="my">
   <div id="my1">
 	<h1>마이페이지<br>
 	<input type="button" id="users" value="회원관리 " onclick="location.href='/busanway?cmd=USERSLIST&member_id=${ loginUser.member_name }'"/>
 	<input type="button" id="api" value="API 업데이트 " onclick="location.href='/view/ApiUpdate.html'"/>
 	</h1>
 	
 	<span style="line-height:300%">
 	<label class="ss">이름</label>
 	<input type="text" value="<%=memberVo.getMember_name() %>"><br>
 	<label class="ss">생년월일</label>
 	<input type="text" value="<%=memberVo.getMember_birth() %>"><br>
 	<label class="ss">아이디</label>
 	<input type="text" value="<%=memberVo.getMember_id() %>"><br>
 	<label class="ss">닉네임</label>
 	<input type="text" value="<%=memberVo.getMember_nick_name() %>"><br>
 	<label class="ss">비밀번호</label>
 	<input type="text" value="<%
 	    int pwLength = memberVo.getMember_pwd().length();
	    String mark = memberVo.getMember_pwd().substring(0, 2);
	    for(int i = 0; i < pwLength - 2; i++) {
		mark += "*";
	    }
	    out.println(mark);
 	%>"><br>
 	<label class="ss">이메일</label>
 	<input type="text" value="<%=memberVo.getMember_email() %>"><br>
 	<label class="ss">전화번호</label>
 	<input type="text" value="<%=memberVo.getMember_tel() %>"><br>
 	<label class="ss">주소</label>
 	<input type="text" value="<%=memberVo.getMember_addr() %>"><br>
 	<label class="ss">가입일자</label>
 	<input type="text" value="<%=memberVo.getMember_joindate() %>"><br>
 	<label class="ss">레벨</label>
 	<input type="text" value="<%=memberVo.getMember_member_level() %>"><br>
 	<input type="button" value="수정완료" >
 	</span>
 </div>
</div>
</body>
</html>