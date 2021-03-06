package StressBall;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Button;


/**
 *
 * @author Erik
 */
public class StressBallController implements Initializable {
        
    /**
     * labels for the fxml
     */
    @FXML
    public  Label FXCounter, lastScore, HighScore, ClickSpeed, ClickSpeedHighScore;
    private static StressBallController Instance;
    
    /**
     * buttons to the fxml
     */
    @FXML
    Button clickButton;
    Button resetButton;
    
    /**
     * count action increases click counter when clicking the button
     * @param event 
     */
    @FXML
    private void Count() {
	SpeedoMeter.getInstance().setTime(System.currentTimeMillis());
	Scoring.getInstance().Clicked();
	System.out.println("you clicked me!");
    }
    
    /**
     * resets the scores
     */
    @FXML
    private void reset() {
	Scoring.getInstance().reset();
    }
    
    /**
     * initialises the window and counter
     * @param url
     * @param rb 
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
	Instance = this;
	Scoring.getInstance().setHighscores();
    }
    
    /**
     * singleton was needed to resolve some static method isues
     * @return the instance
     */
    public static StressBallController getInstance() {
	return Instance;
    }
    
    /**
     * updates the labels with the new scores
     * @param Counter
     * @param Speed
     * @param ClickSpeedHighscore 
     */
    public void setScores(int Counter, int Speed, int ClickSpeedHighscore) {
	Platform.runLater(() -> {
	    FXCounter.setText(Integer.toString(Counter));
	    ClickSpeed.setText(Integer.toString(Speed));
	    ClickSpeedHighScore.setText(Integer.toString(ClickSpeedHighscore));
	});
	
    }
}
