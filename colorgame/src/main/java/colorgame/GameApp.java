package colorgame;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GameApp extends Application{

    
    @Override
    public void start(Stage stage) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("Game.fxml"));
        
        stage.setTitle("Veiby's colorGame");
        stage.setScene(new Scene(root));
        stage.show();        
    }
    
    public static void main(String[] args) {
        Application.launch(args);
    }

}
