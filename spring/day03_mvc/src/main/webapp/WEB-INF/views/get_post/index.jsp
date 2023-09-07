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
	<h3>get방식</h3>
	<form action="result" method="get">
		<input type="text" name="name"><br>
		<input type="text" name="age"><br>
		<input type="submit" name="get전송"><br>
	</form>
	
	<h3>post방식</h3>
	<form action="result" method="post">
		<input type="text" name="name"><br>
		<input type="text" name="age"><br>
		<input type="submit" name="post전송"><br>
	</form>
</body>
</html>