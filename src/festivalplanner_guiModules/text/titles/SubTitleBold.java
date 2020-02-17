package festivalplanner_guiModules.text.titles;

import javafx.scene.control.Label;

public class SubTitleBold extends Label {

    public SubTitleBold(String text) {

        setText(text);
        setStyle("-fx-text-fill: #FFFFFF; " +
                "-fx-font-family: Helvetica;" +
                "-fx-font-size: 40; " +
                "-fx-font-weight: 900;");
    }

}
