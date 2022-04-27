package s02_member;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Connection;

import org.junit.jupiter.api.Test;

class JUnitTest {

	@Test
	void testDBconn() {
		//DBconn을 테스트
		
		Connection con = DBconn.getConnection();
		System.out.println(con);
		assertNotNull(con); //컨넥션이 null하고 같지 않을때 성공
							//conn 참조변수는 주소를 가지고 있다
	}
	
	
	@Test 
	//membershipdao
	void testInsert() {
		//Membership 객체 만들기
		Membership membership = new Membership();
		membership.setUserid("babo11");
		membership.setPasswd("1123");
		membership.setName("김바보");
		membership.setEmail("babo@gmail.com");
		System.out.println(membership); //membership에 저장하고자하는게 들어가있는가?
		
		MembershipDAO mdao = new MembershipDAO();
		int cnt= mdao.insert(membership);
		System.out.println(cnt + "건 추가");
		
		//unique에러가 뜨는 경우 : pk가 겹치기 때문에 !
	}
	
	

}
