package colorgame;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class ColortileTest {
    

    //Declerations
    private Colortile tile;
    private static int r = 50;
    private static int g = 100;
    private static int b = 150;
    private static int[] testColorArray = new int[3];
    private static Boolean isCorrect = false;


    //Sjekk om man kan opprette en tile
    @Test
    public void testValid() {

        //Setup
        tile = new Colortile(r, g, b, isCorrect);
        int[] colorArray = tile.getColorArray();
        testColorArray[0] = r; testColorArray[1] = g; testColorArray[2] = b;

        //Tests
        assertArrayEquals(testColorArray, colorArray);
        assertEquals(isCorrect, tile.isCorrect());

    }

    //Sjekk at man ikke kan ha verdier over 255 eller under 0.
    @Test
    public void testInvalid() {
        
        //Tests
        assertThrows(IllegalArgumentException.class, () -> new Colortile(ColortileTest.r, ColortileTest.g, ColortileTest.b + 255, isCorrect) , "IllegalArgExp forventes.");
        assertThrows(IllegalArgumentException.class, () -> new Colortile(ColortileTest.r, ColortileTest.g, ColortileTest.b - 255, isCorrect) , "IllegalArgExp forventes.");
    
    }

}
