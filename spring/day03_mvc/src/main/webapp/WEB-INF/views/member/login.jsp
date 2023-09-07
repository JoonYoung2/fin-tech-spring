<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
	${ msg }
</div>
	<form action="login.do" method="post">
		<input type="text" name="id" placeholder="id"><br>
		<input type="password" name="pw" placeholder="password"><br>
		<input type="submit" value="login">
	</form>
	<a href="member_register">회원가입</a><br>
	<a href="list">모든 회원보기</a>
</body>
</html>