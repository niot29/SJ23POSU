package objClass;

public class books {
	private String titel;
	private String form;
	private String desc;
	
	public books() {
	}

	public books(String titel, String form, String desc) {
		this.titel = titel;
		this.form = form;
		this.desc = desc;
	}

	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public String getForm() {
		return form;
	}

	public void setForm(String form) {
		this.form = form;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public boolean isCombustible() {
		return true;		
	}
	
	public boolean isFloatable() {
		return false;		
	}
	
	
	public  void printString() {
		System.out.println("books [titel=" + titel + ", form=" + form + ", desc=" + desc + "]");
	}
	
	public String toString() {
		return "books [titel=" + titel + ", form=" + form + ", desc=" + desc + "]";
	}
	
	
	
	
}
