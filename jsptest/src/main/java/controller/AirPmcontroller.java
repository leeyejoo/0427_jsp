package controller;


import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.AirJSONService;


@WebServlet("/airPM/*")
public class AirPmcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AirJSONService airService = new AirJSONService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		System.out.println(uri);
		
		if(uri.contains("list")) {
			String year = request.getParameter("year");
			List<Map<String, String>> airList = airService.airParsing(year);
			
			request.setAttribute("airList", airList);
			request.getRequestDispatcher("/view/air.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
