package org.CustomerManager.DBService;

import org.CustomerManager.Model.Address;
import org.CustomerManager.Model.Customer;

import java.util.List;

public interface AddressDBInterface {

    public void create(Address address);

    public Address getAddressById(int id);

    public List<Address> ListAddress();

    public Address updateAddress(Address address);

    void deleteAddressByCustomerId(int id);
    void deleteAddressByArenaId(int id);

}
