package dao;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import dto.Covid;

public class CovidDAO {
	
	public int insert(List<Map<String, String>> covidList) {
	//covidlist를 매개변수를 받아서 insert를 반복
	//여러건의 covid 
		int cnt =0; //저장건수
		SqlSession session = MBConn.getSession();
		try {
			for(Map<String, String> covid: covidList) {
				
				try {
				    cnt += session.insert("CovidMapper.insert", covid);
				   
				}catch (Exception e) {
					System.out.println(covid.get("seq")+" 예외발생");
					//예외발생시 수정
					cnt += session.update("CovidMapper.update", covid);
					
					e.printStackTrace();
					
				}
				
			}
		}finally {
			// 예외 발생이 되든안되든 실행 (여러건 insert후 commit을 한번만)
			session.commit(); //JDBC인 경우 commit을 해줘야함.
							  //mybatisConfig의 transactionManager => jdbc
			session.close();
		
		}

		return cnt;
	}
	
	
	//코로나 확진자 리스트
	public List<Covid> selectList(Map<String, String> map){
		try(SqlSession session = MBConn.getSession()){
			return session.selectList("CovidMapper.selectList",map);
		}
	}
	
	
	
	
	
}
