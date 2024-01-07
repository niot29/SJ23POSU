package application.services;

import java.util.ArrayList;
import java.util.List;

import application.modell.Customer;

public class CustomerServices {

	DataHandler dataHandler = new DataHandler();
	
	public List<Customer> addNewCustomer(Customer newCustomer) {
		Customer customer = new Customer();
		List<Customer> customerList = new ArrayList<Customer>();

		
		customerList = dataHandler.readCutomerFromFile("Customer.txt");
		newCustomer.setCustomerId(customerList.size() + 1);
		newCustomer.setStatus(1);
		customerList.add(newCustomer);
		System.out.println("addNewCustomer: "  + customerList);
		
		
		
		//To-do from file 
		
		
		dataHandler.saveToFileList(customerList);
		
		return null;
		
		
	}
	
	
	
}
