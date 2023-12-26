package objClass;

public class computer {

	private String brand;
	private String type;
	private String os;
	
	public computer() {
	}

	public computer(String brand, String type, String os) {

		this.brand = brand;
		this.type = type;
		this.os = os;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}
	
	
	private String haveSomrLed() {
		return "yes";
	}
	
	private String  isPlayable() {
		return "No";
	}

	@Override
	public String toString() {
		return "computer [brand=" + brand + ", type=" + type + ", os=" + os + ", haveSomrLed()=" + haveSomrLed()
				+ ", isPlayable()=" + isPlayable() + "]";
	}
	
	
}
