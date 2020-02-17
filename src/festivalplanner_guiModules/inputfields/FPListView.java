package festivalplanner_guiModules.inputfields;

import festivalPlanner.data_system.Artist;
import festivalPlanner.data_system.Stage;
import javafx.geometry.Pos;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

public class FPListView extends ListView<Stage>  {

    public FPListView() {

        defaultStyle();

        setMinSize(200, 48);
        setPrefSize(200, 150);
        setMaxSize(200, 300);

    }
    public void invalidInputStyle() {

    }


    public void defaultStyle() {

        setStyle("-fx-background-color: #FFFFFF; " +
                "-fx-text-fill: #B76F88; " +
                "-fx-font-size: 15; " +
                "-fx-font-family: Helvetica; ");
    }
}
