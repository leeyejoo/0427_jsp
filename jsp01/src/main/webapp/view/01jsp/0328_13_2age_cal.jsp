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
	//성인, 미자체크
		int age = Integer.parseInt(request.getParameter("age"));
		String result = null;
	
		if (age>=20){
			result= "성인";
		}else{
			result= "미성년자";
		}
	%>
	
	<%
	//값이동
		request.setAttribute("result", result);
		request.setAttribute("age", age);
		
		request.getRequestDispatcher("0328_13_3age_result.jsp").forward(request, response);
		
	%>
	
	
	
	
</body>
</html>