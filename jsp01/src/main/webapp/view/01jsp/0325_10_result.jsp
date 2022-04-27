<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Information</title>
	<style>
	@font-face {
    font-family: 'NeoDunggeunmo';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2001@1.3/NeoDunggeunmo.woff') format('woff');
    font-weight: normal;
    font-style: normal;
	}

	*{
	font-family : 'NeoDunggeunmo';
	color : white;
	background-color : blue;
	}	
	</style>
</head>
<body>
	<h2>회원정보</h2>
	<% request.setCharacterEncoding("utf-8");
		// POST전송방식일때, 한글인코딩 방법 %>
		
		
		
	<h4> <%= request.getParameter("username") %> 
		(<%= request.getParameter("usergender")%>)님의 회원정보</h4>
	
	아이디 : <%= request.getParameter("userid")  %><br>
	비밀번호 :  <%= request.getParameter("userpw")  %><br>
	이메일 :  <%= request.getParameter("useremail")  %><br>
	
	<hr>
	<%
		String sPath = request.getParameter("sPath");
 		if (sPath !=null){
	%>
		가입경로 :  <%= sPath %><br>
 	<%	}
 	%>

	가능 시간대 :  
	<%
		String[] times = request.getParameterValues("time");
 		if (times != null){
			for(String time:times) {
	%>
				<%= time%>
	<%		}
 		}
	%>
</body>
</html>