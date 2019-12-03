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

class User implements Serializable{
    private String Username;
    private ArrayList<String> SavedGames;
    public transient int CurrentLeveltoPlay;
    private int MaxLevelUnlocked;
    transient private Level current;
    User(String Username){
        this.Username=Username;
        SavedGames=new ArrayList<>();
        int MaxLevelUnlocked=1;
        CurrentLeveltoPlay=1;
        current=Level.getLevelToPlay(CurrentLeveltoPlay);
        current.setLevelNum(CurrentLeveltoPlay);
    }
    public void AddSavedGame(String saved){
        SavedGames.add(saved);
    }
    public ArrayList<String> getSavedGames(){
        return SavedGames;
    }
    public String getUsername(){
        return Username;
    }
    public void setLevel(int levelChosen){
        CurrentLeveltoPlay=levelChosen;
        current=Level.getLevelToPlay(CurrentLeveltoPlay);
    }
    public void updateUser(){
        MaxLevelUnlocked=Math.max(MaxLevelUnlocked,CurrentLeveltoPlay+1);
        CurrentLeveltoPlay+=1;
        setLevel(CurrentLeveltoPlay);
    }
    public int getCurrentLevel(){
        return CurrentLeveltoPlay;
    }
    public int getLevelUnlocked(){
        return MaxLevelUnlocked;
    }
    public Level getLevelToPlay(){
        return current;
    }
}