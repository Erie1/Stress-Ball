package StressBall;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;
import javafx.application.Application;
import javafx.event.EventHandler;
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
    public static int Counter, LastRun, Highscore, Speed, ClickSpeedHighscore;
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("StressBall.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
	stage.setMinHeight(StageHeight);
	stage.setMinWidth(StageWidth);
	stage.setOnCloseRequest((WindowEvent we) -> {
	    StressBall.writeHighscores();
	});
        stage.show();
    }

    /**
     * initialize all threads and scores
     * @param args the command line arguments
     */
    public static void main(String[] args) {
	setHighscores();
	Counter = 0;
	Thread Speedometer = new Thread(SpeedoMeter.getInstance());
	Speedometer.setDaemon(true);
	Speedometer.start();
        launch(args);
    }

    /**
     * set the highscores if there are any
     */
    private static void setHighscores() {
	try {
	    Scanner sc;
	    sc = new Scanner(new File("scores.txt"));
	    Highscore = sc.nextInt();
	    ClickSpeedHighscore = sc.nextInt();
	    System.out.println("scores loaded");
	} catch (FileNotFoundException ex) {
	    Highscore = 0;
	    ClickSpeedHighscore = 0;
	    System.out.println("no scores found");
	}
    }
    
    /**
     * write the highscore to a file to be loaded next time
     */
    public static void writeHighscores() {
	try(PrintWriter writer = new PrintWriter("scores.txt", "UTF-8")) {
	    writer.println(Highscore);
	    writer.println(ClickSpeedHighscore);
	    writer.flush();
	    System.out.println("Scores written");
	} catch (FileNotFoundException | UnsupportedEncodingException e) { 
	    System.out.println("something went wrong here");
	}
    }
}
