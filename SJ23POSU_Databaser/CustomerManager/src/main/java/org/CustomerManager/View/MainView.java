package org.CustomerManager.View;

import java.io.IOException;

public class MainView {

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

    public void mainScreen(String[] menu) {
        //clearScreen();
        String leftAlignFormat = "|   %-3d | %-25s |%n";
        System.out.println("");
        System.out.println("");
        System.out.format("+=======+===========================+%n");
        System.out.format("| Menu  | Descriptions              |%n");
        System.out.format("+-------+---------------------------+%n");
        for (int i = 0; i < menu.length; i++) {
            System.out.format(leftAlignFormat, i + 1, menu[i]);
        }
        System.out.format("+-------+---------------------------+%n");
        System.out.print("Navigate from menu, select option in menu: ");

    }

}
