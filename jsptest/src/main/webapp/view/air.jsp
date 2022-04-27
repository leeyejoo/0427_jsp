<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>미세먼지 경보 발령 현황</h2>
	
	<form action="${path}/airPM/list">
	연도 <input type="text" name="year" value="${param.year }">
	<button>입력</button>
	</form>
	<hr>
	<%-- ${alist} --%>
	<table border="1">
		<tr align="center">
			<th>일련번호</th>
			<th>발령일</th>
			<th>발령시간</th>
			<th>지역명</th>
			<th>권역명</th>
			<th>미세먼지 항목(PM10, PM25)</th>
			<th>미세먼지 농도(단위: ug/m3)</th>
			<th>경보단계</th>
		</tr>
		<c:forEach var="air" items="${airList}">
			<tr align="center">
				<td>${air.sn}</td>
				<td>${air.dataDate}</td>
				<td>${air.issueTime}</td>
				<td>${air.districtName}</td>
				<td>${air.moveName}</td>
				<td>${air.itemCode}</td>
				<td>${air.issueVal}</td>
				<td>${air.issueGbn}</td>
			</tr>
		</c:forEach>
	</table>
	
	
</body>
</html>