package main;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class fubar {

	static ArrayList<String> cutomerInfo;
	static ArrayList<String> bookingInfo;
	static ArrayList<String> roomInfo;
	static HashMap<Integer, ArrayList<String>> cuntomerDb = new HashMap<Integer, ArrayList<String>>();
	static HashMap<Integer, ArrayList<String>> roomDb = new HashMap<Integer, ArrayList<String>>();
	static HashMap<Integer, ArrayList<String>> bookingDb = new HashMap<Integer, ArrayList<String>>();

	static HashMap<Integer, HashMap<String, ArrayList<String>>> bookingData = new HashMap<Integer, HashMap<String, ArrayList<String>>>();

	private static void clearScreen() {
		int width = 200;
		int height = 30;
		String str = "HOTEL FUBAR";
		// clear screen
		System.out.print("\033[H\033[2J");
		System.out.flush();

		// BufferedImage image = ImageIO.read(new
		// File("/Users/mkyong/Desktop/logo.jpg"));
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();
		g.setFont(new Font("SansSerif", Font.BOLD, 24));

		Graphics2D graphics = (Graphics2D) g;
		graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		graphics.drawString(str, 10, 20);

		// save this image
		// ImageIO.write(image, "png", new File("/users/mkyong/ascii-art.png"));

		for (int y = 0; y < height; y++) {
			StringBuilder sb = new StringBuilder();
			for (int x = 0; x < width; x++) {

				sb.append(image.getRGB(x, y) == -16777216 ? " " : "$");

			}

			if (sb.toString().trim().isEmpty()) {
				continue;
			}

			System.out.println(sb);
		}

	}

	private static void mainScreen(String[] menu) {
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

	private static void customerScreen() {

		int num = 143;
		for (int i = 0; i <= num; ++i) {
			System.out.print("-");
		}
		System.out.println();
		System.out.printf("| %-10s | %-25s |  %-25s | %-25s | %-25s |  %-12s | %n", "CUTOMER.NO", "FIRSTNAME",
				"LASTNAME", "EMAIL", "ADDRESS", "PHONE");
		String inline = "| %-10s | %-25s |  %-25s | %-25s | %-25s |  %-12s | %n";

		for (int i = 0; i <= num; ++i) {
			System.out.print("-");
		}
		// System.out.print(out);
		System.out.println("");

		for (int cKey : cuntomerDb.keySet()) {
			/*
			 * String STATUS = roomDb.get(cKey).get(5).replace("0", "BOOKED"); STATUS =
			 * STATUS.replace("1", "---"); STATUS = STATUS.replace("X", "OOS"); String
			 * CUSTOM = roomDb.get(cKey).get(3).replace("0", "--"); String BOKNO =
			 * roomDb.get(cKey).get(2).replace("0", "--");
			 */
			System.out.format(inline, cKey, cuntomerDb.get(cKey).get(0), cuntomerDb.get(cKey).get(1),
					cuntomerDb.get(cKey).get(2), cuntomerDb.get(cKey).get(3), cuntomerDb.get(cKey).get(4));
		}
		for (int i = 0; i <= num; ++i) {
			System.out.print("-");
		}
		System.out.println("");
	}

	private static void roomScreen(int listType) {

		int num = 100;
		for (int i = 0; i <= num; ++i) {
			System.out.print("-");
		}
		System.out.println();
		System.out.printf("|  %-10s | %-10s |  %-10s | %-10s | %-15s |  %-10s | %-10s  | %n", "ROOM.NO", "ROOM TYPE",
				"BOOKING NO", "CUTOMER.NO", "BOOKING DATE", "STATUS", "DESCRIPTION");
		String inline = "|  %-10s | %-10s |  %-10s | %-10s | %-15s | %-10s | %-10s | %n";

		for (int i = 0; i <= num; ++i) {
			System.out.print("-");
		}
		// System.out.print(out);
		System.out.println("");

		switch (listType) {
		case 1:

			for (int cKey : roomDb.keySet()) {
				String STATUS = roomDb.get(cKey).get(5).replace("0", "BOOKED");
				STATUS = STATUS.replace("1", "---");
				STATUS = STATUS.replace("X", "OOS");
				String CUSTOM = roomDb.get(cKey).get(3).replace("0", "--");
				String BOKNO = roomDb.get(cKey).get(2).replace("0", "--");

				System.out.format(inline, cKey, roomDb.get(cKey).get(0), BOKNO, CUSTOM, roomDb.get(cKey).get(4), STATUS,
						roomDb.get(cKey).get(1));
			}

			break;
		case 2:

			for (int cKey : roomDb.keySet()) {
				if (roomDb.get(cKey).get(5).equals("1")) {
					String STATUS = roomDb.get(cKey).get(5).replace("0", "BOOKED");
					STATUS = STATUS.replace("1", "--");
					STATUS = STATUS.replace("X", "OOS");
					String CUSTOM = roomDb.get(cKey).get(3).replace("0", "--");
					String BOKNO = roomDb.get(cKey).get(2).replace("0", "--");

					System.out.format(inline, cKey, roomDb.get(cKey).get(0), BOKNO, CUSTOM, roomDb.get(cKey).get(4),
							STATUS, roomDb.get(cKey).get(1));
				}

			}

			break;
		default:
			break;

		}

		for (int i = 0; i <= num; ++i) {
			System.out.print("-");
		}
		System.out.println("");

	}

	private static void bookingScreen(int listType, int bkey) {

		int num = 130;
		for (int i = 0; i <= num; ++i) {
			System.out.print("-");
		}
		System.out.println();
		System.out.printf("| %-10s | %-10s | %-10s | %-15s | %-10s |  %-15s | %-10s | %-25s | %n", "BOOKING.NO",
				"ROOM.NO", "CUTOMER.NO", "BOOKING DATE", "STAY", "DEPARTURE", "STATUS", "DESCRIPTION");
		String inline = "| %-10s | %-10s | %-10s | %-15s | %-10s |  %-15s | %-10s | %-25s | %n";

		for (int i = 0; i <= num; ++i) {
			System.out.print("-");
		}
		// System.out.print(out);
		System.out.println("");

		switch (listType) {
		case 1:

			for (int cKey : bookingDb.keySet()) {
				String STATUS = bookingDb.get(cKey).get(6).replace("0", "BOOKED");
				STATUS = STATUS.replace("1", "---");
				STATUS = STATUS.replace("X", "OOS");
				String CUSTOM = bookingDb.get(cKey).get(1).replace("0", "--");
				String ROMMNO = bookingDb.get(cKey).get(0).replace("0", "--");

				System.out.format(inline, cKey, ROMMNO, CUSTOM, bookingDb.get(cKey).get(2), bookingDb.get(cKey).get(3),
						bookingDb.get(cKey).get(4), STATUS, bookingDb.get(cKey).get(5));
			}

			break;

		case 2:
			for (int cKey : bookingDb.keySet()) {

				if (bookingDb.get(cKey).get(6).equals("1")) {
					String STATUS = bookingDb.get(cKey).get(6).replace("0", "BOOKED");
					STATUS = STATUS.replace("1", "---");
					STATUS = STATUS.replace("X", "OOS");
					String CUSTOM = bookingDb.get(cKey).get(1).replace("0", "--");
					String ROMMNO = bookingDb.get(cKey).get(0).replace("0", "--");

					System.out.format(inline, cKey, ROMMNO, CUSTOM, bookingDb.get(cKey).get(2),
							bookingDb.get(cKey).get(3), bookingDb.get(cKey).get(4), STATUS, bookingDb.get(cKey).get(5));
				}
			}

		default:
			break;

		}

		for (int i = 0; i <= num; ++i) {
			System.out.print("-");
		}
		System.out.println("");
	}

	private static void setDbColumn() {
		cutomerInfo = new ArrayList<String>();
		cutomerInfo.add("First Name: ");
		cutomerInfo.add("Last Name: ");
		cutomerInfo.add("Email: ");
		cutomerInfo.add("Address: ");
		cutomerInfo.add("Phone: ");

		roomInfo = new ArrayList<String>();
		roomInfo.add("Type (Bed in the room): ");
		roomInfo.add("Description: ");
		roomInfo.add("Booking no: ");
		roomInfo.add("Customer no: ");
		roomInfo.add("Booking start date: ");
		roomInfo.add("Status: ");

		bookingInfo = new ArrayList<String>();
		bookingInfo.add("Room no: ");
		bookingInfo.add("Cutomer: ");
		bookingInfo.add("Booking start date (YYYY-MM-DD): ");
		bookingInfo.add("Stay days: ");
		bookingInfo.add("Booking end date (YYYY-MM-DD): ");
		bookingInfo.add("Description: ");
		bookingInfo.add("Status: ");

		// upload data to map

		HashMapFromTextFile("Booking.txt", bookingDb);
		HashMapFromTextFile("Cutomer.txt", cuntomerDb);
		HashMapFromTextFile("Room.txt", roomDb);

	}

	private static void mainMenu() {
		String[] menu = { "Booking", "MgnRoom", "MgnCustom", "Exit" };
		mainScreen(menu);

		String mSelection = "";
		Scanner mainInput = new Scanner(System.in);
		mSelection = mainInput.nextLine();
		while (!mSelection.equals(Integer.toString(menu.length))) {

			switch (mSelection) {
			case "1":
				clearScreen();
				bookingHandler();
				break;
			case "2":
				clearScreen();
				roomManager();
				break;
			case "3":
				clearScreen();
				customerManager();
				break;
			case "4":
				System.out.println("Exit");
				break;
			default:
				// mainScreen();
				System.out.print("Your chouse is incorrect. Pleace try again: ");
			}
			clearScreen();
			mainScreen(menu);
			mSelection = mainInput.nextLine();

		}
		mainInput.close();
		mainScreen(menu);
	}

	private static void saveToFile(String dbFile) {

		String outputFilePath = null;
		BufferedWriter bf = null;
		Set<Entry<Integer, ArrayList<String>>> mapEntrySet = null;
		switch (dbFile) {
		case "booking":
			outputFilePath = "Booking.txt";
			mapEntrySet = bookingDb.entrySet();
			break;
		case "customer":
			outputFilePath = "Cutomer.txt";
			mapEntrySet = cuntomerDb.entrySet();
			break;
		case "room":
			outputFilePath = "Room.txt";
			mapEntrySet = roomDb.entrySet();
			break;
		default:
			break;
		}
		File file = new File(outputFilePath);
		try {

			// create new BufferedWriter for the output file
			bf = new BufferedWriter(new FileWriter(file));

			// iterate map entries
			// for (Map.Entry<Integer, ArrayList<String>> entry : cuntomerDb.entrySet()) {
			for (Map.Entry<Integer, ArrayList<String>> entry : mapEntrySet) {

				// put key and value separated by a colon
				bf.write(entry.getKey() + ":" + entry.getValue());

				// new line
				bf.newLine();
			}

			bf.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			try {

				// always close the writer
				bf.close();
			} catch (Exception e) {
			}
		}
	}

	private static void HashMapFromTextFile(String filePath, HashMap<Integer, ArrayList<String>> db) {
		// String filePath = "Cutomer.txt";
		String[] strArray = null;
		BufferedReader br = null;

		try {

			// create file object
			File file = new File(filePath);

			// create BufferedReader object from the File
			br = new BufferedReader(new FileReader(file));

			String line = null;

			// read file line by line
			while ((line = br.readLine()) != null) {

				// split the line by :
				String[] parts = line.split(":");

				// first part is name, second is number
				int mKey = Integer.parseInt(parts[0].trim());
				// System.out.println("Key: " + mKey);
				String regex1 = ",";
				Pattern ptr1 = Pattern.compile(regex1);

				strArray = ptr1.split(parts[1]);
				ArrayList<String> mList = new ArrayList<String>();
				for (int i = 0; i < strArray.length; i++) {

					strArray[i] = strArray[i].replace("[", "");
					strArray[i] = strArray[i].replace("]", "");
					// strArray[i] = strArray[i].replace(" ", "");
					mList.add(strArray[i].trim());
				}
				db.put(mKey, mList);
				// System.out.println(db);

			}
		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println("System cant open som data import file: ." + filePath);
		} finally {

			// Always close the BufferedReader
			if (br != null) {
				try {
					br.close();
				} catch (Exception e) {
				}
				;
			}
		}

	}

	private static int customerManagerAddNewCutomer() {
		int custId = 1;
		try {
			custId = cuntomerDb.entrySet().stream().reduce((one, two) -> two).get().getKey();
		} catch (Exception e) {
			// custId = 1;
			// e.printStackTrace();
		}
		Scanner input = new Scanner(System.in);
		ArrayList<String> inputList = new ArrayList<String>();
		for (String customer_str : cutomerInfo) {
			System.out.print(customer_str);
			String inputValue = "";
			inputValue = input.nextLine();
			inputList.add(inputValue);
		}

		cuntomerDb.put(custId + 1, inputList);

		// Sort HasMap by key
		HashMap<Integer, ArrayList<String>> temp = cuntomerDb.entrySet().stream()
				.sorted((i1, i2) -> i1.getKey().compareTo(i2.getKey()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

		// BUGG CAST EXEPTION WHEN ADDING MER CUTOMER AND SCANNER IS CLOSE.
		// input.close();
		return custId + 1;
	}

	private static void customerManagerUpdateCutomer() {
		Scanner input3 = new Scanner(System.in);
		Scanner scanValue = new Scanner(System.in);
		System.out.print("Udpdate cutmer with ID: ");
		int cuId = input3.nextInt();
		if (cuntomerDb.containsKey(cuId)) {
			String[] custInfo = cutomerInfo.toArray(new String[cutomerInfo.size()]);
			mainScreen(custInfo);
			System.out.println("With field would you lika to update:");

			ArrayList<String> values = cuntomerDb.get(cuId);

			int updateIndex = input3.nextInt();
			System.out.println("Update customer " + custInfo[updateIndex - 1] + ": " + values.get(updateIndex - 1));
			System.out.print("Input new information: ");
			String newValuse = scanValue.nextLine();
			values.set(updateIndex - 1, newValuse);
			cuntomerDb.put(cuId, values);
		}
		// System.out.println(cuntomerDb.containsKey(cuId));

	}

	private static void customerManagerremoveCutomer() {
		Scanner input4 = new Scanner(System.in);
		Scanner custValue = new Scanner(System.in);
		customerScreen();
		System.out.print("With Cutomer would you lika to remove: ");
		int rCuId = input4.nextInt();
		customerScreen();
		if (cuntomerDb.containsKey(rCuId)) {
			String[] custInfo = cutomerInfo.toArray(new String[cutomerInfo.size()]); //
			String[] values = cuntomerDb.get(rCuId).toArray(new String[cutomerInfo.size()]);
			System.out.print("Customer: " + values[0] + " " + values[1]);
			System.out.print("Verified y/n:");
			String confirme = custValue.nextLine();
			switch (confirme) {
			case "y":
				cuntomerDb.remove(rCuId);
				clearScreen();
				customerScreen();
				break;
			case "Y":
				cuntomerDb.remove(rCuId);
				clearScreen();
				customerScreen();
				break;
			default:
				break;
			}

		} else {
			System.out.println("This ID dosn't exist try again.");
		}
		setDbColumn();
	}

	public static void customerManager() {
		String[] customerMenu = { "List Cutomer", "Add new Cutomer", "Update Custom Informatiom", "Remove cutomer",
				"Exit" };
		mainScreen(customerMenu);

		String mSelection = "";
		int skipp = 1;
		Scanner mainInput = new Scanner(System.in);
		mSelection = mainInput.nextLine();
		while (!mSelection.equals(Integer.toString(customerMenu.length))) {

			switch (mSelection) {
			case "1":
				skipp = 1;
				clearScreen();
				customerScreen();
				mainScreen(customerMenu);
				break;
			case "2":
				System.out.println("Fill in customer information:");
				customerManagerAddNewCutomer();
				saveToFile("customer");
				mSelection = "1";
				skipp = 0;
				break;
			case "3":
				clearScreen();
				customerScreen();
				customerManagerUpdateCutomer();
				saveToFile("customer");
				mSelection = "1";
				skipp = 0;
				break;

			case "4":
				clearScreen();
				customerManagerremoveCutomer();
				saveToFile("customer");
				mSelection = "1";
				skipp = 0;
				break;
			case "5":
				break;
			default:
				clearScreen();
				mainScreen(customerMenu);
				System.out.print("Your chouse is incorrect. Pleace try again: ");
				mSelection = "0";
				break;

			}
			if (skipp != 0) {
				mSelection = mainInput.nextLine();
			}

		}

		mainMenu();

	}

	private static int roomManagerAddNewRoom() {
		int roomId5 = 1;
		try {
			roomId5 = roomDb.entrySet().stream().reduce((one, two) -> two).get().getKey();
		} catch (Exception e) {
			// custId = 1;
			// e.printStackTrace();
		}
		Scanner input = new Scanner(System.in);
		ArrayList<String> inputList = new ArrayList<String>();
		for (String room_str : roomInfo) {
			String inputValue = "";

			if (room_str.equals("Status: ")) {
				System.out.print("Room is bookable (y/n): ");
				inputValue = input.nextLine();
				if (inputValue.equals("y")) {
					inputValue = "1";
				} else {
					inputValue = "0";
				}
			} else if (room_str.equals("Booking no: ") || (room_str.equals("Customer no: "))
					|| (room_str.equals("Booking start date: "))) {
				inputValue = "0";
			} else {
				System.out.print(room_str);
				inputValue = input.nextLine();
			}

			inputList.add(inputValue);
		}
		roomDb.put(roomId5 + 1, inputList);
		return roomId5 + 1;

	}

	private static void roomManagerRemoveRoom() {
		Scanner input4 = new Scanner(System.in);
		System.out.println("Which room would you like to take out of :");
		int roomId4 = input4.nextInt();
		if (roomDb.containsKey(roomId4)) {
			// String[] custInfo = roomInfo.toArray(new String[roomInfo.size()]);
			ArrayList<String> values = roomDb.get(roomId4);
			int index = roomInfo.indexOf("Status: ");
			values.set(index, "X");
			roomDb.put(roomId4, values);
		}
	}

	private static void roomManagerUpdateRoom() {
		Scanner input3 = new Scanner(System.in);
		Scanner scanValue = new Scanner(System.in);
		System.out.print("Udpdate room with ID: ");
		int roomId = input3.nextInt();
		if (roomDb.containsKey(roomId)) {
			String[] rInfo = roomInfo.toArray(new String[roomInfo.size()]);
			mainScreen(rInfo);
			System.out.println("With field would you lika to update:");

			ArrayList<String> values = roomDb.get(roomId);

			int updateIndex = input3.nextInt();
			if (values.size() < updateIndex) {
				System.out.println("Cant update this value");

			}

			String statusString = "ENABLE";
			if (values.get(updateIndex - 1).equals("0")) {
				statusString = "BOOKED";

			}
			System.out.println("Update customer " + rInfo[updateIndex - 1] + ": " + values.get(updateIndex - 1));
			System.out.print("Input new information: ");
			String newValuse = scanValue.nextLine();

			values.set(updateIndex - 1, newValuse);
			roomDb.put(roomId, values);

		}
	}

	private static void roomManager() {
		String[] roomMenu = { "List All", "List Free", "Update room", "Remove room", "Add new room", "Exit" };
		mainScreen(roomMenu);
		String mSelection = "";
		int skipp = 1;
		Scanner mainInput = new Scanner(System.in);
		mSelection = mainInput.nextLine();
		while (!mSelection.equals(Integer.toString(roomMenu.length))) {

			switch (mSelection) {
			case "1":
				skipp = 1;
				clearScreen();
				roomScreen(1);
				mainScreen(roomMenu);
				break;
			case "2":
				skipp = 1;
				clearScreen();
				roomScreen(2);
				mainScreen(roomMenu);
				break;
			case "3":
				clearScreen();
				roomScreen(1);
				roomManagerUpdateRoom();
				saveToFile("room");
				mSelection = "1";
				skipp = 0;
				break;

			case "4":
				clearScreen();
				roomScreen(1);
				roomManagerRemoveRoom();
				saveToFile("room");
				mSelection = "1";
				skipp = 0;
				break;
			case "5":
				// clearScreen();
				// roomScreen(2);
				System.out.println("Fill in room information:");
				roomManagerAddNewRoom();
				saveToFile("room");
				mSelection = "1";
				skipp = 0;
				break;
			case "6":
				break;
			default:
				break;
			}
			if (skipp != 0) {
				mSelection = mainInput.nextLine();
			}

		}

	}

	private static int bookingHandlerAddNewBooking() {

		roomScreen(2);
		int bId;
		int roomKey = 0;
		int rvalue = 0;
		LocalDate firstDate = null;
		LocalDate secondDate = null;
		String stayDay = null;
		ArrayList<String> roomValue = new ArrayList<String>();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		try {
			bId = bookingDb.entrySet().stream().reduce((one, two) -> two).get().getKey();
		} catch (Exception e) {
			bId = 1;
			// e.printStackTrace();
		}
		Scanner input = new Scanner(System.in);
		Scanner switchInput = new Scanner(System.in);
		ArrayList<String> inputList = new ArrayList<String>();
		for (String str : bookingInfo) {
			String inputValue = "";
			String choisetValue = "";
			int cuID;

			switch (str) {
			case "Room no: ":
				System.out.print(str);
				inputValue = input.nextLine();
				roomKey = Integer.parseInt(inputValue);
				roomValue = roomDb.get(roomKey);

				break;
			case "Cutomer: ":
				System.out.print("List Cutomer in sytem (y/n): ");
				choisetValue = switchInput.nextLine();
				if (choisetValue.equals("y")) {
					customerScreen();
					System.out.print("Add new Cutomer (y/n): ");
					choisetValue = switchInput.nextLine();
					if (choisetValue.equals("y")) {
						cuID = customerManagerAddNewCutomer();
						System.out.println(cuID);
						inputValue = String.valueOf(cuID);

						// roomValue = roomDb.get(roomKey);
						roomValue.set(3, inputValue);
					} else {
						System.out.print("Add cutomer no: ");
					}

				} else {
					System.out.print("Add cutomer no: ");
				}
				inputValue = input.nextLine();
				roomValue.set(3, inputValue);
				break;
			case "Status: ":
				inputValue = "1";
				roomValue.set(5, "0");
				break;
			case "Booking start date (YYYY-MM-DD): ":
				System.out.print(str);
				inputValue = "";

				while (inputValue.isEmpty()) {
					String startDate = input.nextLine();

					try {

						firstDate = LocalDate.parse(startDate, formatter);
						// System.out.println(firstDate);
						inputValue = firstDate.toString();

					} catch (Exception e) {
						System.out.print("Wrong format on date. Need to bee number format: ");
						inputValue = "";
						// e.printStackTrace();
					}

				}

				break;
			case "Stay days: ":
				System.out.print(str);
				inputValue = "";
				stayDay = input.nextLine();
				inputValue = stayDay;
				break;
			case "Booking end date (YYYY-MM-DD): ":
				secondDate = firstDate.plusDays(Integer.parseInt(stayDay));
				System.out.println("Booking end date (YYYY-MM-DD): " + secondDate);
				inputValue = String.valueOf(secondDate);
				roomValue.set(4, inputValue);
				break;
			default:
				inputValue = input.nextLine();

				break;
			}

			inputList.add(inputValue);

		}

		bookingDb.put(bId + 1, inputList);
		roomValue.set(2, String.valueOf(bId + 1));

		// update Room database

		saveToFile("booking");
		saveToFile("room");

		return bId + 1;
	}

	private static void bookingHandlerCancelBooking() {
		bookingScreen(2, 0);
		setDbColumn();
		Scanner input = new Scanner(System.in);
		Scanner custValue = new Scanner(System.in);
		System.out.print("Cancel booking on booking no: ");
		int boid = input.nextInt();

		if (bookingDb.containsKey(boid)) {
			ArrayList<String> values = bookingDb.get(boid);
			int index = bookingInfo.indexOf("Status: ");
			int roomKey = Integer.parseInt(values.get(0)); // get room NO
			System.out.print("Verified remove booning y/n:");
			String confirme = custValue.nextLine();
			// clearScreen();

			ArrayList<String> roomList = roomDb.get(roomKey);

			switch (confirme) {
			case "y":
				roomList.set(2, "0");
				roomDb.put(roomKey, roomList);
				roomList.set(3, "0");
				roomDb.put(roomKey, roomList);
				roomList.set(4, "0");
				roomDb.put(roomKey, roomList);
				roomList.set(5, "1");
				roomDb.put(roomKey, roomList);

				values.set(index, "0");
				bookingDb.put(boid, values);

				break;
			case "Y":
				roomList.set(2, "0");
				roomDb.put(roomKey, roomList);
				roomList.set(3, "0");
				roomDb.put(roomKey, roomList);
				roomList.set(4, "0");
				roomDb.put(roomKey, roomList);
				roomList.set(5, "1");
				roomDb.put(roomKey, roomList);

				values.set(index, "0");
				bookingDb.put(boid, values);

				break;
			default:
				break;
			}
		}
		saveToFile("booking");
		saveToFile("room");

	}

	private static void bookingHandlerSearchByBookingNo() {
		System.out.print("Add booking no: ");
		Scanner input = new Scanner(System.in);
		String bId = input.nextLine();
		bookingScreen(3, Integer.parseInt(bId));

	}

	private static void bookingHandlerSearchByDate() {
		System.out.println("");

		System.out.println("");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		int inStatus = 0;
		Scanner input = new Scanner(System.in);
		// String insDate = "2023-10LocalDate -26";
		String insDate = null;
		LocalDate insearchDate = null;

		while (inStatus == 0) {
			System.out.print("search for date (YYYY-MM-DD): ");
			insDate = input.nextLine();

			try {
				dateFormat.parse(insDate.trim());
				insearchDate = LocalDate.parse(insDate, formatter);
				inStatus = 1;
			} catch (ParseException pe) {
				System.out.println("Wrong format on date. Need to bee number format: ");
				inStatus = 0;
			}

		}

		// LocalDate insearchDate = LocalDate.parse(insDate, formatter);

		ArrayList<Integer> freeRoomList = new ArrayList<Integer>();
		for (int roomKey : roomDb.keySet()) {
			ArrayList<String> roomList = roomDb.get(roomKey);

			if (roomList.get(5).equals("0") && !roomList.get(4).isEmpty()) {

				if (!roomList.get(4).equals("0")) {
					LocalDate localDate = LocalDate.parse(roomList.get(4), formatter);
					int compareValueStatusDate = insearchDate.compareTo(localDate);

					if (compareValueStatusDate > 0) {
						// System.out.println(insDate + " is latter than " + localDate);
					} else {
						freeRoomList.add(roomKey);

					}
				} else {
					freeRoomList.add(roomKey);

				}
			} else {
				freeRoomList.add(roomKey);
			}

		}

		// Remove room that cant bee book
		for (int key : freeRoomList) {
			roomDb.remove(key);
		}
		roomScreen(1);
		setDbColumn();

	}

	private static void bookingHandler() {
		String[] bookingMenu = { "Book", "List All Booking", "List Free Room", "Cancel reservation",
				"Search By Booking no", "Search By Date", "Exit" };
		mainScreen(bookingMenu);
		String mSelection = "";
		Scanner mainInput = new Scanner(System.in);
		mSelection = mainInput.nextLine();
		int skipp = 1;
		while (!mSelection.equals(Integer.toString(bookingMenu.length))) {
			switch (mSelection) {
			case "1":
				// customerScreen();
				bookingHandlerAddNewBooking();
				saveToFile("booking");
				saveToFile("room");
				saveToFile("customer");
				// mSelection = "1";
				skipp = 1;
				break;
			case "2":
				clearScreen();
				bookingScreen(2, 0);
				mainScreen(bookingMenu);
				skipp = 1;
				break;
			case "3":
				skipp = 1;
				clearScreen();
				roomScreen(2);
				mainScreen(bookingMenu);
				break;
			case "4":
				clearScreen();
				bookingHandlerCancelBooking();
				saveToFile("booking");
				saveToFile("room");
				saveToFile("customer");
				mSelection = "2";
				break;
			case "5":
				clearScreen();
				bookingScreen(2, 0);
				bookingHandlerSearchByBookingNo();
				skipp = 1;
				break;
			case "6":
				clearScreen();
				bookingScreen(2, 0);
				bookingHandlerSearchByDate();
				skipp = 1;
				break;
			default:
				clearScreen();
				mainScreen(bookingMenu);
				System.out.print("Your chouse is incorrect. Pleace try again: ");
				mSelection = "0";
				break;
			}

			if (skipp != 0) {
				mSelection = mainInput.nextLine();
			}

		}
	}

	public static void main(String[] args) {
		clearScreen();
		setDbColumn();
		mainMenu();

		// Test funk
		// customerScreen();
		//bookingScreen(1, 1);
		//bookingScreen(2, 1);
		// roomScreen(2);

		// addcutomerInfo();
	}

}
