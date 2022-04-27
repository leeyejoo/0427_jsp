<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>계산기</h2>
	<form action="/jsp01/J0329_03"> 
	<input type="number" name="first" >
		<select name="sign">
			<option value="+">＋</option>
			<option value="-">－</option>
			<option value="*">×</option>
			<option value="/">÷</option>
		</select>
	<input type="number" name="second" >
	
	<button>계산</button>
	
	</form>
	
	<!-- 결과 -->
	
	<%= request.getParameter("result") %>
	<%= request.getParameter("warning") %>
	
	
	
</body>
</html>