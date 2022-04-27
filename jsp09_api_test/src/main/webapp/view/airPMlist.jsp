<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>미세먼지 경보 발령 현황</title>
<script type="text/javascript">
	function valuesCheck(){
		const year = frmList.year;
		
		if(year==''){
			alert('측정연도를 입력하시오');
			year.focus();
		}
		return true
	}

	function saveCheck(e){ // 저장
		if(valuesCheck()){
			e.preventDefault();
			frmList.action='${path}/airPM/dbsave';
			frmList.submit();
		}
	}
	
	function listCheck(e){ //리스트
		if(valuesCheck()){
			e.preventDefault();
			frmList.action='${path}/airPM/list';
			frmList.submit();
		}
	}
	


</script>

</head>
<body>
	<h2>미세먼지 경보 발령 현황</h2>
	
	<form name="frmList" >
	측정연도 <input type="text" name="year" value="${param.year}">
	<button onclick="saveCheck(event)">저장</button>
	<button onclick="listCheck(event)">검색</button>
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
		<c:forEach var="airPM" items="${alist}">
			<tr align="center">
				<td>${airPM.sn}</td>
				<td>${airPM.dataDate}</td>
				<td>${airPM.issueTime}</td>
				<td>${airPM.districtName}</td>
				<td>${airPM.moveName}</td>
				<td>${airPM.itemCode}</td>
				<td>${airPM.issueVal}</td>
				<td>${airPM.issueGbn}</td>
			</tr>
		</c:forEach>
	</table>
	
	
</body>
</html>