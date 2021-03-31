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
	
	public int deleteLecturer(int idx) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM lecturer_tbl WHERE idx = ?";
		int result = -1;
		
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, pstmt, conn);
		}
		
		return result;
	}
	
	public int getNextIdx() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT MAX(idx) FROM lecturer_tbl";
		int nextNo = 0;
		
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				nextNo = rs.getInt(1) + 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		
		return nextNo;
	}
	
	public int addLecturer(int idx, String name, String major, String field) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO lecturer_tbl VALUES(?, ?, ?, ?)";
		int result = -1;
		
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			pstmt.setString(2, name);
			pstmt.setString(3, major);
			pstmt.setString(4, field);
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, pstmt, conn);
		}
		
		return result;
	}
}