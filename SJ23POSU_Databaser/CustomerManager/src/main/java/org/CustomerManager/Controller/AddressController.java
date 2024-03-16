package org.CustomerManager.Controller;

import org.CustomerManager.DBService.AddressDBHandler;
import org.CustomerManager.Model.Address;
import org.CustomerManager.Model.Customer;
import org.CustomerManager.View.MainCustomerView;

import java.util.ArrayList;
import java.util.List;

public class AddressController implements  AddressControllerInterface{

    @Override
    public Address createAddress() {
        return null;
    }

    @Override
    public void listAllAddress() {

    }

    @Override
    public Address getAddressById(int id) {
        AddressDBHandler addressDBHandler = new AddressDBHandler();
        return addressDBHandler.getAddressById(id);
    }

    @Override
    public void updateCustomer(Address address) {

    }

    @Override
    public void deleteCustomer(Address address) {

    }
}
