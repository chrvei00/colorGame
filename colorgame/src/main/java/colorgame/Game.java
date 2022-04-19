package colorgame;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

public class Game {

    //Instance
    private List<Colortile> tiles = new ArrayList<>();
    private Timer timer;
    private int roundCounter;

    public Game() {
        this.tiles = Game.generateTiles();
        this.roundCounter = 1;
    }

    private static List<Colortile> generateTiles() {
        
        List<Colortile> tiles = new ArrayList<>();
        
        return tiles;
    }


    public static void main(String[] args) {
        Colortile t1 = new Colortile(100, 23, 33, true);
        System.out.println(t1);
    }

}
