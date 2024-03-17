package org.CustomerManager.Controller;
import org.CustomerManager.DBService.AddressDBHandler;
import org.CustomerManager.DBService.ArenaDBHandler;
import org.CustomerManager.DBService.ConcertDBHandler;
import org.CustomerManager.Model.Address;
import org.CustomerManager.Model.Arena;
import org.CustomerManager.Model.Concert;
import org.CustomerManager.Model.Customer;
import org.CustomerManager.View.MainCustomerView;
import org.CustomerManager.View.MainView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConcertController implements ConcertControllerInterface{

    public Concert createConcert(){
        Scanner concertInput = new Scanner(System.in);
        Concert concert = new Concert();
        Arena arena = new Arena();
        ConcertDBHandler concertDBHandler = new ConcertDBHandler();
        ArenaDBHandler arenaDBHandler = new ArenaDBHandler();
        Address address = new Address();

        System.out.println("Input Artist name");
        concert.setArtistName(concertInput.next());
        System.out.println("Input Concert date");
        concert.setDate(concertInput.next());
        System.out.println("Input ticket price");
        concert.setTicketPrice(Integer.parseInt(concertInput.next()));
        System.out.println("Input age limit");
        concert.setAgeLimit(concertInput.nextInt());
        System.out.println(concert);
        System.out.println(arena);

        // List all Arena
        MainCustomerView mainArenaScreen = new MainCustomerView();
        List<Arena> arenaList = arenaDBHandler.ListArena();
        mainArenaScreen.arenaScreen(arenaList);


        System.out.println("Select Arena for this Consert (Input 0 for quit): ");
        Scanner arenaSelection = new Scanner(System.in);
        AdminController mainView = new AdminController();
        String[] menu1= { "Create Customer", "List All Customer","Create Arena","List All Arene","Create New Consert","List All Consert", "List Customer Order (WC)","Exit" };

        String arenaSelect = arenaSelection.nextLine();
        int selection = Integer.parseInt(arenaSelect);
        System.out.println(selection);

        if(selection <= arenaList.size()){
            //System.out.println(arenaList.get(selection - 1));
            concert.setArena(arenaList.get(selection - 1));
            concertDBHandler.create(concert);
            listConcertForAdmin();
        }else {
            System.out.println("Some thing is wrong cant save info");
        }

        mainView.displayMainMenu(menu1);

        return concert;
    }


    public void listConcertForCustomer() {
        MainCustomerView mainConcertScreen = new MainCustomerView();
        AdminController adminController = new AdminController();
        ConcertDBHandler concertDBHandler = new ConcertDBHandler();
        List<Concert> concertList =  concertDBHandler.ListConcert();
        mainConcertScreen.concertScreen(concertList);

        String[] menu2 = { "List Concert", "Book Concert","List My Bookning", "Change My info", "Exit" };
        adminController.displayCustomerMainMenu(menu2);

    }

    @Override
    public void listConcertForAdmin() {
        MainCustomerView mainConcertScreen = new MainCustomerView();
        AdminController adminController = new AdminController();
        ConcertDBHandler concertDBHandler = new ConcertDBHandler();
        List<Concert> concertList =  concertDBHandler.ListConcert();
        mainConcertScreen.concertScreen(concertList);

        String[] menu1= { "Create Customer", "List All Customer","Create Arena","List All Arene","Create New Consert","List All Consert", "List Customer Order (WC)","Exit" };
        adminController.displayMainMenu(menu1);
    }

    @Override
    public void deleteConcert() {

    }

}
