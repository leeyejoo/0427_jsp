<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	

	<h2>코로나 국가별 최신안전소식</h2>
	
	
	<form action="${path}/list.country">
		국가
		<select name="iso" >
			<c:forEach var="iso" items="${isolist}">
			
			
			</c:forEach>

		</select>
		<button>입력</button>
	
	</form>
	<hr>
	<c:forEach var="country" items="${clist}">
	<h3>${country.title}</h3>
	<p align="right">
		${country.country_nm} (${country.continent_nm})<br>
		작성일: ${country.wrt_dt}
	 </p>
	<a href="${country.file_download_url}">${country.file_download_url}</a>
	${country.html_origin_cn}

	<hr>
	</c:forEach>
	
	
	<%-- ${clist} --%>
</body>
</html>