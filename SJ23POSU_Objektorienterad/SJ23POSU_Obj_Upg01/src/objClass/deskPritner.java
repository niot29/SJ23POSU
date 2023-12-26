package objClass;

public class deskPritner {

	private String brand;
	private String type;
	private String printColor;
	
	public deskPritner() {
	}

	public deskPritner(String brand, String type, String printColor) {
		this.brand = brand;
		this.type = type;
		this.printColor = printColor;
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

	public String getPrintColor() {
		return printColor;
	}

	public void setPrintColor(String printColor) {
		this.printColor = printColor;
	}
	
	public String haveSomrLed() {
		return "yes";
	}

	public String toString() {
		return "deskPritner [brand=" + brand + ", type=" + type + ", printColor=" + printColor + ", haveSomrLed()="
				+ haveSomrLed() + "]";
	}
	
	
	
	
}
