<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	member_list.jsp<br>
	<table border="1">
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
		</tr>
		<c:forEach var="list" items="${ member }">
			<tr>
				<td>${ list.id }</td>
				<td>${ list.pw }</td>
				<td><a href="member_info?id=${ list.id }">${ list.name }</a></td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="3">
				<a href="member_index">index이동</a>
			</td>
		</tr>
	</table>
</body>
</html>