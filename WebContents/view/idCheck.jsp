<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="/js/member.js"></script>
<title>Insert title here</title>
</head>
<body>
<form action="/idcheckservlet" method="GET" name="frm">
  <table>
    <tr>
      <td><label for = id>아이디</label></td>
      <td><input type="text" name="join_id" id="id" value="${ member_id }"></td>
      <td><input type="submit" value="중복 체크"></td>
    </tr>
    <tr>
      <td colspan="3">
        <c:choose>
          <c:when test="${result == 1 }">${ member_id }는 사용중인 아이디입니다</c:when>
          <c:when test="${result == -1 }">${ member_id }는 사용가능한 아이디입니다
          <input type="button" value="아이디 사용" onclick="idOk()"></c:when>
            <c:otherwise></c:otherwise>
        </c:choose>
      </td>
    </tr>
  </table>
</form>
</body>
</html>