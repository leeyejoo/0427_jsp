package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import dto.AirPM;

public class AirPMDAO {
	
	public int insert(List<Map<String, String>> alist) {
		int cnt=0;
		
		SqlSession session = MBConn.getSession();
		try {
			for(Map<String, String> airPM : alist)
				try {
					cnt += session.insert("AirPMMapper.insert", airPM);
				}catch (Exception e) {
					cnt += session.update("AirPMMapper.update", airPM);
					System.out.println("sn 중복");
					
					//e.printStackTrace(); 
				}
		} finally {
			session.commit(); 
			session.close();
		
		}
		

		return cnt;

	}
	
	
	public List<AirPM> selectList(Map<String, String> map){
		try(SqlSession session = MBConn.getSession()){
			return session.selectList("AirPMMapper.seletList",map);
		}
	}
	

}
	

