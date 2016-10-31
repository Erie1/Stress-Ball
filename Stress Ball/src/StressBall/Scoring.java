/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StressBall;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

/**
 *
 * @author Erik
 */
public class Scoring {
    
    /**
     * the Clickcounter, clickspeed, and highscore variables
     * the instance for this part of the program
     */
    private int Counter, Speed, ClickSpeedHighscore;
    private static Scoring Instance;
    
    /**
     * singleton was needed to resolve some static method isues
     * @return the instance
     */
    public static Scoring getInstance() {
	if(Instance == null)
	    Instance = new Scoring();
	return Instance;
    }
    
    /**
     * update clickspeed and if necesary change highscore
     * @param speed the current clickspeed
     */
    public void ClickScore(int speed) {
	Speed = speed;
	if (Speed > ClickSpeedHighscore){
	    ClickSpeedHighscore = Speed;
	    System.out.println("NEW HIGHSCORE");
	}
	StressBallController.getInstance().setScores(Counter, Speed, ClickSpeedHighscore);   
    }
    
    /**
     * resets all the stats
     */
    public void reset() {
	Counter = 0;
	Speed = 0;
	ClickSpeedHighscore = 0;
	StressBallController.getInstance().setScores(Counter, Speed, ClickSpeedHighscore);
	System.out.println("scores have been reset");
    }
    
    /**
     * handles clicks
     */
    public void Clicked() {
	Counter++;
	System.out.println("counter increased");
	StressBallController.getInstance().setScores(Counter, Speed, ClickSpeedHighscore);
    }

    /**
     * set the highscores if there are any
     */
    public void setHighscores() {
	Counter = 0;
	try {
	    Scanner sc;
	    sc = new Scanner(new File("scores.txt"));
	    ClickSpeedHighscore = sc.nextInt();
	    System.out.println("scores loaded");
	} catch (FileNotFoundException ex) {
	    ClickSpeedHighscore = 0;
	    System.out.println("no scores found");
	}
	StressBallController.getInstance().setScores(Counter, Speed, ClickSpeedHighscore);
    }
    
    /**
     * write the highscore to a file to be loaded next time
     */
    public void writeHighscores() {
	try(PrintWriter writer = new PrintWriter("scores.txt", "UTF-8")) {
	    writer.println(ClickSpeedHighscore);
	    writer.flush();
	    System.out.println("Scores written");
	} catch (FileNotFoundException | UnsupportedEncodingException e) { 
	    System.out.println("something went wrong here");
	}
    }
}
