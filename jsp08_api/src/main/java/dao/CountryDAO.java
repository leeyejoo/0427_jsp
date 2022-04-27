package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class CountryDAO {

	public List<Map<String, String>> selectList_iso() {
		try(SqlSession session = MBConn.getSession()){
			return session.selectList("CountryMapper.selectList_iso");
		}
	}
	
}