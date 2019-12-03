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

public class ChooseLevelController implements Initializable{
    int levelsUnlocked;
    @FXML
    ImageView levelblock2,levelblock3,levelblock4,levelblock5,levelimage2,levelimage3,levelimage4,levelimage5;
    ColorAdjust colorAdjustBlock,colorAdjustImage;
    @Override
    public void initialize(URL url, ResourceBundle rb){
        levelsUnlocked=Game.U.getLevelUnlocked();
        colorAdjustBlock=new ColorAdjust();
        colorAdjustImage=new ColorAdjust();
        colorAdjustBlock.setBrightness(-0.66);
        colorAdjustImage.setBrightness(-0.8);
        if(levelsUnlocked>=2){
            levelblock2.setEffect(null);
            levelimage2.setEffect(null);
        }
        if(levelsUnlocked>=3){
            levelblock3.setEffect(null);
            levelimage3.setEffect(null);
        }
        if(levelsUnlocked>=4){
            levelblock4.setEffect(null);
            levelimage4.setEffect(null);
        }
        if(levelsUnlocked>=5){
            levelblock5.setEffect(null);
            levelimage5.setEffect(null);
        }
        if(levelsUnlocked<2){
            levelblock2.setEffect(colorAdjustBlock);
            levelimage2.setEffect(colorAdjustImage);
        }
        if(levelsUnlocked<3){
            levelblock3.setEffect(colorAdjustBlock);
            levelimage3.setEffect(colorAdjustImage);
        }
        if(levelsUnlocked<4){
            levelblock4.setEffect(colorAdjustBlock);
            levelimage4.setEffect(colorAdjustImage);
        }
        if(levelsUnlocked<5){
            levelblock5.setEffect(colorAdjustBlock);
            levelimage5.setEffect(colorAdjustImage);
        }
    }
    // ChooseLevelController(){
    //     levelsUnlocked=Game.getLevelUnlocked();
    //     colorAdjust.setBrightness(-0.66);
    //     colorAdjust.setBrightness(-0.8);
    //     if(levelsUnlocked>=2){
    //         levelblock2.setEffect(null);
    //         levelimage2.setEffect(null);
    //     }
    //     if(levelsUnlocked>=3){
    //         levelblock3.setEffect(null);
    //         levelimage3.setEffect(null);
    //     }
    //     if(levelsUnlocked>=4){
    //         levelblock4.setEffect(null);
    //         levelimage4.setEffect(null);
    //     }
    //     if(levelsUnlocked>=5){
    //         levelblock5.setEffect(null);
    //         levelimage5.setEffect(null);
    //     }
    //     if(levelsUnlocked<2){
    //         levelblock2.setEffect(colorAdjustBlock);
    //         levelimage2.setEffect(colorAdjustImage);
    //     }
    //     if(levelsUnlocked<3){
    //         levelblock3.setEffect(colorAdjustBlock);
    //         levelimage3.setEffect(colorAdjustImage);
    //     }
    //     if(levelsUnlocked<4){
    //         levelblock4.setEffect(colorAdjustBlock);
    //         levelimage4.setEffect(colorAdjustImage);
    //     }
    //     if(levelsUnlocked<5){
    //         levelblock5.setEffect(colorAdjustBlock);
    //         levelimage5.setEffect(colorAdjustImage);
    //     }
    // }
    public void PlayLevel(){
        FXMLLoader loader= new FXMLLoader(getClass().getResource("levelScreen.fxml"));
        Parent root=null;
        try{
            root=loader.load();
        }
        catch(IOException e){
            e.printStackTrace();
            System.exit(0);
        }
        Game.updateStage(root,1280,720);
    }
    @FXML
    private void BackMouseClicked(MouseEvent e){
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
    private void OnMouseEntered(MouseEvent e){
        ImageView button= (ImageView) e.getSource();
        button.setEffect(new Glow(0.3));
    }
    @FXML
    private void OnMouseExited(MouseEvent e){
        ImageView button= (ImageView) e.getSource();
        button.setEffect(null);
    }
    @FXML
    private void OnMouseClick1(MouseEvent e){
        Game.U.setLevel(1);
        PlayLevel();
    }
    @FXML
    private void OnMouseClick2(MouseEvent e){
        if(levelsUnlocked>=2){
            Game.U.setLevel(2);
            PlayLevel();
        }
    }
    @FXML
    private void OnMouseClick3(MouseEvent e){
        if(levelsUnlocked>=3){
            Game.U.setLevel(3);
            PlayLevel();
        }
    }
    @FXML
    private void OnMouseClick4(MouseEvent e){
        if(levelsUnlocked>=4){
            Game.U.setLevel(4);
            PlayLevel();
        }
    }
    @FXML
    private void OnMouseClick5(MouseEvent e){
        if(levelsUnlocked>=5){
            Game.U.setLevel(5);
            PlayLevel();
        }
    }
}