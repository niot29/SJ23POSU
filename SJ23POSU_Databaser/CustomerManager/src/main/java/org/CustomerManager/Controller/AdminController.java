package org.CustomerManager.Controller;

import org.CustomerManager.DBService.CustomerDBHandler;
import org.CustomerManager.Model.Customer;
import org.CustomerManager.View.MainView;

import java.util.Scanner;


public class AdminController {
    public void displayMainMenu(String[] menuItems){
        String[] menu= {};
        MainView mainView = new MainView();
        mainView.mainScreen(menuItems);

        Scanner mainInput = new Scanner(System.in);
        String menuSelection = mainInput.nextLine();
        int selection = Integer.parseInt(menuSelection);

        while (selection > menuItems.length || selection <=0) {
            mainView.mainScreen(menuItems);
            menuSelection = mainInput.nextLine();
            selection = Integer.parseInt(menuSelection);
        }

        CustomerController customerHandler = new CustomerController();

        switch (selection) {
            case 1:
                System.out.println("Create Customer");
                customerHandler.createCustomer();
                break;
            case 2:
                System.out.println("List alla customer");
                customerHandler.listAllCustomer();
                break;
            case 5:
                System.exit(0);
                break;

            default:
                break;

        }
    }
    public void displayCustomerMainMenu(String[] menuItems){
        String[] menu= {};
        MainView mainView = new MainView();
        mainView.mainScreen(menuItems);

        Scanner mainInput = new Scanner(System.in);
        String menuSelection = mainInput.nextLine();
        int selection = Integer.parseInt(menuSelection);

        while (selection > menuItems.length || selection <=0) {
            mainView.mainScreen(menuItems);
            menuSelection = mainInput.nextLine();
            selection = Integer.parseInt(menuSelection);
        }

        ConcertController concertController = new ConcertController();
        CustomerController customerController = new CustomerController();


        // -- Test data
        CustomerDBHandler customerDBHandler = new CustomerDBHandler();
        Customer customer = new Customer();
        customer = customerDBHandler.getCustomerById(7);
        // ----


        switch (selection) {
            case 1:
                System.out.println("List all Concert");
                concertController.listAllConcert();
                break;
            case 2:
                System.out.println("List my Booking");
                //TODO process for handling Order (list my wc)
                break;
            case 3:
                System.out.println("Change My info");
                //customerController.listCustomer(customer);
                customerController.updateCustomer(customer);
            case 5:
                System.exit(0);
                break;

            default:
                break;

        }
    }
}
