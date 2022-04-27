<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/includeFile.jsp" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="../header.jsp" %>
	<h2>회원조회</h2>
	<%-- ${mlist} --%>
	<form action="">
		<select name="findkey">
			<option>아이디</option>
			<option>도로명주소</option>
		</select>
		<input type="text" name="findvalue">
		<button>조회</button>
	</form>
	
	<table border="1">
		<tr>
			<th>아이디</th>
			<th>도로명주소</th>
			<th>등록일자</th>			
		</tr>
		<c:forEach var="member" items="${mlist}">
			<tr>
				<td>${member.userid}</td>
				<td>${member.addrload}</td>
				<td><fmt:formatDate value="${member.regidate}" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>