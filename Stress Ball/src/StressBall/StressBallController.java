package StressBall;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 *
 * @author Erik
 */
public class StressBallController implements Initializable {
    
    private int Counter;
    
    @FXML
    public  Label FXCounter, HighScore, ClickSpeed, ClickSpeedHighscore;
    
    @FXML
    private void Count(ActionEvent event) {
	SpeedoMeter.getInstance().setTime(System.currentTimeMillis());
	Counter++;
	FXCounter.setText(Integer.toString(Counter));
    }
    
    @FXML
    private void speedRun(ActionEvent event) {
	Counter = 0;
	FXCounter.setText(Integer.toString(Counter));
	//TODO implement threading to set and display countdown and result in
	//showing score and if necesary change highscore
	//(start counting after first click or 1 sec)
    }
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
	Counter = 0;
	FXCounter.setText(Integer.toString(Counter));
    }    
}
