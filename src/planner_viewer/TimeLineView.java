package planner_viewer;

import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;

public class TimeLineView extends StackPane {

    public TimeLineView() {

        setMinSize(1280, 690);
        setPrefSize(1280, 690);
        setMaxSize( 1280, 690);


        CanvasDrawer canvasDrawer = new CanvasDrawer();

        getChildren().addAll(canvasDrawer);
        setAlignment(Pos.TOP_LEFT);
    }


}
