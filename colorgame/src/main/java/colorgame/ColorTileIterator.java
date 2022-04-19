package colorgame;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ColorTileIterator implements Iterator<Colortile> {

    private List<Colortile> tiles = new ArrayList<>();
    private int counter;

    public ColorTileIterator(List<Colortile> tiles) {
        this.tiles = tiles;
    }

    @Override
    public boolean hasNext() {
        return counter < tiles.size();
    }

    @Override
    public Colortile next() {
        if (!this.hasNext()) {
            throw new Error("No more tiles");
        }
        counter++;
        return tiles.get(counter);
    }
    
}
