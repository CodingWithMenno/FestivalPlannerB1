package festivalplanner_guiModules.inputfields;

import javafx.geometry.Pos;
import javafx.scene.control.TextField;


public class FPTextField extends TextField implements FPInputFields {

    public FPTextField(String promptText) {

        defaultStyle();

        setAlignment(Pos.CENTER);

        setPromptText(promptText);

        setMinSize(150, 40);
        setPrefSize(150, 40);
        setMaxSize(150, 40);

    }

    public FPTextField(String promptText, int width, int height) {

        defaultStyle();

        setAlignment(Pos.CENTER);

        setPromptText(promptText);

        setMinSize(width, height);
        setPrefSize(width, height);
        setMaxSize(width, height);

    }

    @Override
    public void invalidInputStyle() {

    }

    @Override
    public void defaultStyle() {
        setStyle("-fx-background-color: #EEEEEE; " +
                "-fx-text-fill: #B76F88; " +
                "-fx-background-radius: 50; " +
                "-fx-font-size: 15; " +
                "-fx-font-family: Helvetica; " +
                "-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0 , 0 , 1.5 );");
    }
}

