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
    
    /**
     * click counter
     */
    private int Counter;
        
    /**
     * labels for the fxml
     */
    @FXML
    public  Label FXCounter, HighScore, ClickSpeed, ClickSpeedHighscore;
    
    /**
     * count action increases click counter when clicking the button
     * @param event 
     */
    @FXML
    private void Count(ActionEvent event) {
	SpeedoMeter.getInstance().setTime(System.currentTimeMillis());
	Counter++;
	FXCounter.setText(Integer.toString(Counter));
    }
    
    /**
     * activates a small game to see how many clicks you can accomplish in ... seconds
     * @param event 
     */
    @FXML
    private void speedRun(ActionEvent event) {
	Counter = 0;
	FXCounter.setText(Integer.toString(Counter));
	
    }
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
	Counter = 0;
	FXCounter.setText(Integer.toString(Counter));
    }    
}
