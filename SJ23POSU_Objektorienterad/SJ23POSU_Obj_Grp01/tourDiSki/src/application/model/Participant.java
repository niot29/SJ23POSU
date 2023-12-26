package application.model;

public class Participant {
	
	private int id;
	private String namen;
	private int position;
	private String startTime;
	private String totalDiffrenceTime;
	private String endTime;
	
	public Participant() {
	}

	public Participant(int id, String namen, int startOrder, String startTime, String totalDiffrenceTime,
			String endTime) {
		super();
		this.id = id;
		this.namen = namen;
		this.position = startOrder;
		this.startTime = startTime;
		this.totalDiffrenceTime = totalDiffrenceTime;
		this.endTime = endTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNamen() {
		return namen;
	}

	public void setNamen(String namen) {
		this.namen = namen;
	}

	public int getStartOrder() {
		return position;
	}

	public void setStartOrder(int startOrder) {
		this.position = startOrder;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getTotalDiffrenceTime() {
		return totalDiffrenceTime;
	}

	public void setTotalDiffrenceTime(String totalDiffrenceTime) {
		this.totalDiffrenceTime = totalDiffrenceTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return "participant [id=" + id + ", namen=" + namen + ", startOrder=" + position + ", startTime=" + startTime
				+ ", totalDiffrenceTime=" + totalDiffrenceTime + ", endTime=" + endTime + "]";
	}
	
	
	
	
	
	
}
