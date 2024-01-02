package application.model;

public class Participant  implements Comparable<Participant>{
	
	private int id;
	private String namen;
	private int position;
	private String startTime = "0";
	private String  totalDiffrenceTime = "0";
	private String compTime01 = "0";
	private String compTime02 = "0";
	private String compTime03 = "0";
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
		this.compTime01 = compTime01;
		this.compTime02 = compTime02;
		this.compTime03 = compTime03;
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

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
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

	public String getCompTime01() {
		return compTime01;
	}

	public void setCompTime01(String compTime01) {
		this.compTime01 = compTime01;
	}

	public String getCompTime02() {
		return compTime02;
	}

	public void setCompTime02(String compTime02) {
		this.compTime02 = compTime02;
	}

	public String getCompTime03() {
		return compTime03;
	}

	public void setCompTime03(String compTime03) {
		this.compTime03 = compTime03;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return "Participant [id=" + id + ", namen=" + namen + ", position=" + position + ", startTime=" + startTime
				+ ", totalDiffrenceTime=" + totalDiffrenceTime + ", compTime01=" + compTime01 + ", compTime02="
				+ compTime02 + ", compTime03=" + compTime03 + ", endTime=" + endTime + "]";
	}

	@Override
	public int compareTo(Participant totalDiffrenceTime) {
		// TODO Auto-generated method stub
		return (Integer) null;
	}

	

	
	
}
