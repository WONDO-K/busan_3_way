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
<form action="/emailcheckservlet" method="GET" name="frm">
  <table>
    <tr>
      <td><label for = email>이메일</label></td>
      <td><input type="text" name="join_email" id="email" value="${ member_email }"></td>
      <td><input type="submit" value="중복 체크"></td>
    </tr>
    <tr>
      <td colspan="3">
        <c:choose>
          <c:when test="${result == 1 }">${ member_email }는 사용중인 이메일입니다</c:when>
          <c:when test="${result == -1 }">${ member_email }는 사용가능한 이메일입니다
          <input type="button" value="이메일 사용" onclick="emailOk()"></c:when>
            <c:otherwise></c:otherwise>
        </c:choose>
      </td>
    </tr>
  </table>
</form>
</body>
</html>