package festivalplanner_guiModules.text.titles;

import javafx.scene.control.Label;

public class TitleTextStyle extends Label {

    public TitleTextStyle(String titleText) {

        setText(titleText);
        setStyle("-fx-text-fill: #35477D; " +
                "-fx-font-family: Helvetica; " +
                "-fx-font-size: 24; " +
                "-fx-font-weight: 800");
    }
}
