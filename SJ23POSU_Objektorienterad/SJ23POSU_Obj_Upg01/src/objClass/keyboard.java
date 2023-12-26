package objClass;

public class keyboard {
	
	private String brand;
	private String type;
	private boolean rgb = true;
	
	
	
	public keyboard() {
	}


	public keyboard(String brand, String type, boolean rgb) {
		this.brand = brand;
		this.type = type;
		this.rgb = rgb;
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


	public boolean isRgb() {
		return rgb;
	}


	public void setRgb(boolean rgb) {
		this.rgb = rgb;
	}

	
	private int  keyboardLayout(String type) {
		if(type.equals("fullSize"))
			return 100;
		else if (type.equals("small")) {
			return  56;
		}else {
			return  75;
		}
		
	}
	
	
	
	private boolean isMechanical(String type) {
		boolean mech;
		mech = (keyboardLayout(type) > 100) ? true: false;
		return mech;
	}

	
	public void printLayout(String keySize) {
		System.out.println("Key is mechanical: " + isMechanical(keySize));
	}

	public String toString() {
		return "keyboard [brand=" + brand + ", type=" + type + ", rgb=" + rgb + "]";
	}

	
}
