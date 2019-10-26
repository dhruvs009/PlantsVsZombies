import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.*;

public class Game extends Application {
    private static Parent root;
    private static Stage stage;
    public static Parent getRoot(){
        return root;
    }
    public static void setRoot(Parent toSetRoot){
        root=toSetRoot;
    }
    public static Stage getStage(){
        return stage;
    }
    public static void setStage(Stage toSetStage){
        stage=toSetStage;
    }
    public static void showStage(){
        stage.show();
    }
    public static void updateStage(Parent toSetRoot, int x, int y){
        root=toSetRoot;
        stage.setScene(new Scene(toSetRoot,x,y));
    }
    public static void hideWindow(){
        Game.root.getScene().getWindow().hide();
    }
    public static void inNewWindow(Parent toSetRoot, Stage toSetStage){
        Game.hideWindow();
        Game.setRoot(toSetRoot);
        Game.setStage(toSetStage);
        Game.showStage();
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
        Game.stage=stage;
    }
    public static void main(String[] args) {
        launch(args);
    }
}