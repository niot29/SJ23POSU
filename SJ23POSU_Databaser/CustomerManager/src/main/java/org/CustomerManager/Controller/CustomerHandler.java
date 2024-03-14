package org.CustomerManager.Controller;


import org.CustomerManager.DBService.AddressDBHandler;
import org.CustomerManager.DBService.CustomerDBHandler;
import org.CustomerManager.Model.Address;
import org.CustomerManager.Model.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

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

}
