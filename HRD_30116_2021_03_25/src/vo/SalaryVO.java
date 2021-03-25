package vo;

public class SalaryVO {
	private int empNo;
	private String empName;
	private int pay;
	
	public SalaryVO(int empNo, String empName, int pay) {
		this.empNo = empNo;
		this.empName = empName;
		this.pay = pay;
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

	public int getPay() {
		return pay;
	}

	public void setPay(int pay) {
		this.pay = pay;
	}

	@Override
	public String toString() {
		return "SalaryVO [empNo=" + empNo + ", empName=" + empName + ", pay=" + pay + "]";
	}
}
