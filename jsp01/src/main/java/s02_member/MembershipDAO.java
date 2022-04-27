package s02_member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//db를 접속하는 클래스
public class MembershipDAO {
	
	//건수반환형 메소드명(매개변수){}
	int insert(Membership membership){
		int cnt=0; //적용건수
		
		//db접속
		Connection con = DBconn.getConnection();
		String sql="insert into membership(userid, passwd, name, email)\r\n"
				+ "Values (?,?,?,?)";
		
		try {	//예외처리
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, membership.getUserid()); //membership안에 있는 userid를 꺼내서 입력
			pstmt.setString(2, membership.getPasswd());
			pstmt.setString(3, membership.getName());
			pstmt.setString(4, membership.getEmail());
			
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;	
	}
	
	
	
	
	//조회리스트 를 반환해주는 메소드
	List<Membership> selectlist(){
		List<Membership> mlist = new ArrayList<>();
		Connection con = DBconn.getConnection();
		String sql = "select * from membership";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs =pstmt.executeQuery();
		
				//rs.next() 다음이 있으면 true, 없으면 false
			while(rs.next()) { 	//false가 될때까지 반복한다. 
				String userid = rs.getString("userid");
				String passwd = rs.getString("passwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Membership membership = new Membership(userid, passwd, name, email); 
						//객체가생성될대 자동으로 실행도는 메소드: 생성자
				mlist.add(membership);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return mlist ; //돌려주는 값이 mlist이다. 
	}
	
	
	
	
	
	
	//한건조회 (userid를 pk로 조회)
	Membership selectOne(String userid) {
		Membership membership=null;
		Connection con = DBconn.getConnection();
		String sql = "select * from membership\r\n"
				+ "where userid=?";
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userid);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				membership = new Membership();
				membership.setUserid(userid);
				membership.setPasswd(rs.getString("passwd"));
				membership.setName(rs.getString("name"));
				membership.setEmail(rs.getString("email"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return membership;
		
	}
	
	
	
	
	
	
	//수정
	int update(Membership membership) {
		int cnt=0;	//적용건수
		
		Connection con =DBconn.getConnection();
		
		String sql ="UPDATE membership\r\n"
				+ "SET passwd=?, name =?, email=?\r\n"
				+ "WHERE userid=?";
		
		try {  //예외처리
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, membership.getPasswd());
			pstmt.setString(2, membership.getName());
			pstmt.setString(3, membership.getEmail());
			pstmt.setString(4, membership.getUserid());
			
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}
	
	
	
	
	
	//삭제
	int delete(String userid) {
		int cnt=0;
		String sql = "DELETE from membership\r\n"
				+ "where userid=?" ;
		Connection con =DBconn.getConnection();
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userid);
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}
	

	
	
	
}
