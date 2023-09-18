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
	<c:if test="${ not empty msg }">
		<c:if test="${ msg ne '성공' }">
			<script>
				alert("답글 달기에 실패했습니다.")
			</script>
		</c:if>
	</c:if>
	<%@ include file="../default/header.jsp" %>
	<div align="center">
		<form action="modify.do" method="post" enctype="multipart/form-data">
			<input type="hidden" name="writeNo" value="${ dto.writeNo }">
			<table>
				<tr>
					<td>제목</td>
					<td><input type="text" name="title" value="${dto.title}"></td>
				</tr>
				<tr>
					<td>내용</td>
					<td><textarea name="content">${ dto.content }</textarea></td>
				</tr>
				<tr>
					<td colspan="2">
						<img src="#"><br>
						<input type="file" name="file">
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<button>수정하기</button><button type="button" onclick="window.history.back()">이전으로 돌아가기</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>