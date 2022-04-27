<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>서블릿매핑</title>
</head>
<body>
	<form action="/jsp01/J0328_01" method="post"> 
<!-- 	주소가 상대경로인 경우 context path를 적어줘야한다.
		contextpath + webservlet의 매핑정보 
-->

	<h2>서블릿 매핑</h2>
	
		이름 : <input type="text" name="name"><br> 
		나이 : <input type="number" name="age"><br>
		<button>전달</button>
	
	</form>
</body>
</html>