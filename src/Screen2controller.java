import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.*;
import java.io.*;
import javafx.application.*;
import javafx.event.*;

public class Screen2controller {
    @FXML
    private void storyMode(MouseEvent event){
        FXMLLoader loader= new FXMLLoader(getClass().getResource("Screen3.fxml"));
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
    private void arcadeMode(MouseEvent event){
        System.exit(0);
    }
    @FXML
    private void goBack(MouseEvent event){
        FXMLLoader loader= new FXMLLoader(getClass().getResource("Screen1.fxml"));
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
}