package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Airline;
import model.Airport;
import model.Flight;

public class ControllerVentana {

	private Airport airport;
	
	@FXML
	private TableView<Flight> tableView;
    @FXML
    private TableColumn<Flight,Integer> time;

    @FXML
    private TableColumn<Flight, Integer> date;

    @FXML
    private TableColumn<Flight,String> airline;

    @FXML
    private TableColumn<Flight, Integer> flight;

    @FXML
    private TableColumn<Flight, String> destinationCity;

    @FXML
    private TableColumn<Flight, Integer> portOfShipment;																																																																																																																																																																																																																																																																

    @FXML
    private TextField numberOfFlight;

    @FXML
    private TextField dataToSearch;

    @FXML
    public void clearData(ActionEvent event) {
    	
    }

    @FXML
    public void generateData(ActionEvent event) {
    	int data = Integer.parseInt(numberOfFlight.getText());
    	try {
			airport.loadAirlinesNames();
		
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	tableView.getColumns().add(airline);
    	
    }

    @FXML
    public void search(ActionEvent event) {
    
    	
    }
    
    @FXML
    public void sortBy(ActionEvent event) {
    	String ev = event.getClass().getComponentType().getName();
    	if (ev.equalsIgnoreCase("Airline")) {
			System.out.println("hola");
		}
    }

    @FXML
    public void initialize() {
    	airport = new Airport("CLO");
    	
    	destinationCity.setCellValueFactory(new PropertyValueFactory<Flight, String>("destinationCity"));
    
    }
}

