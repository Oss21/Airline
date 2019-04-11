package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FlightTest {
	
	private Flight flight;
	
	private void setupEscenary1() {
		int numberOfFlight = 1;
		int portOfShipment = 2;
		int hour = 12;
		int minute = 34;
		int day = 1;
		int month = 4;
		int year = 2019;
		String destinationCity = "Bogota";
		flight = new Flight(numberOfFlight, portOfShipment, hour, minute, day, month, year, destinationCity);
	}
	
	private void setupEscenary2() {
		flight = new Flight();
		int numberOfFlight = 5;
		int portOfShipment = 43;
		int hour = 20;
		int minute = 00;
		int day = 5;
		int month = 11;
		int year = 2020;
		flight.setNumberOfFlight(numberOfFlight);
		flight.setPortOfShipment(portOfShipment);
		flight.setHour(hour);
		flight.setMinute(minute);
		flight.setDay(day);
		flight.setMonth(month);
		flight.setYear(year);
	}
	
	
	
	@Test
	public void checkgetMethods() {
		setupEscenary1();
		int numberOfFlight = 1;
		int portOfShipment = 2;
		int hour = 12;
		int minute = 34;
		int day = 1;
		int month = 4;
		int year = 2019;
		assertEquals(numberOfFlight,flight.getNumberOfFlight(), "No se establecio correctamente el valor del atributo numero de vuelo");
		assertEquals(portOfShipment, flight.getPortOfShipment(), "No se establecio correctamente el valor del atributo puerto de embarque");
		assertEquals(hour, flight.getHour(),"No se establecio correctamente la hora al atributo");
		assertEquals(minute, flight.getMinute(), "No se establecio correctamente el minuto al atributo minute");
		assertEquals(day, flight.getDay(), "No se establecio correctamnete el day al atributo day");
		assertEquals(month, flight.getMonth(), "No se establecio correctamnete el mes al atributo month");
		assertEquals(year, flight.getYear(), "No se establecio correctamnete el año al atributo year");
	}
	
	@Test 
	public void checksetMethods() {
		setupEscenary2();
		int numberOfFlight = 5;
		int portOfShipment = 43;
		int hour = 20;
		int minute = 00;
		int day = 5;
		int month = 11;
		int year = 2020;
		assertEquals(numberOfFlight,flight.getNumberOfFlight(), "No se establecio correctamente el valor del atributo numero de vuelo");
		assertEquals(portOfShipment, flight.getPortOfShipment(), "No se establecio correctamente el valor del atributo puerto de embarque");
		assertEquals(hour, flight.getHour(),"No se establecio correctamente la hora al atributo");
		assertEquals(minute, flight.getMinute(), "No se establecio correctamente el minuto al atributo minute");
		assertEquals(day, flight.getDay(), "No se establecio correctamnete el day al atributo day");
		assertEquals(month, flight.getMonth(), "No se establecio correctamnete el mes al atributo month");
		assertEquals(year, flight.getYear(), "No se establecio correctamnete el año al atributo year");
	}
	
	
} 
