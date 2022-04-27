<%@page import="s02_member.Membership"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보</title>
<%
	Membership member = (Membership)request.getAttribute("member");
%>
<script type="text/javascript">

	function modifyCheck(){
 		var userid = document.getElementById('userid');
		var passwd = document.getElementById('passwd');
		var name = document.getElementById('name');
		var email = document.getElementById('email');
		
		
		if(passwd.value==''){
			alert('비밀번호를 입력하시오')
			passwd.focus();
		}else if(name.value==''){
			alert('이름을 입력하시오')
			name.focus();
		}else if(email.value==''){
			alert('이메일을 입력하시오')
			email.focus();
		}else{}
		
		//submit
		document.getElementById('frmModify').submit();
		
	}
	
	
	function removeCheck(){
		//확인창 (값은 true, false)
		var result = confirm('정말 삭제하시겠습니까?');
		if (result){
			location.href="/jsp01/Membership/remove?userid=<%=member.getUserid()%>";
		}
		
	}


</script>

</head>
<body>



	
	<h2>회원수정</h2>
	
	<form action="/jsp01/Membership/update" method="post" id="frmModify">
		아이디 <input type="Text" name="userid" id="userid" value="<%=member.getUserid()%>" readonly="readonly"><br>
		비밀번호 <input type="password" name="passwd" id="passwd" value="<%=member.getPasswd() %>"><br>
		이름 <input type="text" name="name" id="name" value="<%=member.getName() %>"><br>
		이메일 <input type="email" name="email" id="email" value="<%=member.getEmail()%>"><br>

		<hr>
		<button type="button" onclick="modifyCheck()">수정</button>
		<button type="button" onclick="removeCheck()">삭제</button>
	</form>
	
	
</body>
</html>