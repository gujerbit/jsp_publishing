package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import util.JDBCUtil;
import vo.MemberVO;
import vo.MoneyVO;

public class MemberDAO {
	private static MemberDAO instance = new MemberDAO();
	
	public static MemberDAO getInstance() {
		return instance;
	}
	
	public int getMaxNo() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT MAX(custno) FROM member_tbl_02";
		int maxNo = 0;
			
		try {
			con = JDBCUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				maxNo = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, pstmt, con);
		}
		
		return maxNo+1;
	}
	
	public String getRegDate() {
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String now = sd.format(date);
		
		return now;
	}
	
	public int insertMember(String custname, String phone, String address, String grade, String city) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO member_tbl_02 VALUES(?, ?, ?, ?, SYSDATE, ?, ?)";
		int result = -1;
		
		try {
			con = JDBCUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, getMaxNo());
			pstmt.setString(2, custname);
			pstmt.setString(3, phone);
			pstmt.setString(4, address);
			pstmt.setString(5, grade);
			pstmt.setString(6, city);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, pstmt, con);
		}
		
		return result;
	}
	
	public ArrayList<MemberVO> getAllMember() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		String sql = "SELECT * FROM member_tbl_02 ORDER BY custno DESC";
		
		try {
			con = JDBCUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MemberVO vo;
				int custno = rs.getInt(1);
				String custname = rs.getString(2);
				String phone = rs.getString(3);
				String address = rs.getString(4);
				Timestamp joinDate = rs.getTimestamp(5);
				String grade = rs.getString(6);
				String city = rs.getString(7);
				vo = new MemberVO(custno, custname, phone, address, joinDate, grade, city);
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, pstmt, con);
		}
		
		return list;
	}
	
	public int updateMember(int id, String name, String phone, String address, String grade, String city) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE member_tbl_02 SET custname = ?, phone = ?, address = ?, grade = ?, city = ? WHERE custno = ?";
		int result = -1;
		
		try {
			con = JDBCUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, phone);
			pstmt.setString(3, address);
			pstmt.setString(4, grade);
			pstmt.setString(5, city);
			pstmt.setInt(6, id);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, pstmt, con);
		}
		
		return result;
	}
	
	public ArrayList<MoneyVO> getAllMoney() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT custno, custname, grade, SUM(price) FROM member_tbl_02 JOIN money_tbl_02 USING(custno) GROUP BY(custno, custname, grade) ORDER BY SUM(price) DESC";
		ArrayList<MoneyVO> list = new ArrayList<MoneyVO>();
		
		try {
			con = JDBCUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MoneyVO vo;
				int custno = rs.getInt(1);
				String custname = rs.getString(2);
				String grade = rs.getString(3);
				int price = rs.getInt(4);
				vo = new MoneyVO(custno, custname, grade, price);
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, pstmt, con);
		}
		
		return list;
	}
}
