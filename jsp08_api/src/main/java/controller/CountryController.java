package controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CountryJSONService;

@WebServlet("*.country")
public class CountryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CountryJSONService countryService = new CountryJSONService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri =request.getRequestURI();
		System.out.println(uri);
		
		if(uri.contains("list")) {
			String iso = request.getParameter("iso");
			List<Map<String, String>> clist = countryService.countryParsing(iso);
			
			
			request.setAttribute("clist", clist);
			request.getRequestDispatcher("/view/countrylist.jsp").forward(request, response);
			
			
		}else if(uri.contains("jspform")) {
			//countryList.jsp로 이동
			
			//ISO를 조회
			List<Map<String, String>> isolist = countryService.selectList_iso();
			System.out.println(isolist);
			
			request.setAttribute("isolist", isolist);
			request.getRequestDispatcher("/view/countrylist.jsp").forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
