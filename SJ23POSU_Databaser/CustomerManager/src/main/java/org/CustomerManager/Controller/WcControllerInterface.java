package org.CustomerManager.Controller;

import org.CustomerManager.Model.Arena;
import org.CustomerManager.Model.Concert;
import org.CustomerManager.Model.Customer;
import org.CustomerManager.Model.Wc;

public interface WcControllerInterface {
    public Wc createBooking(Customer customer);

    public void listAllBooking();


}
