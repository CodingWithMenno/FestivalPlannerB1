package festivalPlanner.gui.gui_views;

import festivalPlanner.data_system.Artist;
import festivalPlanner.data_system.Data;
import festivalPlanner.data_system.Event;
import festivalPlanner.data_system.Stage;
import festivalPlanner.gui.SceneHandler;

import festivalPlanner.gui.gui_controllers.ArtistViewController;
import festivalPlanner.gui.gui_controllers.EventViewController;
import festivalplanner_guiModules.buttons.FPButton;
import festivalplanner_guiModules.inputfields.*;
import festivalplanner_guiModules.text.titles.DynamicTitle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

import java.sql.SQLException;
import java.util.ArrayList;

public class EventView extends StackPane {

    private SceneHandler sceneHandler;
    private MainView mainView;
    private EventViewController controller;
    private Data data;


    public EventView(SceneHandler sceneHandler, Data data){
        this.sceneHandler = sceneHandler;
        this.mainView = mainView;
        this.controller = new EventViewController();
        this.controller.setTimes();
        this.controller.setPopularity();
        this.data = data;



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
            try {
                this.sceneHandler.toMainView();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });

        place(BackButton,370,-255);

        //Labels

        DynamicTitle title = new DynamicTitle("Event", 40);
        place(title,-300,-220);

        DynamicTitle secondTitle = new DynamicTitle("Add Event", 21);
        place(secondTitle,-300,-150);

        DynamicTitle thirdTitle = new DynamicTitle("All Events", 21);
        place(thirdTitle,110,-150);

        DynamicTitle mainArtist = new DynamicTitle("Main Artist", 17);
        place(mainArtist,-300,-90);

        DynamicTitle coArtist = new DynamicTitle("Co Artist",17);
        place(coArtist,-300,-30);

        DynamicTitle stage = new DynamicTitle("Stage", 17);
        place(stage,-300,30);

        DynamicTitle popularity = new DynamicTitle("Popularity", 17);
        place(popularity,-300,90);

        DynamicTitle Time = new DynamicTitle("Time", 17);
        place(Time,-300,155);

        //Fields
        ComboBox<Artist> mainArtistField = new FPComboBoxArtist("Main Artist");
        place(mainArtistField,-153,-90);
        mainArtistField.setItems(data.getArtists());


        ComboBox<Artist> coArtistField = new FPComboBoxArtist("Co Artist");
        place(coArtistField,-153,-30);
        coArtistField.setItems(data.getArtists());

        ComboBox<Stage> stageField = new FPComboBoxStage("Stage");
        place(stageField,-153,30);
        stageField.setItems(data.getStages());

        ComboBox<String> popularityField = new FPComboBoxString("Popularity %");
        place(popularityField,-153,90);
        popularityField.setItems(this.controller.getPopularity());

        ComboBox<Double> beginTime = new FPComboBoxDouble("Begin time",100,40);
        place(beginTime,-183,155);
        beginTime.setItems(controller.getTimes());

        ComboBox<Double> endTime = new FPComboBoxDouble("End time",100,40);
        place(endTime,-80,155);
        endTime.setItems(controller.getTimes());

        FPButton addEvent = new FPButton("Add ", 90, 35);
        place(addEvent,-50,230);

        ListView<Event> listViewStages = new ListView();
        listViewStages.setItems(data.getEvents());
        place(listViewStages,200,45);
        listViewStages.setMinSize(200,320);
        listViewStages.setMaxSize(200,320);

        addEvent.setOnAction(event -> {

            data.addToEvents(new Event(mainArtistField.getSelectionModel().getSelectedItem().getName(),
                    stageField.getSelectionModel().getSelectedItem().getName(),
                    beginTime.getSelectionModel().getSelectedItem(),
                    endTime.getSelectionModel().getSelectedItem(),
                    popularityField.getSelectionModel().getSelectedItem()));

        });

        FPButton clearButton = new FPButton("Clear All ", 90, 35);
        place(clearButton,-170,230);

        FPButton RemoveArtist = new FPButton("Remove ", 90, 35);
        place(RemoveArtist,310,230);

        RemoveArtist.setOnAction(event -> {
          data.removeEvent(listViewStages.getSelectionModel().getSelectedItem());
        });

        stackPane.getChildren().addAll(title,secondTitle,thirdTitle,mainArtist,coArtist,stage,popularity,listViewStages,Time,mainArtistField,coArtistField,stageField,popularityField,beginTime,endTime,addEvent,RemoveArtist,clearButton,makeLine(),makeLine2());


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



}

