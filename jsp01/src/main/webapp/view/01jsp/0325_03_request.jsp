<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>>request객체</title>
</head>
<body>
	<h2>request객체</h2>
	<%
		String protocal = request.getProtocol();
	%>
	요청 프로토콜 : <%= request.getProtocol() %><br>
	요청 메소드 방식 : <%= request.getMethod() %><br>
	현재페이지 경로 : <%= request.getContextPath() %><br>
	요청 url(주소) : <%= request.getRequestURI() %><br>
	


</body>
</html>