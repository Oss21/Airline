package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Airline {
	private final static String PATH_DESTINATION_CITY_DATA = "data/Destination_city_data.txt";
	private String name;
	private ArrayList<Flight> flights;
	private String[] destinationCity;
	
	
	public Airline(String name) {
		this.name = name;
		flights = new ArrayList<Flight>();
		destinationCity = new String[8];
	}

	public String getName() {
		return name;
	}
	
	
	public void LoadDestinationCity() throws IOException {
		File file = new File(PATH_DESTINATION_CITY_DATA);
		FileReader fr = new FileReader(file);
		BufferedReader lector = new BufferedReader(fr);
		String line = lector.readLine();
		
		int i = 0;
		while(line != null) {
			destinationCity[i] = line;
			line = lector.readLine();
			i++;
		}
		lector.close();
		fr.close();
		
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public ArrayList<Flight> getFlights(){
		return flights;
	}
	
	public void setFlights(ArrayList<Flight> flights) {
		this.flights = flights;
	}

	public String[] getDestinationCity() {
		return destinationCity;
	}
	
	public void setDestinationCity(String[] destinationCity) {
		this.destinationCity = destinationCity;
		
	}

	
	

}
