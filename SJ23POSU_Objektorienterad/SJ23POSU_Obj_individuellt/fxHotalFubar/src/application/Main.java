package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws IOException {
	
		 

		//FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("views/ParticipantDetails.fxml"));
		
		FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("views/main.fxml"));

		Scene scene = new Scene(fxmlLoader.load(), 1200, 900);
		primaryStage.setTitle("Tour Di Ski");
		primaryStage.setScene(scene);
		primaryStage.show(); 
		
 
	}

	@Override
	public void init() throws Exception {
		// TODO Auto-generated method stub
		super.init();
		System.out.println("test");

	}

	public static void main(String[] args) {
		launch(args);
	}
}
