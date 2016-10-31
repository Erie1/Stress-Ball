package StressBall;

import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Erik
 */
public class SpeedoMeter extends Thread {
    
    private final LinkedList<Long> Times;
    private static SpeedoMeter Instance;
    
    /**
     * the constructor method
     */
    public SpeedoMeter() {
	Times = new LinkedList<>();
    }
    
    /**
     * singleton was needed to resolve some static method isues
     * @return the instance
     */
    public static SpeedoMeter getInstance() {
	if(Instance == null)
	    Instance = new SpeedoMeter();
	return Instance;
    }
    
    /**
     * add a clicktime to the list
     * @param Time the clicktime
     */
    public void setTime(Long Time) {
	Times.addLast(Time);
	Scoring.getInstance().ClickScore(Times.size());
	System.out.println("Click added at: " + Time + " Speed is now: " + Times.size());
    }

    /**
     * run method for runnable interface
     */
    @Override
    public void run() {
	System.out.println("speedometer started");
	while(true){
	    Long Second = System.currentTimeMillis() - 1000;
	    System.out.print("");
	    while(!Times.isEmpty() && Times.getFirst() < Second) {
		Times.removeFirst();
		System.out.println("removed click");
		Scoring.getInstance().ClickScore(Times.size());
	    }
	}
    }
}
