package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCUtil {
	public static Connection getConnection() throws Exception {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String pass = "hr";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection(url, user, pass);
		
		return conn;
	}
	
	public static void close(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		if(rs != null) { try { rs.close(); } catch(Exception e) { e.printStackTrace(); } }
		if(pstmt != null) { try { pstmt.close(); } catch(Exception e) { e.printStackTrace(); } }
		if(conn != null) { try { conn.close(); } catch(Exception e) { e.printStackTrace(); } }
	}
}
