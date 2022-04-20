package colorgame;

//Imports
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ColorTileIterator implements Iterator<Colortile> {

    //Declerations
    private List<Colortile> tiles = new ArrayList<>();
    private int counter = -1;

    //Constructor
    public ColorTileIterator(List<Colortile> tiles) {
        this.tiles = tiles;
    }

    @Override
    public boolean hasNext() {
        return counter < tiles.size() -1;
    }

    @Override
    public Colortile next() {
        if (!this.hasNext()) {
            throw new IndexOutOfBoundsException("No more tiles");
        }
        counter++;
        return tiles.get(counter);
    }
}
