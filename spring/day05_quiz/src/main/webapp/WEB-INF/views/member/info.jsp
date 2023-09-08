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
		<table border="1">
			<tr>
				<th>ID</th>
				<th>PW</th>
				<th>ADDR</th>
			</tr>
			<c:forEach var="list" items="${ member }">
				<tr>
					<td><a href="member_info?id=${list.id}">${ list.id }</a></td>
					<td>${ list.pw }</td>
					<td>${ list.addr }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>