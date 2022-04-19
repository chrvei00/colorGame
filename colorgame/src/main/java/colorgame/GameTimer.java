package colorgame;

import java.util.Timer;
import java.util.TimerTask;

public class GameTimer {
    
    private int counter;
    private boolean stop;
    private Timer ticker = new Timer();

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

    public GameTimer(int time) {
        this.counter = time;
        this.stop = false;
        ticker.scheduleAtFixedRate(tick, 1000, 1000);    
    }

    public int getTime() {
        return counter;
    }

    public void stop() {
        stop = false;
    }

}