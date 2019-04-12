package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Airline implements Comparable<Airline>{
	private final static String PATH_DESTINATION_CITY_DATA = "data/Destination_city_data.txt";
	private String name;
	private ArrayList<Flight> flights;
	private String[] destinationCity;
	
	
	
	public Airline(String name) {
		this.name = name;
		flights = new ArrayList<Flight>();
		destinationCity = new String[8];
		try {
			LoadDestinationCity();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Airline() {
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

	@Override
	public int compareTo(Airline airline) {
		return name.compareTo(airline.getName());
	}

	public void sortByNumberOfFlightOrSortByPortOfShipment(char tipo) {
		for (int i = 0; i < flights.size(); i++) {
			int min = i;
			for (int j = i+1; j < flights.size(); j++) {
				if (tipo == 'F') {
					if (flights.get(j).getNumberOfFlight() > flights.get(min).getNumberOfFlight()) {
						min = j;
					}
					}else {
						if (flights.get(j).getPortOfShipment() > flights.get(min).getPortOfShipment()) {
							min = j;
						}
					}
					Flight temp = flights.get(j);
					flights.set(j, flights.get(min));
					flights.set(min, temp);
				
				
			}
		}
	}

	public void sortByDestinationCity() {
		for (int i = 0; i < flights.size(); i++) {
			Flight current = flights.get(i);
			int j = i;
			 while (j > 0 && flights.get(j-1).compareTo(current) > 0) {
				flights.set(j, flights.get(j-1));
				j--;
			}
			 flights.set(j,current);
		}
	}

	public Flight searchByPortOfShipment(int portOfShipment) {
    	Flight flight = null;
    	int inferior = 0;
    	int superior =flights.size()-1;
    	int mitad = 0;
    while(inferior<=superior && flight == null){
    	mitad = (superior+inferior)/2;
      if(flights.get(mitad).getPortOfShipment() == portOfShipment) {
    	 flight = flights.get(mitad);
      }else if(flights.get(mitad).getPortOfShipment() < portOfShipment){
         superior = mitad -1;
      }
      else {
        inferior = mitad+1;
      }
    }
    return flight;
	}

	public Flight searchByDestinationCity(String destinationCity) {
		Flight flight = null;
		Flight f = new Flight();
		f.setDestinationCity(destinationCity);
    	int inferior = 0;
    	int superior =flights.size()-1;
    	int mitad = 0;
	    while(inferior<=superior && flight == null){
	    	mitad = (superior+inferior)/2;
	      if(flights.get(mitad).compareTo(f) == 0) {
	    	 flight = flights.get(mitad);
	      }else if(flights.get(mitad).compareTo(f) < 0){
	         superior = mitad -1;
	      }
	      else {
	        inferior = mitad+1;
	      }
	    }
    return flight;
}

	public Flight searchByNumberOfFLight(int numberOfFlight) {
		Flight flight = null;
    	int inferior = 0;
    	int superior =flights.size()-1;
    	int mitad = 0;
    while(inferior<=superior && flight == null){
    	mitad = (superior+inferior)/2;
      if(flights.get(mitad).getNumberOfFlight() == numberOfFlight) {
    	 flight = flights.get(mitad);
      }else if(flights.get(mitad).getNumberOfFlight() < numberOfFlight){
         superior = mitad -1;
      }
      else {
        inferior = mitad+1;
      }
    }
    return flight;
	}

	@Override
	public String toString() {
		return "Airline [name=" + name + ", flights=" + flights + ", destinationCity="
				+ Arrays.toString(destinationCity) + "]";
	}

	
	
	

}
