import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.effect.*;
import javafx.scene.control.*;
import javafx.stage.*;
import java.io.*;
import javafx.application.*;
import javafx.event.*;
import javafx.scene.image.ImageView;
import javafx.animation.*;

public class InGameMenuController {
    @FXML
    private void ResumeMouseClicked(MouseEvent e){
        levelScreenController.inGameMenu.close();
    }
    @FXML
    private void SaveMouseClicked(MouseEvent e){
        //serialization
        exitMouseClicked(e);
    }
    @FXML
    private void RestartMouseClicked(MouseEvent e){
        Game.U.setLevel(Game.U.getCurrentLevel());
        levelScreenController.inGameMenu.close();        
        FXMLLoader loader= new FXMLLoader(getClass().getResource("levelScreen.fxml"));
        Parent root=null;
        try{
            root=loader.load();
        }
        catch(IOException e1){
            e1.printStackTrace();
            System.exit(0);
        }
        Stage stage=new Stage();
        stage.setTitle("Plants VS Zombies");
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(new Scene(root, 1280, 720));
        Game.inNewWindow(root, stage);
        // Game.updateStage(root,1280,720);
    }
    @FXML
    private void exitMouseClicked(MouseEvent e){
        levelScreenController.inGameMenu.close();        
        FXMLLoader loader= new FXMLLoader(getClass().getResource("screen.fxml"));
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
}