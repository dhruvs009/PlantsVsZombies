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

public class LoginPageController{
    // private void adventure(ActionEvent event){
    //     FXMLLoader loader= new FXMLLoader(getClass().getResource("LoginScreen.fxml"));
    //     Parent root=null;
    //     try{
    //         root=loader.load();
    //     }
    //     catch(IOException e){
    //         e.printStackTrace();
    //         System.exit(0);
    //     }
    //     Game.updateStage(root,640,379);
    // }
    @FXML
    public static Stage userNameStage;
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
    private void newUserMouseClicked(MouseEvent e){
        userNameStage=new Stage();
        FXMLLoader loader= new FXMLLoader(getClass().getResource("Enterusername.fxml"));
        Parent root=null;
        try{
            root=loader.load();
        }
        catch(IOException e1){
            e1.printStackTrace();
            System.exit(0);
        }
        userNameStage.setScene(new Scene(root,300,200));
        userNameStage.initStyle(StageStyle.UNDECORATED);
        userNameStage.show();
    }
    @FXML
    private void existingUserMouseClicked(MouseEvent e){
        userNameStage=new Stage();
        FXMLLoader loader= new FXMLLoader(getClass().getResource("Enterusername.fxml"));
        Parent root=null;
        try{
            root=loader.load();
        }
        catch(IOException e1){
            e1.printStackTrace();
            System.exit(0);
        }
        userNameStage.setScene(new Scene(root,300,200));
        userNameStage.initStyle(StageStyle.UNDECORATED);
        userNameStage.show();
    }
    @FXML
    private void exitMouseClicked(MouseEvent e){
        System.exit(0);
    }
}