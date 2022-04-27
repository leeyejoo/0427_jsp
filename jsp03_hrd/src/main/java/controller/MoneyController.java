package controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MoneyDAO;


@WebServlet("/money/*")
public class MoneyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MoneyDAO mondao = new MoneyDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");	//post방식으로 넘길때 인코딩
		String uri =request.getRequestURI();
		System.out.println(uri);
		
		
		//회원매출조회
		if (uri.contains("list")) {
			//dao호출
			List<Map<String,Object>> mlist = mondao.selecList()	;
			System.out.println(mlist);
			
			request.setAttribute("mlist", mlist);
			request.getRequestDispatcher("/view/moneyList.jsp").forward(request, response);
			
		}
		
		
		
	}


	
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
