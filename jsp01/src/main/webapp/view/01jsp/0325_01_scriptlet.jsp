<!-- 주석: ctrl + shift + /
주석해제 : ctrl + shift + \
page지시자 : jsp페이지의 속성 -->



<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style type="text/css">
	#plus{
		color: #ff9966;
	}
	#minus{
		color: blue;
	}
	</style>
	



	<script type="text/javascript">
/* 		alert('반가워 jsp') */	
	</script>
</head>
<body>
	<h2>스크립틀릿</h2>
	<%
	/*	스크립틀릿은 자바로 동적인 웹페이지 구현 */
	/* 		자바코드는 톰캣(컨테이너)이 자동으로 클래스 (메소드)로 변환후 해석 + html응답을 보낸다.
 	*/	
		System.out.println("헬로우 sjp");
	
	
		// 자바에서 dom을 다루기 위한 내장객체
		out.println("dom에 출력 <br>");
		out.println("out객체는 dom을 다룰 수 있습니다. <br>");
		//pirntln을 한다고 해서 화면에서 다음줄로 넘어가지 않는다. => <br>을 같이 출력해주기 
		//그러면 어디에서 개행? 소스 코드
		out.println("<hr>");
		
	
		for(int i=1; i<11; i++){
			System.out.println(i);
			out.print(i+"<br>");	//dom에다가 1~10까지 출력
		}
		
		out.println("<hr>");

		
		//양수음수출력
		int a=-101;
		
		if(a>0){
			out.println("<span id='plus'>dom- 양수입니다.</span>");
			System.out.println("콘솔- 양수입니다");
		}else if (a<0) {
			out.println("<span id='minus'>dom- 음수입니다.</span>");
			System.out.println("콘솔- 음수입니다");
		}else{
			out.println("dom- 0입니다");
			System.out.println("콘솔- 0입니다");
		}
		
		
		//삼항연산자로 양음수 출력
		String s = a>0?"양수":"음수";
		out.println(s);
		
		int b=1;
		b=12;
		
		
	%>
	
</body>
</html>