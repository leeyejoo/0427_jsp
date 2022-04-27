<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>select</title>
</head>
<body>
 	<h2>직업선택</h2>
 	<form action="">
 	 	<select name="job">
 			<option>웹프로그래머</option>
 			<option>DB관리자</option>
 			<option>시스템관리자</option>
 			<option>AI프로그래머</option>
 			<option>정보보안관리사</option>
 		</select>
 	
 		<button>선택</button>
 	</form>

	<br><hr><br>
	<%	
		String job = request.getParameter("job");
		if(job !=null){
 	%>
		<h4> 나의 직업은 [ <%= job %> ] 입니다</h4>
	<%}%>
</body>
</html>