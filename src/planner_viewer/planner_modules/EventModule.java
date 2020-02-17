package planner_viewer.planner_modules;

import festivalPlanner.data_system.Event;
import festivalPlanner.gui.SceneHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

/**
 * this class makes the modules on the timeline for the events.
 */

public class EventModule extends VBox {

    private String backgroundURL;
    private SceneHandler sceneHandler;
    private Event mainEvent;

    public EventModule(String eventTitle, double eventStart, double eventEnd, String backgroundURL, double YPos, SceneHandler sceneHandler, Event mainEvent) {

        this.mainEvent = mainEvent;
        this.backgroundURL = backgroundURL;
        this.sceneHandler = sceneHandler;

        String eventStartStr = String.valueOf(eventStart);
        String eventEndStr = String.valueOf(eventEnd);

        if(eventStartStr.length() == 3){
            eventStartStr = "0"+eventStartStr.charAt(0)+":00";
        }
        else if(eventStartStr.length() == 4){
            eventStartStr = eventStartStr.charAt(0) +""+ eventStartStr.charAt(1)+":00";
        }

        if(eventEndStr.length() == 3){
            eventEndStr = "0"+eventEndStr.charAt(0)+":00";
        }
        else if(eventEndStr.length() == 4){
            eventEndStr = eventEndStr.charAt(0) +""+ eventEndStr.charAt(1)+":00";
        }

        double relativeTimePos = ((eventEnd - eventStart)) * 115.0;
        setMinWidth(relativeTimePos);
        setMaxWidth( relativeTimePos);
        setMinHeight(118);
        setMaxHeight(118);

        double relativeStartPos = (eventStart) * 115.0;


        double stageYPos;

        if( YPos == 0){
            stageYPos = 42;
        } else {
            stageYPos = YPos * 10 + YPos * 118 + 42;
        }


        Label eventTitleLabel = new Label(eventTitle);
        Label eventTimeLabel = new Label(eventStartStr + " - " + eventEndStr);

        eventTitleLabel.setStyle("-fx-text-fill: white; -fx-font-size: 20; -fx-font-family: Helvetica; -fx-font-weight: 700");
        eventTimeLabel.setStyle("-fx-text-fill: white; -fx-font-size: 15; -fx-font-family: Helvetica;");


        String url = backgroundURL;

        if(url.equals("")){
            url = "https://upload.wikimedia.org/wikipedia/commons/d/dc/Blue_fade.jpg";
        }



        this.setStyle("-fx-background-radius: 20; " +
                "-fx-text-fill: #35477D; "+
                "-fx-background-color: Blue;"+
                "-fx-background-image: url('" + url + "');" +
                "-fx-background-repeat: no-repeat;" +
                "-fx-background-size: cover;" +
                "-fx-background-position: right center;" +
                "-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 10, 0.0 , 4 , 4 );");


        setTranslateX(relativeStartPos);
        
        setTranslateY(stageYPos);

        getChildren().addAll( eventTitleLabel, eventTimeLabel);

        setAlignment(Pos.CENTER_LEFT);
        setPadding(new Insets(0,0,0,10));

        String finalEventStartStr = eventStartStr;
        String finalEventEndStr = eventEndStr;
        setOnMousePressed(event -> {
            sceneHandler.toInfoScene(this.mainEvent, finalEventStartStr, finalEventEndStr);
        });
}}


