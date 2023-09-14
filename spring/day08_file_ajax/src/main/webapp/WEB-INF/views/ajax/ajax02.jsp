<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script>
	const test = () => {
		$.ajax({ 
			url : "result02",
			type : "get",
			success : ( data ) => {
				console.log("성공");
				$("#txt").text(data+"<br>aa");
			},
			error : () => {
				console.log("실패");
			}
			
		});
	}
</script>
</head>
<body>
	<h1>1111</h1> <h1>1111</h1> <h1>1111</h1> <h1>1111</h1> <h1>1111</h1> <h1>1111</h1> <h1>1111</h1> <h1>1111</h1> <h1>1111</h1>
	<button type="button" onclick="test()">클릭</button>
	<hr>
	<b id="txt"></b>
</body>
</html>