package StressBall;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 *
 * @author Erik
 */
public class StressBallController implements Initializable {
    
    private int counter;
    
    @FXML
    private Label FXCounter;
    private Label HighScore;
    private Label ClickSpeed;
    private Label ClickSpeedHighscore;
    
    private void setClicks(int x){
        counter = x;
	FXCounter.setText(Integer.toString(counter));
    }
    
    @FXML
    private void Count(ActionEvent event) {
	setClicks(++counter);
	speedCount();
    }
    
    @FXML
    private void speedRun(ActionEvent event) {
	setClicks(0);
	//TODO implement threading to set and display countdown and result in
	//showing score and if necesary change highscore
	//(start counting after first click or 1 sec)
    }
    
    private void speedCount() {
	//TODO implement clickspeed counter
    }
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
	setClicks(0);
    }    
    
}
