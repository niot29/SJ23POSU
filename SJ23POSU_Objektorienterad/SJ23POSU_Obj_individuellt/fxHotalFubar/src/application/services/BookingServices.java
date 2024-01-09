package application.services;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import application.modell.Booking;
import application.modell.Customer;
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

	public List<Booking> addNewCustomer(Booking newBooking) {
		Booking booking = new Booking();

		List<Booking> bookingList = getListOfBooking();
		newBooking.setBookingId(bookingList.size() + 1);
		newBooking.setStatus(1);
		bookingList.add(newBooking);


		dataHandler.saveToFileList(bookingList);

		return null;

	}

	public void removeBooking(ObservableList<Booking> bookingList, int rId) {
		bookingList.remove(rId);
		dataHandler.saveToFileList(bookingList);
	}

	public int returnDayStay(LocalDate startDay,LocalDate EndDay) {
		int dayBetween = startDay.datesUntil(EndDay).collect(Collectors.toList()).size();
//		System.out.println(startDay.datesUntil(EndDay)
//			      .collect(Collectors.toList()));
		return dayBetween;		
	}

}
