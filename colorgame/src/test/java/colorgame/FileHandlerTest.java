package colorgame;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class FileHandlerTest {

    //Test load-method
    @Test
    public void testLoad() {

        //Test for correct type
        assertEquals(new ArrayList<>().getClass(), FileHandler.load().getClass());
        assertTrue(FileHandler.load().size() <= 10);
    }

}
