package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import util.JDBCUtil;
import vo.BookVO;
import vo.MemberVO;

public class MemberDAO {
	private static MemberDAO instance = new MemberDAO();
	
	public static MemberDAO getInstance() {
		return instance;
	}
	
	public int getMaxNo() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT MAX(custno) FROM mem_tbl_book";
		int max = 0;
		
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				max = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		
		return max;
	}
	
	public String getDate() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String now = formatter.format(date);
		
		return now;
	}
	
	public int RegisterMember(int custno, String custname, String grade, String address) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO mem_tbl_book VALUES(?, ?, SYSDATE, ?, ?)";
		int result = -1;
		
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, custno);
			pstmt.setString(2, custname);
			pstmt.setString(3, grade);
			pstmt.setString(4, address);
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, pstmt, conn);
		}
		
		return result;
	}
	
	public ArrayList<MemberVO> getAllMember() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM mem_tbl_book ORDER BY custno";
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MemberVO vo = null;
				int custno = rs.getInt(1);
				String custname = rs.getString(2);
				Timestamp joindate = rs.getTimestamp(3);
				String grade = rs.getString(4);
				String address = rs.getString(5);
				vo = new MemberVO(custno, custname, joindate, grade, address);
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		
		return list;
	}
	
	public MemberVO getMember(int inputCustno) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM mem_tbl_book WHERE custno = ?";
		MemberVO vo = null;
		
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, inputCustno);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int custno = rs.getInt(1);
				String custname = rs.getString(2);
				Timestamp joindate = rs.getTimestamp(3);
				String grade = rs.getString(4);
				String address = rs.getString(5);
				vo = new MemberVO(custno, custname, joindate, grade, address);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		
		return vo;
	}
	
	public int updateMember(int custno, String custname, String grade, String address) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE mem_tbl_book SET custname = ?, grade = ?, address = ? WHERE custno = ?";
		int result = -1;
		
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, custname);
			pstmt.setString(2, grade);
			pstmt.setString(3, address);
			pstmt.setInt(4, custno);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, pstmt, conn);
		}
		
		return result;
	}
	
	public ArrayList<BookVO> getMemberTotal() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT custno, custname, COUNT(custno) FROM mem_tbl_book JOIN rent_tbl_book USING(custno) GROUP BY(custno, custname) ORDER BY COUNT(custno) DESC";
		ArrayList<BookVO> list = null;
		
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int custno = rs.getInt(1);
				String custname = rs.getString(2);
				int memberTotal = rs.getInt(3);
				BookVO vo = new BookVO(custno, 0, custname, memberTotal, 0);
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		
		return list;
	}
	
	public ArrayList<BookVO> getBookTotal() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT bookno, COUNT(bookno) FROM mem_tbl_book JOIN rent_tbl_book USING(custno) GROUP BY(bookno, custname) ORDER BY COUNT(bookno) DESC";
		ArrayList<BookVO> list = null;
		
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int bookno = rs.getInt(1);
				int bookTotal = rs.getInt(2);
				BookVO vo = new BookVO(0, bookno, null, 0, bookTotal);
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		
		return list;
	}
	
	public ArrayList<BookVO> memberBookTotal(ArrayList<BookVO> list1, ArrayList<BookVO> list2) {
		ArrayList<BookVO> list = new ArrayList<BookVO>();
		BookVO vo = null;
		
		for(int i = 0; i < list1.size(); i++) {
			int custno = list1.get(i).getCustno();
			int bookno = list2.get(i).getBookno();
			String custname = list1.get(i).getCustname();
			int memberTotal = list1.get(i).getMemberTotal();
			int bookTotal = list2.get(2).getBookTotal();
			vo = new BookVO(custno, bookno, custname, memberTotal, bookTotal);
			list.add(vo);
		}
		
		return list;
	}
}