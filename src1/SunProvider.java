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

public class SunProvider extends Plants{
    protected int toGiveOut;
    private Sun toShow;
    SunProvider(int HP, int sunPower,int waitForNew, String chosenPlant){
        super(HP, sunPower, waitForNew, chosenPlant);
    }
    //public abstract Plants plantThis();
    // public Sun giveSun(){

    // }
}