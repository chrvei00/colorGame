package colorgame;

import java.util.Comparator;

public class HighscoreComparator implements Comparator<String> {

    //Comparator:
    @Override
    public int compare(String o1, String o2) {
        
        try {

            //Validate
            HighscoreHandler.scoreStringValidator(o1);
            HighscoreHandler.scoreStringValidator(o2);

            //Return the compared result
            return (Integer.parseInt(o2.split("-")[0]) - Integer.parseInt(o1.split("-")[0]));

        } catch( Exception e) {

            System.out.println(e);
            return 0;
        
        }
    }

}
