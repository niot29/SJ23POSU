package application.services;

import java.util.ArrayList;
import java.util.List;

import application.modell.Customer;
import application.modell.Room;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CustomerServices {

	DataHandler dataHandler = new DataHandler();

	private List<Customer> getListOfCustomer() {

		return dataHandler.readCutomerFromFile("Customer.txt");
	}

	public ObservableList<Customer> getOListOfCustomer(int statusType) {
		List<Customer> list = getListOfCustomer();
		ObservableList<Customer> customerList = FXCollections.observableArrayList();

		for (Customer c : list) {

			if (c.getStatus() == 0) {

				Customer newCustomer = new Customer();
				newCustomer.setCustomerId(c.getCustomerId());
				newCustomer.setCustomerFname(c.getCustomerFname());
				newCustomer.setCustomerEnamne(c.getCustomerEnamne());
				newCustomer.setCustomerAddress(c.getCustomerAddress());
				newCustomer.setCustomerEmail(c.getCustomerEmail());
				newCustomer.setCustomerPhone(c.getCustomerPhone());

				newCustomer.setStatus(c.getStatus());

				customerList.add(newCustomer);
			} else {
				Customer newCustomer = new Customer();
				newCustomer.setCustomerId(c.getCustomerId());
				newCustomer.setCustomerFname(c.getCustomerFname());
				newCustomer.setCustomerEnamne(c.getCustomerEnamne());
				newCustomer.setCustomerAddress(c.getCustomerAddress());
				newCustomer.setCustomerEmail(c.getCustomerEmail());
				newCustomer.setCustomerPhone(c.getCustomerPhone());

				newCustomer.setStatus(c.getStatus());

				customerList.add(newCustomer);
			}
		}

		return customerList;

	}

	public List<Customer> addNewCustomer(Customer newCustomer) {
		Customer customer = new Customer();
		List<Customer> customerList = new ArrayList<Customer>();

//		customerList = dataHandler.readCutomerFromFile("Customer.txt");
		customerList = getListOfCustomer();
		newCustomer.setCustomerId(customerList.size() + 1);
		newCustomer.setStatus(1);
		customerList.add(newCustomer);
		// To-do from file

		dataHandler.saveToFileList(customerList);

		return customerList;

	}
	
	public void removeCustome(ObservableList<Customer> customerList, int rId) {
		System.out.println(customerList);
//		roomList.get(rId).setStatus(0);
		customerList.remove(rId);
		dataHandler.saveToFileList(customerList);
	}

}
