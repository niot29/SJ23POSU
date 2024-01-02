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
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.util.Callback;
import javafx.util.Duration;

public class MainController implements Initializable {
//
//	static int hours = 0;
//	static int minuts = 0;
//	static int seconds = 0;
//	static int miliseconds = 0;
//	static int elastedTime = 0;
	static boolean state = true;
	static double i = 0;
	static double progStaus = 0;
//	String miliseconds_string = String.format("%02d", miliseconds);
//	String seconds_string = String.format("%02d", seconds);
//	String minuts_string = String.format("%02d", minuts);
//	String hours_string = String.format("%02d", hours);
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
	private TableColumn<Participant, String> colPartvipantX;

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
	private ProgressBar mainPrograsBar;

	@FXML
	private Text mainProgStatusText;

	@FXML
	private AnchorPane mainAchorePane;

	ProgressBar pb = new ProgressBar(0.6);

	participantHandler parHandler = new participantHandler();

	ObservableList<Participant> list = FXCollections.observableArrayList();

	TimerHandler timerHandler = new TimerHandler();

	Timeline timeline = new Timeline(
//            new KeyFrame(Duration.seconds(1),
			new KeyFrame(Duration.millis(1), e -> {

				// System.out.println("timeline: " + ++i/10000 + " " + i/1000 + " -100000- " +
				// ++i/100000);
				mainClock.setText(timerHandler.getCurrentTime());

				if (state) {
					parHandler.setStartTime(list, "1", timerHandler.getCurrentTime());
					state = false;
				}
				System.out.println(i + "--" + progStaus + "---" +  i / 1000);
				progStaus = i / 1000;
				int intValue = (int) Math.round(progStaus);

				if (intValue == 50) {
					// System.out.println("50%");
					mainProgStatusText.setText("50% - " + timerHandler.getCurrentTime());

				}
				if (intValue == 100) {
					// System.out.println("100%");
					mainProgStatusText.setText("100% - " + timerHandler.getCurrentTime());

				}

				timerHandler.timeRunnger();
				mainPrograsBar.setProgress(++i / 100000);

			}));

	Timeline raceStatus = new Timeline(new KeyFrame(Duration.millis(100), e -> {

		// progStaus = ++progStaus;
		// System.out.println(++progStaus + " " + progStaus/100);

		System.out.println("raceStatus:" + progStaus + " Current time: " + timerHandler.getCurrentTime());
		
		parHandler.race1Handler(list);
	
		tbplist.setItems(parHandler.race1Handler(list));
		
		
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
		raceStatus.setCycleCount(Timeline.INDEFINITE);

		raceStatus.play();
		timeline.play();

	}

	@FXML
	void mainStop(ActionEvent event) {
		System.out.println("## Stop ##");

		timeline.stop();
		raceStatus.stop();

		mainClock.setText(timerHandler.resetTimer());
		mainPrograsBar.setProgress(0);
		mainProgStatusText.setText("Done");
		i = 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// parHandler.clearfile();
		mainPrograsBar.setProgress(0.0100);
		//mainPrograsBar.setProgress(0);

		mainClock.setText("00:00:00:000");
		list = parHandler.getPercitipantsFromFile();

		colPartvipantID.setCellValueFactory(new PropertyValueFactory<Participant, Integer>("id"));
		colPartvipantName.setCellValueFactory(new PropertyValueFactory<Participant, String>("namen"));
		colPartvipantPosition.setCellValueFactory(new PropertyValueFactory<Participant, Integer>("position"));
		colPartvipantDiffTime.setCellValueFactory(new PropertyValueFactory<Participant, String>("totalDiffrenceTime"));
		colPartvipantX.setCellValueFactory(new PropertyValueFactory<Participant,  String>("compTime01"));
		tbplist.setItems(list);

	}


}
