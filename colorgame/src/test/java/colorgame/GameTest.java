package colorgame;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
        
    }


}
