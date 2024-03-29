package org.CustomerManager.Controller;

import org.CustomerManager.Model.Concert;
import org.CustomerManager.Model.Customer;

import java.util.List;

public interface CustomerControllerInterface {
    public Customer createCustomer();

    public void listAllCustomer();

    public void listCustomer(Customer customer);
    void updateCustomer(Customer customer);

    void deleteCustomer(Customer customer);
}
