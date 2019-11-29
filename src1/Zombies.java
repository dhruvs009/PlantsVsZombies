//DiscoZombie: super(120,5,3,2, zombieAppearance);
//NormalZombie: super(100,3,3,2, zombieAppearance);
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

public abstract class Zombies extends Living implements Attacking{
    protected int attackVal;
    protected int attackInterval;
    protected int speed;
    protected Image zombieAppearance;
    private ImageView zombie;
    private TranslateTransition tt;
    public Zombies(int HP, int attackVal, int attackInterval, int speed){
        super(HP);
        this.attackVal=attackVal;
        this.speed=speed;
        this.attackInterval=attackInterval;
    }
    public void setImage(){
        Random x= new Random();
        int j= x.nextInt(5);
        zombie=new ImageView();
        zombie.setImage(zombieAppearance);
        zombie.setFitWidth(84.18);
        zombie.setFitHeight(96);
        tt= new TranslateTransition(Duration.millis(40000), zombie);
        tt.setByX(-880);
        tt.setByY(0);
        tt.setFromX(1210);
        tt.setFromY(190+92*j);
        tt.setCycleCount(1);
        zombie.toFront();
    }
    public void playTransition(){
        tt.play();
    }
    public ImageView getZombie(){
        return zombie;
    }
    public abstract Zombies appear();
    @Override
    public int attack(){
        return this.attackVal;
    }
}