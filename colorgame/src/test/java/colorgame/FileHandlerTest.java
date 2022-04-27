package colorgame;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FileHandlerTest {

    //This class test relevant methods from both FileHandler and HighScoreHandler.

    //Declerations
    private FileHandler fH;

    @BeforeEach
    public void setup() {
        fH = new FileHandler("../colorgame/src/main/resources/colorgame/highscores.txt");
    }

    //Test load-method
    @Test
    public void testLoad() {

        //Test for correct type
        assertEquals(new ArrayList<>().getClass(), this.fH.load().getClass());
        assertTrue(this.fH.load().size() <= 10);
    }

    //Test save-method
    @Test
    public void testSave() {

        //Setup
        List<String> highscores = this.fH.load();
        List<String> originalHighscores = this.fH.load();
        String newHighscore = (highscores.get(0).split("-")[0] + "1-TEST (this should be removed)");
        highscores.set(0, newHighscore);
        this.fH.save(highscores);

        //Implicit test the FileHandler.save function
        assertEquals(newHighscore, this.fH.load().get(0));

        //Clean up
        this.fH.save(originalHighscores);

    }

    //Check newScore validator-method
    @Test
    public void testNewScoreValidator() {
        String invalidInput = "Invalid-1";
        assertThrows(IllegalArgumentException.class, () -> HighscoreHandler.scoreStringValidator(invalidInput));
    }

}
