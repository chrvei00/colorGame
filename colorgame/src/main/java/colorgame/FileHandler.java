package colorgame;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileHandler {

    private static final File file = new File("./colorgame/src/main/resources/colorgame/highscores.txt");

    private FileHandler() {
    }
    
    public static void save(List<String> highScores) {
        try {
            PrintWriter writer = new PrintWriter(file);
            for (String string : highScores) {
                System.out.println(string);
                writer.println(string);
            }
            writer.flush();
            writer.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static List<String> load() {
        
        try {
            Scanner scanner = new Scanner(file);
            List<String> highScores = new ArrayList<>();

            while (scanner.hasNextLine()) {
                highScores.add(scanner.nextLine());
            }
            scanner.close();
            return highScores;
        } catch (Exception e) {
            System.err.println(e);
        }

        return new ArrayList<>();
    }

    public static void main(String[] args) {
        String k = "";
        for (String string : FileHandler.load()) {
            k = k + string + "\n";
        }
        System.out.println(k);
    }

}
