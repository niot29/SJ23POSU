package application.services;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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

		System.out.println("getOListOfRoom: liset  " + list);
		
		for (Room r : list) {

			if (r.getStatus() == 1) {

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
//			else {
//				
//				Room room = new Room();
//				room.setRoomid(r.getRoomid());
//				room.setRoomBookingNr(r.getRoomBookingNr());
//				room.setRoomCustomerNr(r.getRoomCustomerNr());
//				room.setRoomBookingDate(r.getRoomBookingDate());
//				room.setRoomDesc(r.getRoomDesc());
//				room.setRoomType(r.getRoomType());
//				room.setStatus(r.getStatus());
//				
//				
//				room.setCustomerFname(r.getCustomerFname());
//				room.setCustomerEnamne(r.getCustomerEnamne());
//
//				roomList.add(room);
//				
//				
//				
//			}
		}
		
		return roomList;

	}

	public List<Room> addNewRoom(Room newRoom) {
		Room room = new Room();

		List<Room> roomList = getListOfRoom();
		
		
		if(roomList.size() == 0) {
			newRoom.setRoomid(1);
		}else {
			newRoom.setRoomid(roomList.getLast().getRoomid() + 1);

		}
		
		newRoom.setStatus(1);
		roomList.add(newRoom);

		dataHandler.saveToFileList(roomList);

		return getOListOfRoom(1);

	}
	
	public void removeRoom(ObservableList<Room> roomList, int rId) {
//		roomList.get(rId).setStatus(0);
		roomList.remove(rId);
		dataHandler.saveToFileList(roomList);
	}

}
