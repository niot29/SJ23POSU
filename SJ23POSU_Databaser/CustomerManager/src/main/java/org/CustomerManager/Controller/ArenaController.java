package org.CustomerManager.Controller;

import org.CustomerManager.DBService.AddressDBHandler;
import org.CustomerManager.DBService.ArenaDBHandler;
import org.CustomerManager.DBService.CustomerDBHandler;
import org.CustomerManager.Model.Address;
import org.CustomerManager.Model.Arena;
import org.CustomerManager.Model.Customer;
import org.CustomerManager.View.MainCustomerView;

import java.util.Scanner;

public class ArenaController implements ArenaControllerInterface{
    @Override
    public Arena createArena() {
        Scanner arenaInput = new Scanner(System.in);
        Scanner customerInput = new Scanner(System.in);
        Address address = new Address();
       // AddressDBHandler addressDBHandler = new AddressDBHandler();
        ArenaDBHandler arenaDBHandler = new ArenaDBHandler();
        Arena arena = new Arena();


        System.out.println("Input Arena infromation: ");
        System.out.println("Add Arena Nane: ");
        arena.setName(arenaInput.next());
        //System.out.println("Type of Arena (Indore/Outdors): ");


        System.out.println("========================");
        System.out.println("Input Arena address information: ");
        System.out.println("Input street: ");
        address.setStreet(customerInput.next());
        System.out.println("Input street nr: ");
        address.setStreetnr(customerInput.nextInt());
        System.out.println("Input Postcode: ");
        address.setPostcode(customerInput.next());
        System.out.println("Input City: ");
        address.setCity(customerInput.next());

        arena.setAddress(address);
        arenaDBHandler.create(arena);

        listAllArena();
        return null;
    }

    @Override
    public void listAllArena() {
        MainCustomerView mainArenaScreen = new MainCustomerView();
        ArenaDBHandler arenaDBHandler = new ArenaDBHandler();
        mainArenaScreen.arenaScreen(arenaDBHandler.ListArena());

    }

    @Override
    public void listArena(Arena arena) {

    }

    @Override
    public Arena getArenaById(int id) {
        ArenaDBHandler arenaDBHandler = new ArenaDBHandler();
        return arenaDBHandler.getArenaById(id);
    }

    @Override
    public void updateArena(Arena arena) {

    }

    @Override
    public void deleteArena(Arena arena) {

    }
}
