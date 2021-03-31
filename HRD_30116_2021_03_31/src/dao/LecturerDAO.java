package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import util.JDBCUtil;
import vo.LecturerVO;

public class LecturerDAO {
	private static LecturerDAO instance = new LecturerDAO();
	
	public static LecturerDAO getInstance() {
		return instance;
	}
	
	public ArrayList<LecturerVO> getLecturerList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM lecturer_tbl ORDER BY idx";
		ArrayList<LecturerVO> list = new ArrayList<LecturerVO>();
		
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			System.out.println("a");
			
			while(rs.next()) {
				String idx = rs.getString(1);
				String name = rs.getString(2);
				String major = rs.getString(3);
				String field = rs.getString(4);
				LecturerVO vo = new LecturerVO(idx, name, major, field);
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		
		return list;
	}
}
