package colorgame;

import java.util.List;

public interface IFileHandler {
    
    public void save(List<String> input);

    public List<String> load();

}
