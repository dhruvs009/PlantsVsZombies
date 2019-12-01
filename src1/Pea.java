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

public class Pea{
    private static Image appearance= new Image("./public/Pea.png");
    private ImageView pea;
    private Timeline shootTimeline;
    private TranslateTransition tt;
    public Pea(){
        pea=new ImageView(appearance);
        pea.setFitWidth(20);
        pea.setFitHeight(20);
    }
    public Timeline getShootTimeline(Pane pane,Pea toShoot, int distX){
        shootTimeline=new Timeline(
            new KeyFrame(
                Duration.millis((int)(1800/647*distX)),
                new KeyValue(toShoot.getPea().xProperty(),distX)
            )
        );
        // shootTimeline.setOnFinished((e)->{
        //     for(int k=0; k<pane.getChildren().size(); k++){
        //         try{
        //             ImageView temp=(ImageView)pane.getChildren().get(k);
        //             if(temp.getImage()==Pea.getImage()){
        //                 pane.getChildren().remove(temp);
        //                 break;
        //             }
        //         }
        //         catch(ClassCastException exception){}
        //     }
        // });
        return shootTimeline;
    }
    public static Image getImage(){
        return appearance;
    }
    public ImageView getPea(){
        return pea;
    }
}