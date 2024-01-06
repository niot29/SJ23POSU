package application.modell;

public class Customer {
	private int id;
	private String fname;
	private String enamne;
	private String email;
	private String phone;
	private String status;
	
	
	public Customer() {
		super();
	}


	public Customer(int id, String fname, String enamne, String email, String phone, String status) {
		super();
		this.id = id;
		this.fname = fname;
		this.enamne = enamne;
		this.email = email;
		this.phone = phone;
		this.status = status;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFname() {
		return fname;
	}


	public void setFname(String fname) {
		this.fname = fname;
	}


	public String getEnamne() {
		return enamne;
	}


	public void setEnamne(String enamne) {
		this.enamne = enamne;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "Customer [id=" + id + ", fname=" + fname + ", enamne=" + enamne + ", email=" + email + ", phone="
				+ phone + ", status=" + status + "]";
	}
	
	
	
	
	
	
	
}
