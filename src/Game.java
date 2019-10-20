import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.*;

public class Game extends Application {
    private static Parent root;
    public static Parent getRoot(){
        return root;
    }
    public static void setRoot(Parent toSetRoot){
        root=toSetRoot;
    }
    @Override
    public void start(Stage stage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("WelcomeScreen.fxml"));
        // Parent root=loader.load();
        Game.root=loader.load();
        stage.setTitle("Plants VS Zombies");
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(new Scene(Game.root, 640, 379));
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}