package application.View;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import application.BusinessObject.Cake;
import application.BusinessObject.Customer;
import application.BusinessObject.OrderHandler;
import application.BusinessObject.Vd;
import application.CakeBuilder.CakeBuilder;
import application.CakeBuilder.Director;

import java.io.IOException;

public class MainMenu {

	private static void clearScreen() {
		int width = 200;
		int height = 30;

		// clear screen
		System.out.print("\033[H\033[2J");
		System.out.flush();
		System.out.println("");

		// clear sccen on win10
		try {
			if (System.getProperty("os.name").contains("Windows"))
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			else
				Runtime.getRuntime().exec("clear");
		} catch (IOException | InterruptedException ex) {
		}

	}

	public int mainScreen() {
		// Clear screen
		clearScreen();

		String menuSelection = "";
		Scanner mainInput = new Scanner(System.in);

		while (!menuSelection.contentEquals("1")) {

			String leftAlignFormat = "|   %-3d | %-25s |%n";
			System.out.println("");
			System.out.println("");
			System.out.format("+=======+===========================+%n");
			System.out.format("| Menu  | Descriptions              |%n");
			System.out.format("+-------+---------------------------+%n");
			System.out.format("+  1    + List customer             +%n");
			System.out.format("+  9    + Exit                      +%n");
			System.out.format("+-------+---------------------------+%n");
			System.out.print("Navigate from menu, select option in menu: ");

			menuSelection = mainInput.nextLine();
			if (menuSelection.contentEquals("9")) {
				break;
			}

		}
		return Integer.parseInt(menuSelection);
	}

	public Customer listCustomerScreen(List<Customer> customerList) {
		// Clear screen
		clearScreen();
		int listAize = customerList.size();

		String menuSelection = "10";
		Scanner mainInput = new Scanner(System.in);

		while (Integer.parseInt(menuSelection) > listAize) {

			String leftAlignFormat = "|   %-3d | %-25s |%n";
			System.out.println("");
			System.out.println("");
			System.out.format("+=======+===========================+%n");
			System.out.format("| Menu  | Customer                  |%n");
			System.out.format("+-------+---------------------------+%n");
			for (Customer c : customerList) {
				System.out.format(leftAlignFormat, c.getId(), c.getName());
			}
			System.out.format("+-------+---------------------------+%n");
			System.out.print("Navigate from menu, select Customer in menu: ");

			menuSelection = mainInput.nextLine();

		}

		Customer customer = new Customer();
		for (Customer c : customerList) {
			if (c.getId() == Integer.parseInt(menuSelection)) {
				customer = c;
			}
		}
		return customer;
	}

	public int selectCake(Customer customer) {
		// Clear screen
		clearScreen();

		String menuSelection = "10";
		Scanner mainInput = new Scanner(System.in);
		int i = 0;
		List<Cake> orderList = new ArrayList<Cake>();

		while (!menuSelection.equals("4")) {

			String leftAlignFormat = "|   %-3d | %-25s |%n";
			System.out.println("");
			System.out.println("");
			System.out.format("+=======+===========================+%n");
			System.out.format("| Menu  | Customer                  |%n");
			System.out.format("+-------+---------------------------+%n");
			System.out.format("+  1    + PrincessCake              +%n");
			System.out.format("+  2    + Opera Cake                +%n");
			System.out.format("+  3    + Chocolate Cake            +%n");
			System.out.format("+  4    + Exit                      +%n");
			System.out.format("+-------+---------------------------+%n");
			System.out.print("Navigate from menu, select Cake from menu: ");

			menuSelection = mainInput.nextLine();

			Vd vd = new Vd();
			OrderHandler orderHandler = new OrderHandler();
			orderHandler.addPropertyChangeListener(vd);

			Director director = new Director();
			CakeBuilder builder = new CakeBuilder();
			Cake cake = new Cake();
			i++;
			switch (menuSelection) {
			case "1":
				// PrincessCake
				orderHandler.setOrderStatus("Order on PrincessCake is add");
				director.buildPrincessCake(builder);
				builder.addCakId(i);
				cake = builder.build();
				cake = director.pipelinePrincessCake(cake);
				cakeOutputt(cake);
				orderHandler.setOrderProcess("Cake is done");
				orderList.add(cake);
				break;
			case "2":
				// Opera Cake
				orderHandler.setOrderStatus("Order on OperaCake is add");
				director.buildOperaCake(builder);
				builder.addCakId(i);
				cake = builder.build();
				cake = director.pipelineOperaCake(cake);
				cakeOutputt(cake);
				orderHandler.setOrderProcess("Cake is done");
				orderList.add(cake);
				break;
			case "3":
				// Chocolate Cake
				orderHandler.setOrderStatus("Order on ChocolateCake is add");

				director.buildChocolateCake(builder);
				builder.addCakId(i);
				cake = builder.build();
				cake = director.pipelineChocolateCake(cake);
				cakeOutputt(cake);
				orderHandler.setOrderProcess("Cake is done");
				orderList.add(cake);
				break;
			case "4":
				System.out.print("Exit: ");
				break;
			default:
				// mainScreen();
				System.out.print("Your chouse is incorrect. Pleace try again: ");
				break;
			}

			
		}
		
		customer.setOrderList(orderList);
		
		customerOutput(customer);
		return Integer.parseInt(menuSelection);
	}

	private void cakeOutputt(Cake cake) {
		// Clear screen
		//clearScreen();

		System.out.println("Cake Type: " + cake.getName());
		System.out.println("Build: " + cake.getCakeBottomLayer());
		System.out.println("Build: " + cake.getCakeBottomCream());
		System.out.println("Build " + cake.getCakeMiddleLayer());
		System.out.println("Build: " + cake.getCakeMiddleCream());
		System.out.println("Build: " + cake.getCakeTopLayer());
		for (String s : cake.getDecoratedStep()) {
			System.out.println(s);
		}

	}
	
	private void customerOutput(Customer customer) {
		// Clear screen
		clearScreen();
		String leftAlignFormat = "|   %-3d | %-25s |%n";
		System.out.println("");
		System.out.println("");
		System.out.println("Customer OrderList: " + customer.getName());
		System.out.format("+=======+===========================+%n");
		System.out.format("| Order ID  | Cake T                |%n");
		System.out.format("+-------+---------------------------+%n");
		for (Cake c : customer.getOrderList()) {
			System.out.format(leftAlignFormat, c.getId(), c.getName());
		}
		System.out.format("+-------+---------------------------+%n");
		

	}
}
