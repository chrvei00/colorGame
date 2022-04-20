package colorgame;

import java.util.ArrayList;
import java.util.List;

public class HighscoreHandler {
    
    private static List<String> highScores = FileHandler.load();
    private static List<String> tmpScores;

    public static void newScore(String newScore) {
        if (Boolean.TRUE.equals(HighscoreHandler.checkIfScoreIsTop10(newScore))) {
            highScores = tmpScores;
            FileHandler.save(highScores);
        }
    }

    public static List<String> getHighScores() {
        return highScores;
    }

    private static Boolean checkIfScoreIsTop10(String newScore) {
        tmpScores = new ArrayList<>();
        tmpScores.addAll(highScores);
        tmpScores.add(newScore);
        tmpScores.sort(new HighscoreComparator());

        if (tmpScores.size() >= 11) {
            tmpScores.remove(10);
        } else {
            return true;
        }
        
        return (!tmpScores.equals(highScores));
    }

}
