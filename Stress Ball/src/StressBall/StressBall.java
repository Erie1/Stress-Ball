package StressBall;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Erik
 */
public class StressBall extends Application {
    
    protected int StageWidth = 320;
    protected int StageHeight = 300;
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("StressBall.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
	stage.setMinHeight(StageHeight);
	stage.setMinWidth(StageWidth);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
	Thread Speed = new Thread(SpeedoMeter.getInstance());
	Speed.setDaemon(true);
	Speed.start();
        launch(args);
    }
}
