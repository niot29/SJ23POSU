package org.example.View;

public class MainAdminView {
    public void mainScreen(String[] menu) {
        // clearScreen();
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
