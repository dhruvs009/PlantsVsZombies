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

public class Plants extends Living{
    protected int sunPower;
    protected float waitForNew;
    protected boolean plantable;
    protected ImageView plantAppearance;
    
    public Plants(int HP, int sunPower, int waitForNew,ImageView Appearance){
        super(HP);
        this.sunPower=sunPower;
        this.waitForNew=waitForNew;
        this.plantAppearance=Appearance;
        // this.plantAppearance=new ImageView(new Image(getClass().getResourceAsStream(String.format("./public/%s.gif",c))));
        plantAppearance.setFitWidth(76.18);
        plantAppearance.setFitHeight(88);
    }

    // protected abstract Plants plantThis();
    public ImageView getPlant(){
        return plantAppearance;
    }
}
/* waitForNew
 30 for slow
 50 for very slow
 7.5 changed to 7 for fast
 */