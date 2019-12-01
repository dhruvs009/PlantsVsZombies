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

public class PlantFactory{
    public static PlantFactory myFactory;
    public static PlantFactory getMyFactory(){
        if(myFactory==null){
            myFactory=new PlantFactory();
        }
        return myFactory;
    }
    public Plants getPlant(String arg){
        if(arg.equals("CherryBlaster")){
            return new CherryBlaster();
        }
        if(arg.equals("PeaShooter")){
            return new PeaShooter();
        }
        if(arg.equals("PuffShroom")){
            return new PuffShroom();
        }
        if(arg.equals("SunFlower")){
            return new SunFlower();
        }
        if(arg.equals("Wallnut")){
            return new Wallnut();
        }
        return null;
    }
}