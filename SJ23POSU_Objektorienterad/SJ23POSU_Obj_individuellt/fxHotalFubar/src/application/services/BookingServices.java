package application.services;

import java.util.List;

import application.modell.Booking;
import application.modell.Customer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;



public class BookingServices {

	
DataHandler dataHandler = new DataHandler();

	private  List<Booking> getListOfBooking(){
		
		return  dataHandler.readBookingFromFile("Booking.txt");
	}

	
	
	public ObservableList<Booking> getOListOfBooking(int statusType) {
		List<Booking> list = getListOfBooking();
		ObservableList<Booking> bookingList = FXCollections.observableArrayList();

		for (Booking b : list) {

			if (b.getStatus() == 0) {

				Booking booking = new Booking();
				booking.setBookingId(b.getBookingId());
				booking.setBookingRoomNr(b.getBookingRoomNr());
				booking.setBookingCustomerId(b.getBookingCustomerId());
				booking.setBookingStayDay(b.getBookingStayDay());
				booking.setBookingStartDate(b.getBookingStartDate());
				booking.setBookingEndDate(b.getBookingEndDate());
				booking.setBookingDesc(b.getBookingDesc());
				booking.setStatus(b.getStatus());
				
				
				// need change later
				booking.setRoomid(2);
				booking.setRoomCustomerNr(10);
				booking.setCustomerFname("killer");
				booking.setCustomerEnamne("Nalle");
				
				
				bookingList.add(booking);

			} else {
				Booking booking = new Booking();
				booking.setBookingId(b.getBookingId());
				booking.setBookingRoomNr(b.getBookingRoomNr());
				booking.setBookingCustomerId(b.getBookingCustomerId());
				booking.setBookingStayDay(b.getBookingStayDay());
				booking.setBookingStartDate(b.getBookingStartDate());
				booking.setBookingEndDate(b.getBookingEndDate());
				booking.setBookingDesc(b.getBookingDesc());
				booking.setStatus(b.getStatus());

				
				// need change later
				booking.setRoomid(2);
				booking.setRoomCustomerNr(10);
				booking.setCustomerFname("killer");
				booking.setCustomerEnamne("Nalle");
				
				System.out.println(booking);
				bookingList.add(booking);
			}
		}

		return bookingList;

	}
	
	
	public List<Booking> addNewCustomer(Booking newBooking) {
		Booking booking = new Booking();

		
		List<Booking> bookingList = getListOfBooking();
		newBooking.setBookingId(bookingList.size() + 1);
		newBooking.setStatus(1);
		bookingList.add(newBooking);
		System.out.println("addNewBooling: "  + bookingList);
		
		
		
		//To-do from file 
		
		
		dataHandler.saveToFileList(bookingList);
		
		return null;
		
		
	}
	
	
	
}
