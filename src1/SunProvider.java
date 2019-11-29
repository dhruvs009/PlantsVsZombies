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

public class SunProvider extends Plants{
    protected int toGiveOut;
    private final Timeline growSun;
    private static Sun toShow;
    SunProvider(int HP, int sunPower,int waitForNew, ImageView sunAppearance){
        super(HP, sunPower, waitForNew, sunAppearance);
        toShow=new Sun(15);
        growSun=Sun.getSunProviderTimeline(toShow);
        growSun.playFromStart();
    }
    public void playTimeline(){
        if(toShow==null){
            toShow=new Sun(15);
        }
        growSun.playFromStart();
    }
    public static ImageView getSun(){
        if(toShow==null){
            toShow=new Sun(15);
        }
        return toShow.getSun(); 
    }
    // @Override
    // public void action(){

    // }
    //public abstract Plants plantThis();
    // public Sun giveSun(){

    // }
}