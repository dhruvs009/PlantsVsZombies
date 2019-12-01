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
public class NormalZombie extends Zombies {
    private static Image normalzombieimage;
    private static Image[] zombieImages;
    private Random x=new Random();
    public NormalZombie(){
        super(100,3,3,2);
        String[] zombies={"zombie","coneZombie","footballZombie"};
        if(zombieImages==null){
            zombieImages=new Image[3];
            zombieImages[0]=new Image(getClass().getResourceAsStream(String.format("./public/%s.gif",zombies[0])));
            zombieImages[1]=new Image(getClass().getResourceAsStream(String.format("./public/%s.gif",zombies[1])));
            zombieImages[2]=new Image(getClass().getResourceAsStream(String.format("./public/%s.gif",zombies[2])));
        }
        int y=x.nextInt(3);
        zombieAppearance=zombieImages[y];
        setHP(100*(2+y)/2);
        super.setImage();
    }
    public static Image getImage(){
        return normalzombieimage;
    }
    @Override
    public Zombies appear(){
        return this;
    }
}