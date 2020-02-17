package festivalplanner_guiModules.inputfields;

import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;

public class FPCheckBox extends CheckBox {

    public FPCheckBox() {

        defaultStyle();
        setAlignment(Pos.CENTER);

    }

    public void defaultStyle() {
        setStyle("-fx-font-size: 20; ");
    }
}

