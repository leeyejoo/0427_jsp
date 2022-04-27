<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>06_cal result</title>
</head>
<body>
	<h2>사각형의 넓이 결과</h2>
	
	<%
		request.getParameter("width");
		request.getParameter("height");
		// requst는 문자열로 반환..!
		// 계산을 위해서는 형변환 해야함 (문자열>정수)
		// 래퍼클래스를 이용 (Integer.parseInt)
		int width = Integer.parseInt(request.getParameter("width"));
		int height = Integer.parseInt(request.getParameter("height"));
	%>
	
		사각형의 넓이 : <%= width*height %>
</body>
</html>