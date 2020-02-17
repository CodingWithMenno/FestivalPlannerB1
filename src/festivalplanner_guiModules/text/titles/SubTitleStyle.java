package festivalplanner_guiModules.text.titles;

import javafx.scene.control.Label;

public class SubTitleStyle extends Label {

    public SubTitleStyle(String subTitleText) {

        setText(subTitleText);
        setStyle("-fx-text-fill: #B76F88; " +
                "-fx-font-family: Helvetica; " +
                "-fx-font-size: 18; " +
                "-fx-font-weight: 600;");

    }
}
