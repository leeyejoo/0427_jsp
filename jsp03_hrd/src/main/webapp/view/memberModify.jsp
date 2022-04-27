<%@page import="dto.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원수정</title>
<script type="text/javascript">

	function modiCheck() {
		var custno = frmModi.custno;
	}


</script>

</head>
<body>
<%@include file="header.jsp" %>	
	
	<%
		Member member = (Member)request.getAttribute("member");
	%>

<section>
	<h2>홈쇼핑 회원 정보 수정</h2>
	<form action="" method="post" name="frmModi">
				<table border="1">
			<tr>
				<th>회원번호(자동발행)</th>
				<td><input type="number" name="custno" readonly="readonly" value="<%= member.getCustno()%>"></td>
			</tr>
			<tr>
				<th>회원성명</th>
				<td><input type="text" name="custname" value=<%=member.getCustname() %>></td>
			</tr>
			<tr>
				<th>회원전화</th>
				<td><input type="tel" name="phone" value= "<%=member.getPhone() %>"></td>
			</tr>		
			<tr>
				<th>회원주소</th>
				<td><input type="text" name="address" value="<%=member.getAddress() %>" ></td>
			</tr>			
			<tr>
				<th>가입일자</th>
				<td><input type="date" name="joindate" <%=member.getJoindate() %>></td>
			</tr>		
			<tr>
				<th>고객등급</th>
				<td>
					<select name="grade" value="<%=member.getGrade()%>">
						<option value="A">A: VIP</option>
						<option value="B">B: 일반</option>
						<option value="C">C: 직원</option>
					</select>
			</tr>			
			<tr>
				<th>도시코드</th>
				<td><input type="text" name="city" valu="<%=member.getCity()%>"></td>
			</tr>
			<tr>
				<td colspan="2" align="center" >
					<button type="button" onclick="modiCheck()" >수정</button>
					<button>조회</button>
				</td>
			</tr>
		</table>
	
	
	</form>
</section>
<%@include file="footer.jsp" %>	
</body>
</html>