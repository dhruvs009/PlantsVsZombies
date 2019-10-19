import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import java.io.*;
import javafx.application.*;
import javafx.event.*;

public class StartPageController implements Initializable {
    @FXML
    private static Pane rootStartPagePane;
    @FXML
    private static StackPane topPane;
    @FXML
    private static StackPane middlePane;
    @FXML
    private static StackPane bottomPane;
    @FXML
    private void handleExitGame(ActionEvent event){
        System.exit(0);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb){
        // System.out.println("StartPageSuccessful");
    }
}