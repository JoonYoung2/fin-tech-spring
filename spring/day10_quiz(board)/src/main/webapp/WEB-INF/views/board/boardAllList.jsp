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
						<td>${ board.writeNo }</td>
						<td>${ board.id }</td>
						<td><a href="contentView?writeNo=${board.writeNo }">${ board.title }</a></td>
						<td>${ board.saveDate }</td>
						<td>${ board.hit }</td>
						<td>${ board.imageFileName }</td>
					</tr>
				</c:forEach>
			</c:if>
			<tr>
				<td colspan="6">
					<div style="display:flex;">
						<div align="left">
							<c:forEach var="i" begin="${ start }" end="${ end }" step="1">
								<a href="boardList/${ i }">[${ i }]</a> 
							</c:forEach>
						</div>
						<div align="right">
							<a href="writeForm">글작성</a>
						</div>
					</div>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>