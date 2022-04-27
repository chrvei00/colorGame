package colorgame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {

    //Declerations
    private static Random rand = new Random();
    private List<Colortile> tiles = new ArrayList<>();
    private int result = 0;
    private GameTimer timer;
    private int roundCounter;
    private int correctAnswers;

    //Init
    public Game() {
        this.newRound();
        timer = new GameTimer(60);
    }

    
    //Getters:
    public List<Colortile> getTiles() {
        return this.tiles;
    }
    public int getRoundCounter() {
        return this.roundCounter;
    }
    public String getCorrectAnswers() {
        return Integer.toString(correctAnswers);
    }
    public int getResult() {
        return this.result;
    }
    public int getTime() {
        return this.timer.getTime();
    }


    //Gamerunninng-methods

    //  onClickHandler - main event handler
    public void handler(int clickedTileIndex) {

        //Validate input
        if (!(clickedTileIndex <= 4 && clickedTileIndex >= 0)) {
            throw new IllegalArgumentException("Tile do not exist");
        }

        //Check if tileClicked is correct and send the result to updateScore method.
        this.updateScore(tiles.get(clickedTileIndex).toString().equals(this.findCorrectTile().toString()));

        //If the game is not finished --> new round
        if (!this.isFinished()) {            
            this.newRound();
        }
    
    }

    //  Create next round
    private void newRound() {
        this.tiles = Game.generateTiles();
        this.roundCounter++;
    }

    //  Generate new tiles
    private static List<Colortile> generateTiles() {

        List<Colortile> tmpTiles = new ArrayList<>();
        int k = rand.nextInt(5);
        boolean isCorrect;

        //Generate 5 new tiles and set one of them to correct.
        for (int i = 0; i < 5; i++) {
            isCorrect = (i == k);
            Colortile tmp = new Colortile(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255), isCorrect);
            tmpTiles.add(tmp);
        }

        return tmpTiles;

    }

    //  Find correct tile
    public Colortile findCorrectTile() {

        //Iterate over tiles and return the tile marked correct.
        Colortile tile;
        ColorTileIterator it1 = new ColorTileIterator(tiles);
            while (it1.hasNext()) {
                tile = it1.next();
                if (tile.isCorrect()) {
                    return tile;
                }
            }
        
        //If no correct tile is found, throw exeption.
        throw new IllegalArgumentException("Cannot find the correct tile");

    }

    //  Update score
    public void updateScore(boolean answer) {
        //Increase score if answer is correct. And validate not more than max 5 correct answers.
        if( answer && this.correctAnswers <= 5) { this.correctAnswers++; }
    }

    //  Calculate score
    private int calcScore() {
        //return calulated result.
        return ( 5 * this.timer.getTime() + 50 * this.correctAnswers);
    }

    //  Check if game is finished
    public boolean isFinished() {
        
        if (timer.getTime() == 0  || this.roundCounter == 5) {
            this.result = calcScore();
            timer.stop();
            return true;
        } else {
            return false;
        }

    }

}
