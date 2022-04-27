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
		request.setCharacterEncoding("UTF-8");
		String userid = request.getParameter("userid");
		String passwd = request.getParameter("passwd");
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String route = request.getParameter("route");
		String[] times = request.getParameterValues("time");
	%>
	
		아이디 : <%=userid %><br>
		비밀번호 : <%=passwd %><br>
		이메일 : <%=email %><br>
		이름 : <%=name %><br>
		성별 : <%=gender %><br>
		가입경로 : <%=route %><br>
		알바가능시간 : 
		
<%-- 		<!-- for 문  -->
		<%	if (times !=null){
				for(int i=0; i<times.length; i++){
		%>
					<%= times[i] %>	
		<%		}
			}
		%> --%>
		
		
		<!-- foreach문 -->
		<% 
			if (times != null){
				for (String time: times){ %>
					<%=time %>
		<% 		}
			}%>
</body>
</html>