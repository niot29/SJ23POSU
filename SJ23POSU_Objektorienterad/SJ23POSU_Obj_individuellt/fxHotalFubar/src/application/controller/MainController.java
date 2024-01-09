package application.controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import application.modell.Booking;
import application.modell.Customer;
import application.modell.Room;
import application.services.BookingServices;
import application.services.CustomerServices;
import application.services.DataHandler;
import application.services.RoomHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

public class MainController implements Initializable {

// -- Customer tabel	

	@FXML
	private TableView<Customer> mainCustomerList;

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
	private TextField txtCustomerFName;

	@FXML
	private TextField txtCustomerEName;

	@FXML
	private TextField txtCustomerAddress;

	@FXML
	private TextField txtCustomerPhone;

	@FXML
	private TextField txtCustomerEmail;

	@FXML
	private Button btSaveCustomer;

	@FXML
	private Button btRemoveCustomer;

	// Booking

	@FXML
	private TableView<Booking> mainBookingList;

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
	private Text txtBlRoomNr;
	@FXML
	private Text txtBlStayDay;
	@FXML
	private Text txtBlNr;
	@FXML
	private Text txtBlCustomer;
	@FXML
	private Text txtBlBookingDatas;

	@FXML
	private Button btRemoveBooking;

	@FXML
	private Button btSaveBooking;

	@FXML
	private Button btmainSearch;

	@FXML
	private DatePicker dpickEndtDay;

	@FXML
	private DatePicker dpickStartDay;

	@FXML
	private TextArea txtBlDesc;

	@FXML
	private TextField txtSearchFeild;
	// Room

	@FXML
	private TableView<Room> mainRoomList;

	@FXML
	private TableColumn<Room, Integer> tbRoomBookNr;

	@FXML
	private TableColumn<Room, String> tbRoomDesc;

	@FXML
	private TableColumn<Room, Integer> tbRoomNr;

	@FXML
	private TableColumn<Room, String> tbRoomtype;

	@FXML
	private Button btRoomSave;

	@FXML
	private Button btRoomRemove;

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

	private String[] controllerList = { "Customer", "BookingNr", "RoomNr" };

	int customerSelectId;

//	int roomSelectId =  mainRoomList.getSelectionModel().getSelectedIndex();
//	int customerSelectId =  mainCustomerList.getSelectionModel().getSelectedIndex();
//	int bookingSelectId = mainBookingList.getSelectionModel().getSelectedIndex();

	ObservableList<Customer> customerList = FXCollections.observableArrayList();
	ObservableList<Room> roomList = FXCollections.observableArrayList();
	ObservableList<Booking> bookingList = FXCollections.observableArrayList();

	CustomerServices customerService = new CustomerServices();
	BookingServices bookingService = new BookingServices();
	RoomHandler roomHandler = new RoomHandler();
	DataHandler dataHandler = new DataHandler();

	@FXML
	void btmainSearchAction(ActionEvent event) {
		
		if(txtSearchFeild.getText().isEmpty()){
			bookingList = bookingService.getOListOfBooking(1);
			mainBookingList.setItems(bookingList);
		}else {
			ObservableList<Booking> bookingList2 = bookingService.searchById(txtSearchFeild.getText());
			mainBookingList.setItems(bookingList2);
		}
		
//		mainBookingList.setItems(bookingList);
	}

	@FXML
	void getBookingItem(MouseEvent event) {
		int bookingSelectId = mainBookingList.getSelectionModel().getSelectedIndex();

		if (bookingSelectId <= -1) {
			return;

		}

		String Customer = tbCustomerFName.getCellData(customerSelectId).toString() + " "
				+ tbCustomerLName.getCellData(customerSelectId).toString();
		txtBlCustomer.setText(Customer);

		txtBlNr.setText(tbBookingNr.getCellData(bookingSelectId).toString());
		txtBlRoomNr.setText(tbBookingRoomNr.getCellData(bookingSelectId).toString());

		LocalDate startDay = LocalDate.parse(tbBookingStartDate.getCellData(bookingSelectId).toString());
		LocalDate EndDay = LocalDate.parse(tbBookingEndDate.getCellData(bookingSelectId).toString());

		txtBlStayDay.setText(Integer.toString(bookingService.returnDayStay(startDay, EndDay)));

		txtBlCustomer.setText(Customer);

	}

	@FXML
	void getRoomItem(MouseEvent event) {
		int roomSelectId = mainRoomList.getSelectionModel().getSelectedIndex();

		if (roomSelectId <= -1) {
			return;

		}
		txtBlRoomNr.setText(tbRoomNr.getCellData(roomSelectId).toString());

	}

	@FXML
	void getCustomerItem(MouseEvent event) {
		customerSelectId = mainCustomerList.getSelectionModel().getSelectedIndex();

		if (customerSelectId <= -1) {
			return;

		}

		String Customer = tbCustomerFName.getCellData(customerSelectId).toString() + " "
				+ tbCustomerLName.getCellData(customerSelectId).toString();
		txtBlCustomer.setText(Customer);

	}

	@FXML
	void getStartDay(ActionEvent event) {
		System.out.println(dpickStartDay.getValue());

		LocalDate startDay = dpickStartDay.getValue();
	}

	@FXML
	void getEndDay(ActionEvent event) {
		System.out.println(dpickEndtDay.getValue());

		try {
			LocalDate startDay = dpickStartDay.getValue();
			LocalDate EndDay = dpickEndtDay.getValue();
			int days = bookingService.returnDayStay(startDay, EndDay);
			txtBlStayDay.setText(Integer.toString(days));
		} catch (Exception e) {
			System.err.println("Some Date Pick value is not define");
//				e.printStackTrace();
		}

	}

	@FXML
	void btSaveBookingAction(ActionEvent event) {
		System.out.println("btSaveBookingAction");

		Booking booking = new Booking();
		booking.setBookingRoomNr(Integer.parseInt(txtBlRoomNr.getText()));
		booking.setBookingStayDay(Integer.parseInt(txtBlStayDay.getText()));
		booking.setBookingStartDate(dpickStartDay.getValue().toString());
		booking.setBookingEndDate(dpickEndtDay.getValue().toString());
		booking.setBookingDesc(txtBlDesc.getText());
		booking.setBookingCustomerId(mainCustomerList.getItems().get(customerSelectId).getCustomerId());

		bookingService.addNewBooking(booking);
		bookingList = bookingService.getOListOfBooking(1);
		mainBookingList.setItems(bookingList);
		resettxtFiled();

	}
	

	@FXML
	void btRemoveBookingActions(ActionEvent event) {
//		int selectID =  mainBookingList.getSelectionModel().getSelectedIndex();
//		mainBookingList.getItems().remove(selectID);
//
//		bookingList = bookingService.getOListOfBooking(1);
//
//		bookingService.removeBooking(bookingList, selectID);
//		mainBookingList.setItems(bookingList);
//		mainBookingList.refresh();

	}

	@FXML
	void btSaveCustomerAction(ActionEvent event) {
		Customer customer = new Customer();
		customer.setCustomerFname(txtCustomerFName.getText());
		customer.setCustomerEnamne(txtCustomerEName.getText());
		customer.setCustomerAddress(txtCustomerAddress.getText());
		customer.setCustomerPhone(txtCustomerPhone.getText());
		customer.setCustomerEmail(txtCustomerEmail.getText());
		customerService.addNewCustomer(customer);

		customerList = customerService.getOListOfCustomer(1);
		tbRoomBookNr.setSortType(TableColumn.SortType.ASCENDING);
		mainCustomerList.getSortOrder().add(tbCustomerFName);
		mainCustomerList.sort();

		mainCustomerList.setItems(customerList);
		mainCustomerList.refresh();
	}

	@FXML
	void btRemoveCustomerAction(ActionEvent event) {
		System.out.println("btRemoveCustomerAction");
		int selectID = mainCustomerList.getSelectionModel().getSelectedIndex();
		mainCustomerList.getItems().remove(selectID);

		customerList = customerService.getOListOfCustomer(1);

		customerService.removeCustome(customerList, selectID);
		mainCustomerList.setItems(customerList);
		mainCustomerList.refresh();

	}

	@FXML
	void tbRoomSaveAction(ActionEvent event) {
		Room room = new Room();
//		room.setRoomBookingNr(Integer.parseInt(mainTxtRoomNr.getText()));
		room.setRoomType(mainTxtRoomType.getText());
		room.setRoomDesc(mainTxtARoomDesc.getText());
		roomHandler.addNewRoom(room);

		roomList = roomHandler.getOListOfRoom(1);
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

	
	void resettxtFiled() {
		txtBlNr.setText("");
		txtBlRoomNr.setText("");
		txtBlStayDay.setText("");
		txtBlCustomer.setText("");
		txtBlDesc.setText("");
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		System.out.println("mainController");

		// init Booking Tabel
		bookingList = (ObservableList<Booking>) bookingService.getOListOfBooking(1);

		tbBookingNr.setCellValueFactory(new PropertyValueFactory<Booking, Integer>("bookingId"));
		tbBookingRoomNr.setCellValueFactory(new PropertyValueFactory<Booking, Integer>("bookingRoomNr"));
		tbBookingCusterFNamne.setCellValueFactory(new PropertyValueFactory<Booking, String>("bookingCustomerFname"));
		tbBookingCustomerLName.setCellValueFactory(new PropertyValueFactory<Booking, String>("bookingCustomerEnamne"));
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

//		mainTxtRoomNr.setPromptText(Integer.toString(roomList.size() +1));

		// init Customer Tabel
		customerList = (ObservableList<Customer>) customerService.getOListOfCustomer(1);
		tbCustomerFName.setCellValueFactory(new PropertyValueFactory<Customer, String>("customerFname"));
		tbCustomerLName.setCellValueFactory(new PropertyValueFactory<Customer, String>("customerEnamne"));
		tbCustomerAddress.setCellValueFactory(new PropertyValueFactory<Customer, String>("customerAddress"));
		tbCustomerEmail.setCellValueFactory(new PropertyValueFactory<Customer, String>("customerEmail"));
		tbCustomerPhone.setCellValueFactory(new PropertyValueFactory<Customer, String>("customerPhone"));
		tbCustomerStatus.setCellValueFactory(new PropertyValueFactory<Customer, Integer>("status"));
		mainCustomerList.setItems(customerList);

//		System.out.println(bookingList.get(bookingSelectId));

	}

}
