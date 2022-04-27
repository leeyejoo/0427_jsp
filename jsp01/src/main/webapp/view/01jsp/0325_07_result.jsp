<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>좋아하는 색상</h2>
	
	당신이 좋아하는 색상은 <%= request.getParameter("favColor")%> 입니다.
</body>
</html>