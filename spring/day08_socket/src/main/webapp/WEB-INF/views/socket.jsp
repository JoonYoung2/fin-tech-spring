<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script>
	let sock = null;
	window.onload = () => {
		let wsUri = "ws://localhost:8081/root/test/websocket";
		sock = new WebSocket( wsUri );
		
		sock.onmessage = onMessage;
		
		$("#sendBtn").click( () => {
			sendMessage();
		} )
	}
	
	const onMessage = ( msg ) => {
		$("#rec_data").append( msg.data + "<br>" )
	}
	
	const sendMessage = () => {
// 		let msg = document.getElementById("send_msg").value;
// 		sock.send( msg );
		sock.send( $("#send_msg").val() );
		$("#send_msg").val("");
	}
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	socket 연결<br>
	<div id="rec_data"></div>
	<input type="text" id="send_msg"><br>
	<button type="button" id="sendBtn">전송</button>
</body>
</html>