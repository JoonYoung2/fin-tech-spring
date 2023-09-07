<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>개인정보</h3>
	id : ${ dto.id }<br><br>
	pw : ${ dto.pw }<br><br>
	name : ${ dto.name }<br><br>
	<a href="list">목록으로 이동</a>
</body>
</html>