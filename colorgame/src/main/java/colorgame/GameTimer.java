package colorgame;

//Imports
import java.util.Timer;
import java.util.TimerTask;

public class GameTimer {
    
    //Declerations
    private int counter;
    private boolean stop;
    private Timer ticker = new Timer();
    //  TimerTask declearation
    private TimerTask tick = new TimerTask() {
        @Override
        public void run() {
            if (counter == 0 || stop) {
                ticker.cancel();
            } else {
                counter--;
            }
        }
    };

    //Constructor
    public GameTimer(int time) {
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
        stop = false;
    }

}