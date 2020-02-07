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

    @Override
    public void invalidInputStyle() {

    }

    @Override
    public void defaultStyle() {

    }
}
