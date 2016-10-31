package StressBall;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
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
    public  Label FXCounter, lastScore, HighScore, ClickSpeed, ClickSpeedHighScore;
    private static StressBallController Instance;
    
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
    
    public static StressBallController getInstance() {
	return Instance;
    }
    
    public void setScores(int Counter, int Speed, int ClickSpeedHighscore) {
	Platform.runLater(() -> {
	    FXCounter.setText(Integer.toString(Counter));
	    ClickSpeed.setText(Integer.toString(Speed));
	    ClickSpeedHighScore.setText(Integer.toString(ClickSpeedHighscore));
	});
	
    }
}
