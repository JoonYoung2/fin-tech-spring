<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script>
		const test = () => {
			$.ajax({
				url : "http://192.168.42.113:8008/test/",
				type : "get",
				dataType : "json",
				data : {"name" : "홍길동"},
				contentType : "application/json; charset=utf-8",
				success : (data) => {
					$("#result").text( data.key )
					console.log(data)
				},
				error : () => {
					alert("problem")
				}
			})
		}
	</script>
</head>
<body>
	test2<br>
	<b id="result">data</b><br>
	<button type="button" onclick="test()">click</button>
</body>
</html>
