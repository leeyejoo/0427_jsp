<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>insert회원가입</title>
<script type="text/javascript">

	//메세지가 null이 아닐때 알림창
	/* null에 반드시 '따옴표' 해줘야함.. 아니면 변수취급된다.. */

	if('<%= request.getParameter("msg") %>' != 'null'){ 
		alert('<%= request.getParameter("msg") %>');
	}
	
	//메세지가 null일때 알림창
	//가입시, 유효성 체크
	function joinCheck() {
		var userid = document.getElementById('userid');
		var passwd = document.getElementById('passwd');
		var name = document.getElementById('name');
		var email = document.getElementById('email');
	
		console.log(userid);
		
		if (userid.value==''){
			alert('아이디를 입력해 주세요!')
			userid.focus();
			return; //함수를 종료함 ; 사용 안해도 무관
		}else if (passwd.value==''){
			alert('비밀번호를 입력해 주세요!')
			passwd.focus();
			return;
		}else if (name.value==''){	
			alert('이름을 입력해 주세요!')
			name.focus();
			return;
		}else if (email.value==''){
			alert('이메일을 입력해 주세요!')
			email.focus();
			return; //return이 없다면 else를 써줘야 함... 
		}
		
		
		//submit(form을 제출)
		document.getElementById('frmjoin').submit();
	}
	

	
	
	
</script>
</head>
<body>
	<!-- s02_membership view -->

	<h2>회원가입</h2>
				<!-- /Membership/insert는 매핑한 이름 -->
	<form action="/jsp01/Membership/insert" method="post" id="frmjoin">
		아이디 <input type="Text" name="userid" id="userid"><br>
		비밀번호 <input type="password" name="passwd" id="passwd"><br>
		이름 <input type="text" name="name" id="name"><br>
		이메일 <input type="email" name="email" id="email"><br>

		<hr>
		<button type="button" onclick="joinCheck()">가입</button>
		<button type="button" onclick="location.href='/jsp01/Membership/selectlist';">목록</button>
	</form>
	<%
		if (request.getParameter("msg") != null){
	%>
			<%=request.getParameter("msg") %>
	<%
		}
	%>
	
	
	
	
</body>
</html>