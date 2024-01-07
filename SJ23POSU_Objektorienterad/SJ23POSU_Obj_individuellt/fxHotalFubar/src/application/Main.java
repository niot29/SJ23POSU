package application;

import java.io.IOException;

import application.modell.Customer;
import application.services.CustomerServices;
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
		
		
		Customer customer = new Customer();
		customer.setCustomerFname("Fnamne");
		customer.setCustomerEnamne("Ename");
		customer.setCustomerAddress("Address");
		customer.setCustomerEmail("Email");
		customer.setCustomerPhone("phtone");
		
//		Customer customer2 = new Customer();
//		customer2.setCustomerFname("2Fnamne");
//		customer2.setCustomerEnamne("2Ename");
//		customer2.setCustomerAddress("2Address");
//		customer2.setCustomerEmail("2Email");
//		customer2.setCustomerPhone("2phtone");
//		
		
		CustomerServices customerServices = new CustomerServices();
		customerServices.addNewCustomer(customer);
//		customerServices.addNewCustomer(customer2);
		
	

	}

	public static void main(String[] args) {
		launch(args);
	}
}
