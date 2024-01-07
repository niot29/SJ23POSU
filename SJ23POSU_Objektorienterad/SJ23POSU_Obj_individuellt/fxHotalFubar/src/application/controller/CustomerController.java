package application.controller;


import application.modell.Customer;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.AnchorPane;

public class CustomerController {

	
    @FXML
    private AnchorPane CustomerAnchor;

    @FXML
    private TableColumn<Customer, Integer> CustomerAddress;

    @FXML
    private TableColumn<Customer, String> CustomerEmail;

    @FXML
    private TableColumn<Customer, String> CustomerFname;

    @FXML
    private TableColumn<Customer, String> CustomerLname;

    @FXML
    private TableColumn<Customer, String> CustomerPhone;

    @FXML
    private TableColumn<Customer, String> CustomerStatus;

    @FXML
    private TableColumn<Customer, Integer> customerId;
}
