<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	//원의 넓이를 계산만
		String r = request.getParameter("radius"); //getParameter 반환값: 문자열
		
		//String -> int 형변환
		int radius = Integer.parseInt(r);
		double area = radius * radius*3.14;
	
		System.out.println(area);
		
		//값을 "area"에 담기
		request.setAttribute("area", area); 
	
		//결과창으로 이동 (주소는 그대로, 화면만 변경된다.)
		request.getRequestDispatcher("0328_12_3area_result.jsp").forward(request, response);
	
	%>
</body>
</html>
