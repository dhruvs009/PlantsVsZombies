import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import java.io.*;
import javafx.application.*;
import javafx.event.*;

public class PlayGamePageController {
    @FXML
    private static Pane rootPlayGamePagePane;
    @FXML
    private static StackPane topPane;
    @FXML
    private static StackPane bottomPane;
    @FXML
    private void handleBackButton(ActionEvent event){
        FXMLLoader loader= new FXMLLoader(getClass().getResource("StartPage.fxml"));
        Parent root=null;
        try{
            root=loader.load();
        }
        catch(IOException e){
            e.printStackTrace();
            System.exit(0);
        }
        Game.updateStage(root,640,379);
    }
    @FXML
    private void handleChooseLevelButton(ActionEvent event){
        System.exit(0);
    }
}