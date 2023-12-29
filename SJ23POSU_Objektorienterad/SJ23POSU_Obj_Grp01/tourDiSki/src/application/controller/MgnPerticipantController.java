package application.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import application.model.Participant;
import application.services.participantHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
//import com.gluonhq.charm.glisten.control.TextField;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class MgnPerticipantController {

	@FXML
	private Button btAdd;

	@FXML
	private Button btExit;

	@FXML
	private Button btRandom;

	@FXML
	private Button btremove;

	@FXML
	private Button btGo;

	@FXML
	private TableColumn<Participant, Integer> colPartvipantID;

	@FXML
	private TableColumn<Participant, String> colPartvipantName;

	@FXML
	private TableColumn<Participant, Integer> colPartvipantPosition;

	@FXML
	private TextField inputFCount;

	@FXML
	private Text txtId;

	@FXML
	private Text txtName;

	@FXML
	private Text txtPosition;

	@FXML
	private Text txtStartTime;

	@FXML
	private Text txtDiffrenceTime;

	@FXML
	private Text txtEndTime;

	@FXML
	private Text txtRace1;

	@FXML
	private Text txtRace2;

	@FXML
	private Text txtRace3;

	@FXML
	private TextField txSearchFeild;

	@FXML
	private TextField txfRadomAdd;

	@FXML
	private TableView<Participant> tbplist;

	@FXML
	private TextField txFieldName;
	
	@FXML
    private AnchorPane partiDetailAchorePane;

	participantHandler parHandler = new participantHandler();

	ObservableList<Participant> list = FXCollections.observableArrayList();

	@FXML
	void mgnPartAdd(ActionEvent event) {
		list = parHandler.addRanPercitipant(list, txFieldName.getText());

		colPartvipantID.setCellValueFactory(new PropertyValueFactory<Participant, Integer>("id"));
		colPartvipantName.setCellValueFactory(new PropertyValueFactory<Participant, String>("namen"));
		colPartvipantPosition.setCellValueFactory(new PropertyValueFactory<Participant, Integer>("position"));

		tbplist.setItems(list);
		parHandler.savePercitipantToFile(list);
		txFieldName.setText("");

	}

	@FXML
	void mgnPartExit(ActionEvent event) throws IOException {
		new SceneSwitch(partiDetailAchorePane, "views/main.fxml");

	}

	@FXML
	void mgnPartRadomAdd(ActionEvent event) {
		int count = 0;
		if (!txfRadomAdd.getText().isEmpty()) {

			try {
				count = Integer.parseInt(txfRadomAdd.getText());
			} catch (NumberFormatException e) {
				e.printStackTrace();
				txfRadomAdd.setText(null);

			}
			try {
				list = parHandler.addRanPercitipantfromFile(list, count);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			colPartvipantID.setCellValueFactory(new PropertyValueFactory<Participant, Integer>("id"));
			colPartvipantName.setCellValueFactory(new PropertyValueFactory<Participant, String>("namen"));
			colPartvipantPosition.setCellValueFactory(new PropertyValueFactory<Participant, Integer>("position"));
			
			tbplist.setItems(list);
			parHandler.savePercitipantToFile(list);
			txfRadomAdd.setText(null);
		}

	}

	@FXML
	void mgnPartRemove(ActionEvent event) {
		int selectID = tbplist.getSelectionModel().getSelectedIndex();
		
		
		tbplist.getItems().remove(selectID);
		
		list = parHandler.getPercitipantsFromFile();
		parHandler.removeRanPercitipant(list, selectID);
		tbplist.setItems(list);
	}

	@FXML
	void tbCelDetail(MouseEvent event) {
		int selectID = tbplist.getSelectionModel().getSelectedIndex();
		System.out.println(tbplist.getItems().get(selectID).getId());
		System.err.println();
		txtId.setText(String.valueOf(tbplist.getItems().get(selectID).getId()));
		txtName.setText(tbplist.getItems().get(selectID).getNamen());
		txtPosition.setText(String.valueOf(tbplist.getItems().get(selectID).getPosition()));
		txtStartTime.setText(tbplist.getItems().get(selectID).getStartTime());

		txtDiffrenceTime.setText(tbplist.getItems().get(selectID).getTotalDiffrenceTime());
		txtEndTime.setText(tbplist.getItems().get(selectID).getEndTime());
		txtRace1.setText(tbplist.getItems().get(selectID).getRac1());
		txtRace2.setText(tbplist.getItems().get(selectID).getRac2());
		txtRace3.setText(tbplist.getItems().get(selectID).getRac3());

	}

	@FXML
	void search(ActionEvent event) {
		System.out.println("search " + txSearchFeild.getText());
		//parHandler.getPercitipantsFromFile();
		
		// Create temp search list
		ObservableList<Participant> list2 = parHandler.searchList(list, txSearchFeild.getText());

		if (txSearchFeild.getText().isEmpty()) {
			list = parHandler.getPercitipantsFromFile();
			tbplist.setItems(list);
		} else {
			tbplist.setItems(list2);
		}

	}

}
