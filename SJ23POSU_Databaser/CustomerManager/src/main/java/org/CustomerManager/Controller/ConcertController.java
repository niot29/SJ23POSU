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

        System.out.println("Input Artist name");
        concert.setArtistName(concertInput.next());
        System.out.println("Input Concert date");
        concert.setDate(concertInput.next());
        System.out.println("Input ticket price");
        concert.setTicketPrice(Integer.parseInt(concertInput.next()));
        System.out.println("Input age limit");
        concert.setAgeLimit(concertInput.nextInt());
        System.out.println(concert);

        /*
        System.out.println("========================");
        System.out.println("Input arena information");
        arena.setAddress(concertInput.next());
        System.out.println("Input arena name");
        arena.setName(concertInput.next());
        System.out.println("Input arena adress");
        arena.setAddress(concertInput.next());
        */

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
