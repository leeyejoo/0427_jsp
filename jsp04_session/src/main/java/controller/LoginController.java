package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.LoginService;

//확장자 패턴 매핑
@WebServlet("*.log")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	//service 객체생성
	private LoginService loginservice = new LoginService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String uri =request.getRequestURI();
		System.out.println(uri);
	
		if(uri.contains("login")) {
			String userid = request.getParameter("userid");
			String passwd = request.getParameter("passwd");
			System.out.println(userid+' '+passwd);
			
			//서비스 호출
			String msg = loginservice.loginCheck(userid, passwd);
		
			//로그인으로 이동
		}
		
		
		
	
	
	}// doget

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
