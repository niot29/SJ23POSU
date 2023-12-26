package objClass;


public class room { 
	
	
	private String rname;
	private String desc;
	private int width;
	private int hight;
	private int length;
	private double  area;
	private double  cubic;
	

	
	public room() {
	}



	// skip squar and area
	public room(String rname, String desc, int width, int hight, int length) {
		this.rname = rname;
		this.desc = desc;
		this.width = width;
		this.hight = hight;
		this.length = length;
	}



	public String getRname() {
		return rname;
	}



	public void setRname(String rname) {
		this.rname = rname;
	}



	public String getDesc() {
		return desc;
	}



	public void setDesc(String desc) {
		this.desc = desc;
	}



	public int getWidth() {
		return width;
	}



	public void setWidth(int width) {
		this.width = width;
	}



	public int getHight() {
		return hight;
	}



	public void setHight(int hight) {
		this.hight = hight;
	}



	public int getLength() {
		return length;
	}



	public void setLength(int length) {
		this.length = length;
	}


	// return room area
	public double  getArea() {
		return  length * width;
	}

	
	// reutrn Cubic = area * area * area.
	public double  getCubic() {
		return  Math.pow(getArea(),3);
	}



	@Override
	public String toString() {
		return "room [rname=" + rname + ", desc=" + desc + ", width=" + width + ", hight=" + hight + ", length="
				+ length + ", area=" + area + ", cubic=" + cubic + "]";
	}



	

}
