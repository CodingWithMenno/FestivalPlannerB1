package festivalplanner_guiModules.text.titles;

import javafx.scene.control.Label;

public class Logo extends Label {

    public Logo(String text) {

        setText(text);
        setStyle("-fx-text-fill: #FFFFFF; " +
                "-fx-font-family: Helvetica;" +
                "-fx-font-size: 70; " +
                "-fx-font-weight: 900;");
    }

}
