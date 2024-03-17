package org.CustomerManager.Controller;

import org.CustomerManager.Model.Concert;
import org.CustomerManager.Model.Customer;

import java.util.List;

public interface CustomerControllerInterface {
    public Customer createCustomer();

    public void listAllCustomer();

    public void listCustomer(Customer customer);

    // Hardcode role value 1=customer 0=admin
    void updateCustomer(Customer customer,int roleType);

    void deleteCustomer(Customer customer);
}
