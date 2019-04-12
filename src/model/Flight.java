package model;

import java.util.Comparator;

public class Flight implements Comparable<Flight>{

	private int numberOfFlight;
	private int portOfShipment;
	private int hour;
	private int minute;
	private int day;
	private int month;
	private int year;
	private String destinationCity;

	public Flight() {
		
	}
	
	public Flight(int numberOfFlight, int portOfShipment, int hour, int minute, int day, int month, int year, String destinationCity) {
		this.numberOfFlight = numberOfFlight;
		this.portOfShipment = portOfShipment;
		this.hour = hour;
		this.minute = minute;
		this.day = day;
		this.month = month;
		this.year = year;
		this.destinationCity = destinationCity;
	}

	public int getNumberOfFlight() {
		return numberOfFlight;
	}

	public void setNumberOfFlight(int numberOfFlight) {
		this.numberOfFlight = numberOfFlight;
	}

	public int getPortOfShipment() {
		return portOfShipment;
	}

	public void setPortOfShipment(int portOfShipment) {
		this.portOfShipment = portOfShipment;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getDestinationCity() {
		return destinationCity;
	}

	public void setDestinationCity(String destinationCity) {
		this.destinationCity = destinationCity;
	}

	

	@Override
	public int compareTo(Flight flightDos) {
		int value= 0;
		if (this.destinationCity.compareTo(flightDos.getDestinationCity()) > 0 ) {
			value = 1;
		}else if (this.destinationCity.compareTo(flightDos.getDestinationCity()) < 0) {
			value = -1;
		}
		
		return value;
	}

	@Override
	public String toString() {
		return "Flight [numberOfFlight=" + numberOfFlight + ", portOfShipment=" + portOfShipment + ", hour=" + hour
				+ ", minute=" + minute + ", day=" + day + ", month=" + month + ", year=" + year + ", destinationCity="
				+ destinationCity + "]";
	}

	
	
	
	
}
