package org.CustomerManager.DBService;

import org.CustomerManager.Model.Customer;

import java.util.List;

public interface CustomerDBInterface {

    public void create(Customer customer);

    public Customer getCustomerById(int id);

    public List<Customer> ListCustomer();

    public Customer updateCustomer(Customer customer);

    void deleteCustomerById(int id);

}
