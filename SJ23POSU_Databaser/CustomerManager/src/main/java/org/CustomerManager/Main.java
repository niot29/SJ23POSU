package org.CustomerManager;

import org.CustomerManager.Controller.AdminController;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        System.out.println("Hello world!");
        Scanner scanner = new Scanner(System.in);
        boolean isLoggedIn = false;
        String adminPassword = "adminPassword";
        String cutomerPassword = "cutomerPassword";
        AdminController adminController = new AdminController();

        int choise;

        // Open session to DB -- just for Nils Project have problem for fynding config file
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session=sessionFactory.openSession();


        while (true) {
            System.out.println("Enter the password for the user you want to login as.:");
            String inputPassword = scanner.next();
            if (inputPassword.equals(adminPassword)) {
                System.out.println("Login succeeded as admin!");
                isLoggedIn = true;
                choise = 1;
                break;
            } else if (inputPassword.equals(cutomerPassword)) {
                System.out.println("Login succeeded as cutomer!!");
                isLoggedIn = true;
                choise = 2;
                break;
            } else {
                System.out.println("Fel lösenord. Försök igen.");
                choise = 0;
            }
        }
        switch (choise) {
            case 1:
                System.out.println("Redirect to Admin Menu ...");
                String[] menu1= { "Create Customer", "List All Customer","Create New Consert","List All Consert", "Exit" };
                adminController.displayMainMenu(menu1);

                break;
            case 2:
                System.out.println("Redirect to Cutomer Menu...");
                String[] menu2 = { "List Concert", "List My Bookning", "Change My info", "Exit" };
                adminController.displayCustomerMainMenu(menu2);
                // add some method for Customer
                break;
            default:
                System.out.println("Ogiltigt val. Försök igen.");
                break;
        }


    }

}


