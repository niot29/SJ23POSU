package application.services;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import application.modell.Booking;
import application.modell.Customer;
import application.modell.Room;

public class DataHandler {
	
	
	public void clearfile(String filename) {
		File file = new File(filename);
		try {
			new FileWriter(file, false).close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public <T> void saveToFileList(List<T> customerList) {

		String filename = null;
		// Get Object class type
		String oclass = customerList.get(0).getClass().getName();
//		System.out.println(oclass);

		switch (oclass) {
		case "application.modell.Customer":
			filename = "Customer.txt";
			clearfile(filename);
			break;

		case "application.modell.Booking":
			filename = "Booking.txt";
			clearfile(filename);
			break;

		case "application.modell.Room":
			filename = "Room.txt";
			clearfile(filename);
			break;
		}

		File file = new File(filename);

		try {

			// Remove content i file before add from list
//			new FileWriter(file, false).close();
			for (Object o : customerList) {

				FileWriter fw = new FileWriter(file, true);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(o.toString());

//				bw.write(p.getId() + "," + p.getNamen() + "," + p.getPosition() + "," + p.getStartTime() + ","
//						+ p.getTotalDiffrenceTime() + "," + p.getCompTime01() + "," + p.getCompTime02() + ","
//						+ p.getCompTime03() + "," + p.getEndTime() + "," + p.getSpeed());

				bw.newLine();

				bw.close();
				fw.close();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public List<Customer> readCutomerFromFile(String filname) {
		BufferedReader br = null;

		List<Customer> customerList = new ArrayList<Customer>();
		try {

			File file = new File(filname);
			br = new BufferedReader(new FileReader(file));

			String line = null;
			while ((line = br.readLine()) != null) {
				List<String> list = new ArrayList<String>();
				Customer cust = new Customer();

				String[] parts = line.split(",");

				for (String a : parts) {
//					System.out.println(" parts[0] " + a);
					String[] s = a.split("=");
					String[] c = s[1].split("]");
					list.add(c[0]);

				}
				
				cust.setCustomerId(Integer.parseInt(list.get(0)));
				cust.setCustomerFname(list.get(1));
				cust.setCustomerEnamne(list.get(2));
				cust.setCustomerAddress(list.get(3));
				cust.setCustomerEmail(list.get(4));
				cust.setCustomerPhone(list.get(5));
				cust.setStatus(Integer.parseInt(list.get(6)));

				customerList.add(cust);
			}
		} catch (Exception e) {
			// TODO: handle exception
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
		
		return customerList;

	}
	
	
	public List<Booking> readBookingFromFile(String filname) {
		BufferedReader br = null;

		List<Booking> bookingList = new ArrayList<Booking>();
		try {

			File file = new File(filname);
			br = new BufferedReader(new FileReader(file));

			String line = null;
			while ((line = br.readLine()) != null) {
				List<String> list = new ArrayList<String>();
				Booking booking = new Booking();

				String[] parts = line.split(",");

				for (String a : parts) {
//					System.out.println(" parts[0] " + a);
					String[] s = a.split("=");
					String[] c = s[1].split("]");
					list.add(c[0]);

				}
				
				System.out.println(list);
				booking.setBookingId(Integer.parseInt(list.get(0)));
				booking.setBookingRoomNr(Integer.parseInt(list.get(1)));
				booking.setBookingCustomerId(Integer.parseInt(list.get(2)));
				booking.setBookingStayDay(Integer.parseInt(list.get(3)));
				booking.setBookingStartDate(list.get(4));
				booking.setBookingEndDate(list.get(5));
				booking.setBookingDesc(list.get(6));
				booking.setStatus(Integer.parseInt(list.get(7)));
				bookingList.add(booking);
			}
		} catch (Exception e) {
			// TODO: handle exception
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
		
		return bookingList;

	}
	
	
	public List<Room> readRoomFromFile(String filname) {
		System.out.println("readRoomFromFile: filename " + filname);
		BufferedReader br = null;

		List<Room> roomList = new ArrayList<Room>();
		try {

			File file = new File(filname);
			br = new BufferedReader(new FileReader(file));

			String line = null;
			while ((line = br.readLine()) != null) {
				List<String> list = new ArrayList<String>();
				Room room = new Room();

				String[] parts = line.split(",");

				for (String a : parts) {
//					System.out.println(" parts[0] " + a);
					String[] s = a.split("=");
					String[] c = s[1].split("]");
					list.add(c[0]);

				}
				
				room.setRoomid(Integer.parseInt(list.get(0)));
				room.setRoomBookingNr(Integer.parseInt(list.get(1)));
				room.setRoomCustomerNr(Integer.parseInt(list.get(2)));
				room.setRoomType(list.get(3));
				room.setRoomBookingDate(list.get(4));
				room.setRoomDesc(list.get(5));
				room.setStatus(Integer.parseInt(list.get(6)));
				
				roomList.add(room);
								
			}
		} catch (Exception e) {
			// TODO: handle exception
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
		
		return roomList;

	}

}
