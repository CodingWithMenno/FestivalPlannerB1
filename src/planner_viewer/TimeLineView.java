package planner_viewer;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class TimeLineView extends StackPane {

    public TimeLineView() {

        setMinSize(1280, 690);
        setPrefSize(1280, 690);
        setMaxSize( 1280, 690);

        getChildren().addAll(timeLineSlider());
        setAlignment(Pos.TOP_LEFT);
    }

    private Node timeLineSlider() {
        StackPane sliderContainer = new StackPane();
        sliderContainer.setPrefSize(2760, 660);
        sliderContainer.setMinSize(2760,660);
        sliderContainer.setMaxSize(2760, 660);
        sliderContainer.setStyle("-fx-background-color: blue");

        sliderContainer.setAlignment(Pos.TOP_CENTER);
        sliderContainer.getChildren().addAll(new CanvasDrawer(),makeHboxWithTimeNumber() );


        return sliderContainer;
    }

    public HBox makeHboxWithTimeNumber(){
        HBox hBox = new HBox();
        hBox.setLayoutX(50);
        hBox.setTranslateX(50);
        hBox.setLayoutY(4);
        hBox.setTranslateY(4);
        hBox.setMaxSize(2760,30);
        hBox.setMinSize(2760,30);
        hBox.setSpacing(98);

        for(int i = 0; i<10;i++){
            Label label = new Label("0"+i);
            label.setFont(Font.font(15));
            label.setAlignment(Pos.CENTER);
            label.setTextFill(Color.WHITE);
            hBox.getChildren().add(label);

        }
        for(int i = 10; i<24;i++){
            Label label = new Label(""+i);
            label.setFont(Font.font(15));
            label.setAlignment(Pos.CENTER);
            label.setTextFill(Color.WHITE);
            hBox.getChildren().add(label);
        }

        return hBox;
    }


}
