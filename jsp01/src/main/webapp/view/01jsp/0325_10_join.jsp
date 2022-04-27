<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JOIN </title>
	<style>
	@font-face {
    font-family: 'NeoDunggeunmo';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2001@1.3/NeoDunggeunmo.woff') format('woff');
    font-weight: normal;
    font-style: normal;
	}

	*{
	font-family : 'NeoDunggeunmo';
	color : white;
	background-color : blue;
	}	
	</style>

</head>
<body>
	<h2>회원가입</h2>
	
	<!-- 입력항목
		 아이디, 비밀번호, 이메일, 이름, 성별(radio), 가입경로(select),
		 알바가능 시간대(checkbox)
		
		 버튼을 눌렀을때 결과창에 가입정보 출력  -->
	  
	  <form action="0325_10_result.jsp"  method="post" >
	  <fieldset class="box">
	 	아이디 <input type="text" name=userid><br>
	 	비밀번호 <input type="password" name="userpw"><br>
	 	이메일 <input type="email" name="useremail"><br>
		
		<hr>
		이름 <input type="text" name="username"><br>
		성별 <input type="radio" name="usergender" value="남">남 
			 <input type="radio" name="usergender" value="여">여
	  </fieldset>
	  <fieldset class="box">
	  	가입경로 <select name="sPath">
	  				<option>검색</option>
	  				<option>광고</option>
	  				<option>지인추천</option>
	  				<option>커뮤니티게시판</option>
	  				<option>기타</option>
	  			 </select><br>
	  	알바가능 시간대 <input type="checkbox" name="time" value="오전"> 오전
	  			 		<input type="checkbox" name="time" value="오후"> 오후
	  			 		<input type="checkbox" name="time" value="저녁"> 저녁
	  			 		<input type="checkbox" name="time" value="새벽"> 새벽
	  			 
	  </fieldset>
	  
	  <button>가입</button> <button type="reset">취소</button>
	  </form>
	  
	  
	  
	  
	  
</body>
</html>