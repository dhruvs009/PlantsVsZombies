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
import javafx.beans.value.*;
import java.io.*;

public class levelScreenController implements Initializable {
    public static int checkQuit=0;
    public static int levelNum=1;
    public static long[] coolDown;
    @FXML
    private ImageView progressBar;
    @FXML
    private Pane rootPane;
    @FXML
    private Label timeCounter;
    @FXML
    private Label sunCounter;
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
    //Initialize game screen
    private static User userPlaying;
    // private static Level Game.U.getLevelToPlay();
    private Thread sunThread;
    private Thread zombieThread;
    private Thread timerThread;
    private static double getXFromGridPane(int i, int j){
        return 420+80.18*j;
    }
    private static double getYFromGridPane(int i, int j){
        return 190+92*i;
    }
    private void sideBarAdd(String arg){
        ImageView x= new ImageView();
        x.setImage(new Image(getClass().getResourceAsStream(String.format("./public/%s.jpg",arg))));
        x.setFitWidth(120);
        x.setFitHeight(66.67);
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
        Sun toAppear= new Sun(25);
        for(Node node: tileGrid.getChildren()){
            if(GridPane.getColumnIndex(node)==i && GridPane.getRowIndex(node)==j){
                StackPane temp= (StackPane) node;
                toAppear.playTransition();
                temp.getChildren().addAll(toAppear.getSun());
            }
        }
    }
    public void zombieAppear(){
        NormalZombie nz=new NormalZombie();
        //ImageView zombie= new ImageView();
        // zombie.setImage(new Image(getClass().getResourceAsStream("./public/zombie.gif")));
        // zombie.setFitWidth(84.18);
        // zombie.setFitHeight(96);
        // TranslateTransition tt= new TranslateTransition(Duration.millis(40000), zombie);
        // tt.setByX(-880);
        // tt.setByY(0);
        // tt.setFromX(1210);
        // tt.setFromY(190+92*j);
        // tt.setCycleCount(1);
        // tt.play();
        // zombie.toFront();
        Game.U.getLevelToPlay().addToZombie(nz, nz.getPos());
        nz.playTransition();
        nz.getZombie().translateXProperty().addListener(new ChangeListener<Number>(){
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue){
                for(int i=0; i<11; i++){
                    final int xcoordinatetemp= i;
                    if(Math.abs(getXFromGridPane(nz.getPos(),i)-(double)newValue)<100){
                        if(i==0){
                            try{
                                Game.U.getLevelToPlay().getLM(nz.getPos()).playTimeline();
                                Game.U.getLevelToPlay().getLM(nz.getPos()).attack(rootPane,0,0,Game.U.getLevelToPlay(), nz.getPos(), 0);
                                Game.U.getLevelToPlay().removeLM(nz.getPos());
                            }
                            catch(NullPointerException exceptionNoLM){
                                checkQuit=2;
                            }
                        }
                        else{
                            if(Game.U.getLevelToPlay().plantedObjects[nz.getPos()][xcoordinatetemp]!=null){
                                // System.out.println(Game.U.getLevelToPlay().plantedObjects[nz.getPos()][i]);
                                nz.pauseTransition();
                                Timeline hitPlant= new Timeline(
                                    new KeyFrame(
                                        Duration.millis(1000),
                                        (e)->{
                                            Timeline hitNow=new Timeline(
                                                new KeyFrame(
                                                    Duration.millis(1000),
                                                    (e1)->{
                                                        try{
                                                            nz.hitPlant(Game.U.getLevelToPlay().plantedObjects[nz.getPos()][xcoordinatetemp]);
                                                        }
                                                        catch(PlantDiedException exceptionPlant){
                                                            Game.U.getLevelToPlay().containers[nz.getPos()][xcoordinatetemp].getChildren().remove(Game.U.getLevelToPlay().planted[nz.getPos()][xcoordinatetemp]);
                                                            Game.U.getLevelToPlay().planted[nz.getPos()][xcoordinatetemp]=null;
                                                            nz.playTransition();
                                                            try{
                                                                PeaShooter tempPeaShooter=(PeaShooter)Game.U.getLevelToPlay().plantedObjects[nz.getPos()][xcoordinatetemp];
                                                                tempPeaShooter.stopTimeline();
                                                            }
                                                            catch(ClassCastException exceptionClassCast1){
                                                                try{
                                                                    SunProvider tempSunFlower=(SunProvider)Game.U.getLevelToPlay().plantedObjects[nz.getPos()][xcoordinatetemp];
                                                                    tempSunFlower.stopTimeline();
                                                                }
                                                                catch(ClassCastException exceptionClassCast2){}
                                                            }
                                                            Game.U.getLevelToPlay().plantedObjects[nz.getPos()][xcoordinatetemp]=null;
                                                        }
                                                        catch(NullPointerException exceptionNull){}
                                                    }
                                                )
                                            );
                                            hitNow.playFromStart();
                                        }
                                    )
                                );
                                hitPlant.setCycleCount(7);
                                hitPlant.playFromStart();
                                hitPlant.setOnFinished((e)->{
                                    if(Game.U.getLevelToPlay().zombieObjects.indexOf(nz)!=-1){
                                        // Game.U.getLevelToPlay().containers[nz.getPos()][xcoordinatetemp].getChildren().remove(Game.U.getLevelToPlay().planted[nz.getPos()][xcoordinatetemp]);
                                        // Game.U.getLevelToPlay().planted[nz.getPos()][xcoordinatetemp]=null;
                                        // Game.U.getLevelToPlay().plantedObjects[nz.getPos()][xcoordinatetemp]=null;
                                        nz.playTransition();
                                    }
                                });
                                break;
                            }
                        }
                    }
                }
            }
        });
        rootPane.getChildren().addAll(nz.getZombie());
    }
    public void addAllBasicEventHandlers(){
        for(int i=0; i<5; i++){
            for(int j=0; j<11; j++){
                final int xcoordinate=i;
                final int ycoordinate=j;
                StackPane container=new StackPane();
                if(j==0){
                    // Game.U.getLevelToPlay().getLM(i).getLawnMower()
                    // ImageView x= new ImageView();
                    // x.setImage(new Image(getClass().getResourceAsStream("./public/Lawnmower.png")));
                    // x.setFitWidth(76.18);
                    // x.setFitHeight(88);
                    container.getChildren().addAll(Game.U.getLevelToPlay().getLM(i).getLawnMower());
                }
                container.setOnMousePressed((MouseEvent e1) ->{
                    if(container.getChildren().size()>0 && (chosenPlant==null || chosenPlant.compareTo("shovel")!=0)){
                        ImageView temp;
                        int flag=0;
                        for(int k=0; k<container.getChildren().size(); k++){
                            temp= (ImageView)container.getChildren().get(k);
                            if(temp.getImage()==Sun.getImage()){
                                container.getChildren().remove(temp);
                                Game.U.getLevelToPlay().setSunCounter(Game.U.getLevelToPlay().getSunCounter()+Sun.getToAdd());
                                // sunCounterVal+=Sun.getToAdd();
                                sunCounter.setText(String.format("%d",Game.U.getLevelToPlay().getSunCounter()));
                                flag=1;
                                break;
                            }
                        }
                        if(flag==1){
                            for(int k=0; k<container.getChildren().size(); k++){
                                temp=(ImageView)container.getChildren().get(k);
                                if(temp.getImage()==SunFlower.getImage()){
                                    Sun toAdd=new Sun(15);
                                    container.getChildren().addAll(toAdd.getSun());
                                    Sun.getSunProviderTimeline(toAdd).playFromStart();
                                }
                            }
                        }
                    }
                    else if(chosenPlant!=null && chosenPlant.compareTo("")!=0 && chosenPlant.compareTo("shovel")!=0 && container.getChildren().size()==0 && GridPane.getColumnIndex(container)%10!=0){
                        // ImageView x= new ImageView();
                        // x.setImage(new Image(getClass().getResourceAsStream(String.format("./public/%s.gif",chosenPlant))));
                        // x.setFitWidth(76.18);
                        // x.setFitHeight(88);
                        // container.getChildren().addAll(x);
                        Plants x;
                        if(chosenPlant!=null && chosenPlant.compareTo("")!=0 && chosenPlant.compareTo("shovel")!=0 && container.getChildren().size()==0 && GridPane.getColumnIndex(container)%10!=0){
                            if(chosenPlant.compareTo("PeaShooter")==0){
                                if((coolDown[0]==0 || (System.currentTimeMillis()-coolDown[0])/1000>=7) && Game.U.getLevelToPlay().getSunCounter()-100>=0){
                                    x=PlantFactory.getMyFactory().getPlant("PeaShooter");
                                    PeaShooter temp= (PeaShooter) x;
                                    container.getChildren().addAll(x.getPlant());
                                    Game.U.getLevelToPlay().addToPlants(x,xcoordinate,ycoordinate);
                                    temp.attack(rootPane,getXFromGridPane(xcoordinate,ycoordinate),getYFromGridPane(xcoordinate,ycoordinate), Game.U.getLevelToPlay(), xcoordinate, ycoordinate);
                                    Game.U.getLevelToPlay().setSunCounter(Game.U.getLevelToPlay().getSunCounter()-100);
                                    // sunCounterVal+=Sun.getToAdd();
                                    sunCounter.setText(String.format("%d",Game.U.getLevelToPlay().getSunCounter()));
                                    coolDown[0]=System.currentTimeMillis();
                                }
                            }
                            else if(chosenPlant.compareTo("SunFlower")==0){
                                if((coolDown[1]==0 || (System.currentTimeMillis()-coolDown[1])/1000>=5) && Game.U.getLevelToPlay().getSunCounter()-50>=0){
                                    x=PlantFactory.getMyFactory().getPlant("SunFlower");
                                    SunProvider temp= (SunProvider) x;
                                    container.getChildren().addAll(x.getPlant());
                                    Game.U.getLevelToPlay().addToPlants(x,xcoordinate,ycoordinate);
                                    container.getChildren().addAll(temp.getSun());
                                    temp.playTimeline();
                                    Game.U.getLevelToPlay().setSunCounter(Game.U.getLevelToPlay().getSunCounter()-50);
                                    // sunCounterVal+=Sun.getToAdd();
                                    sunCounter.setText(String.format("%d",Game.U.getLevelToPlay().getSunCounter()));
                                    coolDown[1]=System.currentTimeMillis();
                                }
                            }
                            else if(chosenPlant.compareTo("Wallnut")==0){
                                if((coolDown[2]==0 || (System.currentTimeMillis()-coolDown[2])/1000>=12) && Game.U.getLevelToPlay().getSunCounter()-50>=0){
                                    x=PlantFactory.getMyFactory().getPlant("Wallnut");
                                    container.getChildren().addAll(x.getPlant());
                                    Game.U.getLevelToPlay().addToPlants(x,xcoordinate,ycoordinate);
                                    Game.U.getLevelToPlay().setSunCounter(Game.U.getLevelToPlay().getSunCounter()-50);
                                    // sunCounterVal+=Sun.getToAdd();
                                    sunCounter.setText(String.format("%d",Game.U.getLevelToPlay().getSunCounter()));
                                    coolDown[2]=System.currentTimeMillis();
                                }
                            }
                            else if(chosenPlant.compareTo("CherryBomb")==0){
                                if((coolDown[3]==0 || (System.currentTimeMillis()-coolDown[3])/1000>=20) && Game.U.getLevelToPlay().getSunCounter()-150>=0){
                                    x=PlantFactory.getMyFactory().getPlant("CherryBlaster");
                                    container.getChildren().addAll(x.getPlant());
                                    CherryBlaster temp=(CherryBlaster) x;
                                    Game.U.getLevelToPlay().addToPlants(x,xcoordinate,ycoordinate);
                                    temp.playTimeline(rootPane, getXFromGridPane(xcoordinate,ycoordinate),getYFromGridPane(xcoordinate,ycoordinate), Game.U.getLevelToPlay(), xcoordinate, ycoordinate, container);
                                    Game.U.getLevelToPlay().setSunCounter(Game.U.getLevelToPlay().getSunCounter()-150);
                                    // sunCounterVal+=Sun.getToAdd();
                                    sunCounter.setText(String.format("%d",Game.U.getLevelToPlay().getSunCounter()));
                                    coolDown[3]=System.currentTimeMillis();
                                }
                            }
                            else if(chosenPlant.compareTo("PuffShroom")==0){
                                if((coolDown[4]==0 || (System.currentTimeMillis()-coolDown[4])/1000>=10) && Game.U.getLevelToPlay().getSunCounter()-100>=0){
                                    x=PlantFactory.getMyFactory().getPlant("PuffShroom");
                                    PuffShroom temp= (PuffShroom) x;
                                    container.getChildren().addAll(x.getPlant());
                                    Game.U.getLevelToPlay().addToPlants(x,xcoordinate,ycoordinate);
                                    temp.attack(rootPane,getXFromGridPane(xcoordinate,ycoordinate),getYFromGridPane(xcoordinate,ycoordinate), Game.U.getLevelToPlay(), xcoordinate, ycoordinate);
                                    // Game.U.getLevelToPlay().setSunCounter(Game.U.getLevelToPlay().getSunCounter()-100);
                                    // // sunCounterVal+=Sun.getToAdd();
                                    // sunCounter.setText(String.format("%d",Game.U.getLevelToPlay().getSunCounter()));
                                    coolDown[4]=System.currentTimeMillis();
                                }
                            }
                            // container.getChildren().addAll(x.getPlant());
                        }
                    }
                    else if(chosenPlant!=null && chosenPlant.compareTo("shovel")==0){
                        if(GridPane.getColumnIndex(container)%10!=0){
                            if(container.getChildren().size()>0){
                                ImageView temp;
                                for(int k=0; k<container.getChildren().size(); k++){
                                    temp= (ImageView)container.getChildren().get(k);
                                    if(temp.getImage()!=Sun.getImage()){
                                        Game.U.getLevelToPlay().containers[xcoordinate][ycoordinate].getChildren().remove(Game.U.getLevelToPlay().planted[xcoordinate][ycoordinate]);
                                        Game.U.getLevelToPlay().planted[xcoordinate][ycoordinate]=null;
                                        try{
                                            PeaShooter tempPeaShooter=(PeaShooter)Game.U.getLevelToPlay().plantedObjects[xcoordinate][ycoordinate];
                                            tempPeaShooter.stopTimeline();
                                        }
                                        catch(ClassCastException exceptionClassCast1){
                                            try{
                                                SunProvider tempSunFlower=(SunProvider)Game.U.getLevelToPlay().plantedObjects[xcoordinate][ycoordinate];
                                                tempSunFlower.stopTimeline();
                                            }
                                            catch(ClassCastException exceptionClassCast2){
                                                CherryBlaster tempCherry=(CherryBlaster)Game.U.getLevelToPlay().plantedObjects[xcoordinate][ycoordinate];
                                                tempCherry.stopTimeline();
                                            }
                                        }
                                        Game.U.getLevelToPlay().plantedObjects[xcoordinate][ycoordinate]=null;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                });
                Game.U.getLevelToPlay().containers[i][j]=container;
                tileGrid.add(container,j,i);
            }
        }
    }
    public void initializeGameScreen(){
        availablePlants=new ArrayList<ImageView>();
        String[] availablePlantsList=Game.U.getLevelToPlay().getAllPlants();
        for(int i=0; i<Game.U.getLevelToPlay().getLevelNum(); i++){
            sideBarAdd(availablePlantsList[i]);
        }
        sunCounter.setText(String.format("%d",Game.U.getLevelToPlay().getSunCounter()));
        addShovelEvents();
        addAllBasicEventHandlers();
    }
    public String addTime(String timeNow){
        String[] time=timeNow.split(":",2);
        int minutes=Integer.parseInt(time[0]);
        int seconds=Integer.parseInt(time[1]);
        seconds++;
        if(seconds==60){
            seconds=0;
            minutes++;
        }
        if(seconds<10){
            if(minutes<10){
                return String.format("0%d:0%d",minutes,seconds);
            }
            return String.format("%d:0%d",minutes,seconds);
        }
        else{
            if(minutes<10){
                return String.format("0%d:%d",minutes,seconds);
            }
            return String.format("%d:%d",minutes,seconds);
        }
    }
    public void initializeThreads(){
        sunThread= new Thread(() -> {
            try{
                while(checkQuit==0){
                    Thread.sleep(10000);
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
        zombieThread= new Thread(() -> {
            int i=0;
            try{
                while(i<Game.U.getLevelToPlay().getNumZomb()){
                    if(i==0){
                        Thread.sleep(5000);
                    }
                    Thread.sleep(8000);
                    i++;
                    Platform.runLater(() ->{
                        Timeline progress= new Timeline(
                            new KeyFrame(
                                new Duration(5000+8000*(Game.U.getLevelToPlay().getNumZomb())),
                                new KeyValue(progressBar.translateXProperty(),-284+21)
                            )
                        );
                        progress.playFromStart();
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
        timerThread= new Thread(() -> {
            try{
                while(checkQuit==0){
                    Thread.sleep(1000);
                    Platform.runLater(() -> {
                        try {
                            Game.U.getLevelToPlay().checkGameWon();
                        } catch (LevelWonException e) {
                            checkQuit=1;
                        } catch (LevelLostException e) {
                            checkQuit=2;
                        }
                        timeCounter.setText(addTime(timeCounter.getText()));
                    });
                }
                Platform.runLater(()->{
                    gameResult();
                });
                Thread.sleep(3000);
                Platform.runLater(()->{
                    FXMLLoader loader=new FXMLLoader(getClass().getResource("screen.fxml"));
                    Parent root=null;
                    try{
                        root=loader.load();
                    }
                    catch(IOException e1){
                        e1.printStackTrace();
                        System.exit(0);
                    }
                    int temp=checkQuit;
                    checkQuit=0;
                    if(temp==1){
                        Game.U.updateUser();
                    }
                    // System.out.println(Game.U.getCurrentLevel());
                    Game.updateStage(root, 1280, 720);
                });
            }
            catch(InterruptedException e){
                System.exit(0);
            }
        });
    }
    public void startThreads(){
        sunThread.start();
        zombieThread.start();
        timerThread.start();
    }
    //
    @Override
    public void initialize(URL url, ResourceBundle rb){
        coolDown=new long[6];
        userPlaying=Game.U;
        // Game.U.getLevelToPlay()=userPlaying.getGame.U.getLevelToPlay()();
        initializeGameScreen();
        initializeThreads();
        startThreads();
    }
    public void gameResult(){
        ImageView youWonImageView=new ImageView();
        if(checkQuit==1){
            youWonImageView.setImage(new Image("./public/YouWon.png"));
        }
        else if(checkQuit==2){
            youWonImageView.setImage(new Image("./public/YouLost.png"));
        }
        youWonImageView.setX(320);
        youWonImageView.setY(150);
        youWonImageView.setFitWidth(623);
        youWonImageView.setFitHeight(415);
        ScaleTransition transition=new ScaleTransition(Duration.millis(1500), youWonImageView);
        transition.setFromX(0);
        transition.setByX(1f);
        transition.setFromY(0);
        transition.setByY(1f);
        transition.play();
        youWonImageView.toFront();
        rootPane.getChildren().addAll(youWonImageView);
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
