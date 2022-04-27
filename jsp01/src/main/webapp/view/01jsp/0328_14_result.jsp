<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과창</title>
</head>
<body>
	<h2>리다이렉트 결과창</h2>
	아이디 : <%=request.getParameter("userid") %>
	출생년도 : <%=request.getParameter("birthyear") %>
</body>
</html>