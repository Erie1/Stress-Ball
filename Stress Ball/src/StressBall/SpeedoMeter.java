package StressBall;

import static java.lang.Thread.interrupted;
import java.util.LinkedList;

/**
 *
 * @author Erik
 */
public class SpeedoMeter implements Runnable {

    /**
     * the SpeedoMeter instance for singleton implementation
     * the linkedList of click times for calculating clickspeed
     */
    private static SpeedoMeter Instance = null;
    LinkedList<Long> Times;
    
    /**
     * the constructor method
     */
    protected SpeedoMeter() {
	Times = new LinkedList<>();
    }
    
    /**
     * getInstance for Singleton implementation
     * @return The instance
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
	Times.add(Time);
    }

    /**
     * run method for runnable interface
     */
    @Override
    public void run() {
	while(!interrupted()){
	    Long Second = System.currentTimeMillis() - 1000;
	    while(!Times.isEmpty() && Times.getFirst() < Second) {
		Times.removeFirst();
	    }
	int Temp = Times.size();
	if (Temp > StressBall.ClickSpeedHighscore)
	    StressBall.ClickSpeedHighscore = Temp;
	System.out.println(Temp);
	}
    }
}
