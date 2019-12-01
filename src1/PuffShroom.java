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

public class PuffShroom extends Shooter{
    private static Image appearance=new Image("./public/PuffShroom.gif");
    private ShroomPea shootThis;
    private Timeline shootTimeline;
    public PuffShroom(){
        super(75,0,7,new ImageView(appearance));
        shootThis=new ShroomPea();
    }
    public static Image getImage(){
        return appearance;
    }
    public ImageView getPea(){
        return shootThis.getPea();
    }
    public void initTimeline(Pane pane, double xcoord, double ycoord, Level toPlay, int i, int j){
        int[] tempTranslator={0,0,0,0,0};
        shootTimeline=new Timeline(
            new KeyFrame(
                Duration.millis(1500),
                (ev)->{
                    shootThis=new ShroomPea();
                    shootThis.getPea().setLayoutX(xcoord+60);
                    shootThis.getPea().setLayoutY(ycoord+50);
                    ImageView toUse=getPea();
                    try{
                        int distX=(int)toPlay.zombiesInRow.get(i).get(tempTranslator[i]).getTranslateX();
                        if(distX-(int)xcoord-60>0){
                            pane.getChildren().addAll(toUse);
                            // System.out.println(distX-(int)xcoord-60);
                            Timeline shootTimelineTemp= shootThis.getShootTimeline(pane,shootThis, distX-(int)xcoord-60);
                            shootTimelineTemp.playFromStart();
                            shootTimelineTemp.setOnFinished((e)->{
                                for(int k=0; k<pane.getChildren().size(); k++){
                                    try{
                                        ImageView temp=(ImageView)pane.getChildren().get(k);
                                        if(temp.getImage()==ShroomPea.getImage()){
                                            pane.getChildren().remove(temp);
                                            break;
                                        }
                                    }
                                    catch(ClassCastException exception){}
                                }
                                try{
                                    toPlay.zombieObjects.get(i).get(tempTranslator[i]).hit(shootThis);
                                }
                                catch(ZombieDiedException zombieException){
                                    Level.updateDeadZombie();
                                    pane.getChildren().remove(toPlay.zombieObjects.get(i).get(tempTranslator[i]).getZombie());
                                    toPlay.zombieObjects.get(i).get(tempTranslator[i]).stopTransition();
                                    toPlay.removeZombie(i,tempTranslator[i]);
                                }
                                catch(IndexOutOfBoundsException exceptionIndex){}
                            });
                        }
                        else{
                            tempTranslator[i]++;
                        }
                    }
                    catch(Exception exception){}
                }));
        shootTimeline.setCycleCount(Timeline.INDEFINITE);
    }
    public void attack(Pane pane, double xcoord, double ycoord, Level toPlay, int i, int j){
        initTimeline(pane, xcoord, ycoord, toPlay, i, j);
        shootTimeline.playFromStart();
    }
    public void stopTimeline(){
        shootTimeline.stop();
    }
    @Override
    public int attack() {
        // TODO Auto-generated method stub
        return 0;
    }
        
}