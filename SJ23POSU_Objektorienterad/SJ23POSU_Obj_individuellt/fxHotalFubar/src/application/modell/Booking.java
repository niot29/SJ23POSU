package application.modell;

public class Booking extends Room{

	
	private int bookingId;
	private int bookingRoomNr;
	private int bookingCustomerId;
	private String bookingCustomerFname;
	private String bookingCustomerEnamne;
	private int bookingStayDay;
	private String bookingStartDate;
	private String bookingEndDate;
	private String bookingDesc;
	private int status;

	
	public Booking() {
	
	}



	public Booking(int bookingId, int bookingRoomNr, int bookingCustomerId, String bookingCustomerFname,
			String bookingCustomerEnamne, int bookingStayDay, String bookingStartDate, String bookingEndDate,
			String bookingDesc, int status) {
		super();
		this.bookingId = bookingId;
		this.bookingRoomNr = bookingRoomNr;
		this.bookingCustomerId = bookingCustomerId;
		this.bookingCustomerFname = bookingCustomerFname;
		this.bookingCustomerEnamne = bookingCustomerEnamne;
		this.bookingStayDay = bookingStayDay;
		this.bookingStartDate = bookingStartDate;
		this.bookingEndDate = bookingEndDate;
		this.bookingDesc = bookingDesc;
		this.status = status;
	}



	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public int getBookingRoomNr() {
		return bookingRoomNr;
	}

	public void setBookingRoomNr(int bookingRoomNr) {
		this.bookingRoomNr = bookingRoomNr;
	}

	public int getBookingCustomerId() {
		return bookingCustomerId;
	}

	public void setBookingCustomerId(int bookingCustomerId) {
		this.bookingCustomerId = bookingCustomerId;
	}

	public int getBookingStayDay() {
		return bookingStayDay;
	}

	public void setBookingStayDay(int bookingStayDay) {
		this.bookingStayDay = bookingStayDay;
	}

	public String getBookingStartDate() {
		return bookingStartDate;
	}

	public void setBookingStartDate(String bookingStartDate) {
		this.bookingStartDate = bookingStartDate;
	}

	public String getBookingEndDate() {
		return bookingEndDate;
	}

	public void setBookingEndDate(String bookingEndDate) {
		this.bookingEndDate = bookingEndDate;
	}

	public String getBookingDesc() {
		return bookingDesc;
	}

	public void setBookingDesc(String bookingDesc) {
		this.bookingDesc = bookingDesc;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}



	public String getBookingCustomerFname() {
		return bookingCustomerFname;
	}



	public void setBookingCustomerFname(String bookingCustomerFname) {
		this.bookingCustomerFname = bookingCustomerFname;
	}



	public String getBookingCustomerEnamne() {
		return bookingCustomerEnamne;
	}



	public void setBookingCustomerEnamne(String bookingCustomerEnamne) {
		this.bookingCustomerEnamne = bookingCustomerEnamne;
	}



	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", bookingRoomNr=" + bookingRoomNr + ", bookingCustomerId="
				+ bookingCustomerId + ", bookingCustomerFname=" + bookingCustomerFname + ", bookingCustomerEnamne="
				+ bookingCustomerEnamne + ", bookingStayDay=" + bookingStayDay + ", bookingStartDate="
				+ bookingStartDate + ", bookingEndDate=" + bookingEndDate + ", bookingDesc=" + bookingDesc + ", status="
				+ status + "]";
	}

	

	
	
	
}
