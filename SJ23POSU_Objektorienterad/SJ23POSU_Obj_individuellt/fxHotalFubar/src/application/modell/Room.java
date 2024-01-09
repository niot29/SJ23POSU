package application.modell;

public class Room extends Customer{

	private int roomid;
	private int roomBookingNr;
	private int roomCustomerNr;
	private String roomType;
	private String roomBookingDate;
	private String roomDesc;
	private int status;



	public Room() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Room(int customerId, String customerFname, String customerEnamne, String customerAddress,
			String customerEmail, String customerPhone, int status) {
		super(customerId, customerFname, customerEnamne, customerAddress, customerEmail, customerPhone, status);
		// TODO Auto-generated constructor stub
	}

	

	public Room(int roomid, int roomBookingNr, int roomCustomerNr, String roomType, String roomBookingDate,
			String roomDesc, int status) {
		super();
		this.roomid = roomid;
		this.roomBookingNr = roomBookingNr;
		this.roomCustomerNr = roomCustomerNr;
		this.roomType = roomType;
		this.roomBookingDate = roomBookingDate;
		this.roomDesc = roomDesc;
		this.status = status;
	}

	public int getRoomid() {
		return roomid;
	}

	public void setRoomid(int roomid) {
		this.roomid = roomid;
	}

	public int getRoomBookingNr() {
		return roomBookingNr;
	}

	public void setRoomBookingNr(int roomBookingNr) {
		this.roomBookingNr = roomBookingNr;
	}

	public int getRoomCustomerNr() {
		return roomCustomerNr;
	}

	public void setRoomCustomerNr(int roomCustomerNr) {
		this.roomCustomerNr = roomCustomerNr;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public String getRoomBookingDate() {
		return roomBookingDate;
	}

	public void setRoomBookingDate(String roomBookingDate) {
		this.roomBookingDate = roomBookingDate;
	}

	public String getRoomDesc() {
		return roomDesc;
	}

	public void setRoomDesc(String roomDesc) {
		this.roomDesc = roomDesc;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Room [roomid=" + roomid + ", roomBookingNr=" + roomBookingNr + ", roomCustomerNr=" + roomCustomerNr
				+ ", roomType=" + roomType + ", roomBookingDate=" + roomBookingDate + ", roomDesc=" + roomDesc
				+ ", status=" + status + ", toString()=" + super.toString() + "]";
	}

	
}
