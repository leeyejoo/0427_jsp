<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>DB에 저장</h2>
	<form action="0328_16_result.jsp" method="post">
	
	아이디 : <input type="text" name="userid"><br>
	비밀번호 : <input type ="password" name="passwd"><br>
	이름 : <input type="text" name="name"><br>
	이메일 : <input type="text" name="email"><br>
	<hr>
	
	<button>제출</button>
	</form>
	

 	<%= request.getParameter("msg") %>
	
	
</body>
</html>