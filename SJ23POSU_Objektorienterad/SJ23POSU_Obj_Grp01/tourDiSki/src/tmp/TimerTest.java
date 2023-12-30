package tmp;

import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {

	public static void main(String[] args) {

		System.out.println("Starting up...");

		// one-time use timer: prints stuff after 10s
		/*
		 * Timer myTimer = new Timer(); myTimer.schedule(new TimerTask(){
		 * 
		 * @Override public void run() {
		 * System.out.println("On timer hello from timer"); } }, 10000);
		 */
		// repeating timer: prints stuff every 10s
		Timer myRepeatingTimer = new Timer();

		myRepeatingTimer.scheduleAtFixedRate(new TimerTask() {
			int hours = 0;
			int minuts = 0;
			int seconds = 0;
			int miliseconds = 0;
			int elastedTime = 0;
			boolean state = true;
			String miliseconds_string = String.format("%02d", miliseconds);
			String seconds_string = String.format("%02d", seconds);
			String minuts_string = String.format("%02d", minuts);
			String hours_string = String.format("%02d", hours);

			@Override
			public void run() {
				
				elastedTime++;
				miliseconds++;
				//System.out.println(elastedTime);
				hours = (elastedTime/3600000);
				minuts =  (elastedTime/60000) % 60;
				seconds = (elastedTime/1000) % 60;
				//miliseconds =  elastedTime;
				
				miliseconds_string = String.format("%02d", miliseconds);
				seconds_string = String.format("%02d", seconds);
				minuts_string = String.format("%02d", minuts);
				hours_string = String.format("%02d", hours);
				
				
				if (miliseconds >= 1000) {
					miliseconds = 0;
					miliseconds_string = String.format("%02d", miliseconds);
//					seconds++;
					
				}
				
				

				
			
//				if (seconds >= 60) {
//					seconds = 0;
//					minuts++;
//
//				}
//				if (minuts >= 60) {
//					minuts = 0;
//					hours++;
//				}
//				miliseconds++;
//			
//				System.out.println( String.format("%02d", hours) + ":" +  String.format("%02d", minuts) + ":" +  String.format("%02d", seconds) + ":" + String.format("%01d", miliseconds));
//			
			}
		}, 0, 1);
	}
}
