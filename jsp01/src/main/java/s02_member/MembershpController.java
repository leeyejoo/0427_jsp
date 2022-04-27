package s02_member;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Membership/*") //contextpath 쓸 필요 없다. 
		// 디렉토리 패턴
		// *의 뜻 : membership으로 시작하는 모든것을 가져올 수 있음. 
public class MembershpController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//인코딩변경
		request.setCharacterEncoding("utf-8");
		String uri= request.getRequestURI();
		System.out.println(uri);
		
		
	
		
		if (uri.contains("insert")) { 	//join처리를 하기 위한 문장
			
			System.out.println("가입");
			//view 데이터 읽기
			String userid = request.getParameter("userid");
			String passwd = request.getParameter("passwd");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			
			//멤버객체생성하고 초기화
			Membership membership = new Membership(userid,passwd,name,email);
			System.out.println(membership);
			
			//DAO객체 생성 (controller와 Dao 연결)
			MembershipDAO mdao = new MembershipDAO();
			int cnt = mdao.insert(membership); 
			System.out.println(cnt+"건 추가");
		
			
			// 회원가입 완료 메세지를 view에 보내기
			//0329_01_insert.jsp
			String msg= cnt+"건 추가";
			
			//redirect
			msg = URLEncoder.encode(msg,"utf-8");
			response.sendRedirect("/jsp01/view/03db/0329_01_insert.jsp?msg="+msg);
			
			
			
			
			
			
		}else if (uri.contains("selectlist")) {		//조회리스트 사용 
			MembershipDAO mdao = new MembershipDAO(); 
			List<Membership> mlist = mdao.selectlist();	
			System.out.println(mlist);
			
			//0330_02_selectlist.jsp로 이동
			//대량정보이기 때문에 forward전송으로
			request.setAttribute("mlist", mlist);	 //어떤 형이든 저장가능(Object)
			request.getRequestDispatcher("/view/03db/0330_02_selectlist.jsp").forward(request, response);
										 //contextpath X

	
			
			
			
			
		}else if (uri.contains("modify")) {			//수정폼으로 이동
			
			//한건 조회
			String userid = request.getParameter("userid");
			System.out.println(userid);
			MembershipDAO mdao = new MembershipDAO();
			Membership member = mdao.selectOne(userid);
			System.out.println(member);
			
			
			//forward 이동 (대량의 데이터)
			//0330_03_update.jsp
			request.setAttribute("member",member);
			request.getRequestDispatcher("/view/03db/0330_03_update.jsp").forward(request, response);

			
			
			
			
			
			
		}else if (uri.contains("update")) {			//최종수정
			String userid=request.getParameter("userid");
			String passwd=request.getParameter("passwd");
			String name=request.getParameter("name");
			String email=request.getParameter("email");

			//멤버객체
			Membership membership = new Membership(userid, passwd, name, email); 
			membership.setUserid(userid);
			membership.setPasswd(passwd);
			membership.setName(name);
			membership.setEmail(email);
			System.out.println(membership);
			
			//DAO연결
			MembershipDAO mdao = new MembershipDAO();
			int cnt = mdao.update(membership);			
			System.out.println(cnt);
			
			//redirect이동(조회로..)
			response.sendRedirect("/jsp01/Membership/selectlist");
		
		
		
		
		
		}else if (uri.contains("remove")) { //삭제
			String userid = request.getParameter("userid");
			
			MembershipDAO mdao = new MembershipDAO();
			int cnt = mdao.delete(userid);
			System.out.println(cnt+"삭제");
			response.sendRedirect("/jsp01/Membership/selectlist");
			
			
			
		}
		
		
		
		
		
		
	
	} 	//doGet
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
