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
	<h3>index Page</h3>
	<c:if test="${empty sessionScope.userId }"><a href="member_login">Login</a></c:if>
	<c:if test="${ not empty sessionScope.userId }"><a href="member_logout">Logout</a></c:if>
	 <a href="member_register">Register</a>
</body>
</html>