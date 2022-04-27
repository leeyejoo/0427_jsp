package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Member;

public class MemberDAO{
	//DB연결
	private Connection con = DBconn.getConnection();

	
	
	//등록 (insert)
	public int insert(Member member) {
		int cnt=0;
		String sql="insert into member_tbl_02 "
					+ "values ((select nvl(max(custno) +1,1) from member_tbl_02), ?, ?, ?, ?, ?, ?)";
								//자동발권 custno의 max에 +1한 값을 넣어라. 만약 null이라면 1을 집어넣어라
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getCustname());
			pstmt.setString(2, member.getPhone());
			pstmt.setString(3, member.getAddress());
			pstmt.setString(4, member.getJoindate());
			pstmt.setString(5, member.getGrade());
			pstmt.setString(6, member.getCity());
			
			cnt=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}
	
	
	
	
	
	
	
	//수정 (update)
	
	
	
	//삭제 (delete)
	
	
	//한건조회
	public Member selectOne(int custno) {
		Member member = null;
		String sql="select * from member_tbl_02 "
				+ "where custno = ?";
		
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, custno);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String custname=rs.getString("custname");
				String phone=rs.getString("phone");
				String address=rs.getString("address");
				String joindate=rs.getString("joindate");
				String grade=rs.getString("grade");
				String city=rs.getString("city");
				member = new Member(custno, custname, phone, address, joindate, grade, city);
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return member;
	}
	
	
	
	
	
	
	
	//리스트 (list)
	public List<Member> selectList(){
		List<Member> mlist = new ArrayList<>();
		
		String sql ="select custno, custname, phone, address, to_char(joindate,'YYYY-MM-DD') joindate, \r\n"
				+ "         decode(grade, 'A','VIP','B','일반','C','직원') grade, city\r\n"
				+ "from member_tbl_02\r\n"
				+ "order by custno";
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int custno = rs.getInt("custno");
				String custname= rs.getString("custname");
				String phone = rs.getString("phone");
				String address= rs.getString("address");
				String joindate= rs.getString("joindate");
				String grade = rs.getString("grade");
				String city = rs.getString("city");
				Member member = new Member (custno, custname, phone, address, joindate, grade, city);
				
				mlist.add(member);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mlist;
	}
	
	
	
	
}