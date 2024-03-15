package org.CustomerManager.Controller;

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

}