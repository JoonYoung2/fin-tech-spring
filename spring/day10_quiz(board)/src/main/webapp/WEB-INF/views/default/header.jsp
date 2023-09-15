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
<br><br>
	<div align="center">CARE LAB</div>
<br><br>
<hr>
	<div align="right">
		<a href="/root">HOME</a> <a href="info">회원정보</a> <a href="boardList">게시판</a>
		<c:if test="${empty sessionScope.user_id }">
			<a href="login">LOGIN</a>
		</c:if>
		<c:if test="${not empty sessionScope.user_id }">
			<a href="logout">LOGOUT</a>
		</c:if>
	</div>
<hr>
</body>
</html>