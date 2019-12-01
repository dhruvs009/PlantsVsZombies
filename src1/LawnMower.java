import java.net.URL;
import java.util.*;
import java.util.ResourceBundle;
import java.util.logging.Logger;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.effect.*;
import javafx.stage.*;
import javafx.util.Duration;
import java.io.*;
import javafx.scene.control.Label;
import javafx.application.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.*;
import javafx.scene.image.ImageView;
import javafx.animation.*;
import javafx.scene.image.Image;
import javafx.scene.shape.*;
import javafx.animation.Transition.*;

public class LawnMower{
    private int attackVal;
    private int rowPos;
    private static Image lawnMowerImage;
    private ImageView lawnMowerView;
    private Timeline killAll;
    public LawnMower(){
        if(lawnMowerImage==null){
            lawnMowerImage=new Image("./public/Lawnmower.png");
        }
        this.attackVal=rowPos*10000;
        lawnMowerView=new ImageView(lawnMowerImage);
        lawnMowerView.setFitWidth(76.18);
        lawnMowerView.setFitHeight(88);
    }
    public void playTimeline(){
        killAll=new Timeline(
            new KeyFrame(
                Duration.millis(2000),
                new KeyValue(
                    lawnMowerView.translateXProperty(),2000
                )
            )
        );
        killAll.playFromStart();
    }
    public void attack(Pane pane, double xcoord, double ycoord, Level toPlay, int i, int j){
        int b=toPlay.zombiesInRow.get(i).size();
        for(int a=0; a<b; a++){
            try{
                toPlay.zombieObjects.get(i).get(a).hit(this);
            }
            catch(ZombieDiedException exception){
                Level.updateDeadZombie();
                pane.getChildren().remove(toPlay.zombiesInRow.get(i).get(a));
                toPlay.zombieObjects.get(i).get(a).stopTransition();
                // toPlay.zombiesInRow.get(i).remove(a);
                // toPlay.zombieObjects.get(i).remove(a);
            }
        }
        toPlay.zombiesInRow.get(i).clear();
        toPlay.zombieObjects.get(i).clear();
    }
    public ImageView getLawnMower(){
        return lawnMowerView;
    }
}