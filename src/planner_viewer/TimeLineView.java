package planner_viewer;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class TimeLineView extends StackPane {

    public TimeLineView() {

        setMinSize(1280, 690);
        setPrefSize(1280, 690);
        setMaxSize( 1280, 690);

        getChildren().addAll(timeLineSlider());
        //setAlignment(Pos.TOP_LEFT);
    }

    private Node timeLineSlider() {
        StackPane sliderContainer = new StackPane();
        sliderContainer.setPrefSize(2760, 660);
        sliderContainer.setMinSize(2760,660);
        sliderContainer.setMaxSize(2760, 660);
        sliderContainer.setStyle("-fx-background-color: blue");

        sliderContainer.getChildren().addAll(new CanvasDrawer());

        return sliderContainer;
    }


}
