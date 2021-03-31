package vo;

public class LecturerVO {
	private String idx;
	private String name;
	private String major;
	private String field;
	
	public LecturerVO(String idx, String name, String major, String field) {
		this.idx = idx;
		this.name = name;
		this.major = major;
		this.field = field;
	}

	public String getIdx() {
		return idx;
	}

	public void setIdx(String idx) {
		this.idx = idx;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	@Override
	public String toString() {
		return "LecturerVO [idx=" + idx + ", name=" + name + ", major=" + major + ", field=" + field + "]";
	}
}