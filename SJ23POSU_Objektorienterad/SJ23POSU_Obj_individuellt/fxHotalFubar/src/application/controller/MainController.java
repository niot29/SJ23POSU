package application.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import application.modell.Booking;
import application.modell.Customer;
import application.modell.Room;
import application.services.BookingServices;
import application.services.CustomerServices;
import application.services.RoomHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class MainController implements Initializable {

	@FXML
	private TableView<Booking> mainBookingList;

	@FXML
	private TableView<Customer> mainCustomerList;

	@FXML
	private TableView<Room> mainRoomList;

// -- Customer tabel	
	@FXML
	private TableColumn<Customer, String> tbCustomerAddress;

	@FXML
	private TableColumn<Customer, String> tbCustomerEmail;

	@FXML
	private TableColumn<Customer, String> tbCustomerFName;

	@FXML
	private TableColumn<Customer, String> tbCustomerLName;

	@FXML
	private TableColumn<Customer, String> tbCustomerPhone;

	@FXML
	private TableColumn<Customer, Integer> tbCustomerStatus;

	@FXML
	private TableColumn<Booking, Integer> tbBookingNr;

	@FXML
	private TableColumn<Booking, Integer> tbBookingRoomNr;

	@FXML
	private TableColumn<Booking, String> tbBookingCusterFNamne;

	@FXML
	private TableColumn<Booking, String> tbBookingCustomerLName;

	@FXML
	private TableColumn<Booking, String> tbBookingStartDate;

	@FXML
	private TableColumn<Booking, String> tbBookingEndDate;

	@FXML
	private TableColumn<Booking, String> tbBookingDesc;

	@FXML
	private TableColumn<Room, Integer> tbRoomBookNr;

	@FXML
	private TableColumn<Room, String> tbRoomDesc;

	@FXML
	private TableColumn<Room, Integer> tbRoomNr;

	@FXML
	private TableColumn<Room, String> tbRoomtype;

	@FXML
	private TabPane mainTbPane;

	@FXML
	private AnchorPane mainAnchore01;

	@FXML
	private AnchorPane mainAchorCenter;

	@FXML
	private AnchorPane mainLeftAnchor;

	@FXML
	private BorderPane mainBoarder;

	@FXML
	private Button btRoomSave;
	
	@FXML
	private Button btRoomRemove;
	
	@FXML
	private TextArea mainTxtARoomDesc;

	@FXML
	private TextField mainTxtRoomNr;
	@FXML
	private TextField mainTxtRoomType;

	@FXML
	private ChoiceBox<String> pickController;

	@FXML
	private Tab tabBookList;

	private String choice;

	private String[] controllerList = { "Customer", "Room", "Booking" };

	ObservableList<Customer> customerList = FXCollections.observableArrayList();
	ObservableList<Room> roomList = FXCollections.observableArrayList();
	ObservableList<Booking> bookingList = FXCollections.observableArrayList();

	CustomerServices customerService = new CustomerServices();
	BookingServices bookingService = new BookingServices();
	RoomHandler roomHandler = new RoomHandler();

	public void sceneSwitch(ActionEvent event) throws IOException {

		choice = pickController.getValue();
		System.out.println(choice);

		switch (choice) {
		case "Customer":

			new AnchoreSwitch(mainAchorCenter, "views/customer.fxml");

			break;
		case "Individuals":

			break;
		case "Booking":
			new AnchoreSwitch(mainAnchore01, "views/main.fxml");
			break;
		}

	}

	@FXML
	void tbRoomSaveAction(ActionEvent event) {
		System.out.println(mainTxtARoomDesc.getText());
		Room room = new Room();
		room.setRoomBookingNr(Integer.parseInt(mainTxtRoomNr.getText()));
		room.setRoomType(mainTxtRoomType.getText());
		room.setRoomDesc(mainTxtARoomDesc.getText());
		roomHandler.addNewRoom(room);
		
		roomList = (ObservableList<Room>) roomHandler.getOListOfRoom(1);
		tbRoomBookNr.setSortType(TableColumn.SortType.ASCENDING);
		mainRoomList.getSortOrder().add(tbRoomBookNr);
		mainRoomList.sort();
		
		mainRoomList.setItems(roomList);
		mainRoomList.refresh();
	}
	
	@FXML
	void tbRoomRemoveAction(ActionEvent event) {
		int selectID = mainRoomList.getSelectionModel().getSelectedIndex();
		mainRoomList.getItems().remove(selectID);

		roomList = (ObservableList<Room>) roomHandler.getOListOfRoom(1);

		roomHandler.removeRoom(roomList, selectID);
		mainRoomList.setItems(roomList);
		mainRoomList.refresh();

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		System.out.println("mainController");
		
		
		pickController.getItems().addAll(controllerList);
		pickController.setOnAction(arg0 -> {
			try {
				sceneSwitch(arg0);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

		// init Booking Tabel
		bookingList = (ObservableList<Booking>) bookingService.getOListOfBooking(1);

		tbBookingNr.setCellValueFactory(new PropertyValueFactory<Booking, Integer>("bookingId"));
		tbBookingRoomNr.setCellValueFactory(new PropertyValueFactory<Booking, Integer>("bookingRoomNr"));
		tbBookingCusterFNamne.setCellValueFactory(new PropertyValueFactory<Booking, String>("customerFname"));
		tbBookingCustomerLName.setCellValueFactory(new PropertyValueFactory<Booking, String>("customerFname"));
		tbBookingStartDate.setCellValueFactory(new PropertyValueFactory<Booking, String>("bookingStartDate"));
		tbBookingEndDate.setCellValueFactory(new PropertyValueFactory<Booking, String>("bookingEndDate"));
		tbBookingDesc.setCellValueFactory(new PropertyValueFactory<Booking, String>("bookingDesc"));
		mainBookingList.setItems(bookingList);

		// roomList
		roomList = (ObservableList<Room>) roomHandler.getOListOfRoom(1);
		tbRoomBookNr.setCellValueFactory(new PropertyValueFactory<Room, Integer>("roomBookingNr"));
		tbRoomDesc.setCellValueFactory(new PropertyValueFactory<Room, String>("roomDesc"));
		tbRoomNr.setCellValueFactory(new PropertyValueFactory<Room, Integer>("roomid"));
		tbRoomtype.setCellValueFactory(new PropertyValueFactory<Room, String>("roomType"));
		mainRoomList.setItems(roomList);
		
		

		// init Customer Tabel
		customerList = (ObservableList<Customer>) customerService.getOListOfCustomer(1);
		tbCustomerFName.setCellValueFactory(new PropertyValueFactory<Customer, String>("customerFname"));
		tbCustomerLName.setCellValueFactory(new PropertyValueFactory<Customer, String>("customerEnamne"));
		tbCustomerAddress.setCellValueFactory(new PropertyValueFactory<Customer, String>("customerAddress"));
		tbCustomerEmail.setCellValueFactory(new PropertyValueFactory<Customer, String>("customerEmail"));
		tbCustomerPhone.setCellValueFactory(new PropertyValueFactory<Customer, String>("customerPhone"));
		tbCustomerStatus.setCellValueFactory(new PropertyValueFactory<Customer, Integer>("status"));
		mainCustomerList.setItems(customerList);

	}

}
