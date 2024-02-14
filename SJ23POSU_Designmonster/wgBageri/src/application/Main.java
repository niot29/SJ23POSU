package application;

import java.util.ArrayList;
import java.util.List;

import application.BusinessObject.*;
import application.CakeBuilder.*;
import application.Command.MarzipanCover;
import application.Command.MarzipanGarnish;
import application.Command.PourCover;
import application.Command.ProcessingPipeline;
import application.View.MainMenu;

public class Main {
	public static void main(String[] args) {

		/**
		 * Init add new customer
		 */

		List<Customer> customerList = new ArrayList<Customer>();
		Customer customer1 = new Customer(1, "Nils", null);
		customerList.add(customer1);
		Customer customer2 = new Customer(2, "Kungen", null);
		customerList.add(customer2);

		/**
		 * Menu
		 */

		int menuResponse = 0;

		// MainMenu
		MainMenu menu = new MainMenu();
		menuResponse = menu.mainScreen();
		// Select a customer
		Customer customer = new Customer();
		if (menuResponse == 1) {
			customer = menu.listCustomerScreen(customerList);
		}

		// Select a cake
		menuResponse = menu.selectCake(customer);

//    	
//        /**
//         * Observer
//         */
//
//         Vd vd = new Vd();
//         OrderHandler orderHandler = new OrderHandler();
//         orderHandler.addPropertyChangeListener(vd);
//         orderHandler.setOrderStatus("Order is add");
//         //orderHandler.setOrderProcess("Oder is done");
//
//
//        /**
//         * Build Plan cakae
//         */
//
//        Director director = new Director();
//        CakeBuilder builder = new CakeBuilder();
//        director.buildPrincessCake(builder);
//        builder.addCakId(1);
//        Cake cake = builder.build();
//
//        /**
//         * Start Cake pipeline
//         */
//        cake = director.pipelinePrincessCake(cake);
//        System.out.println(cake);
//        System.out.println("============================");
//        orderHandler.setOrderProcess("Oder is done");
//
//
//
//       director.buildOperaCake(builder);
//       builder.addCakId(2);
//       Cake cake2 = builder.build();
//       cake2 = director.pipelineOperaCake(cake2);
//       System.out.println(cake2);
//
//       System.out.println("============================");
//       director.buildChocolateCake(builder);
//       builder.addCakId(3);
//       Cake cake3 = builder.build();
//       cake3 = director.pipelineChocolateCake(cake3);
//       System.out.println(cake3);

	}
}