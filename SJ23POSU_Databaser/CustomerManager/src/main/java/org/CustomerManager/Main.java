package org.CustomerManager;

import org.CustomerManager.View.MainAdminView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        System.out.println("Hello world!");
        Scanner scanner = new Scanner(System.in);
        boolean isLoggedIn = false;
        String adminPassword = "adminPassword";
        String cutomerPassword = "cutomerPassword";
        MainAdminView mainAdminView = new MainAdminView();

        int choise;

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
                String[] menu1= { "XXXXXXXX", "gkdjasöglfjfdö", "MANAGER CUTOMER", "Exit" };
                mainAdminView.mainScreen(menu1);
                System.exit(0);
                // add some method for admin
                break;
            case 2:
                System.out.println("Redirect to Cutomer Menu...");
                String[] menu2 = { "BOOKING", "MANAGER ROOM", "MANAGER CUTOMER", "Exit" };
                mainAdminView.mainScreen(menu2);
                System.exit(0);
                // add some method for Customer
                break;
            default:
                System.out.println("Ogiltigt val. Försök igen.");
                break;
        }


    }

}


