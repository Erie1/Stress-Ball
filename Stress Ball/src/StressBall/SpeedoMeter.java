package StressBall;

import java.util.LinkedList;

/**
 *
 * @author Erik
 */
public class SpeedoMeter extends Thread {
    
    private LinkedList<Long> Times;
    private static SpeedoMeter Instance;
    
    /**
     * the constructor method
     */
    public SpeedoMeter() {
	Times = new LinkedList<>();
    }
    
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
	    while(!Times.isEmpty() && Times.getFirst() < Second) {
		Times.removeFirst();
		System.out.println("removed time");
	    }
	    Scoring.getInstance().ClickScore(Times.size());
	}
    }
}
