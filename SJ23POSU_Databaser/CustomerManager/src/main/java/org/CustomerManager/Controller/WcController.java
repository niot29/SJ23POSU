package org.CustomerManager.Controller;

import org.CustomerManager.DBService.ConcertDBHandler;
import org.CustomerManager.DBService.WcDBHandling;
import org.CustomerManager.Model.Arena;
import org.CustomerManager.Model.Concert;
import org.CustomerManager.Model.Customer;
import org.CustomerManager.Model.Wc;
import org.CustomerManager.View.MainCustomerView;
import org.CustomerManager.View.MainView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WcController implements  WcControllerInterface{
    @Override
    public Wc createBooking(Customer customer) {
        MainCustomerView mainConcertScreen = new MainCustomerView();
        AdminController mainCustomerMenu = new AdminController();
        ConcertDBHandler concertDBHandler = new ConcertDBHandler();

        List<Concert> concertList = concertDBHandler.ListConcert();
        mainConcertScreen.concertScreen(concertList);

        Scanner wcInput = new Scanner(System.in);
        System.out.println("Select Concert for booking (Input 0 for quit): ");
        int selection = wcInput.nextInt();

        if (selection > 0 && selection <= concertList.size()) {
            WcDBHandling wcDBHandling = new WcDBHandling();
            Concert concert = concertList.get(selection - 1);
            List<Concert> concertList1 = new ArrayList<Concert>();
            List<Arena> arenaList1 = new ArrayList<Arena>();
            Wc wcBooking = new Wc();
            concertList1.add(concert);

            ArenaController arenaController = new ArenaController();
            Arena arena = arenaController.getArenaById(concert.getArena().getId());
            arenaList1.add(arena);

            mainConcertScreen.concertScreen(concertList1);
            mainConcertScreen.arenaScreen(arenaList1);
            //mainView.mainScreen(menu);

            Scanner wcInputBooking = new Scanner(System.in);
            System.out.println("Would tou like too book this concert (Y/N Input 0 for quit): ");
            String bookingSelection = wcInputBooking.nextLine();

            if(bookingSelection.equals('N') || bookingSelection.equals('n')){
                String[] customerMenu = { "List Concert", "Book Concert","List My Bookning", "Change My info", "Exit" };
                mainCustomerMenu.displayCustomerMainMenu(customerMenu);
            }


            wcBooking.setConcert(concert);
            wcBooking.setCustomer(customer);

            System.out.println(wcBooking);
            wcDBHandling.create(wcBooking);


        }
return null;
    }

    @Override
    public void listAllBooking() {
        MainCustomerView mainWcScreen = new MainCustomerView();
        MainView mainView = new MainView();

        WcDBHandling wcDBHandling = new WcDBHandling();
        List<Wc> wcList = wcDBHandling.ListWc();
        mainWcScreen.wcScreen(wcList);

    }

}
