package model;

public class Batch {
	private String b_id;
	private String name;
	private String startTime;
	private String endTime;
	private String shift;

	public Batch() {
		super();

	}

	public Batch(String b_id, String name, String startTime, String endTime, String shift) {
		super();
		this.b_id = b_id;
		this.name = name;
		this.startTime = startTime;
		this.endTime = endTime;
		this.shift = shift;
	}

	public String getB_id() {
		return b_id;
	}

	public void setB_id(String b_id) {
		this.b_id = b_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getShift() {
		return shift;
	}

	public void setShift(String shift) {
		this.shift = shift;
	}

	// private List<Participant> participants;

}
