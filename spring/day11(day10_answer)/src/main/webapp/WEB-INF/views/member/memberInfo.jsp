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
		<h1>${ member.id }정보</h1>
		<table>
			<tr>
				<td>아이디</td>
				<td>${ member.id }</td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td>${ member.pw }</td>
			</tr>
			<tr>
				<td>주소</td>
				<td>${ member.addr }</td>
			</tr>
		</table>
	</div>
</body>
</html>