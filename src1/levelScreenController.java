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

public class levelScreenController implements Initializable {
    @FXML
    private Pane rootPane;
    @FXML
    private Label timeCounter;
    @FXML
    private GridPane tileGrid;
    private int flag;
    private String chosenPlant;
    private ArrayList<ImageView> availablePlants;
    @FXML
    private ImageView shovel;
    @FXML
    private VBox sideBar;
    @FXML
    public static Stage inGameMenu;
    private void sideBarAdd(String arg){
        ImageView x= new ImageView();
        x.setImage(new Image(getClass().getResourceAsStream(String.format("./public/%s.jpg",arg))));
        x.setFitWidth(180);
        x.setFitHeight(100);
        int pos= availablePlants.size();
        availablePlants.add(x);
        x.setOnMouseEntered((MouseEvent e1) -> {
            if(chosenPlant==null || chosenPlant.compareTo(arg)!=0){
                x.setEffect(new Glow(0.2));
            }
        });
        x.setOnMouseExited((MouseEvent e2) -> {
            if(chosenPlant==null || chosenPlant.compareTo(arg)!=0){
                x.setEffect(null);
            }
        });
        x.setOnMousePressed((MouseEvent e3) ->{
            for(int i=0; i<availablePlants.size(); i++){
                if(i!=pos){
                    availablePlants.get(i).setEffect(null);
                }
                else{
                    availablePlants.get(i).setEffect(new Glow(0.5));
                }
            }
            shovel.setEffect(null);
            chosenPlant=new String(arg);
        });
        sideBar.getChildren().addAll(x);
    }
    private void addShovelEvents(){
        shovel.setOnMouseEntered((MouseEvent e1) -> {
            if(chosenPlant==null || chosenPlant.compareTo("shovel")!=0){
                shovel.setEffect(new Glow(0.2));
            }
        });
        shovel.setOnMouseExited((MouseEvent e2) -> {
            if(chosenPlant==null || chosenPlant.compareTo("shovel")!=0){
                shovel.setEffect(null);
            }
        });
        shovel.setOnMousePressed((MouseEvent e3) ->{
            for(int i=0; i<availablePlants.size(); i++){
                availablePlants.get(i).setEffect(null);
            }
            shovel.setEffect(new Glow(0.5));
            chosenPlant=new String("shovel");
        });
    }
    public void sunAppear(){
        Random x= new Random();
        int i= 1+x.nextInt(9);
        int j= x.nextInt(5);
        ImageView sun= new ImageView();
        sun.setImage(new Image(getClass().getResourceAsStream("./public/Sun.png")));
        sun.setFitWidth(76.18);
        sun.setFitHeight(88);
        for(Node node: tileGrid.getChildren()){
            if(GridPane.getColumnIndex(node)==i && GridPane.getRowIndex(node)==j){
                StackPane temp= (StackPane) node;
                ScaleTransition st=new ScaleTransition(Duration.millis(3000), sun);
                st.setFromX(0);
                st.setByX(1f);
                st.setFromY(0);
                st.setByY(1f);
                st.setCycleCount(1);
                st.play();
                temp.getChildren().addAll(sun);
            }
        }
    }
    public void zombieAppear(){
        Random x= new Random();
        int j= x.nextInt(5);
        ImageView zombie= new ImageView();
        zombie.setImage(new Image(getClass().getResourceAsStream("./public/zombie.gif")));
        zombie.setFitWidth(84.18);
        zombie.setFitHeight(96);
        TranslateTransition tt= new TranslateTransition(Duration.millis(40000), zombie);
        tt.setByX(-880);
        tt.setByY(0);
        tt.setFromX(1210);
        tt.setFromY(190+92*j);
        tt.setCycleCount(1);
        tt.play();
        zombie.toFront();
        rootPane.getChildren().addAll(zombie);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb){
        availablePlants=new ArrayList<ImageView>();
        sideBarAdd("PeaShooter");
        sideBarAdd("SunFlower");
        sideBarAdd("Wallnut");
        sideBarAdd("CherryBomb");
        addShovelEvents();
        for(int i=0; i<5; i++){
            for(int j=0; j<11; j++){
                StackPane container=new StackPane();
                if(j==0){
                    ImageView x= new ImageView();
                    x.setImage(new Image(getClass().getResourceAsStream("./public/Lawnmower.png")));
                    x.setFitWidth(76.18);
                    x.setFitHeight(88);
                    container.getChildren().addAll(x);
                }
                container.setOnMousePressed((MouseEvent e1) ->{
                    if(chosenPlant!=null && chosenPlant.compareTo("")!=0 && chosenPlant.compareTo("shovel")!=0 && container.getChildren().size()==0 && GridPane.getColumnIndex(container)%10!=0){
                        ImageView x= new ImageView();
                        x.setImage(new Image(getClass().getResourceAsStream(String.format("./public/%s.gif",chosenPlant))));
                        x.setFitWidth(76.18);
                        x.setFitHeight(88);
                        container.getChildren().addAll(x);
                    }
                    else if(chosenPlant!=null && chosenPlant.compareTo("shovel")==0){
                        if(GridPane.getColumnIndex(container)%10!=0){
                            container.getChildren().clear();
                        }
                    }
                });
                tileGrid.add(container,j,i);
            }
        }
        Thread sunThread= new Thread(() -> {
            try{
                while(true){
                    Thread.sleep(20000);
                    Platform.runLater(() ->{
                        sunAppear();
                    }
                    );
                }
            }
            catch(InterruptedException e){
                System.exit(0);
            }
        }
        );
        sunThread.start();
        Thread zombieThread= new Thread(() -> {
            try{
                while(true){
                    Thread.sleep(5000);
                    Platform.runLater(() ->{
                        zombieAppear();
                    }
                    );
                }
            }
            catch(InterruptedException e){
                System.exit(0);
            }
        }
        );
        zombieThread.start();
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
    @FXML
    private void MenuMouseClick(MouseEvent e){
        inGameMenu=new Stage();
        FXMLLoader loader1= new FXMLLoader(getClass().getResource("InGameMenu.fxml"));
        Parent root1=null;
        try{
            root1=loader1.load();
        }
        catch(IOException e1){
            e1.printStackTrace();
            System.exit(0);
        }
        inGameMenu.setScene(new Scene(root1,600,400));
        inGameMenu.initStyle(StageStyle.UNDECORATED);
        inGameMenu.show();
    }
}
