package application.controller;

import java.io.IOException;
import java.util.Objects;

import application.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class SceneSwitch {
	
	public SceneSwitch(AnchorPane currentAnchorePane, String fxml) throws IOException{
		AnchorPane nextAnchorePabe = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource(fxml)));
		currentAnchorePane.getChildren().removeAll();
		currentAnchorePane.getChildren().setAll(nextAnchorePabe);
		
	}

}
