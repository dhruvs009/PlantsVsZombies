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

public class CherryBlaster extends Bomber{
    private static Image appearance=new Image("./public/CherryBomb.gif");
    private Timeline blast;
    public CherryBlaster(){
        super(100,150,50,new ImageView(appearance));
        setSize(76.18*(1.5), 88*(1.5));
    }
    //public Plants plantThis();
    public static Image getImage(){
        return appearance;
    }
    public void initTimeline(Pane pane, double xcoord, double ycoord, Level toPlay, int i, int j, StackPane container){
        blast= new Timeline(
            new KeyFrame(
                Duration.millis(2500),
                new KeyValue(
                    getPlant().xProperty(),0)
            )
        );
        blast.setOnFinished((e)->{
            container.getChildren().remove(getPlant());
            toPlay.plantedObjects[i][j]=null;
            toPlay.planted[i][j]=null;
            for(int a=i-1; a<i+2; a++){
                if(a>=0 && a<5){
                    for(int b=0; b<toPlay.zombiesInRow.get(a).size(); b++){
                        int distX=Math.abs((int)toPlay.zombiesInRow.get(a).get(b).getTranslateX()-(int)xcoord-60);
                        if(distX<130){
                            try{
                                toPlay.zombieObjects.get(a).get(b).hit(this);
                            }
                            catch(ZombieDiedException exception){
                                Level.updateDeadZombie();
                                pane.getChildren().remove(toPlay.zombiesInRow.get(a).get(b));
                                toPlay.zombiesInRow.get(a).remove(b);
                                toPlay.zombieObjects.get(a).remove(b);
                            }
                        }
                    }
                }
            }
        });
    }
    public void playTimeline(Pane pane, double xcoord, double ycoord, Level toPlay, int i, int j, StackPane container){
        initTimeline(pane, xcoord, ycoord, toPlay, i, j, container);
        blast.playFromStart();
    }
    public void stopTimeline(){
        blast.stop();
    }
    @Override
    public int attack() {
        // TODO Auto-generated method stub
        return 0;
    }
}