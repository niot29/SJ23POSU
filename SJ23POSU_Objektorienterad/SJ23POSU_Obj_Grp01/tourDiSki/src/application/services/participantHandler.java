package application.services; 

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

import application.model.Participant;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class participantHandler {

	public void savePercitipantToFile(ObservableList<Participant> parUserList) {
		File file = new File("Percitipant.txt");

		try {

			// Remove content i file before add from list
			new FileWriter(file, false).close();
			for (Participant p : parUserList) {

//				System.out.println("savePercitipantToFile " + p);

				FileWriter fr = new FileWriter(file, true);
				BufferedWriter bw = new BufferedWriter(fr);
				//bw.write(p.toString());
				bw.write(p.getId()  + ":" + p.getNamen() + ":" + p.getPosition() + ":" + p.getStartTime() + ":" + p.getTotalDiffrenceTime() + ":" + p.getRac1() + ":" + p.getRac2() + ":" + p.getRac3() + ":" + p.getEndTime());

				bw.newLine();

				bw.close();
				fr.close();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void removeRanPercitipant(ObservableList<Participant> parUserList, int rId) {
		parUserList.remove(rId);
		savePercitipantToFile(parUserList);
	}

	public ObservableList<Participant> getPercitipantsFromFile() {
		BufferedReader br = null;
		ObservableList<Participant> list = FXCollections.observableArrayList();
		
		try {
			// create file object
			File file = new File("Percitipant.txt");

			// create BufferedReader object from the File
			br  = new BufferedReader(new FileReader(file));
			
			String line = null;

			// read file line by line
			while ((line = br.readLine()) != null) {
				System.out.println("read file: " + line);
				String[] parts = line.split(":");
				System.out.println(parts.length);
				
				Participant pa = new Participant();
				pa.setId(Integer.parseInt(parts[0]));
				pa.setNamen(parts[1]);
				pa.setPosition(Integer.parseInt(parts[2]));
				pa.setStartTime(parts[3]);
				pa.setTotalDiffrenceTime(parts[4]);
				pa.setRac1(parts[5]);
				pa.setRac2(parts[6]);
				pa.setRac3(parts[7]);
				pa.setEndTime(parts[8]);
				
				//System.out.println("PS " + pa);
				list.add(pa);
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {

			// Always close the BufferedReader
			if (br != null) {
				try {
					br.close();
				} catch (Exception e) {
				}
				;
			}
		}

		System.out.println("PS Lisr: " + list);
		return list;

	}

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

	public ObservableList<Participant> searchList(ObservableList<Participant> parUserList, String searchWords) {

		ObservableList<Participant> returnList = FXCollections.observableArrayList();

		List<String> listOfStrings = nameObjToStringList(parUserList);
		List<String> searchWordsArray = Arrays.asList(searchWords.trim().split(" "));

		List<String> nameList = listOfStrings.stream().filter(input -> {
			return searchWordsArray.stream().allMatch(word -> input.toLowerCase().contains(word.toLowerCase()));
		}).collect(Collectors.toList());

		for (Participant nameObj : parUserList) {
			if (nameList.contains(nameObj.getNamen())) {
				returnList.add(nameObj);
			}
		}
		System.out.println(returnList);
		return returnList;

	}
}
