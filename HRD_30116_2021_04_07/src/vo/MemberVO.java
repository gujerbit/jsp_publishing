package vo;

public class MemberVO {
	private String id;
	private String name;
	private String dept;
	private String position;
	private String duty;
	private String phone;
	
	public MemberVO(String id, String name, String dept, String position, String duty, String phone) {
		this.id = id;
		this.name = name;
		this.dept = dept;
		this.position = position;
		this.duty = duty;
		this.phone = phone;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getDuty() {
		return duty;
	}

	public void setDuty(String duty) {
		this.duty = duty;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", name=" + name + ", dept=" + dept + ", position=" + position + ", duty=" + duty
				+ ", phone=" + phone + "]";
	}
}
