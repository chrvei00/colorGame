package colorgame;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class FileHandler {

    //Declearations:
    private static final String relativeFilePath = ("./colorgame/src/main/resources/colorgame/highscores.txt");
    private static final File file = new File(relativeFilePath);

    private FileHandler() {}
    
    public static void save(List<String> highScores) {

        //Write every hs as a line in txt document (file)
        try (PrintWriter writer = new PrintWriter(file);) {
            for (String string : highScores) {
                writer.println(string);
            }
            writer.flush();
        } catch (Exception e) {
            System.err.println(e);
        }

    }

    public static List<String> load() {
        
        //Declare arraylist to be returned.
        List<String> highScores = new ArrayList<>();

        //Read every line of file and add it to arraylist, then return the list.
        try (Scanner scanner = new Scanner(file);) {
            while (scanner.hasNextLine()) {
                highScores.add(scanner.nextLine());
            }
        } catch (Exception e) {
            System.err.println(e);
        }

        return highScores;
        
    }

}
