import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.effect.*;
import javafx.stage.*;
import java.io.*;
import javafx.application.*;
import javafx.event.*;
import javafx.scene.image.ImageView;
import javafx.animation.*;

public class EntryScreenController {
    // @FXML
    private void adventure(ActionEvent event){
        FXMLLoader loader= new FXMLLoader(getClass().getResource("screen.fxml"));
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
    private void mouseEntered(MouseEvent e){
        ImageView button= (ImageView) e.getSource();
        button.setEffect(new Glow(0.3));
    }
    @FXML
    private void mouseExited(MouseEvent e){
        ImageView button= (ImageView) e.getSource();
        button.setEffect(null);
    }
    @FXML
    private void exitMouseClicked(MouseEvent e){
        //ImageView button = (ImageView) e.getSource();
        System.exit(0);
    }
    @FXML
    private void playMouseClicked(MouseEvent e){
        FXMLLoader loader= new FXMLLoader(getClass().getResource("chooseLevel.fxml"));
        Parent root=null;
        try{
            root=loader.load();
        }
        catch(IOException e1){
            e1.printStackTrace();
            System.exit(0);
        }
        Game.updateStage(root,1280,720);
    }
    // @FXML
    // private void quit(ActionEvent event){
    //     System.exit(0);
    // }
    // private void handle(MouseEvent event){

    // }
}