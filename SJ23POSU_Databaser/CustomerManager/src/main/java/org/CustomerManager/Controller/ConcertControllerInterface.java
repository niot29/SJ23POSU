package org.CustomerManager.Controller;


import org.CustomerManager.Model.Concert;
import org.CustomerManager.Model.Customer;

public interface ConcertControllerInterface {
    public Concert createConcert();

    public void listConcertForCustomer();
    public void listConcertForAdmin();


    void deleteConcert();
}
