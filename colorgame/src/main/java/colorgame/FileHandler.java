package colorgame;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileHandler {

    //Declearations:
    private static String path = ("./colorgame/src/main/resources/colorgame/highscores.txt");
    private static File file;

    private FileHandler() {}

    //Save with no specified path
    public static void save(List<String> highScores) {
       FileHandler.save(highScores, FileHandler.path);
    }
    
    //Save with specified path
    public static void save(List<String> highScores, String path) {

        //Declare file
        try {
            file = new File(path);
        } catch (Exception e) {
            System.out.println(e);
        }

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

    //Load with no specified path
    public static List<String> load() {
        return load(FileHandler.path);
    }

    //Load with specified path
    public static List<String> load(String path) {

        //Declare file
        try {
            file = new File(path);
        } catch (Exception e) {
            System.out.println(e);
        }

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
