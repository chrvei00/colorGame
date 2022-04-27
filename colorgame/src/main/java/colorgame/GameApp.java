package colorgame;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GameApp extends Application{

    private static GameController controller;

    
    @Override
    public void start(Stage stage) throws IOException {
        //Stage setup
        stage.setTitle("Veiby's colorGame");
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("Game.fxml"));
        Parent root = (Parent) loader.load();
        controller = loader.getController();
        stage.setScene(new Scene(root));
        //Open stage
        stage.show();        
    }

    public static GameController getController() {
        return GameApp.controller;
    }
    
    public static void main(String[] args) {
        GameApp.launch(args);
    }

}