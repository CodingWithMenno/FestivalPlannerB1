package festivalplanner_guiModules.inputfields;

import javafx.geometry.Pos;
import javafx.scene.control.TextArea;

public class FPTextArea extends TextArea implements FPInputFields {

    public FPTextArea(String promptText) {

        defaultStyle();
        setPromptText(promptText);

        setMinSize(150, 48);
        setPrefSize(150, 100);
        setMaxSize(150, 100);

    }

    public FPTextArea(String promptText, int width, int height) {

        defaultStyle();
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
