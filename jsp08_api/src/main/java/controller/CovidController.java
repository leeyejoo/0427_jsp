package controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Covid;
import service.CovidXMLService;

@WebServlet("*.covid")
public class CovidController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CovidXMLService covidXMLService = new CovidXMLService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String uri = request.getRequestURI();
		System.out.println(uri);
		
		String path =request.getContextPath();
		
		
		if(uri.contains("list")) {
			String startDt = request.getParameter("startDt");
			String endDt = request.getParameter("endDt");
			
			
			
			List<Covid> covidList = new ArrayList<>();
			covidList = covidXMLService.selectList(startDt,endDt); //변수...
			
			
			
			System.out.println(startDt +":" +endDt);
			System.out.println("controller cist :" +covidList);
			
			request.setAttribute("covidList", covidList);
			request.getRequestDispatcher("/view/covidlist.jsp").forward(request, response);
			//forward는 프로젝트 안에서 이동이기 때문에 contextPath 안적어줌!!!!!!!
			
//			System.out.println("-----");
//			System.out.println(covidList);
		
		
		
		
		}else if(uri.contains("dbsave")) {
			//파싱 후 db저장
			String startDt = request.getParameter("startDt");
			String endDt = request.getParameter("endDt");
			
			int cnt = covidXMLService.covidParsing(startDt,endDt);
			
			
			
			//redirect 리스트로 이동
			String msg = URLEncoder.encode(cnt+"건 DB저장","utf-8") ;
			response.sendRedirect(path+"/view/covidlist.jsp?msg="+msg+"&startDt="+startDt+"&endDt="+endDt);
			
			
		}
		
		
	}//get방식

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
