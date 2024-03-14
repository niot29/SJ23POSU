package org.CustomerManager.Controller;


import org.CustomerManager.DBService.AddressDBHandler;
import org.CustomerManager.DBService.CustomerDBHandler;
import org.CustomerManager.Model.Address;
import org.CustomerManager.Model.Customer;
import org.CustomerManager.View.MainCustomerView;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerHandler {

    public Customer createCustomer(){
        Scanner customerInput = new Scanner(System.in);
        Customer customer = new Customer();
        Address address = new Address();
        CustomerDBHandler customerDBHandler = new CustomerDBHandler();
        AddressDBHandler addressDBHandler = new AddressDBHandler();

        System.out.println("Input Cunstomer first name: ");
        customer.setForname(customerInput.next());
        System.out.println("Input Cunstomer last name: ");
        customer.setEnamne(customerInput.next());
        System.out.println("Input Cunstomer Birth date: ");
        customer.setBirthdate(customerInput.next());
        System.out.println("Input Cunstomer phone: ");
        customer.setPhone(customerInput.next());
        System.out.println(customer);

        System.out.println("========================");
        System.out.println("Input Customer address information: ");
        System.out.println("Input street: ");

        address.setStreet(customerInput.next());
        System.out.println("Input street nr: ");
        address.setStreetnr(customerInput.nextInt());
        System.out.println("Input Postcode: ");
        address.setPostcode(customerInput.next());
        System.out.println("Input City: ");
        address.setCity(customerInput.next());

        int addressId = addressDBHandler.create(address);
        customer.setAddress(address);
        int customerId = customerDBHandler.create(customer);
        System.out.println(customer);
        System.out.println(address);
        return customer;
    }

    public void listAllCustomer(){
        // test data
        Address address = new Address(50,"Stockholm",23,"12344","killervägen1");
        Customer customer1 = new Customer(100,"Nils","Ottosson","750329","123456789",address);
        Customer customer2 = new Customer(200,"Nisse","Ottosson","750329","123456789");

        List<Customer> customerList = new ArrayList<Customer>();
        customerList.add(customer1);
        customerList.add(customer2);

        Scanner customerInput = new Scanner(System.in);
        MainCustomerView mainCustomerView = new MainCustomerView();
        CustomerDBHandler customerDBHandler = new CustomerDBHandler();
        AddressDBHandler addressDBHandler = new AddressDBHandler();
        //Customer customer = new Customer();
        //Address address = new Address();
        // Get this infor fram dbHandler
        // List<Customer> customerList = customerDBHandler.ListCustomer();

        // Send to View
        mainCustomerView.customerScreen(customerList);

        System.out.println("Input customer id for customer address info (Input 0 for quit): ");
        String choiseImput = customerInput.nextLine();
        int selection = Integer.parseInt(choiseImput);

        AdminController mainView = new AdminController();

        if( selection > 0 && selection <= customerList.size()){
            // System.out.println("zzzz "  + customerList.get(selection - 1));
            // System.out.println(customerList.get(selection - 1).getAddress().getId());

            List<Address> addressList = new ArrayList<Address>();
            addressList.add(customerList.get(selection - 1).getAddress());
            mainCustomerView.addressScreen(addressList);


        } else{
            String[] menu= { "Create Customer", "List All Customer","Create New Consert","List All Consert", "Exit" };
            mainView.displayMainManu(menu);
        }

    }


}
