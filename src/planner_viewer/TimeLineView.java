package planner_viewer;

import festivalPlanner.data_system.*;
import festivalPlanner.gui.SceneHandler;
import festivalPlanner.gui.gui_controllers.TimeLineViewScrollController;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import planner_viewer.planner_modules.EventModule;
import planner_viewer.planner_modules.StageModule;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * this class places events on the timeline.
 */

public class TimeLineView extends StackPane {

    private DatabaseConnection databaseConnection;
    private ArrayList<Stage> stages;
    private ArrayList<Event> events;
    private TimeLineViewScrollController timeLineViewScrollController;
    public Pane sliderContainer;
    private Data data;
    private SceneHandler sceneHandler;


    public TimeLineView(DatabaseConnection databaseConnection, Data data, SceneHandler sceneHandler) throws SQLException {


        this.data = data;
        this.sceneHandler = sceneHandler;

        this.timeLineViewScrollController = new TimeLineViewScrollController(this);

        this.stages = databaseConnection.updateStageTable();

        setMinSize(1280, 690);
        setPrefSize(1280, 690);
        setMaxSize( 1280, 690);

        getChildren().addAll(timeLineSlider(data.getEvents()), stageModuleContainer(data.getStages()),makeStageHbox());
        setAlignment(Pos.TOP_LEFT);
    }

    private Node stageModuleContainer(ObservableList<Stage> stages) {

        VBox container = new VBox();
        container.setLayoutY(42);
        container.setTranslateY(42);
        container.setMinSize(118,690);
        container.setMaxSize(118,690);
        container.setSpacing(10);



        for (Stage stage : stages){
            container.getChildren().add(new StageModule(stage.getName()));
        }

        return container;
    }


    private Node timeLineSlider(ObservableList<Event> events) {
        sliderContainer= new Pane();
        sliderContainer.setLayoutX(150);
        sliderContainer.setTranslateX(150);
        sliderContainer.setPrefSize(2760, 660);
        sliderContainer.setMinSize(2760,660);
        sliderContainer.setMaxSize(2760, 660);
        sliderContainer.setStyle("-fx-background-color: blue");

        //sliderContainer.setAlignment(Pos.TOP_CENTER);
        sliderContainer.getChildren().addAll(new CanvasDrawer(),makeTimeSeparator() );

        for (Event event : events){

            for (Stage stage : data.getStages()){

                if ( event.getStage().equals(stage.getName())){
                    this.sliderContainer.getChildren().add( new EventModule(event.getHeadArtist().getName(), event.getStartTime(), event.getEndTime(), event.getPhotoURL(), data.getStages().indexOf(stage),this.sceneHandler,event));
                }

            }

        }

        return sliderContainer;
    }


    public HBox makeStageHbox(){
        HBox hBox = new HBox();
        hBox.setMaxSize(150,30);
        hBox.setMinSize(150,30);
        hBox.setStyle("-fx-background-color: #B76F88");
        Label label = new Label("Stages / Time");
        label.setStyle(
                "-fx-text-fill: White;" + "-fx-font-size: 17;" +
                        "-fx-font-family: Helvetica;");
        hBox.getChildren().add(label);
        hBox.setAlignment(Pos.CENTER);

        return hBox;
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
