package s02_member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//db 컨넥션을 반환하는 메소드
public class DBconn {
	static Connection getConnection() {
		//static :정적 메소드
		
		//반환행이 connection
		Connection con=null;
		
		//url, user, passwoard
		String url ="jdbc:oracle:thin:@localhost:1521:xe";
		String user ="hr";
		String password="hr";
		
		
		//오라클드라이버 로딩 + 예외처리
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			
			//컨넥션 객체 생성
			con = DriverManager.getConnection(url,user,password);
			System.out.println("컨넥션 완료");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("드라이버로딩실패");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("접속실패");
			e.printStackTrace();
		}
		
		
		
		return con; 
	}
}