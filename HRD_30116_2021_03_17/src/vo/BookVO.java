package vo;

public class BookVO {
	private int custno;
	private int bookno;
	private String custname;
	private int memberTotal; //회원별 대여 횟수
	private int bookTotal; //도서별 대여 횟수
	
	public BookVO(int custno, int bookno, String custname, int memberTotal, int bookTotal) {
		this.custno = custno;
		this.bookno = bookno;
		this.custname = custname;
		this.memberTotal = memberTotal;
		this.bookTotal = bookTotal;
	}

	public int getCustno() {
		return custno;
	}

	public void setCustno(int custno) {
		this.custno = custno;
	}

	public int getBookno() {
		return bookno;
	}

	public void setBookno(int bookno) {
		this.bookno = bookno;
	}

	public String getCustname() {
		return custname;
	}

	public void setCustname(String custname) {
		this.custname = custname;
	}

	public int getMemberTotal() {
		return memberTotal;
	}

	public void setMemberTotal(int memberTotal) {
		this.memberTotal = memberTotal;
	}

	public int getBookTotal() {
		return bookTotal;
	}

	public void setBookTotal(int bookTotal) {
		this.bookTotal = bookTotal;
	}

	@Override
	public String toString() {
		return "BookVO [custno=" + custno + ", bookno=" + bookno + ", custname=" + custname + ", memberTotal="
				+ memberTotal + ", bookTotal=" + bookTotal + "]";
	}
}
