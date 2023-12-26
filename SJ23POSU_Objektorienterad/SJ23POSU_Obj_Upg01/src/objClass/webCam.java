package objClass;

public class webCam {
	private String titel;
	private String fabric;
	private int status;
	
	
	
	public webCam() {
	}



	public webCam(String titel, String fabric, int status) {
		this.titel = titel;
		this.fabric = fabric;
		this.status = status;
	}



	public String getTitel() {
		return titel;
	}



	public void setTitel(String titel) {
		this.titel = titel;
	}



	public String getFabric() {
		return fabric;
	}



	public void setFabric(String fabric) {
		this.fabric = fabric;
	}



	public int getStatus() {
		return status;
	}



	public void setStatus(int status) {
		this.status = status;
	}
	
	public boolean haveZomme() {
		return true;
	}
	
	private String cabelColor(String fabric) {
		if(fabric.equals("logitech"))
				return "black";
		
		return "white";
	}


	public void printCabelfun() {
		System.out.println("Just print cabel color by fabric: " + cabelColor(fabric));
	}
	
	public String toString() {
		return "webCam [titel=" + titel + ", fabric=" + fabric + ", status=" + status + ", haveZomme()=" + haveZomme()
				+ "]";
	}

	
}
