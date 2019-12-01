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

class LevelWonException extends Exception{
    LevelWonException(String message){
        super(message);
    }
}

class LevelLostException extends Exception{
    LevelLostException(String message){
        super(message);
    }
}

public class Level implements Serializable{
    private static int[] numZombies={2,7,15,22,30};
    private int levelNum;
    private LawnMower[] listLawnMowers;
    public void removeLM(int i){
        listLawnMowers[i]=null;
    }
    public LawnMower getLM(int i){
        return listLawnMowers[i];
    }
    private static int DeadZombieCounter=0;
    public int getLevelNum(){
        return levelNum;
    }
    public void setLevelNum(int levelNum){
        this.levelNum=levelNum;
    }
    private static Level toPlay; 
    private int sunCounter;
    public int getSunCounter(){
        return sunCounter;
    }
    public static void updateDeadZombie(){
        DeadZombieCounter++;
    }
    public void checkGameWon() throws LevelWonException, LevelLostException{
        if(DeadZombieCounter==numZomb){
            throw new LevelWonException("You defeated the zombies!!");
        }
        else if(levelScreenController.checkQuit==2){
            throw new LevelLostException("Zombies ate your brains!!!");
        }
    }
    public void setSunCounter(int sunCounter){
        this.sunCounter=sunCounter;
    }
    private String[] allPlants;
    public String[] getAllPlants(){
        return allPlants;
    }
    public void setAllPlants(){
        allPlants=new String[5];
        allPlants[0]="PeaShooter";
        allPlants[1]="SunFlower";
        allPlants[2]="CherryBomb";
        allPlants[3]="Wallnut";
        allPlants[4]="PuffShroom";
    }
    // public void getAllPlantsAvailable(VBox sideBar, ArrayList<ImageView> availablePlants, ImageView shovel, String chosenPlant){
    //     for(int a=0; a<levelNum; a++){
    //         ImageView x= new ImageView();
    //         x.setImage(new Image(getClass().getResourceAsStream(String.format("./public/%s.jpg",allPlants[a]))));
    //         x.setFitWidth(180);
    //         x.setFitHeight(100);
    //         int pos= availablePlants.size();
    //         availablePlants.add(x);
    //         x.setOnMouseEntered((MouseEvent e1) -> {
    //             if(chosenPlant==null || chosenPlant.compareTo(allPlants[a])!=0){
    //                 x.setEffect(new Glow(0.2));
    //             }
    //         });
    //         x.setOnMouseExited((MouseEvent e2) -> {
    //             if(chosenPlant==null || chosenPlant.compareTo(allPlants[a])!=0){
    //                 x.setEffect(null);
    //             }
    //         });
    //         x.setOnMousePressed((MouseEvent e3) ->{
    //             for(int i=0; i<availablePlants.size(); i++){
    //                 if(i!=pos){
    //                     availablePlants.get(i).setEffect(null);
    //                 }
    //                 else{
    //                     availablePlants.get(i).setEffect(new Glow(0.5));
    //                 }
    //             }
    //             shovel.setEffect(null);
    //             chosenPlant=new String(allPlants[a]);
    //         });
    //         sideBar.getChildren().addAll(x);
    //     }
    // }
    public ImageView[][] planted= new ImageView[5][11];
    public Plants[][] plantedObjects=new Plants[5][11];
    public StackPane[][] containers=new StackPane[5][11];
    public ArrayList<ArrayList<ImageView>> zombiesInRow=new ArrayList<ArrayList<ImageView>>();
    public ArrayList<ArrayList<Zombies>> zombieObjects=new ArrayList<ArrayList<Zombies>>();
    private int numZomb;
    private Level(int numZomb){
        listLawnMowers=new LawnMower[5];
        for(int i=0; i<5; i++){
            listLawnMowers[i]=new LawnMower();
        }
        DeadZombieCounter=0;
        this.numZomb=numZomb;
        for(int i=0; i<5; i++){
            zombiesInRow.add(new ArrayList<ImageView>());
            zombieObjects.add(new ArrayList<Zombies>());
        }
    }
    public static Level getLevelToPlay(int levelNum){
        toPlay=new Level(Level.numZombies[levelNum-1]);
        toPlay.setLevelNum(levelNum);
        toPlay.setSunCounter(100);
        toPlay.setAllPlants();
        return toPlay;
    }
    public void addToPlants(Plants toAdd, int i, int j){
        plantedObjects[i][j]=toAdd;
        planted[i][j]=toAdd.getPlant();
    }
    public int getNumZomb(){
        return numZomb;
    }
    public void removePlant(int i, int j){
        plantedObjects[i][j]=null;
        planted[i][j]=null;
    }
    public void addToZombie(Zombies toAdd, int i){
        zombieObjects.get(i).add(toAdd);
        zombiesInRow.get(i).add(toAdd.getZombie());
    }
    public void removeZombie(int i){
        zombieObjects.get(i).remove(0);
        zombiesInRow.get(i).remove(0);
    }
    public void removeZombie(int i, int j){
        zombieObjects.get(i).remove(j);
        zombiesInRow.get(i).remove(j);
    }

}