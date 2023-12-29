package application.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Observable;
import java.util.ResourceBundle;

import application.model.Participant;
import application.services.participantHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class MainController implements Initializable{

	 	@FXML
	    private TableColumn<Participant, Integer> colPartvipantID;

	    @FXML
	    private TableColumn<Participant, String> colPartvipantName;

	    @FXML
	    private TableView<Participant> tbplist;
	    
	    
	    @FXML
	    private Text mainClock;
	    
	    @FXML
	    private Button mainStart;

	    @FXML
	    private Button mainStop;
	    
	    @FXML
	    private Button mgn;

	    @FXML
	    private AnchorPane mainAchorePane;
	    
	    participantHandler parHandler = new participantHandler();
	    
	    ObservableList<Participant> list = FXCollections.observableArrayList();

	    
	    @FXML
	    void switchScene(ActionEvent event) throws IOException {
	    	System.out.println("switchScene");
	    	new SceneSwitch(mainAchorePane, "views/ParticipantDetails.fxml");
	    }
	    
	    @FXML
	    public void mainStart(ActionEvent event) {
	    	System.out.println("## Start ##");
	    	mainClock.setText("11:00:00:00");
	    }
	    
	    public void mainStop(ActionEvent event) {
	    	System.out.println("## Start ##");
	    }
	    
	    
		@Override
		public void initialize(URL location, ResourceBundle resources) {
			
			
			
			colPartvipantID.setCellValueFactory(new PropertyValueFactory<Participant, Integer>("id"));
			colPartvipantName.setCellValueFactory(new PropertyValueFactory<Participant, String>("namen"));

			tbplist.setItems(list);
			
			
		
		}

}
