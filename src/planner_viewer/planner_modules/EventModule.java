package planner_viewer.planner_modules;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class EventModule extends VBox {

    private String backgroundURL;

    public EventModule(String eventTitle, int eventStart, int eventEnd, String backgroundURL) {

        this.backgroundURL = backgroundURL;

        String eventStartStr = String.valueOf(eventStart);
        String eventEndStr = String.valueOf(eventEnd);

        Label eventTitleLabel = new Label(eventTitle);
        Label eventTimeLabel = new Label(eventStartStr + " - " + eventEndStr);

        setStyle("-fx-background-color: #B76F88; " +
                "-fx-background-radius: 20; " +
                "-fx-text-fill: white;");

        setHeight(118);
        setWidth((eventEnd - eventStart) / 100);

        getChildren().addAll(eventTitleLabel, eventTimeLabel);

        setAlignment(Pos.CENTER_LEFT);
        setPadding(new Insets(0,0,0,10));

    }

    private BackgroundImage backgroundImage(){

        BackgroundImage backgroundImage = new BackgroundImage(
                new Image(this.backgroundURL, 1600, 1068, true, true),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                new BackgroundPosition(Side.RIGHT, 30,false, Side.TOP,-75,false),
                new BackgroundSize(1600,1068,false,false,false, false));

        this.setBackground(new Background(backgroundImage));

    }

}


