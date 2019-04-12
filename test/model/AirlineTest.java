package model;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
class AirlineTest {
	private Airline airline;
	private ArrayList<Flight> flights;
	private String[] destinationCity = {"Madrid","Barcelona","Roma","Florencia","Bogota","Medellin","Paris","Londres"};

	public void setupEscenary1() {
		flights = new ArrayList<Flight>();
		flights.add(new Flight(6,50,2,30,9,12,2020,"New York"));
		flights.add(new Flight(3, 8,10, 05, 3, 9, 2021, "Miami"));
		airline = new Airline("Avianca");
		airline.setFlights(flights);		
	}

	
	public void setupEscenary2() {
		airline = new Airline("Latam");
		airline.setDestinationCity(destinationCity);
	}
	
	public void setupEscenary3() {
		airline = new Airline("Copa Airlines");
	}
	
	public void setupEscenary4() {
		
	}
	
	@Test
	public void checkGetFlights() {
		setupEscenary1();
		//Verifica si el metodo getFlights funciona correctamente.
		for (int i = 0; i < flights.size(); i++) {
			assertEquals(flights.get(i).getNumberOfFlight(), airline.getFlights().get(i).getNumberOfFlight());
			assertEquals(flights.get(i).getHour(), airline.getFlights().get(i).getHour());
			assertEquals(flights.get(i).getMinute(), airline.getFlights().get(i).getMinute());
			assertEquals(flights.get(i).getDay(), airline.getFlights().get(i).getDay());
			assertEquals(flights.get(i).getMonth(), airline.getFlights().get(i).getMonth());
			assertEquals(flights.get(i).getYear(), airline.getFlights().get(i).getYear());
		}
	}
	/**
	 * Verificar el metodo loadDestinationCity carga correctamente los datos.
	 * el arhivo y lo asigna de correctamente al arreglo de ciudades de destino.
	 * @throws IOException 
	 */
	@Test
	public void checkLoadDestinationCity() throws IOException {
		setupEscenary3();
		airline.LoadDestinationCity();
		try {
			assertTrue(CompareFileWithArray.assertEqualsCompareFileWithArrangement(airline.getDestinationCity(),"data/Destination_city_data.txt"));
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (DifferentSizesException e) {
			e.printStackTrace();
		}
		
		// Probar si la excepcion se lanza al no encontrar la ruta del archivo en especifico.
		
		try {
			assertTrue(CompareFileWithArray.assertEqualsCompareFileWithArrangement(airline.getDestinationCity(),"dat/Destination_city_data.txt"));
			fail("El arhivo no esta en la dirección correnspondiente");
			} catch (IOException | DifferentSizesException e) {
				
			}
		
	}
	@Test
	public void checkLoadData() {
		setupEscenary4();
		//Verifica si el arhivo esta correcto
		try {
			assertTrue(CompareFileWithArray.assertEqualsCompareFileWithArrangement(destinationCity,"data/Destination_city_data.txt"));
		} catch (IOException | DifferentSizesException e) {
			e.printStackTrace();
		}
		destinationCity[destinationCity.length-1] = null;
		// Probar si la excepcion se lanza al no tener los mismos numero de datos y mismos arhchivos.
		try {
			assertTrue(CompareFileWithArray.assertEqualsCompareFileWithArrangement(destinationCity,"data/Destination_city_data.txt"));
			fail("El arhivo es igual a los elementos del arreglo");
		} catch (IOException | DifferentSizesException e) {
		
		}

	}
	@Test
	public void checkgetName() {
		setupEscenary3();
		String nombre = "Copa Airlines";
		assertEquals(nombre, airline.getName());
		
		String air = "Avianca";
		airline.setName(air);
		assertEquals(air,airline.getName());
	}
	
	@Test
	public void checkComparTo() {
		setupEscenary3();
		Airline airlineDos = new Airline("Copa Airlines");
		Airline airlineTres = new Airline("Avianca");
		Airline airlineCuatro = new Airline("Latam");
		int iguales = 0;
		int mayor = airline.compareTo(airlineTres);
		int menor = airline.compareTo(airlineCuatro);
		assertEquals(iguales,airline.compareTo(airlineDos));
		assertEquals(mayor, airline.compareTo(airlineTres));
		assertEquals(menor, airline.compareTo(airlineCuatro));

	}
	
	@Test
	public void checkSortByNumberOfFlight() {
		setupEscenary1();
		int[] orderedFlightNumber = {3,6};
		airline.sortByNumberOfFlightOrSortByPortOfShipment('F');
		for (int i = 0; i < flights.size(); i++) {
			assertEquals(orderedFlightNumber[i],airline.getFlights().get(i).getNumberOfFlight());
		}
	}
	
	@Test
	public void checkSortByDestinationCity() {
		setupEscenary1();
		String []  orderedDestinationCity = {"Miami","New York"};
		airline.sortByDestinationCity();
		for (int i = 0; i < flights.size(); i++) {
			assertEquals(orderedDestinationCity[i], airline.getFlights().get(i).getDestinationCity());
		}
	}
	
	@Test
	public void checkSortByPortOfShipment() {
		setupEscenary1();
		int []  orderedPortOfShipment = {8,50};
		airline.sortByNumberOfFlightOrSortByPortOfShipment('S');
		for (int i = 0; i < flights.size(); i++) {
			assertEquals(orderedPortOfShipment[i], airline.getFlights().get(i).getPortOfShipment());
		}
	}
	
	
	@Test
	public void checkSearchByPortOfShipment() {
		setupEscenary1();
		int portOfShipment = 50;
		assertEquals(airline.getFlights().get(0),airline.searchByPortOfShipment(portOfShipment));
	}

	// realizar diseño de pruebas.
	@Test
	public void checkSearchByDestinationCiy() {
		setupEscenary1();
		String destinationCity = "Miami";
		assertEquals(airline.getFlights().get(1), airline.searchByDestinationCity(destinationCity));
		
	}
	
	@Test
	public void checkSearchByNumberOfFlight() {
		setupEscenary1();
		int numberOfFlight = 3;
		assertEquals(airline.getFlights().get(1),airline.searchByNumberOfFLight(numberOfFlight));

	}
	
	
}