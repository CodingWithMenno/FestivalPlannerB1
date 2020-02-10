package festivalplanner_guiModules.text.titles;


import javafx.geometry.Pos;
import javafx.scene.control.Label;

public class DynamicTitle extends Label {

    public DynamicTitle(String titleText, int fontSize) {
        setText(titleText);
        setStyle("-fx-text-fill: #35477D; " +
                "-fx-font-family: Helvetica; " +
                "-fx-font-size: "+fontSize+"; " +
                "-fx-font-weight: 800");
    }
}
