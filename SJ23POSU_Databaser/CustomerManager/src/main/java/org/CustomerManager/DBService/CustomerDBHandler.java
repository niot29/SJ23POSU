package org.CustomerManager.DBService;

import org.CustomerManager.Model.Customer;

import java.util.List;

public class CustomerDBHandler implements  CustomerDBInterface{


    @Override
    public int create(Customer customer) {
        return 0;
    }

    @Override
    public Customer getCustomerById(int id) {
        return null;
    }

    @Override
    public List<Customer> ListCustomer() {
        return null;
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return null;
    }

    @Override
    public void deleteCustomerById(int id) {

    }
}
