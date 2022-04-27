<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<body>
	<header><h1 align="center">쇼핑몰 회원관리VER1.0</h1></header><hr>
	<nav>
		<a href="/jsp03_hrd/view/memberAdd.jsp">회원등록</a> 
<!--   			url가 계속 바뀌는 상황에서 상대경로로 하면 주소를 못찾을 수가 있다.
				=> 상대경로로 바꿔줘야 함.											 -->
		<a href="/jsp03_hrd/member/list">회원목록 조회/수정</a>
<!-- 		memberList.jsp로 하면 데이터를 가지고 올 수가 없다.
			=> servlet으로 바로 호출을 해야함. 										 -->
			
		<a href="/jsp03_hrd/money/list">회원매출조회</a>
		<a href="/jsp03_hrd/view/index.jsp">홈으로.</a>
	</nav>
	<hr>
</body>
</html>