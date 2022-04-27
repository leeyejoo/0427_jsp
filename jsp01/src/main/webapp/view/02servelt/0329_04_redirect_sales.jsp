<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>redirect</title>
</head>
<body>
	<h2>상품판매</h2>
	<form action="/jsp01/J0329_04">
		상품명: <input type="text" name="pname">
		단가: <input type="number" name="price" min="1">
		판매수량 : <input type="number" name="qty" min="1">
		<button>계산</button>
	</form>
	
	<hr>
	<%= request.getParameter("pname") %>의 판매금액 : 
	<%= request.getParameter("amount") %> 
</body>
</html>