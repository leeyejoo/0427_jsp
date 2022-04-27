<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>forward</h2>
	<%  
	 	String name ="hong gildong";
		int age = 25;
		request.setAttribute("name", name); //request객체에 정보를 담는다.	
											//"name"에 name(변수)를 담는다.
		request.setAttribute("age", age);	//모든 형 전송 가능(모든 형을 담을 수 있다)
											//대량으 정보를 전송 가능 
		
		
		
		//forward 이동
		//1) 이동경로의 정보 획득
		RequestDispatcher rd = request.getRequestDispatcher("0328_11_result.jsp");
		
		//2) forwad 시킨다 (특징 : 경로는 변경도지 않음(url이 바뀌지 않음))
		rd.forward(request, response);
	%>
</body>
</html>