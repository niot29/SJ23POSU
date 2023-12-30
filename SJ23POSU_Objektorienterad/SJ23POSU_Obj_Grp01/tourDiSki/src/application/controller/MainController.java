package application.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Observable;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import application.model.Participant;
import application.services.TimerHandler;
import application.services.participantHandler;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
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
import javafx.util.Duration;

public class MainController implements Initializable {

	static int hours = 0;
	static int minuts = 0;
	static int seconds = 0;
	static int miliseconds = 0;
	static int elastedTime = 0;
	static boolean state = true;
	String miliseconds_string = String.format("%02d", miliseconds);
	String seconds_string = String.format("%02d", seconds);
	String minuts_string = String.format("%02d", minuts);
	String hours_string = String.format("%02d", hours);
	String watchTimer = "";

	@FXML
	private TableColumn<Participant, Integer> colPartvipantID;

	@FXML
	private TableColumn<Participant, String> colPartvipantName;

	@FXML
	private TableColumn<Participant, Integer> colPartvipantPosition;
	
	@FXML
    private TableColumn<Participant, String> colPartvipantDiffTime;

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

	TimerHandler timerHandler = new TimerHandler();

	Timeline timeline = new Timeline(
//            new KeyFrame(Duration.seconds(1),
			new KeyFrame(Duration.millis(1), e -> {

				timerHandler.timeRunnger();
				mainClock.setText(timerHandler.getCurrentTime());
			}));

	@FXML
	void switchScene(ActionEvent event) throws IOException {
		System.out.println("switchScene");
		new SceneSwitch(mainAchorePane, "views/ParticipantDetails.fxml");
	}

	@FXML
	public void mainStart(ActionEvent event) {
		System.out.println("## Start ##");
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.play();
	}

	@FXML
	void mainStop(ActionEvent event) {
		System.out.println("## Stop ##");
		timeline.stop();
		mainClock.setText(timerHandler.resetTimer());
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//parHandler.clearfile();
		mainClock.setText("00:00:00:000");
		list = parHandler.getPercitipantsFromFile();

		colPartvipantID.setCellValueFactory(new PropertyValueFactory<Participant, Integer>("id"));
		colPartvipantName.setCellValueFactory(new PropertyValueFactory<Participant, String>("namen"));
		colPartvipantPosition.setCellValueFactory(new PropertyValueFactory<Participant, Integer>("position"));
		colPartvipantDiffTime.setCellValueFactory(new PropertyValueFactory<Participant, String>("totalDiffrenceTime"));

		tbplist.setItems(list);

	}
//
//	public Runnable runTimer() {
//		TimerHandler timerHandler = new TimerHandler();
//		
//	
//		
//		myRepeatingTimer.scheduleAtFixedRate(new TimerTask(){
//			
//			@Override
//			public void run() {
//		
//				elastedTime++;
//				miliseconds++;
//				// System.out.println(elastedTime);
//				hours = (elastedTime / 3600000);
//				minuts = (elastedTime / 60000) % 60;
//				seconds = (elastedTime / 1000) % 60;
//				// miliseconds = elastedTime;
//		
//				miliseconds_string = String.format("%02d", miliseconds);
//				seconds_string = String.format("%02d", seconds);
//				minuts_string = String.format("%02d", minuts);
//				hours_string = String.format("%02d", hours);
//		
//				if (miliseconds >= 1000) {
//					miliseconds = 0;
//					miliseconds_string = String.format("%02d", miliseconds);
//		
//				}
//		
//			}
//		
//			},0,1);
//	
//		watchTimer = hours_string + ":" + minuts_string + ":" + seconds_string + ":" + miliseconds_string;
//		
//		mainClock.setText(watchTimer);
//		return null;
//
//	}

}
