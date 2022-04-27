package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.Member;

public class MemberDAO {
	private Connection con = DBconn.getConnection();
	
	//한건조회
	public Member selectOne(String userid) {
		Member member=null;
		String sql = "select userid, passwd from membership\r\n"
				+ "where userid=?";
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return member;
	}
}
