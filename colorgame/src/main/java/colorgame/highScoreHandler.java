package colorgame;

import java.util.ArrayList;
import java.util.List;

public class HighscoreHandler {

    //Declerations
    private FileHandler fileHandler;
    private List<String> tmpScores;
    private List<String> highScores;
    
    //private constructor
    public HighscoreHandler() {
        this.fileHandler = new FileHandler("./colorgame/src/main/resources/colorgame/highscores.txt");
        this.highScores = fileHandler.load();
    }


    //Handle new scores
    public void newScore(String newScore) {

        try {

            //Validate new score
            HighscoreHandler.scoreStringValidator(newScore);
    
            //Check if HSlist changed, and update file accordingly.
            if (this.checkIfScoreIsTop10(newScore)) {
                this.highScores = this.tmpScores;
                this.fileHandler.save(this.highScores);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        
    }

    //Getters
    public List<String> getHighScores() {
        return this.highScores;
    }

    //Validators:

    //  Validate if score is top10
    private boolean checkIfScoreIsTop10(String newScore) {

        try {
            //Validate input
            HighscoreHandler.scoreStringValidator(newScore);
        } catch (Exception e) {
            throw new IllegalArgumentException("Input is invalid format.");
        }
        
        //Add and sort the new highscorelist
        this.tmpScores = new ArrayList<>();
        this.tmpScores.addAll(this.getHighScores());
        this.tmpScores.add(newScore);
        this.tmpScores.sort(new HighscoreComparator());

        //Check if score is top 10, or there are less than 10 highscores
        if (this.tmpScores.size() >= 11) {
            this.tmpScores.remove(10);
        } else {
            return true;
        }
        
        //If the score didnt change the list, return false : true.
        return (!this.tmpScores.equals(this.highScores));
    }

    //  Validate input-score-format
    public static void scoreStringValidator(String elem) throws NumberFormatException {
        Integer.parseInt(elem.split("-")[0]);
    }

}
