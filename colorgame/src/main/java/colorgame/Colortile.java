package colorgame;

public class Colortile implements ITile {

    //Declerations:
    private final int[] color = new int[3];
    private final boolean isCorrect;

    //Constructor:
    public Colortile(int r, int g, int b, boolean isCorrect) {
        
        this.isCorrect = isCorrect;
        
        //Validate and set.
        if (Colortile.checkRGBValue(r) && Colortile.checkRGBValue(g) && Colortile.checkRGBValue(b)) {
            this.color[0] = r;
            this.color[1] = g;
            this.color[2] = b;
        } else {
            throw new IllegalArgumentException("Color not proper format.");
        }

    }

    //Getters:
    public int[] getColorArray() {
        return this.color;
    }
    public String getColorString() {
        return this.toString();
    }
    public boolean isCorrect() {
        return this.isCorrect;
    }

    //Validators:
    private static boolean checkRGBValue(int value) {
        return (value <= 255 && value >= 0);
    }

    //toString
    @Override
    public String toString() {
        return "[ R: " + this.color[0] + "  | G: " + this.color[1] + "  | B: " + this.color[2] + " ] ";
    }

}
