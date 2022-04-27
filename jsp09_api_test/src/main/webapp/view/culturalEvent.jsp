<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>서울시 문화행사 정보</title>
</head>
<body>

	<h2>서울시 문화행사 정보</h2>
	
	<form action="${path}/cultural/list">
	분류
	<select name="codename">
		<option value="클래식">클래식</option>
		<option value="콘서트">콘서트</option>
		<option value="축제-전통/역사">축제-전통/역사</option>
		<option value="축제-시민화합">축제-시민화합</option>
		<option value="축제-문화/예술">축제-문화/예술</option>
		<option value="축제-기타">축제-기타</option>
		<option value="전시/미술">전시/미술</option>
		<option value="영화">영화</option>
		<option value="연극">연극</option>
		<option value="뮤지컬/오페라">뮤지컬/오페라</option>
		<option value="문화교양/강좌">문화교양/강좌</option>
		<option value="무용">무용</option>
		<option value="독주/독창회">독주/독창회</option>
		<option value="기타">기타</option>
	</select>
	<button>검색</button>
	<button>DB저장</button>
	</form>
	<hr>
	<%-- ${culturalList} --%>
	
	<table border="1">
		<tr>
			<th>분류</th>
			<th>공연/행사명</th>
			<th>날짜/시간</th>
		</tr>
		<c:forEach var="culturalEvent" items="${culturalList}">
			<tr>
				<td>${culturalEvent.CODENAME}</td>
				<td><a href="${path}/view/culturalEventDetail.jsp?TITlE=${culturalEvent.TITLE}">${culturalEvent.TITLE}</a></td>
				<td>${culturalEvent.DATE}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>