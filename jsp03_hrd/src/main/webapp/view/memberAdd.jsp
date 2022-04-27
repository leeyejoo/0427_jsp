<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>add</title>
	<script type="text/javascript">
		//메세지 창 띄우기
		if ('<%=request.getParameter("msg")%>' != 'null' )
			alert('<%=request.getParameter("msg")%>');
	
		function addCheck(){
			var custno = frmAdd.custno;
			var custname = frmAdd.custname;
			var phone = frmAdd.phone;
			var address = frmAdd.address;
 			var joindate = frmAdd.joindate;
			var grade = frmAdd.grade;
			var city = frmAdd.city;
		
			
			if(custname.value == ''){
				alert('회원성명이 입력되지 않았습니다.');
				custname.focus();
			}else if(phone.value ==''){
				alert('회원전화가 입력되지 않았습니다.');
				phone.focus();
			}else if(address.value ==''){
				alert('회원주소 가 입력되지 않았습니다.');
				address.focus();
			}else if(joindate.value ==''){
				alert('가입일자가 입력되지 않았습니다.');
				joindate.focus();
			}else if(grade.value==''){
				alert('회원등급이 입력되지 않았습니다.');
				grade.focus();
			}else if(city.value==''){
				alert('도시코드가 입력되지 않았습니다.');
				city.focus();
			}else {
				//submit
				document.getElementById('frmAdd').submit();
			}


		}
		
	
	</script>




</head>
<body>
	<%@include file="header.jsp" %>
	<h2>홈쇼핑 회원 등록</h2>
	
	<form action="/jsp03_hrd/view/member/add" name="frmAdd" id="frmAdd">
		<table border="1">
			<tr>
				<th>회원번호(자동발행)</th>
				<td><input type="number" name="custno" readonly="readonly" value="112"></td>
			</tr>
			<tr>
				<th>회원성명</th>
				<td><input type="text" name="custname"></td>
			</tr>
			<tr>
				<th>회원전화</th>
				<td><input type="tel" name="phone"></td>
			</tr>		
			<tr>
				<th>회원주소</th>
				<td><input type="text" name="address"></td>
			</tr>			
			<tr>
				<th>가입일자</th>
				<td><input type="date" name="joindate"></td>
			</tr>		
			<tr>
				<th>고객등급</th>
				<td>
					<select name="grade">
						<option value="A">A: VIP</option>
						<option value="B">B: 일반</option>
						<option value="C">C: 직원</option>
					</select>
			</tr>			
			<tr>
				<th>도시코드</th>
				<td><input type="text" name="city"></td>
			</tr>
			<tr>
				<td colspan="2" align="center" >
					<button type="button" onclick="addCheck()" >등록</button>
					<button>조회</button>
				</td>
			</tr>
		</table>
	</form>
	
		<%@include file="footer.jsp" %>
</body>
</html>