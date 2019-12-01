import java.io.*;
import java.util.*;
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
class GameBase implements Serializable{
    User InPlay;
    Level[] allLevels=new Level[5];
    //Level l;
    GameBase(String username)throws IOException,ClassNotFoundException{
        InPlay=deserialize(username);
        if(InPlay==null){
            new User(username);
        }
        // l.setLevelNum(InPlay.getCurrentLevel());
    }
    public int getLevelUnlocked(){
        return InPlay.getLevelUnlocked();
    }
    public ArrayList<String> getSavedGames(){
        return InPlay.getSavedGames();
    }
    public static User deserialize(String Username) throws IOException, ClassNotFoundException{
        User i;
        ObjectInputStream in=null;
        try{
            in=new ObjectInputStream(new FileInputStream(Username));
            i=(User)in.readObject();
        }
        finally{
            in.close();
        }
        return i;
    }
    public static void serialize(User InPlay) throws IOException{
        ObjectOutputStream out=null;
        try{
            out=new ObjectOutputStream(new FileOutputStream(InPlay.getUsername()));
            out.writeObject(InPlay);
        }
        finally{
            out.close();
        }
    }
    public static void main(String[] args) throws IOException,ClassNotFoundException {
        User temp= new User("hello");
        GameBase.serialize(temp);
        User u1=GameBase.deserialize("hello");
        System.out.println(u1.getUsername());
    }
}