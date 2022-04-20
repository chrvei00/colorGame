package colorgame;

//Imports
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GameApp extends Application{

    
    @Override
    public void start(Stage stage) throws IOException {
        //Stage setup
        stage.setTitle("Veiby's colorGame");
        Parent root = FXMLLoader.load(getClass().getResource("Game.fxml"));
        stage.setScene(new Scene(root));
        //Open stage
        stage.show();        
    }
    
    public static void main(String[] args) {
        Application.launch(args);
    }

}
