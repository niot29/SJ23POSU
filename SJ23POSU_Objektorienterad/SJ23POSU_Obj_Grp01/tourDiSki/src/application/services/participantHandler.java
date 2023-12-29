package application.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import application.model.Participant;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class participantHandler {

	public ObservableList<Participant> addRanPercitipant(ObservableList<Participant> parUserList, String name) {
		Participant pUser = new Participant();
		int indexid = parUserList.size();

		if (indexid != 0) {

			indexid = parUserList.get(indexid - 1).getId();
		}

		pUser.setId(indexid + 1);
		pUser.setNamen(name);
		pUser.setPosition(0);
		parUserList.add(pUser);

		return parUserList;

	}

	public ObservableList<Participant> addRanPercitipantfromFile(ObservableList<Participant> parUserList, int count)
			throws IOException {
		BufferedReader br = null;
		ArrayList<String> nameList = new ArrayList<String>();
		// ArrayList<Participant> participantList = new ArrayList<Participant>();
		// HashMap<Integer, ArrayList<competitor>> participant = new HashMap<Integer,
		// ArrayList<competitor>>();

		try {

			String line = null;
			File file = new File("randomName.txt");
			br = new BufferedReader(new FileReader(file));

			while ((line = br.readLine()) != null) {
				nameList.add(line);
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// System.out.println(nameList);

		// Random get list av contest
		Random rand = new Random();
		int listSize = parUserList.size();

		if (count > 20) {
			count = 15;
		}
		if (listSize != 0) {

			listSize = parUserList.get(listSize - 1).getId();
		}
		for (int i = 1; i <= count; i++) {
			Participant competitor = new Participant();
			int rand_int1 = rand.nextInt(50);
			competitor.setId(listSize + i);
			competitor.setNamen(nameList.get(rand_int1));
			parUserList.add(competitor);
		}

		return parUserList;

	}

	
	
	public List<String> nameObjToStringList(ObservableList<Participant> parUserList) {

		List<String> participantNameList = new ArrayList<String>();
		for (Participant participant : parUserList) {
			participantNameList.add(participant.getNamen());
		}

		return participantNameList;

	}

	
	public ObservableList<Participant> searchList( ObservableList<Participant> parUserList,String searchWords) {
		 
			ObservableList<Participant> returnList =  FXCollections.observableArrayList();
		
		 	List<String> listOfStrings = nameObjToStringList(parUserList);
	        List<String> searchWordsArray = Arrays.asList(searchWords.trim().split(" "));

	        
	        List<String> nameList =  listOfStrings.stream().filter(input -> {
	            return searchWordsArray.stream().allMatch(word ->
	                    input.toLowerCase().contains(word.toLowerCase()));
	        }).collect(Collectors.toList());
			
	        
	        for(Participant nameObj : parUserList) {
	        	if (nameList.contains(nameObj.getNamen())) {
	        		returnList.add(nameObj);
	        	}
	        }
	        System.out.println(returnList);
	        return returnList;
	        
	        
	        
	        
	    }
}
