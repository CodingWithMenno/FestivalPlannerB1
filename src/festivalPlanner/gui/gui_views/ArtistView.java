package festivalPlanner.gui.gui_views;

import festivalPlanner.data_system.Artist;
import festivalPlanner.data_system.Event;
import festivalPlanner.data_system.Stage;
import festivalPlanner.gui.SceneHandler;
import festivalPlanner.gui.gui_controllers.ArtistViewController;
import festivalplanner_guiModules.buttons.FPButton;
import festivalplanner_guiModules.inputfields.FPCheckBox;
import festivalplanner_guiModules.inputfields.FPListView;
import festivalplanner_guiModules.inputfields.FPTextArea;
import festivalplanner_guiModules.inputfields.FPTextField;
import festivalplanner_guiModules.text.titles.DinamicTitle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

public class ArtistView extends StackPane {

    private SceneHandler sceneHandler;
    private MainView mainView;
    private FPListView fpListView;
    private  ArtistViewController controller;
    private EventView eventView;
    private ObservableList<Artist> artists;


    public ArtistView(SceneHandler sceneHandler, EventView eventView) {
        this.sceneHandler = sceneHandler;
        this.mainView = mainView;
        this.eventView = eventView;
        this.artists = FXCollections.observableArrayList();


        setWidth(1280);
        setHeight(800);
        setStyle("-fx-background-color: #35477D;");
        getChildren().add(createStackPane());
    }

    public FPListView getFpListView() {
        return fpListView;
    }

    public void setListView(ObservableList list) {
        this.fpListView.setItems(list);
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
            this.sceneHandler.toMainView();
        });

        BackButton.setLayoutX(370);
        BackButton.setLayoutY(-255);
        BackButton.setTranslateX(370);
        BackButton.setTranslateY(-255);

        //labels

        DinamicTitle title = new DinamicTitle("Artist", 40);
        place(title,-300,-220);

        DinamicTitle secondTitle = new DinamicTitle("Add Artist", 21);
        place(secondTitle,-300,-150);

        DinamicTitle thirdTitle = new DinamicTitle("All Artists", 21);
        place(thirdTitle,110,-150);

        DinamicTitle artistName = new DinamicTitle("Artist Name", 17);
        place(artistName,-300,-90);

        DinamicTitle Age = new DinamicTitle("Age",17);
        place(Age,-300,-30);

        DinamicTitle Genre = new DinamicTitle("Genre", 17);
        place(Genre,-300,30);

        DinamicTitle profileImage = new DinamicTitle("Profile Image", 17);
        place(profileImage,-300,90);

        DinamicTitle biography = new DinamicTitle("Biography", 17);
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

        this.fpListView = new FPListView("Artist list");
        place(fpListView,250,50);

        this.controller = new ArtistViewController(this.fpListView);

        stackPane.getChildren().addAll(title,secondTitle,thirdTitle,artistName,artistNameField,Age,fpListView,ageField,Genre,genreField,profileImage,biography,biographyField,open,addArtist,clearButton,removeArtist,makeLine(),makeLine2());

        addArtist.setOnAction(event -> {

            int age = 0;

            try {
                age = Integer.parseInt(ageField.getText());

                Artist artist = new Artist(artistNameField.getText(),
                        age,
                        genreField.getText(),
                        biographyField.getText());

                this.eventView.addArtistToList(artist);
                this.controller.addArtist(artist);

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

        removeArtist.setOnAction(event -> this.controller.deleteArtist(fpListView.getSelectionModel().getSelectedItem()));
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

