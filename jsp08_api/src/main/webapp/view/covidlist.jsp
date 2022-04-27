<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>코로나</title>
</head>
<script type="text/javascript">

	if('${param.msg}' !=''){
		alert('${param.msg}');
	}
	
	
	function valueCheck(){
		 //유효성체크
		 
		 const startDt = frmList.startDt;
		 const endDt = frmList.endDt;
		 
		 if(startDt.value == ''){
			 alert('시작날짜를 입력하시오')
			 startDt.focus();
			 return false; //유효성체크 실패
		 }else if(endDt.value ==''){
			 alert('마지막날짜를 입력하시오')
			 endDt.focus();
			 return false;
		 }
		 return true; // 유효성체크 성공
	}
	
	
	
	//파싱 후 DB저장
	 function pasingSave(e){
		e.preventDefault(); //기본이벤트 제거
		if(valueCheck()){
			frmList.action = '${path}/dbsave.covid'; //form의 action바꿈
			frmList.submit(); 
		} 
	 }
	
	
	//조회버튼
	 function listCheck(e){
		 e.preventDefault();
		 if(valueCheck()){
			frmList.action = '${path}/list.covid';
			frmList.submit(); 
			}
	 }

</script>

<body>
	<h2>코로나 확진자 현황</h2>
	
	<form name="frmList">
		기간 <input type="date" name="startDt" value="${param.startDt}" min="2020-01-20"> ~ 
			 <input type="date" name="endDt" value="${param.endDt}" min="2020-01-20">
		<button onclick="listCheck(event)">조회</button>
		<button onclick="pasingSave(event)">파싱후 DB저장</button>
	</form>
	
	<hr>
 	<table border="1" bordercolor="ffffff">
		<tr bgcolor="ff6699" align="center">
			<th>게시물번호(seq)</th>
			<th>기준일(stateDt)</th>
			<th>기준시간(stateTime)</th>
			<th>일일확진자수(dailyDecideCnt)</th>
			<th>누적사망자수(deathCnt)</th>
			<th>누적확진자수(decideCnt)</th>
			<th>등록일시분초(createDt)</th>
			<th>수정일시분초(updateDt)</th>
		</tr>
		<c:forEach var="covid" items="${covidList}">
			<tr align="center">
				<td>${covid.seq}</td>
				<td>${covid.stateDt}</td>
				<td>${covid.stateTime}</td>
				<td>${covid.dailyDecideCnt}</td>
				<td>${covid.deathCnt}</td>
				<td>${covid.decideCnt}</td>
				<td>${covid.createDt}</td>
				<td>${covid.updateDt}</td>
		
			</tr>
		</c:forEach>
	
	</table>
<%-- 	${covidList} --%>
</body>
</html>