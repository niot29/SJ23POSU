package application.services;

import java.lang.reflect.Array;
import java.util.Timer;
import java.util.TimerTask;

public class TimerHandler {

	private int hours = 0;
	private int minuts = 0;
	private int seconds = 0;
	private int miliseconds = 0;
	private int elastedTime = 0;
	private boolean state = true;
	String miliseconds_string = String.format("%02d", miliseconds);
	String seconds_string = String.format("%02d", seconds);
	String minuts_string = String.format("%02d", minuts);
	String hours_string = String.format("%02d", hours);

	public TimerHandler() {
	}

	public TimerHandler(int hours, int minuts, int seconds, int miliseconds, int elastedTime, boolean state) {
		super();
		this.hours = hours;
		this.minuts = minuts;
		this.seconds = seconds;
		this.miliseconds = miliseconds;
		this.elastedTime = elastedTime;
		this.state = state;
	}

	public String getCurrentTime() {
		// watchTimer = hours_string + ":" + minuts_string + ":" + seconds_string + ":"
		// + miliseconds_string;
		return hours_string + ":" + minuts_string + ":" + seconds_string + ":" + miliseconds_string;
	}

	public String resetTimer() {
		hours = 0;
		minuts = 0;
		seconds = 0;
		miliseconds = 0;
		elastedTime = 0;
		state = true;

		miliseconds_string = String.format("%02d", miliseconds);
		seconds_string = String.format("%02d", seconds);
		minuts_string = String.format("%02d", minuts);
		hours_string = String.format("%02d", hours);

		return hours_string + ":" + minuts_string + ":" + seconds_string + ":" + miliseconds_string;

	}

	public void timeRunnger() {

		elastedTime++;
		miliseconds++;
		// System.out.println(elastedTime);
		hours = (elastedTime / 3600000);
		minuts = (elastedTime / 60000) % 60;
		seconds = (elastedTime / 1000) % 60;
		// miliseconds = elastedTime;

		miliseconds_string = String.format("%02d", miliseconds);
		seconds_string = String.format("%02d", seconds);
		minuts_string = String.format("%02d", minuts);
		hours_string = String.format("%02d", hours);

		if (miliseconds >= 1000) {
			miliseconds = 0;
			miliseconds_string = String.format("%02d", miliseconds);

		}

	}

	public int convertStringTimeToMilliseconds(String str) {
		System.out.println("convertStringTimeToMilliseconds");
//		String str = "00:01:50:987";
		String[] t = str.split(":");

		int a = Integer.valueOf(t[1]) * 60000;
		a = a + Integer.valueOf(t[2]) * 1000;
		a = a + Integer.valueOf(t[3]);

		return a;
	}

	public String convertMillisecondsTimeToString(int milli) {
		int milliq = 7999;
		
		
		int conhours = (milli / 3600000);
		int conminuts = (milli / 60000) % 60;
		int conseconds = (milli / 1000) % 60;	
		int conmiliseconds =  milli - (conseconds * 1000);
				
				
		String conmiliseconds_string = String.format("%02d", conmiliseconds);
		String conseconds_string = String.format("%02d", conseconds);
		String conminuts_string = String.format("%02d", conminuts);
		String conhours_string = String.format("%02d", conhours);

//		System.out.println(conhours_string + ":" + conminuts_string + ":" + conseconds_string + ":" + conmiliseconds_string);
		
		return conhours_string + ":" + conminuts_string + ":" + conseconds_string + ":" + conmiliseconds_string;
		
		
		
	}



}
