package festivalPlanner.gui.gui_views;

import festivalPlanner.data_system.Artist;
import festivalPlanner.data_system.Event;
import festivalPlanner.data_system.Stage;
import festivalPlanner.gui.SceneHandler;

import festivalPlanner.gui.gui_controllers.EventViewController;
import festivalplanner_guiModules.buttons.FPButton;
import festivalplanner_guiModules.inputfields.*;
import festivalplanner_guiModules.text.titles.DinamicTitle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

import java.util.ArrayList;

public class EventView extends StackPane {

    private SceneHandler sceneHandler;
    private MainView mainView;
    private ObservableList<Artist> artists;
    private ObservableList<Stage> stages;
    private EventViewController controller;
    private ArrayList<Event> events;


    public EventView(SceneHandler sceneHandler){
        this.sceneHandler = sceneHandler;
        this.mainView = mainView;
        this.artists = FXCollections.observableArrayList();
        this.stages = FXCollections.observableArrayList();
        this.controller = new EventViewController();
        this.events = new ArrayList<>();
        controller.setTimes();
        controller.setPopularity();

        setWidth(1280);
        setHeight(800);
        setStyle("-fx-background-color: #35477D;" );
        getChildren().add(createStackPane());
    }

    public StackPane createStackPane(){

        StackPane stackPane = new StackPane(); //deze stackpane kun je in bouwen
        stackPane.setMinSize(800,570);
        stackPane.setMaxSize(800,570);

        stackPane.setStyle("-fx-background-color: #FFFFFF;" +
                        "-fx-background-radius: 30; " +
                        "-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 20, 0.0 , 2 , 2 );"
                );

        Button BackButton = new FPButton("X",30,30);
        stackPane.getChildren().add(BackButton);
        BackButton.setOnAction(event -> {
            this.sceneHandler.toMainView();
        });

        place(BackButton,370,-255);

        //Labels

        DinamicTitle title = new DinamicTitle("Event", 40);
        place(title,-300,-220);

        DinamicTitle secondTitle = new DinamicTitle("Add Event", 21);
        place(secondTitle,-300,-150);

        DinamicTitle thirdTitle = new DinamicTitle("All Events", 21);
        place(thirdTitle,110,-150);

        DinamicTitle mainArtist = new DinamicTitle("Main Artist", 17);
        place(mainArtist,-300,-90);

        DinamicTitle coArtist = new DinamicTitle("Co Artist",17);
        place(coArtist,-300,-30);

        DinamicTitle stage = new DinamicTitle("Stage", 17);
        place(stage,-300,30);

        DinamicTitle popularity = new DinamicTitle("Popularity", 17);
        place(popularity,-300,90);

        DinamicTitle Time = new DinamicTitle("Time", 17);
        place(Time,-300,155);

        //Fields

        ComboBox<Artist> mainArtistField = new FPComboBoxArtist("Main Artist");
        place(mainArtistField,-153,-90);
        mainArtistField.setItems(artists);

        ComboBox<Artist> coArtistField = new FPComboBoxArtist("Co Artist");
        place(coArtistField,-153,-30);
        coArtistField.setItems(artists);

        ComboBox<Stage> stageField = new FPComboBoxStage("Stage");
        place(stageField,-153,30);
        stageField.setItems(stages);

        ComboBox<String> popularityField = new FPComboBoxString("Popularity %");
        place(popularityField,-153,90);
        popularityField.setItems(this.controller.getPopularity());

        ComboBox<Double> beginTime = new FPComboBoxDouble("Begin time",100,40);
        place(beginTime,-183,155);
        beginTime.setItems(controller.getTimes());

        ComboBox<Double> endTime = new FPComboBoxDouble("End time",100,40);
        place(endTime,-80,155);
        endTime.setItems(controller.getTimes());

        FPListView fpListView = new FPListView("Artist list");
        place(fpListView,250,30);

        FPButton addArtist = new FPButton("Add ", 90, 35);
        place(addArtist,-50,230);

        FPButton RemoveArtist = new FPButton("Remove ", 90, 35);
        place(RemoveArtist,310,230);

        stackPane.getChildren().addAll(title,secondTitle,thirdTitle,mainArtist,coArtist,stage,popularity,Time,mainArtistField,coArtistField,stageField,popularityField,beginTime,endTime,addArtist,RemoveArtist,makeLine(),makeLine2());

//        addArtist.setOnAction(event -> {
//            this.events.add(new Event(mainArtistField.getValue(),stageField.getValue(),beginTime.getValue(),endTime.getValue(),popularityField.getValue()));
//        });


        return stackPane;
    }
    public void place(Node node, int x, int y){
        node.setLayoutX(x);
        node.setLayoutY(y);
        node.setTranslateX(x);
        node.setTranslateY(y);
    }

    public HBox makeLine(){

        HBox hBox = new HBox();
        hBox.setMinSize(700, 2);
        hBox.setMaxSize(700, 2);
        place(hBox,0,-170);
        hBox.setStyle("-fx-background-color: #EEEEEE;");

        return hBox;
    }

    public HBox makeLine2(){

        HBox hBox = new HBox();
        hBox.setMinSize(2, 400);
        hBox.setMaxSize(2, 400);
        place(hBox,40,50);
        hBox.setStyle("-fx-background-color: #EEEEEE;");

        return hBox;
    }

    public void addArtistToList(Artist artist){
        artists.add(artist);
    }

    public void addStageToList(Stage stage){
        stages.add(stage);
    }







}

