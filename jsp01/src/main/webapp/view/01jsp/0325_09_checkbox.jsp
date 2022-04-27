<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>사용가능한 언어</h2>
	<form action="">
	<fieldset>
		<legend>언어</legend>
		<input type="checkbox" name="language" value="java">자바
		<input type="checkbox" name="language" value="python">파이썬
		<input type="checkbox" name="language" value="HTNL5">HTML5
		<input type="checkbox" name="language" value="CSS">CSS
		<input type="checkbox" name="language" value="javascript">JS
		<input type="checkbox" name="language" value="jsp">JSP
	</fieldset>
	<button>선택</button>
	</form>
	
	<br>
	
		당신이 사용 가능한 언어는
	<%
		String[] langs = request.getParameterValues("language");
		
		if(langs != null) {
			for(String lang:langs){ //langs에 있는 것을 풀어서 lang에다가 하나씩 대입
	%>
				 <%= lang %>
	<%
			}
		}
	%>
	입니다.
	
</body>
</html>