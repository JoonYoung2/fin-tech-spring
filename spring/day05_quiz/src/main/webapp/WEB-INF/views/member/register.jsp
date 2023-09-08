<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="../default/header.jsp" %>
	<div align="center">
		<div>
			${ msg }
		</div>
		<form action="register.do" method="post">
			<input type="text" name="id"><br>
			<input type="text" name="pw"><br>
			<input type="text" name="addr"><br>
			<button>회원가입</button>
		</form>
	</div>
</body>
</html>