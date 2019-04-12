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
		airlines = new ArrayList<Airline>();
		airlinesName =new  String[7];
	}

	public void generateFlights(int size) {
		
		for (int i = 0; i < size; i++) {
			
			int airlinePosition = (int) Math.floor(Math.random()*(airlinesName.length-1));
			airlines.add(new Airline(airlinesName[airlinePosition]));
			
			int numberOfFlight = i;
			int portOfShipment = (int) Math.floor(Math.random()*100+1);
			int hour = (int) Math.floor(Math.random()*12+1);
			int minute = (int) Math.floor(Math.random()*59+00);
			int day = (int) Math.floor(Math.random()*31+1);
			int month = (int) Math.floor(Math.random()*12+1);
			int year = (int) Math.floor(Math.random()*2020+2019);
			int destinationCityPosition = (int) Math.floor(Math.random()*(airlines.get(i).getDestinationCity().length-1));
			airlines.get(i).getFlights().add(new Flight(numberOfFlight, portOfShipment, hour, minute, day, month, year, airlines.get(i).getDestinationCity()[destinationCityPosition]));
		}
		

		
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

	public void sortByAirline() {
		for (int i = 0; i < airlines.size(); i++) {
			for (int j = 0; j < airlines.size()-1-i; j++) {
				if (airlines.get(j).compareTo(airlines.get(j+1)) > 0) {
					Airline temp = airlines.get(j);
					airlines.set(j, airlines.get(j+1));
					airlines.set(j+1, temp);
				}
			}
		}
	}

	public Airline searchByAirline(String name2) {
		Airline airl = null;
		for (int i = 0; i < airlines.size(); i++) {
			if (airlines.get(i).getName().equals(name2)) {
				airl = airlines.get(i);
			}
		}
		return airl;
	}
	
	
}
