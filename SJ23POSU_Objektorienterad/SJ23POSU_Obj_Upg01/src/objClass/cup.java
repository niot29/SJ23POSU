package objClass;

public class cup {
	
	private String cname;
	private String type;
	private String color;
	private int height;
	private int radius;
	
	public cup() {
	}


	
	public cup(String cname, String type, String color, int height, int radius) {
		this.cname = cname;
		this.type = type;
		this.color = color;
		this.height = height;
		this.radius = radius;
	}



	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	
	
	public int getHeight() {
		return height;
	}



	public void setHeight(int height) {
		this.height = height;
	}



	public int getRadius() {
		return radius;
	}



	public void setRadius(int radius) {
		this.radius = radius;
	}



	public double getCupCylinder(int height,int radius) {
		double pie=3.14285714286;  
		return pie*(radius*radius)*height;  
	}
	
	public double getCupCylinder() {
		double pie=3.14285714286;  
		return pie*(radius*radius)*height;  
	}



	public void printString() {
		System.out.println(  "cup [cname=" + cname + ", type=" + type + ", color=" + color + ", height=" + height + ", radius="
				+ radius + "]");
	}
	
	
	public String toString() {
		return "cup [cname=" + cname + ", type=" + type + ", color=" + color + ", height=" + height + ", radius="
				+ radius + "]";
	}
	
	

}
