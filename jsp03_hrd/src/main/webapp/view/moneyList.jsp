<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>매출조회</title>
</head>
<body>
	<!-- 매출조회 -->
	
	<%@include file="header.jsp" %>	
	<section>
	<%
		List<Map<String, Object>> mlist = (List<Map<String, Object>>) request.getAttribute("mlist");
	
	%>
	
<%-- 	<%=mlist %> --%>
	
	
	<h2>회원매출조회</h2>
	<table border="1">
		<tr>
			<th>회원번호</th>
			<th>회원성명</th>
			<th>고객등급</th>
			<th>매출</th>
		</tr>
<%
		if(mlist != null ){
			for(Map<String , Object> map : mlist){
				
%>
				<tr>
					<td><%=map.get("custno") %>
					<td><%=map.get("custname") %>
					<td><%=map.get("grade") %>
					<td><%=map.get("price") %>
				</tr>
<%			}
		}


%>		
		
	
	</table>
			
	</section>
	<%@include file="footer.jsp" %>		
</body>
</html>