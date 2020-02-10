package planner_viewer.planner_modules;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

//import static com.sun.javafx.scene.control.skin.Utils.getResource;

public class EventModule extends VBox {

    private String backgroundURL;

    public EventModule(String eventTitle, double eventStart, double eventEnd, String backgroundURL, double YPos) {

        this.backgroundURL = backgroundURL;

        String eventStartStr = String.valueOf(eventStart);
        String eventEndStr = String.valueOf(eventEnd);

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

        String url = "https://cdn.vox-cdn.com/thumbor/e5PgdnUTcdfPoXydiBctllA62yA=/0x0:1600x1118/1200x800/filters:focal(672x431:928x687)/cdn.vox-cdn.com/uploads/chorus_image/image/59464313/TimStudio2104_edit.0.jpg";

        this.setStyle("-fx-background-radius: 20; " +
                "-fx-text-fill: #35477D; "+
                "-fx-background-color: Black;"+
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


}}


