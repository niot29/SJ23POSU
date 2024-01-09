package application.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import application.modell.Booking;
import application.modell.Customer;
import application.modell.Room;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class BookingServices {

	DataHandler dataHandler = new DataHandler();

	private List<Booking> getListOfBooking() {

		return dataHandler.readBookingFromFile("Booking.txt");
	}

	public ObservableList<Booking> getOListOfBooking(int statusType) {
		List<Booking> list = getListOfBooking();
		ObservableList<Booking> bookingList = FXCollections.observableArrayList();

		for (Booking b : list) {

			if (b.getStatus() == 1) {

				Booking booking = new Booking();
				booking.setBookingId(b.getBookingId());
				booking.setBookingRoomNr(b.getBookingRoomNr());
				booking.setBookingCustomerId(b.getBookingCustomerId());
				booking.setBookingCustomerFname(b.getBookingCustomerFname());
				booking.setBookingCustomerEnamne(b.getBookingCustomerEnamne());
				booking.setBookingStayDay(b.getBookingStayDay());
				booking.setBookingStartDate(b.getBookingStartDate());
				booking.setBookingEndDate(b.getBookingEndDate());
				booking.setBookingDesc(b.getBookingDesc());
				booking.setStatus(b.getStatus());

				// need change later
				booking.setRoomid(b.getRoomid());
				booking.setRoomBookingNr(b.getRoomBookingNr());
				booking.setRoomCustomerNr(b.getRoomCustomerNr());
				booking.setRoomBookingDate(b.getRoomBookingDate());
				booking.setRoomDesc(b.getRoomDesc());
				booking.setRoomType(b.getRoomType());
				booking.setStatus(b.getStatus());

				
				booking.setCustomerId(b.getCustomerId());
				booking.setCustomerFname(b.getCustomerFname());
				booking.setCustomerEnamne(b.getCustomerEnamne());
				booking.setCustomerAddress(b.getCustomerAddress());
				booking.setCustomerEmail(b.getCustomerEmail());
				booking.setCustomerPhone(b.getCustomerPhone());
				booking.setStatus(b.getStatus());
				
				bookingList.add(booking);

			} 
//			else {
//				Booking booking = new Booking();
//				booking.setBookingId(b.getBookingId());
//				booking.setBookingRoomNr(b.getBookingRoomNr());
//				booking.setBookingCustomerId(b.getBookingCustomerId());
//				booking.setBookingStayDay(b.getBookingStayDay());
//				booking.setBookingStartDate(b.getBookingStartDate());
//				booking.setBookingEndDate(b.getBookingEndDate());
//				booking.setBookingDesc(b.getBookingDesc());
//				booking.setStatus(b.getStatus());
//
//				// need change later
//				booking.setRoomid(2);
//				booking.setRoomCustomerNr(10);
//				booking.setCustomerFname("killer");
//				booking.setCustomerEnamne("Nalle");
//
//				bookingList.add(booking);
//			}
		}

		return bookingList;

	}

	public List<Booking> addNewBooking(Booking newBooking) {
		Booking booking = new Booking();
		
		
		List<Room> newRoomList = new ArrayList<Room>();
		List<Customer> newCustomerList = new ArrayList<Customer>();
		
		List<Booking> bookingList = getListOfBooking();
		List<Customer> customerList = dataHandler.readCutomerFromFile("Customer.txt");
		List<Room> roomList = dataHandler.readRoomFromFile("Room.txt");
		
		newBooking.setBookingId(bookingList.size() + 1);
		newBooking.setStatus(1);
		
		for (Room room : roomList) {
			if(room.getRoomid() == newBooking.getBookingRoomNr()) {
				System.out.println(room);
				room.setRoomBookingNr(newBooking.getBookingId());
				room.setRoomBookingDate(newBooking.getBookingStartDate());
				room.setRoomCustomerNr(newBooking.getBookingCustomerId());
				
				newBooking.setRoomBookingNr(room.getRoomBookingNr());
				newBooking.setRoomCustomerNr(room.getRoomCustomerNr());
				newBooking.setRoomBookingDate(room.getRoomBookingDate());
				newBooking.setRoomDesc(room.getRoomDesc());
				newBooking.setRoomType(room.getRoomType());
				newBooking.setStatus(room.getStatus());
				
			}
			newRoomList.add(room);
			dataHandler.saveToFileList(newRoomList);
		}
		for (Customer customer: customerList) {
			if(customer.getCustomerId() == newBooking.getBookingCustomerId()) {
				newBooking.setBookingCustomerFname(customer.getCustomerFname());
				newBooking.setBookingCustomerEnamne(customer.getCustomerEnamne());
				
				newBooking.setCustomerFname(customer.getCustomerFname());
				newBooking.setCustomerEnamne(customer.getCustomerEnamne());
				newBooking.setCustomerAddress(customer.getCustomerAddress());
				newBooking.setCustomerEmail(customer.getCustomerEmail());
				newBooking.setCustomerPhone(customer.getCustomerPhone());
				newBooking.setStatus(customer.getStatus());
				
			}
		}
		
		bookingList.add(newBooking);

		
		dataHandler.saveToFileList(bookingList);
		return  bookingList;

	}

	public void removeBooking(ObservableList<Booking> bookingList, int rId) {
		bookingList.remove(rId);
		dataHandler.saveToFileList(bookingList);
		
	}

	public int returnDayStay(LocalDate startDay,LocalDate EndDay) {
		int dayBetween = startDay.datesUntil(EndDay).collect(Collectors.toList()).size();
		return dayBetween;		
	}
	
	public ObservableList<Booking> searchById(String searchId){
		List<Booking> list =  getListOfBooking();
		ObservableList<Booking> bookingList2 = FXCollections.observableArrayList();
		
		ObservableList<Booking> bookingLis = getOListOfBooking(1);
		int sId = Integer.parseInt(searchId);
		
		for(Booking b : list) {
			if (sId == b.getBookingId()) {
				bookingList2.add(b);
			}
		}
		return bookingList2;
		
	}
}
