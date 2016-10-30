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
    
    private void setCounter(int x){
        counter = x;
	FXCounter.setText(Integer.toString(counter));
    }
    
    @FXML
    private void Count(ActionEvent event) {
	setCounter(++counter);
    }
    
    @FXML
    private void speedRun(ActionEvent event) {
	setCounter(0);
	//TODO implement threading to set and display countdown and result in
	//showing score and if necesary change highscore
    }
    
    @FXML
    private void speedCount(ActionEvent event) {
	//TODO implement clickspeed counter
    }
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
	setCounter(0);
    }    
    
}
