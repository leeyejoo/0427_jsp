package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dto.MoneyList;

public class MoneyDAO {
	//DB연결
	private Connection con = DBconn.getConnection();

	
	public List<Map<String, Object>> selecList(){
		List<Map<String, Object>> mlist = new ArrayList<>();
		String sql ="SELECT mon.custno, mem.custname,\r\n"
				+ "          decode(mem.grade,'A','VIP','B','일반','C','직원') grade,\r\n"
				+ "          sum(mon.price) price\r\n"
				+ "FROM MONEY_TBL_02 mon join MEMBER_TBL_02 mem on(mon.custno = mem.custno)\r\n"
				+ "GROUP BY mon.custno, mem.custname, mem.grade\r\n"
				+ "ORDER BY price desc";
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int custno = rs.getInt("custno");
				String custname = rs.getString("custname");
				String grade = rs.getString("grade");
				int price = rs.getInt("price");
				
				//map 생성
				
				Map<String, Object> map = new HashMap<>();
				map.put("custno",custno);
				map.put("custname",custname);
				map.put("grade",grade);
				map.put("price",price);
				
				mlist.add(map);	//리스트에 추가
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mlist;
		
	}
}
