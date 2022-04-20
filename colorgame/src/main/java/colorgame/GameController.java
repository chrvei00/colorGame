package colorgame;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class GameController {

    //Declarations
    private Game game;
    
    //FXML Declerations
    @FXML
    private Button startButton;
    @FXML
    private Text scoreTxt;
    @FXML
    private Text roundTxt;
    @FXML
    private Text timeTxt;
    @FXML
    private Text colorTxt;
    @FXML
    private Text ptsTxt;
    @FXML
    private TextField nameTxtField;
    @FXML
    private Rectangle tile1;
    @FXML
    private Rectangle tile2;
    @FXML
    private Rectangle tile3;
    @FXML
    private Rectangle tile4;
    @FXML
    private Rectangle tile5;
    @FXML
    private TextArea highScoreTxt1;
    @FXML
    private TextArea highScoreTxt2;
    
    //Initialiser controller
    public void initialize() {
        this.updateScoreboard();
    }

    //Initialiser spill
    private void initGame() {
        game = new Game();
        this.enableTiles();
        this.updateTxt();
        this.updateTiles();
        this.updateScoreboard();
    }


    //Event-handlers

    //  Oppdaterer spill når klikk.
    void updateGame(int clickedTileIndex) {

        if (game.isFinished()) {
            this.gameFinished();
        } else {
            game.handler(clickedTileIndex);
            this.updateTxt();
            this.updateTiles();
        }
        
    }

    //  Handler for startknapp
    @FXML
    void startButtonClick() {

        startButton.setDisable(true);
        nameTxtField.setDisable(true);
        this.initGame();

    }
    
    //  Handler for klikk på tile 1
    @FXML
    void tile1Click() {
        this.updateGame(0);
    }
    //  Handler for klikk på tile 2
    @FXML
    void tile2Click() {
        this.updateGame(1);
    }    
    //  Handler for klikk på tile 3
    @FXML
    void tile3Click() {
        this.updateGame(2);
    }    
    //  Handler for klikk på tile 4
    @FXML
    void tile4Click() {
        this.updateGame(3);
    }    
    //  Handler for klikk på tile 5
    @FXML
    void tile5Click() {
        this.updateGame(4);
    }

    //Enabling tiles
    private void enableTiles() {
        tile1.setDisable(false);
        tile2.setDisable(false);
        tile3.setDisable(false);
        tile4.setDisable(false);
        tile5.setDisable(false);
    }

    //Oppdatering av txt-felt
    private void updateTxt() {
        timeTxt.setText(Integer.toString(game.getTime()));
        roundTxt.setText(Integer.toString(game.getRoundCounter()));
        colorTxt.setText(game.findCorrectTile().toString());
        ptsTxt.setText(game.getCorrectAnswers());
    }
    
    //Oppdater flisene
    private void updateTiles() {
        ColorTileIterator it1 = new ColorTileIterator(game.getTiles());
        Colortile tmpTile = it1.next();
        tile1.setFill(Color.rgb(tmpTile.getColorArray()[0], tmpTile.getColorArray()[1], tmpTile.getColorArray()[2]));
        tmpTile = it1.next();
        tile2.setFill(Color.rgb(tmpTile.getColorArray()[0], tmpTile.getColorArray()[1], tmpTile.getColorArray()[2]));
        tmpTile = it1.next();
        tile3.setFill(Color.rgb(tmpTile.getColorArray()[0], tmpTile.getColorArray()[1], tmpTile.getColorArray()[2]));
        tmpTile = it1.next();
        tile4.setFill(Color.rgb(tmpTile.getColorArray()[0], tmpTile.getColorArray()[1], tmpTile.getColorArray()[2]));
        tmpTile = it1.next();
        tile5.setFill(Color.rgb(tmpTile.getColorArray()[0], tmpTile.getColorArray()[1], tmpTile.getColorArray()[2]));

    }
    
    //Oppdater highScoreListen
    private void updateScoreboard() {

        int i = 0;
        StringBuilder hs1 = new StringBuilder();
        StringBuilder hs2 = new StringBuilder();

        //Create two hs.strings one for each textarea.
        for (String string : HighscoreHandler.getHighScores()) {
            if (i < 5) {
                hs1.append(string + "\n");
            } else {
                hs2.append(string + "\n");
            }
            i++;
        }

        highScoreTxt1.setText(hs1.toString());
        highScoreTxt2.setText(hs2.toString());

    }

    //Game is finished, clean up
    private void gameFinished() {
        
        //Set text
        scoreTxt.setText(Integer.toString(game.getResult()));
        timeTxt.setText(Integer.toString(game.getTime()));
        roundTxt.setText("Fin.");
        colorTxt.setText("Game is finished. Good job!");
        
        //Set fliser
        tile1.setFill(Color.RED);
        tile1.setDisable(true);
        tile2.setFill(Color.RED);
        tile2.setDisable(true);
        tile3.setFill(Color.RED);
        tile3.setDisable(true);
        tile4.setFill(Color.RED);
        tile4.setDisable(true);
        tile5.setFill(Color.RED);
        tile5.setDisable(true);
        
        //Save result if top10
        HighscoreHandler.newScore(scoreTxt.getText() + "-" + nameTxtField.getText());
        this.updateScoreboard();
        
        //Ready for next game
        startButton.setDisable(false);
        startButton.setText("Play again?");
        nameTxtField.setDisable(false);
    
    }

}