<%@page import="dto.Member"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>멤버리스트</title>
</head>
<body>
	<%@include file="header.jsp" %>
	<section>
	<%
		List<Member> mlist = ( List<Member>)request.getAttribute("mlist");
	%>
	
	<h2>회원목록조회/수정</h2>
	 
	 
	<table border="1">
		<tr>
			<th align="center">회원번호</th>
			<th align="center">회원성명</th>
			<th align="center">전화번호</th>
			<th align="center">주소</th>
			<th align="center">가입일자</th>
			<th align="center">고객등급</th>
			<th align="center">거주지역</th>
		</tr>
<%
		if (mlist !=null){
			for(Member member: mlist){
%>
				<tr>
					<td><a href="/jsp03_hrd/member/modiform?custno=<%=member.getCustno()%>"><%= member.getCustno() %></a></td>
					<td><%= member.getCustname() %></td>
					<td><%= member.getPhone() %></td>
					<td><%= member.getAddress() %></td>
					<td><%= member.getJoindate() %></td>
					<td><%= member.getGrade() %></td>
					<td><%= member.getCity() %></td>
				</tr>
<%
			}
		}


%>
	</table>
	
	
	</section>
	<%@include file="footer.jsp" %>
</body>
</html>