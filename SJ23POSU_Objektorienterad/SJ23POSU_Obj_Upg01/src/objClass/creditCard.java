package objClass;

public class creditCard {
	
	static int sum = 100;
	
	private String titel;
	private String name;
	private int number;
	
	public creditCard() {
	}

	public creditCard(String titel, String name, int number) {
		this.titel = titel;
		this.name = name;
		this.number = number;
	}

	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	
	private int creditSum(int spend) {
		sum  = sum - spend;
		return sum;
		
	}
	
	private boolean isCreditLeft() {
		if(sum > 0)
			return true;
		return false;
		
	}

	public void printCredit(int spend) {
		System.out.println("creditCard Sum[ credit: " + creditSum(spend) + " - Any credit left: " + isCreditLeft() + "]" );
		
	}
	
	public String toString() {
		return "creditCard [titel=" + titel + ", name=" + name + ", number=" + number + "]";
	}
	
	
}
