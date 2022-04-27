package service;

import dao.MemberDAO;
import dto.Member;

//컨트롤러와 dao를 연결
//비지니스 로직 처리
public class LoginService {
	//dao객체 생성
	private MemberDAO mdao = new MemberDAO();
	
	public String  loginCheck(String userid, String passwd) {
		String msg = null;
		
		//dao호출
		//1) userid를 기준으로 한건조회(selectOne)
		Member member = mdao.selectOne(userid);
		
		//2) 만약에 결과(return값이 null)이라면 회원이 존재하지 않는다는 뜻
		if (member == null) {
			msg = "회원이 존재하지 않습니다.";
			return msg;
		}
		
		//3) 만약에 userid가 null이 아니라면 패스워드 일치여부 확인
		//		만약에 패스워드가 일치한다면 로그인성공
		if (member.getPasswd())
		{
			
		}
		
		
		
		return msg;
	}
}
