package festivalplanner_guiModules.gui_bars;

import festivalPlanner.gui.SceneHandler;
import festivalPlanner.gui.gui_controllers.TimeLineViewScrollController;
import festivalplanner_guiModules.buttons.FPButton;
import festivalplanner_guiModules.buttons.FPSimulateButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import planner_viewer.TimeLineView;

import java.sql.SQLException;

public class ControllerBar extends HBox {

    private TimeLineView timeLineView;
    private TimeLineViewScrollController timeLineViewScrollController;
    private SceneHandler sceneHandler;

    public ControllerBar(TimeLineView timeLineView,SceneHandler sceneHandler) {
        this.timeLineView = timeLineView;
        this.sceneHandler = sceneHandler;
        this.timeLineViewScrollController = new TimeLineViewScrollController(this.timeLineView);

        setMinSize(1280,70);
        setPrefSize(1280, 70);
        setMaxSize(1280, 70);

        getChildren().addAll(leftSideButtons(), rightSideButtons());

    }

    private Node rightSideButtons() {
        HBox rightSideContainer = new HBox();

        rightSideContainer.setAlignment(Pos.CENTER_RIGHT);
        rightSideContainer.setSpacing(20);
        rightSideContainer.setPadding(new Insets(0,30,0,0));

        rightSideContainer.setPrefSize(640, 70);
        rightSideContainer.setMinSize(640, 70);

        Button artistButton = new FPButton("Artists", 95,45);
        Button stageButton = new FPButton("Stages", 95,45);
        Button eventButton = new FPButton("Events", 95,45);

        eventButton.setOnAction(event -> {
            this.sceneHandler.toAddEvent();
        });

        stageButton.setOnAction(event -> {
            this.sceneHandler.toAddStage();
        });

        artistButton.setOnAction(event -> {
            this.sceneHandler.toAddArtist();
        });

        rightSideContainer.getChildren().addAll(
                artistButton,
                stageButton,
                eventButton,
                new FPSimulateButton()
        );

        return rightSideContainer;
    }

    private Node leftSideButtons() {
        HBox leftSideContainer = new HBox();

        leftSideContainer.setAlignment(Pos.CENTER_LEFT);
        leftSideContainer.setSpacing(20);
        leftSideContainer.setPadding(new Insets(0,0,0,30));

        leftSideContainer.setPrefSize(640, 70);
        leftSideContainer.setMinSize(640, 70);

        Button rightButton = new FPButton(">", 45,45);
        rightButton.setOnAction(event -> {
            timeLineViewScrollController.shiftToLeft();
        });

        Button leftButton = new FPButton("<", 45,45);
        leftButton.setOnAction(event -> {
            timeLineViewScrollController.shiftToRight();

        });

        leftSideContainer.getChildren().addAll(
                new FPButton("View", 95,45),
                leftButton,
                rightButton
//                new FPButton(">", 45,45)
        );

        return leftSideContainer;
    }
}
