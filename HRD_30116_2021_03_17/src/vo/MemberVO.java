package vo;

import java.sql.Timestamp;

public class MemberVO {
	private int custno;
	private String custname;
	private Timestamp joindate;
	private String grade;
	private String address;
	
	public MemberVO(int custno, String custname, Timestamp joindate, String grade, String address) {
		this.custno = custno;
		this.custname = custname;
		this.joindate = joindate;
		this.grade = grade;
		this.address = address;
	}

	public int getCustno() {
		return custno;
	}

	public void setCustno(int custno) {
		this.custno = custno;
	}

	public String getCustname() {
		return custname;
	}

	public void setCustname(String custname) {
		this.custname = custname;
	}

	public Timestamp getJoindate() {
		return joindate;
	}

	public void setJoindate(Timestamp joindate) {
		this.joindate = joindate;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "MemberVO [custno=" + custno + ", custname=" + custname + ", joindate=" + joindate + ", grade=" + grade
				+ ", address=" + address + "]";
	}
}
