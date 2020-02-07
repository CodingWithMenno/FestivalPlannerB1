package festivalplanner_guiModules.inputfields;

import javafx.geometry.Pos;
import javafx.scene.control.TextField;


public class FPTextField extends TextField implements FPInputFields {

    public FPTextField(String promptText) {

        defaultStyle();

        setAlignment(Pos.CENTER);

        setPromptText(promptText);

        setMinSize(150,48);
        setPrefSize(150,48);
        setMaxSize(150,48);

    }

    @Override
    public void invalidInputStyle() {

    }

    @Override
    public void defaultStyle() {

    }
}
