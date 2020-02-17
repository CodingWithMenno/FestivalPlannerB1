package festivalplanner_guiModules.buttons;

import javafx.geometry.Pos;
import javafx.scene.control.Button;

/**
 * Custom Festival Planner button
 */

public class showButton extends Button implements FPButtons {

    public showButton(String buttonText, int Width, int Height) {

        setText(buttonText);

        defaultStyle();

        //Set Fixed Button Size boundaries
        setMinSize(Width, Height);
        setPrefSize(Width, Height);
        setMaxSize(Width, Height);

        setOnMousePressed(e -> actionStyle());
        setOnMouseReleased(e -> defaultStyle());

        setAlignment(Pos.CENTER);

    }

    @Override
    public void actionStyle() {

        setStyle("-fx-background-color: #35477D; " +
                "-fx-text-fill: White; " +
                "-fx-background-radius: 50; " +
                "-fx-font-size: 15; " +
                "-fx-font-family: Helvetica;" +
                "-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0 , 0 , 1.5 );");
    }

    @Override
    public void defaultStyle() {

        setStyle("-fx-background-color: #EEEEEE; " +
                "-fx-text-fill: #35477D; " +
                "-fx-background-radius: 50; " +
                "-fx-font-size: 15; " +
                "-fx-font-family: Helvetica;" +
                "-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0 , 0 , 1.5 );");

    }
}
