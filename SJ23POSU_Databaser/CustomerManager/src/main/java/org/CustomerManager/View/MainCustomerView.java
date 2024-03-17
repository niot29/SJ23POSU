package org.CustomerManager.View;

import org.CustomerManager.Model.*;

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
    public void arenaScreen(List<Arena> arenaList) {
        clearScreen();

        int num = 117;
        for (int i = 0; i <= num; ++i) {
            System.out.print("-");
        }
        System.out.println();
        System.out.printf("| %-10s | %-25s | %-16s | %n", "ARENA NO","ARENA NAME", "ARENA ADRESS");
        String inline = "| %-10s | %-25s |%-12s | %n";

        for (int i = 0; i <= num; ++i) {
            System.out.print("-");
        }
        // System.out.print(out);
        System.out.println();

        int row = 1;
        for (Arena arena : arenaList) {
            System.out.format(inline, row, arena.getName(), arena.getAddress());
            row++;
        }
        for (int i = 0; i <= num; ++i) {
            System.out.print("-");
        }
        System.out.println("");
    }
    public void concertScreen(List<Concert> concertList) {
        clearScreen();

        int num = 117;
        for (int i = 0; i <= num; ++i) {
            System.out.print("-");
        }
        System.out.println();
        System.out.printf("| %-10s | %-25s |  %-25s  | %-16s | %n", "CONCERT ID","ARTIST NAME", "DATE",
                "PRICE", "AGE");
        String inline = "| %-10s | %-25s |  %-25s |  %-12s | %n";

        for (int i = 0; i <= num; ++i) {
            System.out.print("-");
        }
        // System.out.print(out);
        System.out.println();

        int row = 1;
        for (Concert concert : concertList) {
            System.out.format(inline, row, concert.getArtistName(), concert.getDate(), concert.getTicketPrice(), concert.getAgeLimit());
            row++;
        }
        for (int i = 0; i <= num; ++i) {
            System.out.print("-");
        }
        System.out.println("");
    }

    public void wcScreen(List<Wc> wcList) {
        clearScreen();

        int num = 117;
        for (int i = 0; i <= num; ++i) {
            System.out.print("-");
        }
        System.out.println();
        System.out.printf("| %-10s | %-25s |  %-25s | %-25s | %-16s | %n", "ORDER.NO", "WC NAME",
                "NAME", "CONCERT", "ARENA");
        String inline = "| %-10s | %-25s |  %-25s | %-25s |  %-12s | %n";


        for (int i = 0; i <= num; ++i) {
            System.out.print("-");
        }
        // System.out.print(out);
        System.out.println();

        int row = 1;
        for (Wc wc : wcList) {
            System.out.format(inline, wc.getId(),wc.getName(),wc.getCustomer().getFirstName() + " " + wc.getCustomer().getLastName(),wc.getConcert().getArtistName(),wc.getConcert().getArena().getName());
            row++;
        }
        for (int i = 0; i <= num; ++i) {
            System.out.print("-");
        }
        System.out.println("");
    }

}
