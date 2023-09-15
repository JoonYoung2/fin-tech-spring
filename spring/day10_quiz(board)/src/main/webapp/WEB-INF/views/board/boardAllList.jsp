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
	<%@ include file="../default/header.jsp" %>
	<div align="center">
		<h1>게시판</h1>
		<table border="1">
			<tr>
				<th>번호</th>
				<th>id</th>
				<th>제목</th>
				<th>날짜</th>
				<th>조회수</th>
				<th>image_file_name</th>
			</tr>
			<c:if test="${ empty list }">
				<tr>
					<td colspan="6">게시글을 작성해주세요.</td>
				</tr>
			</c:if>
			<c:if test="${ not empty list }">
				<c:forEach var="board" items="${ list }">
					<tr>
						<td>${ board.writeOn }</td>
						<td>${ board.id }</td>
						<td>${ board.title }</td>
						<td>${ board.saveDate }</td>
						<td>${ board.hit }</td>
						<td>${ board.imageFileName }</td>
					</tr>
				</c:forEach>
			</c:if>
			<tr>
				<td colspan="6">
					<div align="right"><a href="writeForm">글작성</a></div>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>