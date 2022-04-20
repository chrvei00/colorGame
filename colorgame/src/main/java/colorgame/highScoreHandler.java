package colorgame;

import java.util.ArrayList;
import java.util.List;

public class highScoreHandler {
    
    private static List<String> highScores = FileHandler.load();
    private static List<String> tmpScores;

    public static void newScore(String newScore) {
        if (Boolean.TRUE.equals(highScoreHandler.checkIfScoreIsTop10(newScore))) {
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
        tmpScores.sort(new highscoreComparator());

        if (tmpScores.size() >= 11) {
            tmpScores.remove(10);
        } else {
            return true;
        }
        

        if (tmpScores.equals(highScores)) {
            return false;
        } else {
            return true;
        }

    }

    public static void main(String[] args) {
        List<String> l1 = new ArrayList<>();
        List<String> l2 = new ArrayList<>();
        l1.add("13-nummerTO");
        l1.add("12-nummerEN");
        l1.add("14-nummerTre");
        l2.add("13-nummerTO");
        l2.add("12-nummerENAnnerledes");
        l2.add("14-nummerTre");
        System.out.println(l1);
        l1.sort(new highscoreComparator());
        System.out.println(l1);
        System.out.println(l1.equals(l2));
    }

}
