package application.model;

public class Participant {
	
	private int id;
	private String namen;
	private int position;
	private String startTime = "0";
	private String totalDiffrenceTime = "0";
	private String race1 = "0";
	private String race2 = "0";
	private String race3 = "0";
	private String endTime = "0";
	
	public Participant() {
	}

	
	public Participant(int id, String namen, int position, String startTime, String totalDiffrenceTime,
			String compTime01, String compTime02, String compTime03, String endTime) {
		super();
		this.id = id;
		this.namen = namen;
		this.position = position;
		this.startTime = startTime;
		this.totalDiffrenceTime = totalDiffrenceTime;
		this.race1 = compTime01;
		this.race2 = compTime02;
		this.race3 = compTime03;
		this.endTime = endTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	
	public int getPosition() {
		return position;
	}


	public void setPosition(int position) {
		this.position = position;
	}


	public String getRac1() {
		return race1;
	}


	public void setRac1(String race1) {
		this.race1 = race1;
	}


	public String getRac2() {
		return race2;
	}


	public void setRac2(String race2) {
		this.race2 = race2;
	}


	public String getRac3() {
		return race3;
	}


	public void setRac3(String race3) {
		this.race3 = race3;
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
