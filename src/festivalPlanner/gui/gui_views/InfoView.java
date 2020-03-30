package festivalPlanner.gui.gui_views;

import festivalPlanner.data_system.Event;
import festivalPlanner.gui.SceneHandler;
import festivalplanner_guiModules.buttons.showButton;
import festivalplanner_guiModules.text.titles.DynamicTitle;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.sql.SQLException;

/**
 * This class the the makes the info scene, the scene that appears when clicked on an event.
 */

public class InfoView extends StackPane {

    private Event event;
    private SceneHandler sceneHandler;
    private DynamicTitle artist;
    private DynamicTitle coArtistDescription;
    private String beginTime;
    private String endTime;


    public InfoView(Event event, SceneHandler sceneHandler, String beginTime, String endTime) {
        this.event = event;
        this.sceneHandler = sceneHandler;
        this.beginTime = beginTime;
        this.endTime = endTime;

        setWidth(1280);
        setHeight(800);
        setStyle("-fx-background-color: #35477D;" );
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

        Button BackButton = new showButton("X", 30, 30);
        stackPane.getChildren().add(BackButton);
        BackButton.setOnAction(event -> {
            try {
                this.sceneHandler.toMainView();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });

        place(BackButton, 370, -255);

        VBox vBox = new VBox();

        try {
             this.artist = new DynamicTitle(event.getHeadArtist().getName() + " ("+event.getHeadArtist().getAge()+ ")" + " & " +event.getCoArtist().getName()+ " ("+event.getCoArtist().getAge()+ ")", 40);
            place(artist,0,-220);
            stackPane.getChildren().add(artist);
        }catch (Exception e){
            this.artist = new DynamicTitle(event.getHeadArtist().getName() + " ("+event.getHeadArtist().getAge()+ ")", 40);
            place(artist,0,-220);
            stackPane.getChildren().add(artist);
        }

        DynamicTitle time = new DynamicTitle("From " + beginTime + " till " + endTime +"\n--------------------------------" , 21);

        DynamicTitle stage = new DynamicTitle("Stage: " + event.getStage()+"\n--------------------------------", 21);

        DynamicTitle genre = new DynamicTitle("Genre: " + event.getHeadArtist().getGenre()+"\n--------------------------------",21);

        DynamicTitle description = new DynamicTitle(event.getHeadArtist().getName() + ":\n"+event.getHeadArtist().getDescription()+"\n--------------------------------", 17);

        vBox.getChildren().addAll(time,stage,genre,description);

        try {
             this.coArtistDescription = new DynamicTitle(event.getCoArtist().getName()+ ":\n"+event.getCoArtist().getDescription(), 17);
            vBox.getChildren().add(coArtistDescription);
        } catch (Exception e){}

        VBox artistPhoto = makePhoto(event.getPhotoURL());
        place(artistPhoto,200,-70);

        try{
            VBox coArtistPhoto = makePhoto(event.getCoArtist().getArtistPhoto());
            place(coArtistPhoto,200,130);
            stackPane.getChildren().add(coArtistPhoto);
        }catch (Exception e){}

        vBox.setAlignment(Pos.TOP_LEFT);
        place(vBox,50,125);

        stackPane.getChildren().addAll(vBox,makeLine(),makeLine2(),artistPhoto);
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

    public VBox makePhoto(String url){
        VBox photo = new VBox();
        photo.setMaxSize(170,170);
        photo.setMinSize(170,170);

        photo.setStyle("-fx-background-radius: 20; " +
                "-fx-text-fill: #35477D; "+
                "-fx-background-image: url('" + url + "');" +
                "-fx-background-repeat: no-repeat;" +
                "-fx-background-size: cover;" +
                "-fx-background-position: right center;" +
                "-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 10, 0.0 , 4 , 4 );");
        return photo;
    }

}
