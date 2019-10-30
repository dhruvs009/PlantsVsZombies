import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import java.io.*;
import javafx.application.*;

public class WelcomeScreenController implements Initializable {
    @FXML
    private static StackPane rootWelcomeScreenPane;
    @Override
    public void initialize(URL url, ResourceBundle rb){
        new SleeperThread().start();
    }
    public class SleeperThread extends Thread{
        @Override
        public void run(){
            try{
                Thread.sleep(5000);
                Platform.runLater(new Runnable(){
                    @Override
                    public void run() {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("Screen1Alt.fxml"));
                        Parent root=null;
                        try{
                            root=loader.load();
                        }
                        catch(IOException e){
                            e.printStackTrace();
                            System.exit(0);
                        }
                        Stage stage= new Stage();
                        stage.setTitle("Plants VS Zombies");
                        stage.setScene(new Scene(root, 640, 379));
                        Game.inNewWindow(root, stage);
                    }
                });
            }
            catch(InterruptedException e2){
                System.exit(0);
            }
        }
    }
}
