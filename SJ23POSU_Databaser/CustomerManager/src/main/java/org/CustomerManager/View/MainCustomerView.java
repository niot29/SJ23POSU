package org.CustomerManager.View;

import org.CustomerManager.Model.Address;
import org.CustomerManager.Model.Customer;

import java.io.IOException;
import java.util.List;

public class MainCustomerView {
    public static void clearScreen() {
        // clear sccen on win10
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {
        }
    }

    public void customerScreen(List<Customer> customerList) {
        //clearScreen();

        int num = 117;
        for (int i = 0; i <= num; ++i) {
            System.out.print("-");
        }
        System.out.println();
        System.out.printf("| %-10s | %-25s |  %-25s | %-25s | %-16s | %n", "CUTOMER.NO", "FIRSTNAME",
                "LASTNAME", "BIRTHDAY", "PHONE");
        String inline = "| %-10s | %-25s |  %-25s | %-25s |  %-12s | %n";

        for (int i = 0; i <= num; ++i) {
            System.out.print("-");
        }
        // System.out.print(out);
        System.out.println();

        int row = 1;
        for (Customer customer : customerList) {
            System.out.format(inline,row,customer.getFirstName(),customer.getLastName(),customer.getBirthDate(),customer.getPhoneNumber());
            row++;
        }
        for (int i = 0; i <= num; ++i) {
            System.out.print("-");
        }
        System.out.println("");
    }

    public void addressScreen(List<Address> addressList) {
        clearScreen();

        int num = 117;
        for (int i = 0; i <= num; ++i) {
            System.out.print("-");
        }
        System.out.println();
        System.out.printf("| %-10s | %-25s |  %-25s | %-25s | %-16s | %n", "CUTOMER.NO", "STREET",
                "STREET NR", "POSTCODE", "CITY");
        String inline = "| %-10s | %-25s |  %-25s | %-25s |  %-12s | %n";

        for (int i = 0; i <= num; ++i) {
            System.out.print("-");
        }
        // System.out.print(out);
        System.out.println("");

        for (Address address : addressList) {
            System.out.format(inline, address.getId(),address.getStreet(),address.getStreetnr(),address.getPostcode(),address.getCity());
        }
        for (int i = 0; i <= num; ++i) {
            System.out.print("-");
        }
        System.out.println("");
    }

}
