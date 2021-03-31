package vo;

public class CourseVO {
	private int id;
	private String name;
	private int credit;
	private String lecName;
	private int week;
	private int start;
	private int end;
	
	public CourseVO(int id, String name, int credit, String lecName, int week, int start, int end) {
		this.id = id;
		this.name = name;
		this.credit = credit;
		this.lecName = lecName;
		this.week = week;
		this.start = start;
		this.end = end;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public String getLecName() {
		return lecName;
	}

	public void setLecName(String lecName) {
		this.lecName = lecName;
	}

	public int getWeek() {
		return week;
	}

	public void setWeek(int week) {
		this.week = week;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	@Override
	public String toString() {
		return "CourseVO [id=" + id + ", name=" + name + ", credit=" + credit + ", lecName=" + lecName + ", week="
				+ week + ", start=" + start + ", end=" + end + "]";
	}
}
