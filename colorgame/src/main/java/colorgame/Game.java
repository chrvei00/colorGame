package colorgame;

//Imports
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {

    //Instance
    private List<Colortile> tiles = new ArrayList<>();
    private GameTimer minuteTimer;
    private int roundCounter;
    private int correctAnswers;
    private int result;

    //Init
    public Game() {
        this.result = 0;
        this.newRound();
        minuteTimer = new GameTimer(60);
    }

    
    //Getters:
    public List<Colortile> getTiles() {
        return this.tiles;
    }

    public int getRoundCounter() {
        return this.roundCounter;
    }

    public int getResult() {
        return this.result;
    }

    public int getTime() {
        return this.minuteTimer.getTime();
    }


    //Gamerunninng-methods

    //  onClickHandler - main event handler
    public void handler(int clickedTileIndex) {
        this.updateScore(tiles.get(clickedTileIndex).toString().equals(this.findCorrectTile().toString()));

        if (this.isFinished()) {            
        } else {
            this.newRound();
        }
    }

    //  Create next round
    public void newRound() {
        this.tiles = Game.generateTiles();
        this.roundCounter++;
    }

    //  Generate new tiles
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

    //  Find correct tile
    public Colortile findCorrectTile() {
        Colortile tile;
        ColorTileIterator it1 = new ColorTileIterator(tiles);
            while (it1.hasNext()) {
                tile = it1.next();
                if (tile.isCorrect()) {
                    return tile;
                }
            }

        throw new Error("Cannot find the correct tile");
    }

    //  Update score
    public void updateScore(Boolean answer) {
        if(answer && this.correctAnswers <= 5) { this.correctAnswers++; }
    }

    //  Calculate score
    private int calcScore() {
        return (10*this.minuteTimer.getTime() + 50 * this.correctAnswers);
    }

    //  Check if game is finished and "clean up"
    public Boolean isFinished() {
        if (minuteTimer.getTime() == 0  || this.roundCounter == 5) {
            this.result = calcScore();
            return true;
        } else {
            return false;
        }
    }

}
