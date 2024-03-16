package org.CustomerManager.Controller;

import org.CustomerManager.DBService.AddressDBHandler;
import org.CustomerManager.DBService.ConcertDBHandler;
import org.CustomerManager.DBService.ConsertDBInterface;
import org.CustomerManager.Model.Arena;
import org.CustomerManager.Model.Concert;
import org.CustomerManager.Model.Customer;
import org.CustomerManager.View.MainCustomerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConcertController implements ConcertControllerInterface{
    @Override
    public Concert createConcert() {
        Scanner concertInput = new Scanner(System.in);
        Concert concert = new Concert();
        Arena arena = new Arena();
        ConcertDBHandler concertDBHandler = new ConcertDBHandler();
        concert.setArena(arena);
        int ConsertId = concertDBHandler.create(concert);
        System.out.println(concert);
        System.out.println(arena);
        listAllConcert();
        return concert;
    }

    @Override
    public void listAllConcert() {
        String[] cutomerMenu = {"Book a Concert", "Exit"};
        ConcertDBHandler concertDBHandler = new ConcertDBHandler();
        //Test data
        List<Concert> concertList = concertDBHandler.ListConsert();
        // TODO Get list data from dB




    }

    @Override
    public Concert updateCustomer(Customer customer, String[] menu) {
        return null;
    }

    @Override
    public void deleteConcert() {

    }
}
