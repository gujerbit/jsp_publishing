package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import util.JDBCUtil;
import vo.MemberVO;

public class MemberDAO {
	private static MemberDAO instance = new MemberDAO();
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public static MemberDAO getInstance() {
		return instance;
	}

	public ArrayList<MemberVO> getIdMemberList(String id) {
		ArrayList<MemberVO> list = new ArrayList<>();
		String sql = "SELECT * FROM personnel WHERE id = ? ORDER BY id";

		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String resultId = rs.getString(1);
				String name = rs.getString(2);
				String dept = rs.getString(3);
				String position = rs.getString(4);
				String duty = rs.getString(5);
				String phone = rs.getString(6);
				MemberVO vo = new MemberVO(resultId, name, dept, position, duty, phone);
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, pstmt, conn);
		}

		return list;
	}

	public ArrayList<MemberVO> getDeptMemberList(String dept) {
		ArrayList<MemberVO> list = new ArrayList<>();

		String sql = "SELECT * FROM personnel WHERE dept = ? ORDER BY id";

		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dept);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String id = rs.getString(1);
				String name = rs.getString(2);
				String resultDept = rs.getString(3);
				String position = rs.getString(4);
				String duty = rs.getString(5);
				String phone = rs.getString(6);
				MemberVO vo = new MemberVO(id, name, resultDept, position, duty, phone);
				list.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, pstmt, conn);
		}

		return list;
	}

	public int setMember(String id, String name, String dept, String position, String duty, String phone) {
		int result = -1;

		String sql = "INSERT INTO personnel VALUES(?, ?, ?, ?, ?, ?)";

		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, dept);
			pstmt.setString(4, position);
			pstmt.setString(5, duty);
			pstmt.setString(6, phone);
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, pstmt, conn);
		}

		return result;
	}

	public int updateMember(String id, String name, String dept, String position, String duty, String phone) {
		int result = -1;

		String sql = "UPDATE personnel SET name = ?, dept = ?, position = ?, duty = ?, phone = ? WHERE id = ?";

		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, dept);
			pstmt.setString(3, position);
			pstmt.setString(4, duty);
			pstmt.setString(5, phone);
			pstmt.setString(6, id);
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, pstmt, conn);
		}

		return result;
	}
	
	public int deleteMember(String id, String name) {
		int result = -1;

		String sql = "DELETE FROM personnel WHERE id = ? AND name = ?";

		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		
		return result;
	}
}