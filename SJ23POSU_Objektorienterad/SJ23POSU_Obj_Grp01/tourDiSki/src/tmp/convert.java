package tmp;

public class convert {

	public static void main(String[] args) {
		
		
		
		
	int milli = 15000;
	
	
	int hours = (milli / 3600000);
	int minuts = (milli / 60000) % 60;
	int seconds = (milli / 1000) % 60;	
	int miliseconds =  milli - (seconds * 1000);
			
			
	String miliseconds_string = String.format("%02d", miliseconds);
	String seconds_string = String.format("%02d", seconds);
	String minuts_string = String.format("%02d", minuts);
	String hours_string = String.format("%02d", hours);
	
	 
	System.out.println(seconds);
	System.out.println( ":" + seconds_string + ":" + miliseconds_string);
	System.out.println(hours_string + ":" + minuts_string + ":" + seconds_string + ":" + miliseconds_string);
	
	
	

	}
	
	
	

}
