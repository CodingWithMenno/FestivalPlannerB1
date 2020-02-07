package planner_viewer.planner_modules;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import static com.sun.javafx.scene.control.skin.Utils.getResource;

public class EventModule extends VBox {

    private String backgroundURL;

    public EventModule(String eventTitle, double eventStart, double eventEnd, String backgroundURL, double YPos) {

        this.backgroundURL = backgroundURL;

        String eventStartStr = String.valueOf(eventStart);
        String eventEndStr = String.valueOf(eventEnd);

        double relativeTimePos = ((eventEnd - eventStart) / 100.0) * 115.0;
        setMinWidth(relativeTimePos);
        setMaxWidth( relativeTimePos);
        setMinHeight(118);
        setMaxHeight(118);

        double relativeStartPos = (eventStart / 100.0) * 115.0;


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

        String url = this.backgroundURL;

        this.setStyle("-fx-background-radius: 20; " +
                "-fx-text-fill: #35477D; "+
                "-fx-background-image: url('" + url + "');" +
                "-fx-background-repeat: no-repeat;" +
                "-fx-background-size: cover;" +
                "-fx-background-position: right center;" +
                "-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 10, 0.0 , 4 , 4 );");


        //ImagePattern pattern = new ImagePattern(new Image( this.backgroundURL , 1024, 800, true, true));

        //rectangle.setFill(pattern);

        //setLayoutX(relativeStartPos);
        setTranslateX(relativeStartPos);

        //setLayoutY(stageYPos);
        setTranslateY(stageYPos);

        getChildren().addAll( eventTitleLabel, eventTimeLabel);

        setAlignment(Pos.CENTER_LEFT);
        setPadding(new Insets(0,0,0,10));
//
//        Image bgPicture = new Image(this.backgroundURL, 1600, 1200,true,true);


//        BackgroundImage backgroundImage = new BackgroundImage(
//                new Image(this.backgroundURL, 1600, 1068, true, true),
//                BackgroundRepeat.NO_REPEAT,
//                BackgroundRepeat.NO_REPEAT,
//                new BackgroundPosition(Side.LEFT, 0,false, Side.TOP,0,false),
//                new BackgroundSize(100,100,true,true,false, true));
//
//        this.setBackground(new Background(backgroundImage));
//        this.setBackground(new Background(backgroundImage));


        //setBackground(new Background(backgroundImage()));

    }

//    private BackgroundImage backgroundImage(){
//
//        BackgroundImage backgroundImage = new BackgroundImage(
//                new Image("/media_resources/loginscreenbg.jpeg", 1600, 1068, true, true),
//                BackgroundRepeat.NO_REPEAT,
//                BackgroundRepeat.NO_REPEAT,
//                new BackgroundPosition(Side.RIGHT, 30,false, Side.TOP,-75,false),
//                new BackgroundSize(1600,1068,false,false,false, false));
//
//        //this.setBackground(new Background(backgroundImage));
//
//        return backgroundImage;
//    }

}


