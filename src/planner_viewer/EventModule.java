package planner_viewer;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class EventModule extends VBox {

    public EventModule(String eventTitle, String eventTime, double moduleWidth) {

        Label eventTitleLabel = new Label(eventTitle);
        Label eventTimeLabel = new Label(eventTime);

        setStyle("-fx-background-color: #B76F88; " +
                "-fx-background-radius: 20; " +
                "-fx-text-fill: white;");

        setHeight(118);
        setWidth(moduleWidth);

        getChildren().addAll(eventTitleLabel, eventTimeLabel);

        setAlignment(Pos.CENTER_LEFT);
        setPadding(new Insets(0,0,0,10));

    }

}


