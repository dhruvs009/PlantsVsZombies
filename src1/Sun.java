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
    private int toAddSun;
    final private ScaleTransition sunTransition;
    public Sun(){
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
        this.toAddSun=25;
    }
    public void playTransition(){
        sunTransition.play();
    }
    public ImageView getSun(){
        return sun;
    }
} 