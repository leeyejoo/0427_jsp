package dao;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MBConn {
	//mybatis db접속, 세션을 반환하는 메소드
	public static SqlSession getSession() {
		SqlSession session = null;
		String resource ="mybatis/mybatisConfig.xml";	//xml(환경설정파일) 이 있는 주소
		try {
			InputStream is =	Resources.getResourceAsStream(resource);
			//팩토리객체 생성 (세션을 만들어낼 수 있는 객체)
			SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(is);
			session = sf.openSession();
			//System.out.println("session생성 성공");
		} catch (IOException e) {
			System.out.println("mybatis 환경설정 읽기 실패");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return session;
	}
}
