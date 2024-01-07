package application.services;

import java.util.ArrayList;
import java.util.List;


import application.modell.Room;

public class RoomHandler {

	
DataHandler dataHandler = new DataHandler();

	public List<Room> getListOfRoom(){
		
		return  dataHandler.readRoomFromFile("Room.txt");
	}

	
	public List<Room> addNewCustomer(Room newRoom) {
		Room room = new Room();

		
		List<Room> roomList = getListOfRoom();
		newRoom.setRoomid(roomList.size() + 1);
		newRoom.setStatus(1);
		roomList.add(newRoom);
		System.out.println("addNewCustomer: "  + roomList);
		
		
		
		//To-do from file 
		
		
		dataHandler.saveToFileList(roomList);
		
		return null;
		
		
	}
	
	
	
	
}
