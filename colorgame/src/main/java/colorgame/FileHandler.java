package colorgame;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileHandler implements IFileHandler{

    //Declearations:
    private String path;
    private File file;

    public FileHandler(String path) {
        //Set path
        this.path = path;
        //Declare path
        try {
            this.file = new File(this.path);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //Save
    @Override
    public void save(List<String> highScores) {

        //Write every hs as a line in txt document (file)
        try (PrintWriter writer = new PrintWriter(this.file);) {
            for (String string : highScores) {
                writer.println(string);
            }
            writer.flush();
        } catch (Exception e) {
            System.err.println(e);
        }

    }

    //Load
    @Override
    public List<String> load() {

        //Declare arraylist to be returned.
        List<String> highScores = new ArrayList<>();

        //Read every line of file and add it to arraylist, then return the list.
        try (Scanner scanner = new Scanner(this.file);) {
            while (scanner.hasNextLine()) {
                highScores.add(scanner.nextLine());
            }
        } catch (Exception e) {
            System.err.println(e);
        }

        return highScores;
        
    }

}
