package festivalplanner_guiModules.inputfields;

import javafx.geometry.Pos;
import javafx.scene.control.TextField;

public class FPUsernameField extends TextField implements FPInputFields {

    public FPUsernameField() {

        defaultStyle();

        setAlignment(Pos.CENTER);

        setPromptText("Username");

        setMinSize(306,48);
        setPrefSize(306,48);
        setMaxSize(306,48);
    }

    @Override
    public void defaultStyle() {

        setStyle("-fx-background-color: #FFFFFF; " +
                "-fx-text-fill: #B76F88; " +
                "-fx-background-radius: 50; " +
                "-fx-font-size: 15; " +
                "-fx-font-family: Helvetica;");
    }

    @Override
    public void invalidInputStyle() {

    }
}
