package colorgame;

import java.io.FileNotFoundException;

public interface IFileHandler {
    
    public void save(String[] strings) throws FileNotFoundException;

    public String[] load() throws FileNotFoundException;

}
