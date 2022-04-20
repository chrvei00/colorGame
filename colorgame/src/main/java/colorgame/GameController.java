package colorgame;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class GameController {

    //Declarations
    private static Game game;
    
    //Connect til fx:id - navn burde være forklarende
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
    private Rectangle tile1;
    @FXML
    private Rectangle tile2;
    @FXML
    private Rectangle tile3;
    @FXML
    private Rectangle tile4;
    @FXML
    private Rectangle tile5;
    
    //Initialiser spill
    public static void initialize() {

        game = new Game();

    }

    //Event-handlers

    //  Oppdaterer spill ved event
    @FXML
    void updateGame() {
        this.updateTxt();
        this.updateTiles();
    }

    //  Handler for startknapp
    @FXML
    void startButtonClick() {
        startButton.setDisable(true);
        GameController.initialize();
    }
    
    //  Handler for klikk på tile 1
    @FXML
    void tile1Click() {
        this.updateGame();
    }
    //  Handler for klikk på tile 2
    @FXML
    void tile2Click() {
        this.updateGame();
    }    
    //  Handler for klikk på tile 3
    @FXML
    void tile3Click() {
        this.updateGame();
    }    
    //  Handler for klikk på tile 4
    @FXML
    void tile4Click() {
        this.updateGame();
    }    
    //  Handler for klikk på tile 5
    @FXML
    void tile5Click() {
        this.updateGame();
    }

    //Oppdatering av txt-felt
    public void updateTxt() {
        scoreTxt.setText(Integer.toString(game.getResult()));
        timeTxt.setText(Integer.toString(game.getTime()));
        roundTxt.setText(Integer.toString(game.getRoundCounter()));
        colorTxt.setText(game.findCorrectTile().toString());
    }
    //Oppdatering av timer
    public static void updateTimer() {
    }
    //Oppdater flisene
    public void updateTiles() {
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

}
