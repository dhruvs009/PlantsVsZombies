import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.*;
import javafx.animation.*;
import javafx.util.Duration;

public class Game extends Application {
    // static GameBase G;
    public static User U;
    private static Parent root;
    public static Stage stage;
    public static Parent getRoot(){
        return root;
    }
    static void createUser(User u1){
        U=u1;
        // System.out.println(U.getUsername());
    }
    // static void setUsername(String username){
    //     G=new GameBase(username);
    // }
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
        FadeTransition ft1 = new FadeTransition(Duration.millis(1500), toSetRoot);
        FadeTransition ft2 = new FadeTransition(Duration.millis(1500), toSetRoot);
        ft1.setFromValue(1.0);
        ft1.setToValue(0.0);
        ft1.play();
        stage.setScene(new Scene(toSetRoot,x,y));
        ft2.setFromValue(0.0);
        ft2.setToValue(1.0);
        ft2.play();
        // ft1.setOnFinished((e)->{
        //     ft2.play();
        // });
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
        FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginScreen.fxml"));
        // Parent root=loader.load();
        Game.root=loader.load();
        stage.setTitle("Plants VS Zombies");
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(new Scene(Game.root, 1280, 720));
        stage.show();
        Game.stage=stage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}