package s01;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//MAPPING 
//어노테이션 매핑방법 사용
@WebServlet("/J0328_01")	//서블릿은 context path 제외
public class J0328_01 extends HttpServlet{

	@Override //get방식으로 호출했을땐 여기
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		System.out.println(uri);
	}

	@Override //post방식으로 호출했을땐 여기
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp); 	//post방식과 get방식이 처리하는건 같기 때문에 doGet을 해준다
	}
	
	
	
	
}
