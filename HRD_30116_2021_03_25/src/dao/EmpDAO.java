package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import util.JDBCUtil;
import vo.EmpVO;
import vo.SalaryVO;

public class EmpDAO {
	private static EmpDAO instance = new EmpDAO();
	
	public static EmpDAO getInstance() {
		return instance;
	}
	
	public int getNextNo() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT MAX(empno) FROM employee_tbl";
		int nextNo = 0;
		
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) nextNo = rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		
		return nextNo+1;
	}
	
	public String getNow() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String now = formatter.format(date.getTime());
		
		return now;
	}
	
	public ArrayList<EmpVO> getAllEmpList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM employee_tbl ORDER BY empno";
		ArrayList<EmpVO> list = new ArrayList<EmpVO>();
		
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				EmpVO vo = new EmpVO(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getString(5));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		
		return list;
	}
	
	public int empRegister(int empNo, String empName, String rank, String dept) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO employee_tbl VALUES(?, ?, SYSDATE, ?, ?)";
		int result = 0;
		
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, empNo);
			pstmt.setString(2, empName);
			pstmt.setString(3, rank);
			pstmt.setString(4, dept);
			result = pstmt.executeUpdate();
			
			sql = "INSERT INTO salary_tbl VALUES(?, SYSDATE, 0)";
			pstmt.close();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, empNo);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, pstmt, conn);
		}
		
		return result;
	}
	
	public int empUpdate(int empNo, String empName, String rank, String dept) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE employee_tbl SET empname = ?, rank = ?, dept = ? WHERE empNo = ?";
		int result = 0;
		
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, empName);
			pstmt.setString(2, rank);
			pstmt.setString(3, dept);
			pstmt.setInt(4, empNo);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, pstmt, conn);
		}
		
		return result;
	}
	
	public ArrayList<SalaryVO> getAllSalList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT e.empno, e.empname, SUM(s.pay) FROM employee_tbl e, salary_tbl s WHERE e.empno = s.empno GROUP BY(e.empno, e.empname) ORDER BY SUM(s.pay) DESC";
		ArrayList<SalaryVO> list = new ArrayList<SalaryVO>();
		
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				SalaryVO vo = new SalaryVO(rs.getInt(1), rs.getString(2), rs.getInt(3));
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