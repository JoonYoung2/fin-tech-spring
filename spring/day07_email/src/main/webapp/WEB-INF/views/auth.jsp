<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="contextPath" value="${ pageContext.request.contextPath }"/>
	
	<c:if test="${ user_id == null }">
		<form action="auth_check" method="post">
			<input type="email" name="email" placeholder="email"><br>
			<input type="submit" value="인증">
		</form>
	</c:if>
	<c:if test="${ user_id != null }">
		<h3>${ user_id }님 인증되었습니다.</h3>
		<a href="logout">인증 해제</a>
	</c:if>
</body>
</html>