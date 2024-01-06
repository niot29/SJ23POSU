package application.services;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

import application.model.Participant;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.util.Duration;

public class participantHandler {

	int distanceCount100 = 0;
	int distanceCount50 = 0;
	double speedMark50 = 0.3;
	double speedMark100 = 0.5;
	int startDeplay = 15000;

	public void clearfile() {
		File file = new File("Percitipant.txt");
		try {
			new FileWriter(file, false).close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void savePercitipantToFile(ObservableList<Participant> parUserList) {
		File file = new File("Percitipant.txt");
		int i = 1;

		try {

			// Remove content i file before add from list
			new FileWriter(file, false).close();
			for (Participant p : parUserList) {

//				System.out.println("savePercitipantToFile " + p);
//				System.out.println("user and index: " + p.getId() + "--" + p.getNamen());

				FileWriter fr = new FileWriter(file, true);
				BufferedWriter bw = new BufferedWriter(fr);
				// bw.write(p.toString());
//				bw.write(p.getId() + "," + p.getNamen() + "," + p.getPosition() + "," + p.getStartTime() + ","
//						+ p.getTotalDiffrenceTime() + "," + p.getCompTime01() + "," + p.getCompTime02() + ","
//						+ p.getCompTime03() + "," + p.getEndTime() + "," + p.getSpeed());

				bw.write(i + "," + p.getNamen() + "," + p.getPosition() + "," + p.getStartTime() + ","
						+ p.getTotalDiffrenceTime() + "," + p.getCompTime01() + "," + p.getCompTime02() + ","
						+ p.getCompTime03() + "," + p.getEndTime() + "," + p.getSpeed() + "," + p.getStatus());

				i++;
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
		System.out.println("getPercitipantsFromFile");
		BufferedReader br = null;
		ObservableList<Participant> list = FXCollections.observableArrayList();

		try {
			// create file object
			File file = new File("Percitipant.txt");

			// create BufferedReader object from the File
			br = new BufferedReader(new FileReader(file));

			String line = null;

			// read file line by line
			while ((line = br.readLine()) != null) {
				System.out.println("read file: " + line);
				String[] parts = line.split(",");

				Participant pa = new Participant();
				pa.setId(Integer.parseInt(parts[0]));
				pa.setNamen(parts[1]);
				pa.setPosition(Integer.parseInt(parts[2]));
				pa.setStartTime(parts[3]);  //--
				pa.setTotalDiffrenceTime(Integer.parseInt(parts[4]));
				pa.setCompTime01(parts[5]);
				pa.setCompTime02(parts[6]);
				pa.setCompTime03(parts[7]);
				pa.setEndTime(parts[8]);
				pa.setSpeed(parts[9]);
				pa.setStatus(Integer.parseInt(parts[10]));

				// System.out.println("PS " + pa);
				list.add(pa);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

 	public void setStartTime(ObservableList<Participant> parUserList, String raceType, String getCurrentTime) {
		System.out.println("setStartTime - RaceType: " + raceType);
		ObservableList<Participant> list = FXCollections.observableArrayList();
		
		System.out.println(getCurrentTime);
		for (Participant p : parUserList) {
			p.setStartTime(getCurrentTime);
			list.add(p);

		}
		savePercitipantToFile(list);

	}

	public ObservableList<Participant> setStartStatus(ObservableList<Participant> parUserList, double i,
			String watcher) {
		ObservableList<Participant> list = FXCollections.observableArrayList();

		for (Participant p : parUserList) {
			if (p.getTotalDiffrenceTime() == i) {
				System.out.println("----- " + p.getNamen() + " -- getTotalDiffrenceTime: " + p.getTotalDiffrenceTime() + " i - " + i);
				p.setStatus(1);
//				p.setStartTime(watcher);
			
			}
//			else if (p.getTotalDiffrenceTime() == 0) {
//				p.setStatus(1);
//				p.setStartTime(watcher);
//
//			}

			list.add(p);

		}
		return list;

	}

	public ObservableList<Participant> resetForNextRace(ObservableList<Participant> parUserList, int raceType) {
		ObservableList<Participant> list = FXCollections.observableArrayList();
		TimerHandler timeHandler = new TimerHandler();

		for (Participant p : parUserList) {
			p.setPosition(0);
			p.setTotalDiffrenceTime(0);
			p.setEndTime("0");

			if (raceType == 1) {
				System.err.println("resetForNextRace raceType: " + raceType);
				p.setStatus(1);
				p.setSpeed("0");

			} else if (raceType == 2) {
				System.err.println("resetForNextRace raceType: " + raceType);
				p.setStatus(0);
				p.setSpeed("0");
				p.setStartTime(timeHandler.convertMillisecondsTimeToString((p.getId() - 1) * 15000));
				p.setTotalDiffrenceTime((p.getId() - 1) * 15000);
				p.setPosition(p.getTotalDiffrenceTime());
				
			} else if (raceType == 3) {
				p.setStatus(0);
				p.setSpeed("0");
				int com1 = timeHandler.convertStringTimeToMilliseconds(p.getCompTime01());
				int com2 = timeHandler.convertStringTimeToMilliseconds(p.getCompTime02());
				
				
				p.setStartTime(timeHandler.convertMillisecondsTimeToString(com1 + com2));
				p.setTotalDiffrenceTime(com1 + com2);
				p.setPosition(p.getTotalDiffrenceTime());
			}

			list.add(p);
		}
		savePercitipantToFile(list);
		return list;

	}

	public ObservableList<Participant> getDiffTime(ObservableList<Participant> parUserList, String raceType) {
		ObservableList<Participant> list = FXCollections.observableArrayList();
		TimerHandler timHandler = new TimerHandler();

		Collections.sort(parUserList);
//		Participant pLead = new Participant();

		int lead = parUserList.get(0).getTotalDiffrenceTime();
		int leadId = parUserList.get(0).getId();
		System.out.println("getDiffTime LEAD: " + lead + " LEADID " + leadId);

		for (Participant p : parUserList) {

			int diff = 0;

			switch (raceType) {
			case "Massstart":
				diff = p.getTotalDiffrenceTime() - lead;
				p.setCompTime01(timHandler.convertMillisecondsTimeToString(diff));
				break;
			case "Individuals":
				diff = p.getTotalDiffrenceTime() - lead;
				p.setCompTime02(timHandler.convertMillisecondsTimeToString(diff));
				break;
			case "Chased":
				diff = p.getTotalDiffrenceTime() - lead;
				p.setCompTime03(timHandler.convertMillisecondsTimeToString(diff));
				break;
			}

			System.out.println(p.getId() + "  " + p.getNamen() + " " + p.getTotalDiffrenceTime());
			list.add(p);

		}
		System.out.println(list);
		return list;

	}

	public boolean race1Handler(ObservableList<Participant> parUserList, String watcher, String raceType) {
		ObservableList<Participant> list = FXCollections.observableArrayList();
		TimerHandler timeHandler = new TimerHandler();
		DecimalFormat df = new DecimalFormat("0.00000");
		Random rand = new Random();

		for (Participant p : parUserList) {

			if (p.getStatus() == 1) {

				double speed = Double.valueOf(p.getSpeed());

				int race1Speed = rand.nextInt(4);

				for (int i = 0; race1Speed >= i; i++) {

				System.out.println(
						"-------------------  " + p.getNamen() + " - speed " + speed + " Time: " + watcher + " Count " + i);

					if (speed == speedMark50) {
						System.out.println(
								"------------------- 50% " + p.getNamen() + " - speed " + speed + " Time: " + watcher);
//					distanceCount50 = ++distanceCount50;

//						p.setTotalDiffrenceTime(timeHandler.convertStringTimeToMilliseconds(watcher));

						switch (raceType) {
						case "Massstart":
							p.setCompTime01(watcher);

							break;
						case "Individuals":
							p.setCompTime02(watcher);
							break;
						default:
							p.setCompTime03(watcher);
						}

//					p.setPosition(pIndex);

					}

					if (speed == speedMark100) {
						
//						if (p.getStatus() == 1) {
						if (p.getEndTime().equals("0")) {
							System.out.println("------------------- 100% " + p.getNamen() + " - speed " + speed
									+ " Time: " + watcher + " Position " + p.getEndTime());
							distanceCount100 = ++distanceCount100;
							System.out.println("100 " + distanceCount100 + " " + parUserList.size());
							

							int time = timeHandler.convertStringTimeToMilliseconds(watcher);
							System.out.println("diff " + (time - p.getPosition()));
							p.setTotalDiffrenceTime(time - p.getPosition());

							p.setEndTime(watcher);
							

							p.setStatus(0);
						}

						break;
					}

					speed = speed + 0.005;
					

				}
				String inValue = df.format(speed);
				String str = inValue.replace(",", ".");
								
				p.setSpeed(str);
				list.add(p);
			

			} else {
//				System.out.println("------- " + p.getNamen() + " Time: " + watcher + " StartTime: " + p.getStartTime()
//						+ " Status " + p.getStatus());
			}
		}

		if (distanceCount100 == parUserList.size()) {

//			System.out.println(distanceCount100 + " " + parUserList.size());
			System.out.println("New List: " + list);
			savePercitipantToFile(list);
			distanceCount100 = 0;
			distanceCount50 = 0;
			return false;
		}
		return true;

	}



}
