
<%@page import="java.util.Scanner"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>표현식</h2>
	<%
		int a=10, b=20;
		out.println("<div id='add'>합: "+(a+b)+"<div>");
	
	%>
	<hr>
 	<!-- 변수, 값  -->
 	<div id ="add">	
 		합:<%= a+b %>
 	</div>
 	<hr>
 	
 	
 	<%-- jsp의 주석 --%>
<%--  	<%
 		int age=12;
 		String p =null;
		if(age>=20){
			//out.println(age+"살은 성인")
			 p = "성인";
		}else{
			//out.println(age+"살은 미자")
			 p = "미자";
		}
 	%>
 		<!-- 표현식 -->
 	  	<div> <%= age %>살은 <%= p %> </div> --%>
 	  	
 	  	
 	  	
 	<%
 		Scanner sc = new Scanner(System.in);
 		int age=sc.nextInt();
		if(age>=20){
	%>
			<%= age %>살은 성인
	<% 		
		}else{
	%>
			 <%= age %>살은 미자
	<%
		}
 	%>
 	
 	
 	
 	<hr>
 	<h5>구구단 출력(2단)</h5>
 	<%
 	for(int i=1; i<10; i++){
	%>
	<%= i %>단<br>
 	<%	
 		for(int j=1; j<10; j++){
 	%>
 		<%= i %> × <%= j %> = <%= i*j %> <br>
 	
 	<% } %>
 	<hr>
 	<% }
 	
 	sc.close();%>
 	
 
 	
 	
 	
 	
 	
 	  	
 	
 	
</body>
</html>