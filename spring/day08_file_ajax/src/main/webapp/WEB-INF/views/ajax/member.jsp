<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script type="text/javascript">
   
   function getUsers(){
      $.ajax({
         url : "users", type : "get", dataType : "json",
         success : function( list ){
            console.log(list);
            let msg ="";
            list.forEach((data)=>{
               msg +="<b>이름 : "+data.name+"</b><br>";
               msg +="<b>age : "+data.age+"</b><hr>";
            })
            //$("#data").html(msg);
            $("#data").append(msg);
            $("#btn").html("see more");
         },
         error : () =>{ alert("문제 발생")}
      });
   }
   function getUser(){
      let id = $("#name").val();
      $.ajax({
         url : "getUser/"+id, type: "get", dataType : "json",
         //get방식은 데이터를 가져오겠다는 것이어서 이 곳에서 data:를 사용할 수 없음. 
         success : function(data){
        	 let msg ="";
        	 msg +="<b>이름 : "+data.name+"</b><br>";
             msg +="<b>age : "+data.age+"</b><hr>";
             $("#oneData").html(msg);
         }, error : function(){
            console.log("error");
         }
      });
   }
   
   const reset = () => {
	   $("#data").html("");
	   $("#btn").html("see list");
   }
</script>
</head>
<body>

   <div id="data"></div>
   <button type="button" id="btn" onclick="getUsers()">see list</button>
   <button type="button" onclick="reset()">reset</button>
   <br>
   Name for search : <input type="text" id="name"><br>
   <button type="button" onclick="getUser()">OneData</button>
   <div id="oneData"></div>
   
   
</body>
</html>