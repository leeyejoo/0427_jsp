package controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CulturalEventService;

@WebServlet("/cultural/*")
public class culturalEventController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CulturalEventService culturalService = new CulturalEventService();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String contextPath = request.getContextPath();
		
		String uri = request.getRequestURI();
		System.out.println(uri);
		
		if(uri.contains("list")) {
			String codename = request.getParameter("codename");
			List<Map<String, String>> culturalList = culturalService.culturalParsing(codename);
			
			request.setAttribute("culturalList",culturalList);
			request.getRequestDispatcher("/view/culturalEvent.jsp").forward(request, response);
			
		
		
		
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
