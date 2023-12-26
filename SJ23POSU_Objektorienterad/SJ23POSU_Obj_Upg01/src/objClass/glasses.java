package objClass;

import java.util.Random;

public class glasses {
	private String gname;
	private String fabric;
	private String color;
	
	public glasses() {
	}

	

	
	public glasses(String gname, String fabric, String color) {
		this.gname = gname;
		this.fabric = fabric;
		this.color = color;
	}




	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
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

	
	public String glassesTest(String fabric) {
		Random r = new Random();
		int result = r.nextInt(3-1) + 1;
		String mSpeed ="";
		switch (result) {
		case 1:
			mSpeed = fabric +" Det funkar";
			break;
		case 2:
			mSpeed = fabric +" glassögen orm";
			break;
		case 3:
			mSpeed =fabric +" med de så är man blind";
		default:
			break;
		}
		
		return mSpeed;
	}
	
	public void printString() {
		System.out.println("mouse [gname=" + gname + ", fabric=" + fabric + ", color=" + color + "]");
	}
	
	
	public String toString() {
		return "mouse [gname=" + gname + ", fabric=" + fabric + ", color=" + color + "]";
	}
	
	
	

}
