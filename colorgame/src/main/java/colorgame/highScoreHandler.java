package colorgame;

import java.util.ArrayList;
import java.util.List;

public final class HighscoreHandler {

    //private constructor
    private HighscoreHandler() {}

    //Declerations
    private static List<String> highScores = FileHandler.load();
    private static List<String> tmpScores;

    //Handle new scores
    public static void newScore(String newScore) {

        try {

            //Validate new score
            HighscoreHandler.scoreStringValidator(newScore);
    
            //Check if HSlist changed, and update file accordingly.
            if (HighscoreHandler.checkIfScoreIsTop10(newScore)) {
                highScores = tmpScores;
                FileHandler.save(highScores);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        
    }

    //Getters
    public static List<String> getHighScores() {
        return highScores;
    }

    //Validators:

    //  Validate if score is top10
    private static Boolean checkIfScoreIsTop10(String newScore) {
        
        //Add and sort the new highscorelist
        tmpScores = new ArrayList<>();
        tmpScores.addAll(highScores);
        tmpScores.add(newScore);
        tmpScores.sort(new HighscoreComparator());

        //Check if score is top 10, or there are less than 10 highscores
        if (tmpScores.size() >= 11) {
            tmpScores.remove(10);
        } else {
            return true;
        }
        
        //If the score didnt change the list, return false : true.
        return (!tmpScores.equals(highScores));
    }

    //  Validate input-score-format
    public static void scoreStringValidator(String elem) throws NumberFormatException {
        Integer.parseInt(elem.split("-")[0]);
    }

}
