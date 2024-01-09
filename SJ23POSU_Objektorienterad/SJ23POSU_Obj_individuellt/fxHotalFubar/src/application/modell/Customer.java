package application.modell;


public class Customer implements  Comparable<Customer>{
	private int customerId;
	private String customerFname;
	private String customerEnamne;
	private String customerAddress;
	private String customerEmail;
	private String customerPhone;
	private int status;
	
	public Customer() {
		super();
	}

	public Customer(int customerId, String customerFname, String customerEnamne, String customerAddress,
			String customerEmail, String customerPhone, int status) {
		super();
		this.customerId = customerId;
		this.customerFname = customerFname;
		this.customerEnamne = customerEnamne;
		this.customerAddress = customerAddress;
		this.customerEmail = customerEmail;
		this.customerPhone = customerPhone;
		this.status = status;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerFname() {
		return customerFname;
	}

	public void setCustomerFname(String customerFname) {
		this.customerFname = customerFname;
	}

	public String getCustomerEnamne() {
		return customerEnamne;
	}

	public void setCustomerEnamne(String customerEnamne) {
		this.customerEnamne = customerEnamne;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerFname=" + customerFname + ", customerEnamne="
				+ customerEnamne + ", customerAddress=" + customerAddress + ", customerEmail=" + customerEmail
				+ ", customerPhone=" + customerPhone + ", status=" + status + "]";
	}

	@Override
	public int compareTo(Customer p) {

		return this.customerId - p.customerId;
	}
	
}
	
	