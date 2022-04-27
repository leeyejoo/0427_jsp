package controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.SendResult;

import dao.MemberDAO;
import dto.Member;

@WebServlet("/member/*")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberDAO memdao = new MemberDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");	//post방식으로 넘길때 인코딩
		String uri =request.getRequestURI();
		System.out.println(uri);
		
		
		//게시물 등록
		if(uri.contains("add")) {
//			int custno = Integer.parseInt(request.getParameter("custno"));
			// 자동발권이기 때문에 사용 X 
			String custname = request.getParameter("custname");
			String phone = request.getParameter("phone");
			String address = request.getParameter("address");
			String joindate = request.getParameter("joindate");
			String grade = request.getParameter("grade");
			String city = request.getParameter("city");
			
			//회원(member)객체생성 (생성자로)
			Member member = new Member(custname,phone,address,joindate,grade, city);
			System.out.println(member);
			//
			//MemberDAO memdao = new MemberDAO();
			int cnt = memdao.insert(member);
			System.out.println(cnt);
			
//			request.setAttribute("msg", "회원등록이 완료되었습니다.");
//			request.getRequestDispatcher("/view/memberAdd.jsp").forward(request, response);
	
			//redirect방법으로..
			String contextPath =request.getContextPath();
			System.out.println(contextPath);
			
			String msg = URLEncoder.encode("회원등록이 완료되었습니다.","utf-8");
			response.sendRedirect(contextPath+"/view/memberAdd.jsp?msg="+msg);
		
		
		
			
		//리스트
		}else if (uri.contains("list")) {
			//dao를 호출
			List<Member> mlist = memdao.selectList();
			
			//forward방식
			request.setAttribute("mlist", mlist);
			request.getRequestDispatcher("/view/memberList.jsp").forward(request, response);
		
		
		
		
		
		
		
		//수정폼으로 이동
		}else if (uri.contains("modiform")) {
			//수정폼으로
			int custno = Integer.parseInt(request.getParameter("custno"));
			//한건조회(dao호출)
			Member member = memdao.selectOne(custno);
			System.out.println(member);
			request.setAttribute("member", member);
			request.getRequestDispatcher("/view/memberModify.jsp").forward(request, response);
		
			
			
			
		
		}
		
		
	
		
		
		
	} //doGet
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
