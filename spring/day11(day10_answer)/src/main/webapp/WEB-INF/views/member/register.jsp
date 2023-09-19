<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
function daumPost(){
    new daum.Postcode({
        oncomplete: function(data) {
         console.log( data );
         const addr1 = document.getElementById("addr1");
         const addr2 = document.getElementById("addr2");
         const addr3 = document.getElementById("addr3");
         let addr = "";
         if(data.userSelectedType === "R"){
            addr = data.roadAddress;
         }else{
            addr = data.jibunAddress;
         }
         addr1.value = data.zonecode;
         addr2.value = addr;
         addr3.focus();
        }
    }).open();
}
</script>

</head>
<body>
   <%@ include file="../default/header.jsp" %>
   <div align="center">
	   <h3>회원가입</h3>
	   <form action="register.do" method="post">
	      <input type="text" name="id" placeholder="id"><br>
	      <input type="text" name="pw" placeholder="pw"><br>
	      <input type="text" readonly id="addr1" name="addr" placeholder="우편번호">
	      <button type="button" onclick="daumPost()">우편번호 찾기</button><br>
	      <input type="text" readonly id="addr2" name="addr" placeholder="주소"><br>
	      <input type="text" name="addr" id="addr3" placeholder="상세주소"><br>
	      <input type="submit" value="회원가입"><br>
	   </form>
	</div>
</body>
</html>













