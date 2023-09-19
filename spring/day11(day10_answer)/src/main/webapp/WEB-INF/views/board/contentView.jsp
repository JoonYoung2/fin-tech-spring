<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<style>
	#replyModal{
		display:none;
		position: fixed; /* Stay in place */
		z-index: 1; /* Sit on top */
		padding-top: 100px; /* Location of the box */
		left: 0px;
		top: 80px;
		width: 100%; /* Full width */
		height: 100%; /* Full height */
		overflow: auto; /* Enable scroll if needed */
	}
	
	.replyTable td{
		border-bottom: 1px solid rgba(0, 0, 0, 0.1);
	}
	
	.replyTable div{
		padding-bottom: 5px;
	}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body id="body" style="background-color:white;">
	<%@ include file="../default/header.jsp" %>
	<div align="center">
		<h1>개인 정보</h1>
		<table border="1">
			<tr>
				<th style="width:100px;">글 번호</th>
				<td style="width:50px;">${ dto.writeNo }</td>
				<th style="width:100px;">작성자</th>
				<td style="width:250px;">${ dto.id }</td>
			</tr>
			<tr>
				<th>제목</th>
				<td>${ dto.title }</td>
				<th>등록일자</th>
				<td>${ dto.saveDate }</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>${ dto.content }</td>
				<td colspan="2">
					<img width=100 height=100 src="file:///D:fin_tech_spring/spring_file_upload/image_repo/20230915211549-gg1.webp"/>
				</td>
			</tr>
			<tr>
				<td colspan="4">
					<c:if test="${ sessionScope.user_id eq dto.id }">
						<a href="modify_form?writeNo=${ dto.writeNo }"><button type="button">수정하기</button></a>
						<button type="button" onclick="boardDelete('${dto.writeNo}')">삭제하기</button>
					</c:if>
					<button type="button" onclick="reply()">답글달기</button>
					<a href="boardList"><button type="button">리스트로 돌아가기</button></a>
				</td>
			</tr>
			<c:forEach var="list" items="${ rep }">
				<tr>
					<td colspan="4">
						<b>아이디 : </b>${ list.id }<b>/작성일 : </b>${ list.write_date }<br>
						<b>제목 : </b>${ list.title }<br>
						<b>내용 : </b>${ list.content }
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	
	<div id="replyModal" align="center">
		<div style="background-color:#B8DFF8; width:30%;">
			<form action="reply.do" method="post">
				<input type="hidden" name="id" value="${sessionScope.user_id }">
				<input type="hidden" name="write_group" value="${ dto.writeNo }">
				<table class="replyTable">
					<tr>
						<td>
							<div>
								<b>답글 작성 페이지</b>
							</div>
						</td>
					</tr>
					<tr>
						<td>
							<div>
								<b>작성자 : ${sessionScope.user_id}</b>
							</div>
						</td>
					</tr>
					<tr>
						<td>
							<div>
								<b>제목</b><br>
								<input type="text" name="title">
							</div>
						</td>
					</tr>
					<tr>
						<td>
							<div>
								<b>내용</b><br>
								<textarea name="content"></textarea>
							</div>
						</td>
					</tr>
					<tr>
						<td>
							<div>
								<button>답글</button><button type="button" onclick="cancel()">취소</button>
							</div>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	
	<script>
		const boardDelete = (num) => {
			if( window.confirm("정말 삭제하시겠습니까?") ){
				alert("삭제 완료");
				location.href="delete.do?writeNo="+num;
			}
		}
		
		const reply = () => {
			let replyModal = document.getElementById("replyModal");
			let body = document.getElementById("body");
			replyModal.style.display = "block";
			body.style.backgroundColor = "#eee";
		}
		
		const cancel = () => {
			let replyModal = document.getElementById("replyModal");
			let body = document.getElementById("body");
			replyModal.style.display = "none";
			body.style.backgroundColor = "#fff";
		}
		
	</script>
</body>
</html>