package colorgame;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameTest {

    //Declerations
    private Game game;
    
    //Setup
    @BeforeEach
    public void setup() {
        //Init new instance of game.
        game = new Game();
    }

    //Tests

    //  Check the init of new game instance.
    @Test
    public void testInit() {

        //Round should be 1 and time should be 60s - 1s.
        assertEquals(1, game.getRoundCounter());
        assertEquals(60-1, game.getTime());
    }

    //  Check handler-method
    @Test
    public void testHandler() {
        
        //Check if handler validates input correctly.
        assertThrows(IllegalArgumentException.class, () -> game.handler(-1), "Expected Ill.Arg.E. when provided negative int");
        assertThrows(IllegalArgumentException.class, () -> game.handler(5), "Expected Ill.Arg.E when provided int > 4");

        //Check if correctanswers update correctly. This also tests new round.
        for (int k = 0; k < 2; k++) {
            for (int i = 0; i < game.getTiles().size(); i++) {
                if(game.getTiles().get(i).equals(game.findCorrectTile())) {
                    game.handler(i);
                    break;
                }
            }
        }
        assertEquals(2, Integer.parseInt(game.getCorrectAnswers()), "Expected one correct answer.");
    }

    //  Check generateTiles-method
    @Test
    public void testGenerateTiles() {
        
        //Check if generateNewTiles() works
        List<Colortile> originalTiles = game.getTiles();
        //  Trigger handler -> triggers newRound() -> triggers generateNewTiles();
        game.handler(0);
        //  Assert that the tiles have changed
        assertTrue(originalTiles != game.getTiles(), "New tiles match the old tiles.");

    }

    //  Check isFinished-method
    @Test
    public void testIsFinished() {
        
        //Set roundcounter = 5 --> means game is finished.
        assertTrue(!game.isFinished());
        while (game.getRoundCounter() < 5) {
            //Check if game thinks it is finished before round = 5
            assertTrue(!game.isFinished());
            System.out.println(game.getRoundCounter());
            game.handler(0);
        }
        //Check that isFinished returns true after 5 rounds
        assertTrue(game.isFinished());


    }

}
