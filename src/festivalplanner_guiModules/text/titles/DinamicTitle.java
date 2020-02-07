package festivalplanner_guiModules.text.titles;


import javafx.scene.control.Label;

public class DinamicTitle extends Label {

    public DinamicTitle (String titleText, int fontSize) {

        setText(titleText);
        setStyle("-fx-text-fill: #35477D; " +
                "-fx-font-family: Helvetica; " +
                "-fx-font-size: "+fontSize+"; " +
                "-fx-font-weight: 800");
    }
}
