package colorgame;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class FileHandlerTest {

    //This class test relevant methods from both FileHandler and HighScoreHandler.

    //Declerations
    private static String path = "../colorgame/src/main/resources/colorgame/highscores.txt";

    //Test load-method
    @Test
    public void testLoad() {

        //Test for correct type
        assertEquals(new ArrayList<>().getClass(), FileHandler.load(FileHandlerTest.path).getClass());
        assertTrue(FileHandler.load(FileHandlerTest.path).size() <= 10);
    }

    //Test save-method
    @Test
    public void testSave() {

        //Setup
        List<String> highscores = FileHandler.load(FileHandlerTest.path);
        List<String> originalHighscores = FileHandler.load(FileHandlerTest.path);
        String newHighscore = (highscores.get(0).split("-")[0] + "1-TEST (this should be removed)");
        highscores.set(0, newHighscore);
        FileHandler.save(highscores, FileHandlerTest.path);

        //Implicit test the FileHandler.save function
        assertEquals(newHighscore, FileHandler.load(FileHandlerTest.path).get(0));

        //Clean up
        FileHandler.save(originalHighscores, FileHandlerTest.path);

    }

    //Check newScore validator-method
    @Test
    public void testNewScoreValidator() {
        String invalidInput = "Invalid-1";
        assertThrows(IllegalArgumentException.class, () -> HighscoreHandler.scoreStringValidator(invalidInput));
    }

}
