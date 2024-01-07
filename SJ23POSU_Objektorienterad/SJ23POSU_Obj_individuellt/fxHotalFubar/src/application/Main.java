package application;

import java.io.IOException;

import application.modell.Booking;
import application.modell.Customer;
import application.modell.Room;
import application.services.BookingServices;
import application.services.CustomerServices;
import application.services.RoomHandler;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws IOException {
	
		 

		//FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("views/ParticipantDetails.fxml"));
		
		FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("views/main.fxml"));

		Scene scene = new Scene(fxmlLoader.load(), 1200, 900);
		primaryStage.setTitle("Tour Di Ski");
		primaryStage.setScene(scene);
		primaryStage.show(); 
		
 
	}

	@Override
	public void init() throws Exception {
		// TODO Auto-generated method stub
		super.init();
		System.out.println("test");
		
		
//		Customer customer = new Customer();
//		customer.setCustomerFname("Fnamne");
//		customer.setCustomerEnamne("Ename");
//		customer.setCustomerAddress("Address");
//		customer.setCustomerEmail("Email");
//		customer.setCustomerPhone("phtone");
//		
////		Customer customer2 = new Customer();
////		customer2.setCustomerFname("2Fnamne");
////		customer2.setCustomerEnamne("2Ename");
////		customer2.setCustomerAddress("2Address");
////		customer2.setCustomerEmail("2Email");
////		customer2.setCustomerPhone("2phtone");
////		
//		
//		CustomerServices customerServices = new CustomerServices();
//		customerServices.addNewCustomer(customer);
////		customerServices.addNewCustomer(customer2);
		
//	
//		RoomHandler roomhnadler = new RoomHandler();
//		Room room = new Room();
//		
//		room.setRoomBookingNr(11);
//		room.setRommCustomerNr(1);
//		room.setRoomBookingDate("2024-01-01");
//		room.setRoomDesc("Rummet är bokad ");
//		roomhnadler.addNewCustomer(room);
		
		
		
//		BookingServices bookingService = new BookingServices();
//		Booking  booking = new Booking();
//		booking.setBookingRoomNr(1);
//		booking.setBookingCustomerId(1);
//		booking.setBookingStayDay(3);
//		booking.setBookingStartDate("2024-01-01");
//		booking.setBookingEndDate("2024-01-04");
//		
//		
//		bookingService.addNewCustomer(booking);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
