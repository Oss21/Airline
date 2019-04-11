package model;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class AirportTest {

	private Airport airport;
	private	ArrayList<Airline> airlines;
	private ArrayList<Flight> flights;
	private ArrayList<Flight> flightsDos;
	private String[] nameOfAirlines = {"Avianca","Copa Airlines","Latam","American Eagle Airlines", "Virgin America", "Qatar Airways", "Singapore Airlines"};
	
	private void setupEscenary1() {
		airlines = new ArrayList<Airline>();
		flights = new ArrayList<Flight>();
		flightsDos = new ArrayList<Flight>();
		airport = new Airport("CLO");
		
		airlines.add(new Airline("Avianca"));
		airlines.add(new Airline("Latam"));
		airport.setAirlines(airlines);
		
		flights.add(new Flight(10, 20,2, 05, 3, 9,2021, "Miami"));
		flightsDos.add(new Flight(6,8,1, 30, 9, 12,2020, "New York"));
		airport.getAirlines().get(0).setFlights(flights);
     	airport.getAirlines().get(1).setFlights(flightsDos);
		
	}
	
	private void setupEscenary2() {
		airport = new Airport("CLO");
	}

	
	@Test
	public void checkGetAirlines() {
		setupEscenary1();
		int i = 0;
		while (i < airlines.size()) {
			assertEquals(airlines.get(i).getName(),airport.getAirlines().get(i).getName());
			assertEquals(airlines.get(i).getFlights().get(0).getNumberOfFlight(),airport.getAirlines().get(i).getFlights().get(0).getNumberOfFlight());
			assertEquals(airlines.get(i).getFlights().get(0).getHour(),airport.getAirlines().get(i).getFlights().get(0).getHour());
			assertEquals(airlines.get(i).getFlights().get(0).getDay(),airport.getAirlines().get(i).getFlights().get(0).getDay());
			assertEquals(airlines.get(i).getFlights().get(0).getMonth(),airport.getAirlines().get(i).getFlights().get(0).getMonth());
			assertEquals(airlines.get(i).getFlights().get(0).getYear(),airport.getAirlines().get(i).getFlights().get(0).getYear());
			i++;
		}
			
		
	}
	
	@Test
	public void checkLoadAirlineNames() {
		setupEscenary2();
		try {
			airport.loadAirlinesNames();
			assertTrue(CompareFileWithArray.assertEqualsCompareFileWithArrangement(airport.getAirlinesNames(), Airport.PATH_NAME_OF_AIRLINES));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (DifferentSizesException e) {
			e.printStackTrace();
		}
	 // Probar si la excepcion se lanza correctamente.
		try {
			assertTrue(CompareFileWithArray.assertEqualsCompareFileWithArrangement(airport.getAirlinesNames(), "/"+Airport.PATH_NAME_OF_AIRLINES));
			fail("La excepcion no se lanzo correctamente");
		} catch (IOException e) {
		} catch (DifferentSizesException e) {
		}
		
		
	}
	
	@Test 
	public void checkLoadData() {
		setupEscenary2();
		//Verifica si el arhivo esta correcto
		try {
			assertTrue(CompareFileWithArray.assertEqualsCompareFileWithArrangement(nameOfAirlines,"data/Destination_city_data.txt"));
		} catch (IOException | DifferentSizesException e) {
			e.printStackTrace();
		}
		// Probar si la excepcion se lanza al no tener los mismos numero de datos y mismos arhchivos.
		try {
			nameOfAirlines[nameOfAirlines.length-1] = null;
			assertTrue(CompareFileWithArray.assertEqualsCompareFileWithArrangement(nameOfAirlines,"data/Destination_city_data.txt"));
			fail("El arhivo es igual a los elementos del arreglo");
		} catch (IOException | DifferentSizesException e) {
		
		}

	}
	
	
	
}
