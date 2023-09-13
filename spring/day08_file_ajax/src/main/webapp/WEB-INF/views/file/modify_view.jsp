<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="update.do" method="post" enctype="multipart/form-data">
		<input type="text" name="id" value="${ dto.id }" readonly><br>
		<input type="text" name="name" value="${ dto.name }"><br>
		${dto.imgName }<input type="file" name="file"><br>
		<input type="submit" value="수정">
	</form>
</body>
</html>
