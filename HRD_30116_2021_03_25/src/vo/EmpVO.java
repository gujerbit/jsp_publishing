package vo;

import java.sql.Date;

public class EmpVO {
	private int empNo;
	private String empName;
	private Date joinDate;
	private String rank;
	private String dept;
	
	public EmpVO(int empNo, String empName, Date joinDate, String rank, String dept) {
		this.empNo = empNo;
		this.empName = empName;
		this.joinDate = joinDate;
		this.rank = rank;
		this.dept = dept;
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "EmpVO [empNo=" + empNo + ", empName=" + empName + ", joinDate=" + joinDate + ", rank=" + rank
				+ ", dept=" + dept + "]";
	}
}