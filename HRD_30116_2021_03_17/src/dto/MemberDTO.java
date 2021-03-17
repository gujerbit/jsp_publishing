package dto;

public class MemberDTO {
	private int custno;
	private String joindate;
	
	public MemberDTO(int custno, String joindate) {
		this.custno = custno;
		this.joindate = joindate;
	}

	public int getCustno() {
		return custno;
	}

	public void setCustno(int custno) {
		this.custno = custno;
	}

	public String getJoindate() {
		return joindate;
	}

	public void setJoindate(String joindate) {
		this.joindate = joindate;
	}

	@Override
	public String toString() {
		return "MemberDTO [custno=" + custno + ", joindate=" + joindate + "]";
	}
}
