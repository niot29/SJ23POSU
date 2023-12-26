package application.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import application.model.Participant;

public class participantHandler {
	
	public void addRanPercitipant() {
		

	}
	
	public ArrayList<Participant>  addRanPercitipantfromFile(int  count) throws IOException {
		BufferedReader br = null;
		
		ArrayList<String> nameList  = new ArrayList<String>();
		ArrayList<Participant> participantList  = new ArrayList<Participant>();
		//HashMap<Integer, ArrayList<competitor>> participant = new HashMap<Integer, ArrayList<competitor>>();
		
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
		
		//System.out.println(nameList);
		
		// Random get list av contest
		Random rand = new Random();
		int listSize = nameList.size();
		for (int i = 0; i <= count; i++) {
			Participant competitor = new Participant();
			int rand_int1 = rand.nextInt(50);
			competitor.setId(i + 1);
			competitor.setNamen(nameList.get(rand_int1));
			participantList.add(competitor);
		}
		
	
		return participantList;
		
	}
	
	
}
