<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	test_socket.jsp<br>
	<button type="button" onclick="chat();">상담원 연결</button>
	
	<script>
		function chat(){
			window.open("socket", "", "width=300px,height=500px");
		}
	</script>
</body>
</html>