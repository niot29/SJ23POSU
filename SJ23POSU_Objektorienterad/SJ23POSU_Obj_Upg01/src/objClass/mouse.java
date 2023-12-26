package objClass;

import java.util.Random;

public class mouse {
	private String mname;
	private String fabric;
	private String color;
	
	public mouse() {
	}

	public mouse(String mname, String fabric, String color) {
		this.mname = mname;
		this.fabric = fabric;
		this.color = color;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getFabric() {
		return fabric;
	}

	public void setFabric(String fabric) {
		this.fabric = fabric;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	
	public String speed(String fabric) {
		Random r = new Random();
		int result = r.nextInt(3-1) + 1;
		String mSpeed ="";
		switch (result) {
		case 1:
			mSpeed = fabric +" Snabb";
			break;
		case 2:
			mSpeed = fabric +" Stabilt snabb";
			break;
		case 3:
			mSpeed =fabric +" Fett snabb";
		default:
			break;
		}
		
		return mSpeed;
	}
	
	public void printString() {
		System.out.println("mouse [mname=" + mname + ", fabric=" + fabric + ", color=" + color + "]");
	}
	
	
	public String toString() {
		return "mouse [mname=" + mname + ", fabric=" + fabric + ", color=" + color + "]";
	}
	
	
	

}
