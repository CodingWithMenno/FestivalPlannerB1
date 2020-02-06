package planner_viewer;

import festivalPlanner.data_system.DatabaseConnection;
import festivalPlanner.data_system.Stage;
import festivalPlanner.gui.gui_controllers.TimeLineViewScrollController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import planner_viewer.planner_modules.StageModule;

import java.sql.SQLException;
import java.util.ArrayList;

public class TimeLineView extends StackPane {

    private DatabaseConnection databaseConnection;
    private ArrayList<Stage> stages;
    private TimeLineViewScrollController timeLineViewScrollController;

    public TimeLineView(DatabaseConnection databaseConnection) throws SQLException {

        this.timeLineViewScrollController = new TimeLineViewScrollController(timeLineSlider());

        this.stages = databaseConnection.updateStageTable();

        setMinSize(1280, 690);
        setPrefSize(1280, 690);
        setMaxSize( 1280, 690);

        getChildren().addAll(timeLineSlider(), stageModuleContainer(this.stages));
        setAlignment(Pos.TOP_LEFT);
    }

    private Node stageModuleContainer(ArrayList<Stage> stages) {

        VBox container = new VBox();
        container.setMinSize(118,690);
        container.setMaxSize(118,690);
        container.setSpacing(10);

        HBox stageContainerLabel = new HBox();


        for (Stage stage : stages){
            container.getChildren().add(new StageModule(stage.getName()));
        }

        return container;
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

    public void scrollLeft(){
        this.timeLineViewScrollController.shiftToLeft();
    }

    public void scrollRight(){
        this.timeLineViewScrollController.shiftToRight();
    }

}
