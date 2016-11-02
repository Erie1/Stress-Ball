package StressBall;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author Erik
 */
public class StressBall extends Application {
    
    protected int StageWidth = 320;
    protected int StageHeight = 300;
    
    /**
     * build the stage and set restraints
     * @param stage
     * @throws Exception 
     */
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("StressBall.fxml"));
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("css/buttonstyle.css").toExternalForm());
        scene.getStylesheets().add(getClass().getResource("css/stressballstyle.css").toExternalForm());
        
        stage.setScene(scene);
	stage.setMinHeight(StageHeight);
	stage.setMinWidth(StageWidth);
	stage.setOnCloseRequest((WindowEvent we) -> {
	    Scoring.getInstance().writeHighscores();
	});
        stage.show();
    }

    /**
     * initialize all threads and scores
     * @param args the command line arguments
     */
    public static void main(String[] args) {
	Thread Speedometer = new Thread(SpeedoMeter.getInstance());
	Speedometer.setDaemon(true);
	Speedometer.start();
        launch(args);
    }
}
