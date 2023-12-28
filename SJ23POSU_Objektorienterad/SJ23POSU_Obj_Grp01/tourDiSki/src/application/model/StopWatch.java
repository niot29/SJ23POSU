package application.model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StopWatch implements ActionListener{
	private int hours = 0;
	private int minuts = 0;
	private int seconds = 0;
	private int milisecunds = 0;
	private int elastedTime =0;
	private boolean state = true;
	String milisecunds_string = String.format("%002d", milisecunds);
	String seconds_string = String.format("%002d", seconds);
	String minuts_string = String.format("%002d", minuts);
	String hours_string = String.format("%002d", hours);
	
	 
	
	
	public StopWatch() {
		super();
	}

	
	

	public StopWatch(int hours, int minuts, int seconds, int milisecunds, int elastedTime, boolean state) {
		super();
		this.hours = hours;
		this.minuts = minuts;
		this.seconds = seconds;
		this.milisecunds = milisecunds;
		this.elastedTime = elastedTime;
		this.state = state;
	}





	private void turnoff() {
		
	}




	@Override
	public void actionPerformed(ActionEvent e) {
//
//		elapsedTime.this =elapsedTime+1000;
//		   hours = (elapsedTime/3600000);
//		   minutes = (elapsedTime/60000) % 60;
//		   seconds = (elapsedTime/1000) % 60;
//		   seconds_string = String.format("%02d", seconds);
//		   minutes_string = String.format("%02d", minutes);
//		   hours_string = String.format("%02d", hours);
//		   timeLabel.setText(hours_string+":"+minutes_string+":"+seconds_string);
	}
	
}
