package colorgame;

import java.util.Timer;
import java.util.TimerTask;

public class GameTimer {
    
    //Declerations
    private int counter;
    private boolean stop;
    private final Timer ticker = new Timer();

    //  TimerTask declearation
    private final TimerTask tick = new TimerTask() {
        //Count down until stopped, or counter == 0.
        @Override
        public void run() {
            if (counter == 0 || stop) {
                ticker.cancel();
            } else {
                counter--;
                try {
                    GameController.updateTimer();
                } catch (Exception e) {
                    System.out.println("GameController not initialized. Ignore if this is JUnit test.");
                }
            }
        }
    };

    //Constructor
    public GameTimer(int time) {

        //Init timer
        this.counter = time;
        this.stop = false;
        ticker.scheduleAtFixedRate(tick, 0, 1000);    

    }
    
    //Getters
    public int getTime() {
        return counter;
    }
    
    //Methods
    public void stop() {
        stop = true;
    }

}