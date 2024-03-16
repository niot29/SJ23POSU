package org.CustomerManager.Controller;


import org.CustomerManager.Model.Address;

public interface AddressControllerInterface {
    public Address createAddress();

    public void listAllAddress();

    public Address getAddressById(int id);

    void updateCustomer(Address address);

    void deleteCustomer(Address address);
}
