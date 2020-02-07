package festivalPlanner.gui.gui_views;

import festivalPlanner.gui.SceneHandler;
import festivalPlanner.gui.gui_controllers.StageViewController;
import festivalplanner_guiModules.buttons.FPButton;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

public class StageView extends StackPane{

    private SceneHandler sceneHandler;
    private MainView mainView;

    public StageView(SceneHandler sceneHandler){
        this.sceneHandler = sceneHandler;
        this.mainView = mainView;

        setWidth(1280);
        setHeight(800);
        setStyle("-fx-background-color: #35477D;" );
        getChildren().add(createStackPane());
    }

    public StackPane createStackPane(){

        StackPane stackPane = new StackPane(); //deze stackpane kun je in bouwen
        stackPane.setMinSize(800,570);
        stackPane.setMaxSize(800,570);

        stackPane.setStyle("-fx-background-color: #FFFFFF;" +
                "-fx-background-radius: 30; " +
                "-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 20, 0.0 , 2 , 2 );"
        );

        Button BackButton = new FPButton("X",30,30);
        stackPane.getChildren().add(BackButton);
        BackButton.setOnAction(event -> {
            this.sceneHandler.toMainView();
        });

        BackButton.setLayoutX(370);
        BackButton.setLayoutY(-255);
        BackButton.setTranslateX(370);
        BackButton.setTranslateY(-255);

        Label title = new Label("Stages");
        stackPane.getChildren().add(title);
        setCordinate(-280, -175, title);

        HBox horizontalLine = new HBox();
        stackPane.getChildren().add(horizontalLine);
        horizontalLine.setStyle("-fx-background-color: #EEEEEE;");
        horizontalLine.setMinSize(700, 5);
        horizontalLine.setMaxSize(700, 5);
        setCordinate(0, -160, horizontalLine);

        Label addStage = new Label("Add Stage");
        stackPane.getChildren().add(addStage);
        setCordinate(-280, -135, addStage);

        Label stageName = new Label("Stage Name");
        setCordinate(-280, -90, stageName);
        TextField nameField = new TextField();
        nameField.setMinWidth(200);
        nameField.setMaxWidth(200);
        setCordinate(-100, -90, nameField);
        stackPane.getChildren().addAll(stageName, nameField);



        return stackPane;
    }

    private void setCordinate(int x, int y, Node node) {
        node.setLayoutX(x);
        node.setLayoutY(y);
        node.setTranslateX(x);
        node.setTranslateY(y);
    }
}
