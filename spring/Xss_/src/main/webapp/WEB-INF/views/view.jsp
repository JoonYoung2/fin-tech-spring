<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="insert01" method="post">
		<input type="text" name="txt"><br>
		<input type="submit" value="send">
	</form>
	
	<form action="insert02" method="post">
		<input type="text" name="txt1"><br>
		<input type="text" name="txt2"><br>
		<input type="submit" value="send">
	</form>
	
	<form action="insert03" method="post" enctype="multipart/form-data">
		<input type="text" name="txt1"><br>
		<input type="file" name="file"><br>
		<input type="button" value="전송"><br>
	</form>
</body>
</html>