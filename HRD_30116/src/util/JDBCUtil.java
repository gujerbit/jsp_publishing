package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCUtil {
	public static Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		return con;
	}
	
	public static void close(ResultSet rs, PreparedStatement pstmt, Connection con) {
		if(rs != null) { try { rs.close(); } catch(Exception e) { e.printStackTrace(); } }
		if(pstmt != null) { try { pstmt.close(); } catch(Exception e) { e.printStackTrace(); } }
		if(con != null) { try { con.close(); } catch(Exception e) { e.printStackTrace(); } }
	}
}
