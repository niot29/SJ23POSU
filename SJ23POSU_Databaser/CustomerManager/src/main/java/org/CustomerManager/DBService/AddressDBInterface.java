package org.CustomerManager.DBService;

import org.CustomerManager.Model.Address;
import org.CustomerManager.Model.Customer;

import java.util.List;

public interface AddressDBInterface {

    public int create(Address address);

    public Address getAddressById(int id);

    public List<Address> ListAddress();

    public Address updateCustomer(Address address);

    void deleteAddressById(int id);

}
