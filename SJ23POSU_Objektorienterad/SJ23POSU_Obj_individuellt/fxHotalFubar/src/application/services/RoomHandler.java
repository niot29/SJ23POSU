package application.services;

import java.util.ArrayList;
import java.util.List;

import application.modell.Customer;
import application.modell.Room;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class RoomHandler {

	DataHandler dataHandler = new DataHandler();

	private List<Room> getListOfRoom() {

		return dataHandler.readRoomFromFile("Room.txt");
	}

	public ObservableList<Room> getOListOfRoom(int statusType) {
		List<Room> list = getListOfRoom();
		ObservableList<Room> roomList = FXCollections.observableArrayList();

		System.out.println(list);
		
		for (Room r : list) {

			if (r.getStatus() == 0) {

				Room room = new Room();
				room.setRoomid(r.getRoomid());
				room.setRoomBookingNr(r.getRoomBookingNr());
				room.setRoomCustomerNr(r.getRoomCustomerNr());
				room.setRoomBookingDate(r.getRoomBookingDate());
				room.setRoomDesc(r.getRoomDesc());
				room.setRoomType(r.getRoomType());
				room.setStatus(r.getStatus());
				
				
				room.setCustomerFname(r.getCustomerFname());
				room.setCustomerEnamne(r.getCustomerEnamne());

				roomList.add(room);
			} else {
				
				Room room = new Room();
				room.setRoomid(r.getRoomid());
				room.setRoomBookingNr(r.getRoomBookingNr());
				room.setRoomCustomerNr(r.getRoomCustomerNr());
				room.setRoomBookingDate(r.getRoomBookingDate());
				room.setRoomDesc(r.getRoomDesc());
				room.setRoomType(r.getRoomType());
				room.setStatus(r.getStatus());
				
				
				room.setCustomerFname(r.getCustomerFname());
				room.setCustomerEnamne(r.getCustomerEnamne());

				roomList.add(room);
				
				
				
			}
		}

		return roomList;

	}

	public List<Room> addNewCustomer(Room newRoom) {
		Room room = new Room();

		List<Room> roomList = getListOfRoom();
		newRoom.setRoomid(roomList.size() + 1);
		newRoom.setStatus(1);
		roomList.add(newRoom);
		System.out.println("addNewCustomer: " + roomList);

		// To-do from file

		dataHandler.saveToFileList(roomList);

		return null;

	}

}
