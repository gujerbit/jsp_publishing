package vo;

import java.sql.Timestamp;

public class MoneyVO {
	private int custno;
	private int salenol;
	private int pcost;
	private int amount;
	private int price;
	private String pcode;
	private Timestamp sdate;
	
	public MoneyVO(int custno, int salenol, int pcost, int amount, int price, String pcode, Timestamp sdate) {
		this.custno = custno;
		this.salenol = salenol;
		this.pcost = pcost;
		this.amount = amount;
		this.price = price;
		this.pcode = pcode;
		this.sdate = sdate;
	}

	public int getCustno() {
		return custno;
	}

	public void setCustno(int custno) {
		this.custno = custno;
	}

	public int getSalenol() {
		return salenol;
	}

	public void setSalenol(int salenol) {
		this.salenol = salenol;
	}

	public int getPcost() {
		return pcost;
	}

	public void setPcost(int pcost) {
		this.pcost = pcost;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getPcode() {
		return pcode;
	}

	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

	public Timestamp getSdate() {
		return sdate;
	}

	public void setSdate(Timestamp sdate) {
		this.sdate = sdate;
	}

	@Override
	public String toString() {
		return "MoneyVO [custno=" + custno + ", salenol=" + salenol + ", pcost=" + pcost + ", amount=" + amount
				+ ", price=" + price + ", pcode=" + pcode + ", sdate=" + sdate + "]";
	}
}
