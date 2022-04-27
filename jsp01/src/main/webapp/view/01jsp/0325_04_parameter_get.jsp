<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>요청 파라메터 정보</h2>
<!-- 	
	전송 메소드 : get - 데이터 전송을 url에 담아서 전송
				  post - request 내부 객체에다가 담아서 전송
-->
	
	<form action="" method="get"> 	
		<!-- submit하면 action이 가르키는 곳으로 전송됨 default:자기자신-->
		이름 : <input type="text" name="name"><br>
		나이 : <input type="number" name="age"><br>
		<button>전송</button>	
		<!-- 기본 form에대한 submit기능: action값(url)을 요청 (공백이면 자신의 폼 요청)
			form 안의 name의 정보를 request( get(url에포함) , post(객체)) 에 담아서 보낸다-->
	</form>
	
	<% 
		//스트립틀릿(servlet) : 서버에서 동작
		String name = request.getParameter("name");
			//파라메터중에서 name을 읽어서 반환해주는 값이 문자열 
		String age = request.getParameter("age");
			//파라메터가 반환해주는 값이 String이기 때문에 문자열로 저장
	%>
		이름: <%= name %> <br>
		나이: <%= age %>
	
	
	
	
</body>
</html>