<%@page import="java.net.URLEncoder"%>
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
		// msg : 계열 메세지 
		String name = request.getParameter("name");
		String major = request.getParameter("major");
			
		
		//substring(0,1) 문자열 추출...  
		String prefix = major.substring(0,1);
		String msg=null;
		
		//charAt : 문자열의 맨 앞글자를 char형으로 추출
		char a = (char)major.charAt(0);
		
		if( a =='A'){
			msg="공학계열";
		}else if (prefix.equals("B")){
			msg="사회과학계열";
		}else if (prefix.equals("C")){
			msg="예체능계열";
		}else{
		}
	
		if(major.equals("A001")){
			major="프로그래밍학과";
		}else if(major.equals("A002")){
			major="시스템학과";
		}else if(major.equals("B001")){
			major="행정학과";
		}else if(major.equals("B002")){
			major="경제학과";
		}else if(major.equals("C001")){
			major="조형학과";
		}else{
		}
		
		
		
		//redirect이동(결과창으로 이동 )
		//대량의 정보는 못가져간다.
		
		//자바의 인코딩과 url의 인코딩이 다르기 때문에
		//url에 영어가 아닌 문자를 넣고 싶다면 인코딩 방법을 바꿔줘야함. 
		name = URLEncoder.encode(name,"utf-8");
		major = URLEncoder.encode(major,"utf-8");
		msg =URLEncoder.encode(msg, "utf-8");
		
		response.sendRedirect("0328_15_3result.jsp?name="+name+"&msg="+msg+"&major="+major);
		//url 인코딩 방식을 바꿔줘야함... java와 url UTF-8 방식이 다르기 대문.. . 
	%>



</body>
</html>