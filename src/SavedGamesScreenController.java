import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.effect.*;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.*;
import java.io.*;
import javafx.application.*;
import javafx.event.*;
import javafx.scene.image.ImageView;
import javafx.animation.*;

class SavedGamesScreenController implements Initializable{
    @FXML
    private Label Text1,Text2,Text3,Text4;
    @Override
    public void initialize(URL url,ResourceBundle rb){
        ArrayList<String> SavedGames=Game.U.getSavedGames();
        if(SavedGames.size()>0)
            Text1.setText(SavedGames.get(0));
        if(SavedGames.size()>1)
            Text2.setText(SavedGames.get(1));
        if(SavedGames.size()>2)
            Text3.setText(SavedGames.get(2));
        if(SavedGames.size()>3)
            Text4.setText(SavedGames.get(3));
    }
    @FXML
    private void mouseEntered(MouseEvent e){
        ImageView button= (ImageView) e.getSource();
        button.setEffect(new Glow(0.3));
    }
    @FXML
    private void mouseExited(MouseEvent e){
        ImageView button= (ImageView) e.getSource();
        button.setEffect(null);
    }
}