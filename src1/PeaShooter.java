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

public class PeaShooter extends Shooter{
    private static Image appearance=new Image("./public/PeaShooter.gif");
    public PeaShooter(){
        super(100,50,7,new ImageView(appearance));
    }
    // public Plants plantThis(){
    public static Image getImage(){
        return appearance;
    }
    @Override
    public int attack() {
        // TODO Auto-generated method stub
        return 0;
    }
        
    // }
}