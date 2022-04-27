package controller;


import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.AirPM;
import service.AirPMService;


@WebServlet("/airPM/*")
public class AirPmcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AirPMService airPMService = new AirPMService();
	 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getContextPath();
		String uri = request.getRequestURI();
		System.out.println(uri);
		
		if(uri.contains("dbsave")) {
			String year = request.getParameter("year");
			int cnt = airPMService.airParsing(year);
			
//			request.setAttribute("alist", alist);
//			request.getRequestDispatcher("/view/airPMlist.jsp").forward(request, response);
			String msg = URLEncoder.encode(cnt+"건저장","utf-8");
			response.sendRedirect(path+"/view/airPMlist.jsp?msg="+msg+"&year="+year);
		
			
			
		}else if (uri.contains("list")) {
			String year = request.getParameter("year");
			
			List<AirPM> alist = airPMService.selectList(year);
			
			System.out.println(alist);
			request.setAttribute("alist", alist);
			request.getRequestDispatcher("/view/airPMlist.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
