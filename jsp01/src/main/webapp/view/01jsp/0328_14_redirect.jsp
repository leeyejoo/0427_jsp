<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리다이렉트</title>
</head>
<body>
	<h2>리다이렉트</h2>
	
	<%
		String userid = "java";
		int birthyear = 1997;
		//주소 이동, 주소도 바뀌고 화면도 바뀐다.
		//대량의 데이터 전송 불가능함.
		response.sendRedirect("0328_14_result.jsp?userid="+userid+"&birthyear="+birthyear); //어디로 이동할것인가?
	
	
	
	
	
	
	
	%>
</body>
</html>