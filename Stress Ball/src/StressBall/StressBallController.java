package StressBall;

import java.io.FileReader;
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
        
    /**
     * labels for the fxml
     */
    @FXML
    public  Label FXCounter, HighScore, ClickSpeed, ClickSpeedHighScore;
    
    /**
     * count action increases click counter when clicking the button
     * @param event 
     */
    @FXML
    private void Count(ActionEvent event) {
	SpeedoMeter.getInstance().setTime(System.currentTimeMillis());
	StressBall.Counter++;
	FXCounter.setText(Integer.toString(StressBall.Counter));
    }
    
    /**
     * activates a small game to see how many clicks you can accomplish in ... seconds
     * @param event 
     */
    @FXML
    private void speedRun(ActionEvent event) {
	StressBall.Counter = 0;
	FXCounter.setText(Integer.toString(StressBall.Counter));
	
    }
    
    /**
     * initialises the window and counter
     * @param url
     * @param rb 
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {	
	FXCounter.setText(Integer.toString(StressBall.Counter));
	HighScore.setText(Integer.toHexString(StressBall.Highscore));
	ClickSpeed.setText(Integer.toString(0));
	ClickSpeedHighScore.setText(Integer.toString(StressBall.ClickSpeedHighscore));
    }    
}
