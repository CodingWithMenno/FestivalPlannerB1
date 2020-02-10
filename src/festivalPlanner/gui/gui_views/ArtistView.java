package festivalPlanner.gui.gui_views;

import festivalPlanner.data_system.Artist;
import festivalPlanner.data_system.Data;
import festivalPlanner.gui.SceneHandler;
import festivalPlanner.gui.gui_controllers.ArtistViewController;
import festivalplanner_guiModules.buttons.FPButton;
import festivalplanner_guiModules.inputfields.FPListView;
import festivalplanner_guiModules.inputfields.FPTextArea;
import festivalplanner_guiModules.inputfields.FPTextField;
import festivalplanner_guiModules.text.titles.DynamicTitle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

import java.sql.SQLException;

public class ArtistView extends StackPane {

    private SceneHandler sceneHandler;
    private MainView mainView;
    private FPListView fpListView;
    private  ArtistViewController controller;
    private EventView eventView;
    private ObservableList<Artist> artists;
    private Data data;



    public ArtistView(SceneHandler sceneHandler, EventView eventView, Data data) {
        this.sceneHandler = sceneHandler;
        this.mainView = mainView;
        this.eventView = eventView;
        this.artists = FXCollections.observableArrayList();
        this.data = data;

        setWidth(1280);
        setHeight(800);
        setStyle("-fx-background-color: #35477D;");
        getChildren().add(createStackPane());
    }


    public StackPane createStackPane() {

        StackPane stackPane = new StackPane(); //deze stackpane kun je in bouwen
        stackPane.setMinSize(800, 570);
        stackPane.setMaxSize(800, 570);

        stackPane.setStyle("-fx-background-color: #FFFFFF;" +
                "-fx-background-radius: 30; " +
                "-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 20, 0.0 , 2 , 2 );"
        );

        Button BackButton = new FPButton("X", 30, 30);
        stackPane.getChildren().add(BackButton);
        BackButton.setOnAction(event -> {
            try {
                this.sceneHandler.toMainView();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });

        BackButton.setLayoutX(370);
        BackButton.setLayoutY(-255);
        BackButton.setTranslateX(370);
        BackButton.setTranslateY(-255);

        //labels

        DynamicTitle title = new DynamicTitle("Artist", 40);
        place(title,-300,-220);

        DynamicTitle secondTitle = new DynamicTitle("Add Artist", 21);
        place(secondTitle,-300,-150);

        DynamicTitle thirdTitle = new DynamicTitle("All Artists", 21);
        place(thirdTitle,110,-150);

        DynamicTitle artistName = new DynamicTitle("Artist Name", 17);
        place(artistName,-300,-90);

        DynamicTitle Age = new DynamicTitle("Age",17);
        place(Age,-300,-30);

        DynamicTitle Genre = new DynamicTitle("Genre", 17);
        place(Genre,-300,30);

        DynamicTitle profileImage = new DynamicTitle("Profile Image", 17);
        place(profileImage,-300,90);

        DynamicTitle biography = new DynamicTitle("Biography", 17);
        place(biography,-300,155);

        //Fields

        TextField artistNameField = new FPTextField("Artist Name");
        place(artistNameField,-153,-90);

        TextField ageField = new FPTextField("Age",80,40);
        place(ageField,-153,-30);

        TextField genreField = new FPTextField("Genre");
        place(genreField,-153,30);

        Button open = new FPButton("Open",80,40);
        place(open,-153,90);

        TextArea biographyField = new FPTextArea("Biography",160,80);
        place(biographyField,-153,165);

        FPButton addArtist = new FPButton("Add ", 90, 35);
        place(addArtist,-50,230);

        FPButton clearButton = new FPButton("Clear All ", 90, 35);
        place(clearButton,-170,230);

        FPButton removeArtist = new FPButton("Remove ", 90, 35);
        place(removeArtist,310,230);

        FPListView fpListView = new FPListView("Artist list");
        fpListView.setItems(data.getArtists());
        place(fpListView,250,50);

        stackPane.getChildren().addAll(title,secondTitle,thirdTitle,artistName,artistNameField,Age,fpListView,ageField,Genre,genreField,profileImage,biography,biographyField,open,addArtist,clearButton,removeArtist,makeLine(),makeLine2());

        addArtist.setOnAction(event -> {

            int age = 0;

            try {
                age = Integer.parseInt(ageField.getText());

                Artist artist = new Artist(artistNameField.getText(),
                        age,
                        genreField.getText(),
                        biographyField.getText());

                this.data.addToArtists(artist);

            }
            catch(Exception e) {
                ageField.setText("Error");
            }

        });

        clearButton.setOnAction(event -> {
            artistNameField.setText("");
            ageField.setText("");
            biographyField.setText("");
            genreField.setText("");

        });

        return stackPane;
    }

    private void place(Node node, int x, int y) {
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

