package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import util.JDBCUtil;
import vo.CourseVO;
import vo.LecturerVO;

public class CourseDAO {
	private static CourseDAO instance = new CourseDAO();
	
	public static CourseDAO getInstance() {
		return instance;
	}
	
	public ArrayList<CourseVO> getCourseList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT c.id, c.name, c.credit, l.name, c.week, c.start_hour, c.end_end FROM course_tbl c, lecturer_tbl l WHERE c.lecturer = l.idx ORDER BY c.id";
		ArrayList<CourseVO> list = new ArrayList<CourseVO>();
		
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				int credit = rs.getInt(3);
				String lecName = rs.getString(4);
				int week = rs.getInt(5);
				int start = rs.getInt(6);
				int end = rs.getInt(7);
				CourseVO vo = new CourseVO(id, name, credit, lecName, week, start, end);
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		
		return list;
	}
	
	public int addCourse(int id, String name, String lecName, int credit, int week, int start, int end) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO course_tbl VALUES(?, ?, ?, ?, ?, ?, ?)";
		int result = -1;
		
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setInt(3, credit);
			pstmt.setString(4, lecName);
			pstmt.setInt(5, week);
			pstmt.setInt(6, start);
			pstmt.setInt(7, end);
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, pstmt, conn);
		}
		
		return result;
	}
	
	public ArrayList<String> getLecturer() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT name FROM lecturer_tbl ORDER BY idx";
		ArrayList<String> list = new ArrayList<String>();
		
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				list.add(rs.getString(1));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		
		return list;
	}
	
	public int updateCourse(int id, String name, int credit, String lecName, int week, int start, int end) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE course_tbl SET name = ?, credit = ?, lecturer = ?, week = ?, start_hour = ?, end_end = ? WHERE id = ?";
		int result = -1;
		
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setInt(2, credit);
			pstmt.setString(3, lecName);
			pstmt.setInt(4, week);
			pstmt.setInt(5, start);
			pstmt.setInt(6, end);
			pstmt.setInt(7, id);
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, pstmt, conn);
		}
		
		return result;
	}
	
	public int deleteCourse(int id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE course_tbl WHERE id = ?";
		int result = -1;
		
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, pstmt, conn);
		}
		
		return result;
	}
}