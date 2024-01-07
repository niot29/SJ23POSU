package application.modell;

public class Room {

	private int roomid;
	private int roomBookingNr;
	private int rommCustomerNr;
	private String roomBookingDate;
	private String roomDesc;
	private int status;

	public Room() {
		super();
	}

	public Room(int roomid, String roomDesc, int roomBookingNr, int rommCustomerNr, String roomBookingDate,
			int status) {
		super();
		this.roomid = roomid;
		this.roomDesc = roomDesc;
		this.roomBookingNr = roomBookingNr;
		this.rommCustomerNr = rommCustomerNr;
		this.roomBookingDate = roomBookingDate;
		this.status = status;
	}

	public int getRoomid() {
		return roomid;
	}

	public void setRoomid(int roomid) {
		this.roomid = roomid;
	}

	public String getRoomDesc() {
		return roomDesc;
	}

	public void setRoomDesc(String roomDesc) {
		this.roomDesc = roomDesc;
	}

	public int getRoomBookingNr() {
		return roomBookingNr;
	}

	public void setRoomBookingNr(int roomBookingNr) {
		this.roomBookingNr = roomBookingNr;
	}

	public int getRommCustomerNr() {
		return rommCustomerNr;
	}

	public void setRommCustomerNr(int rommCustomerNr) {
		this.rommCustomerNr = rommCustomerNr;
	}

	public String getRoomBookingDate() {
		return roomBookingDate;
	}

	public void setRoomBookingDate(String roomBookingDate) {
		this.roomBookingDate = roomBookingDate;
	}

	public int isStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Room [roomid=" + roomid + ", roomDesc=" + roomDesc + ", roomBookingNr=" + roomBookingNr
				+ ", rommCustomerNr=" + rommCustomerNr + ", roomBookingDate=" + roomBookingDate + ", status=" + status
				+ "]";
	}

}
