package planner_viewer;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
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
        sliderContainer.getChildren().addAll(new CanvasDrawer(),makeTimeSeparator() );


        return sliderContainer;
    }

    private Node makeTimeSeparator(){
        GridPane timeSeparator = new GridPane();
//        hBox.setLayoutX(50);
//        hBox.setTranslateX(50);
//        hBox.setLayoutY(4);
//        hBox.setTranslateY(4);
        timeSeparator.setMaxSize(2760,30);
        timeSeparator.setMinSize(2760,30);

        timeSeparator.setPadding(new Insets(5,0,0,0));

        for(int i = 0; i<10;i++){
            Label label = new Label("0"+i);
            label.setFont(Font.font(15));
            label.setAlignment(Pos.CENTER);
            label.setTextFill(Color.WHITE);
            label.setPadding(new Insets(0,0,0,49));

            timeSeparator.addColumn(i,label);
            timeSeparator.getColumnConstraints().add(new ColumnConstraints(115));
            //timeSeparator.getChildren().add(label);

        }
        for(int i = 10; i<24;i++){
            Label label = new Label(""+i);
            label.setFont(Font.font(15));
            label.setAlignment(Pos.CENTER);
            label.setTextFill(Color.WHITE);

            timeSeparator.addColumn(i,label);
            timeSeparator.getColumnConstraints().add(new ColumnConstraints(115));
            label.setPadding(new Insets(0,0,0,49));
        }

        return timeSeparator;
    }


}
