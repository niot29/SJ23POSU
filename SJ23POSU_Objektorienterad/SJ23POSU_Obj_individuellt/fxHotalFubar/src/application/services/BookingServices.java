package application.services;

import java.util.List;

import application.modell.Booking;



public class BookingServices {

	
DataHandler dataHandler = new DataHandler();

	public List<Booking> getListOfBooking(){
		
		return  dataHandler.readBookingFromFile("Booking.txt");
	}

	
	public List<Booking> addNewCustomer(Booking newBooking) {
		Booking booking = new Booking();

		
		List<Booking> bookingList = getListOfBooking();
		newBooking.setBookingCustomerId(bookingList.size() + 1);
		newBooking.setStatus(1);
		bookingList.add(newBooking);
		System.out.println("addNewCustomer: "  + bookingList);
		
		
		
		//To-do from file 
		
		
		dataHandler.saveToFileList(bookingList);
		
		return null;
		
		
	}
	
	
	
}
