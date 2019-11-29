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
    public NormalZombie(){
        super(100,3,3,2);
        if(normalzombieimage==null){
            normalzombieimage=new Image(getClass().getResourceAsStream("./public/zombie.gif"));
        }
        zombieAppearance=normalzombieimage;
        super.setImage();
    }
    @Override
    public Zombies appear(){
        return this;
    }
}