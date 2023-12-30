package tmp;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    //Time time = new Time(new CurrentTime().currentTime());
    Time time = new Time("12:13:34");


    @FXML
    private Text timer;

    @FXML
    private TextField alarmTime;

    Timeline timeline = new Timeline(
//            new KeyFrame(Duration.seconds(1),
            new KeyFrame(Duration.millis(100),
                    e -> {
                        if(time.getCurrentTime().equals(alarmTime.getText())){
                            System.out.println("ALARM!");
                        }
                        time.oneSecondPassed();
                        timer.setText(time.getCurrentTime());
            }));

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        timer.setText(time.getCurrentTime());

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }
}