<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="contextPath" value="${ pageContext.request.contextPath }" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/test.css" rel="stylesheet"/>
</head>
<body>
path : ${ contextPath }
	<h3>로그인 페이지</h3>
	<button type="button" id="btn">클릭</button>
	<button type="button" onclick="test();">클릭</button>
	<form action="login_chk" method="post">
		<input type="text" name="id"><br>
		<input type="text" name="pwd"><br>
		<input type="submit" value="로그인"><br>
	</form>
	
	<script src="resources/js/test.js"></script>
</body>
</html>