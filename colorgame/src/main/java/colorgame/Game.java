package colorgame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;

public class Game {

    //Instance
    private List<Colortile> tiles = new ArrayList<>();
    private Timer timer;
    private int roundCounter;

    public Game() {
        this.tiles = Game.generateTiles();
        GameTimer minuteTimer = new GameTimer(60);
        this.roundCounter = 1;
    }

    public List<Colortile> getTiles() {
        return tiles;
    }

    private static List<Colortile> generateTiles() {
        
        List<Colortile> tmpTiles = new ArrayList<>();
        Random rand = new Random();
        int k = rand.nextInt(5);
        Boolean isCorrect;
        for (int i = 0; i < 5; i++) {
            isCorrect = (i == k);
            Colortile tmp = new Colortile(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255), isCorrect);
            tmpTiles.add(tmp);
        }
        return tmpTiles;
    }


    public static void main(String[] args) throws InterruptedException {
    }
}
