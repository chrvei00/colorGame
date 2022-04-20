package colorgame;

import java.util.Comparator;

public class HighscoreComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        return (Integer.parseInt(o2.split("-")[0]) - Integer.parseInt(o1.split("-")[0]));
    }

}
