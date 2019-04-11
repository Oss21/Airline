package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Airport {
	public final static String PATH_NAME_OF_AIRLINES ="data/name_of_airlines";
	private String name;
	private ArrayList<Airline> airlines;
	private String[] airlinesName;
	public Airport(String name) {
		this.setName(name);
		airlines = null;
		airlinesName =new  String[7];
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAirlines(ArrayList<Airline> airlines) {
		this.airlines = airlines;
	}

	public ArrayList<Airline> getAirlines() {
		return airlines;
	}

	public void loadAirlinesNames() throws IOException {
		File file = new File(PATH_NAME_OF_AIRLINES);
		FileReader fr = new FileReader(file);
		BufferedReader lector = new BufferedReader(fr);
		String line = lector.readLine();
		int i = 0;
		while (line != null) {
			airlinesName[i] = line;
			line = lector.readLine();
			i++;
		}
			
		lector.close();
		fr.close();
		
	}

	public String[] getAirlinesNames() {
		return airlinesName;
	}
	
	
}
