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

public class Sun{
    private static Image sunImage;
    private ImageView sun; 
    private static int toAddSun;
    final private ScaleTransition sunTransition;
    private static Sun sunProviderSun=new Sun(15);
    public static Sun getSunProviderSun(){
        return sunProviderSun;
    }
    public static Timeline getSunProviderTimeline(Sun sun){
        Timeline sunProviderTimeline=new Timeline(
            new KeyFrame(
                Duration.millis(0),
                new KeyValue(sun.getSun().scaleXProperty(),0),
                new KeyValue(sun.getSun().scaleYProperty(),0)
            ),
            new KeyFrame(
                Duration.millis(4000),
                new KeyValue(sun.getSun().scaleXProperty(),0),
                new KeyValue(sun.getSun().scaleYProperty(),0)
            ),
            new KeyFrame(
                Duration.millis(5000),
                new KeyValue(sun.getSun().scaleXProperty(),0.5),
                new KeyValue(sun.getSun().scaleYProperty(),0.5)
            )    
        );
        return sunProviderTimeline;
    }
    // public static void playSunProviderTimeline(){
    //     sunProviderTimeline.playFromStart();
    // }
    public Sun(int toAddSun){
        if(Sun.sunImage==null){
            Sun.sunImage=new Image(getClass().getResourceAsStream("./public/Sun.png"));
        }
        sun=new ImageView();
        sun.setImage(Sun.sunImage);
        sun.setFitWidth(76.18);
        sun.setFitHeight(88);
        sunTransition=new ScaleTransition(Duration.millis(3000),sun);
        sunTransition.setFromX(0);
        sunTransition.setByX(1f);
        sunTransition.setFromY(0);
        sunTransition.setByY(1f);
        sunTransition.setCycleCount(1);
        this.toAddSun=toAddSun;
    }
    public static int getToAdd(){
        return toAddSun;
    }
    public void playTransition(){
        sunTransition.play();
    }
    public static Image getImage(){
        return sunImage;
    }
    public ImageView getSun(){
        return sun;
    }
} 