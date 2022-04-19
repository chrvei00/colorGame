package colorgame;

import java.util.List;

public class Colortile {

    private int[] color = new int[3];
    private boolean isCorrect;

    public Colortile(int r, int g, int b, Boolean isCorrect) {
        this.isCorrect = isCorrect;
        this.color[0] = r;
        this.color[1] = g;
        this.color[2] = b;
    }

    public int[] getColorArray() {
        return this.color;
    }
    public String getColorString() {
        return this.toString();
    }

    public Boolean isCorrect() {
        return this.isCorrect;
    }

    @Override
    public String toString() {
        return "[ R: " + this.color[0] + "  | G: " + this.color[1] + "  | B: " + this.color[2] + " || isCorrect: " + isCorrect + " ] ";
    }

}
