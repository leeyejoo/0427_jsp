<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>확장자패턴 매핑</title>
</head>
<body>
	<h2>삼각형의 넓이 구하기</h2>
	<h4>확장자패턴 매핑</h4>
	<form action="/jsp01/tri.cal"> 
		<!-- contextpath부터 적어줘야함. -->
		가로 <input type="number" min="1" name="width"> <br>
		세로 <input type="number" min="1" name="height"> <br>
	
		<button>계산</button>
	</form>
	
	넓이는.... <br>
	<%= request.getAttribute("area") %>cm2
</body>
</html>