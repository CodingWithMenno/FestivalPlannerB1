package festivalPlanner.gui.gui_views;

import festivalPlanner.gui.SceneHandler;
import festivalPlanner.gui.gui_controllers.StageViewController;
import festivalplanner_guiModules.buttons.FPButton;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

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
        setCordinate(-280, -60, stageName);
        TextField nameField = new TextField();
        nameField.setMinWidth(200);
        nameField.setMaxWidth(200);
        setCordinate(-100, -60, nameField);
        stackPane.getChildren().addAll(stageName, nameField);

        Label capacityLabel = new Label("Capacity");
        setCordinate(-280, -20, capacityLabel);
        TextField capacityField = new TextField();
        setCordinate(-100, -20, capacityField);
        capacityField.setMinWidth(200);
        capacityField.setMaxWidth(200);
        stackPane.getChildren().addAll(capacityLabel, capacityField);

        Label indoorLabel = new Label("Indoor");
        setCordinate(-280, 20, indoorLabel);
        RadioButton indoorButton = new RadioButton();
        setCordinate(-185, 20, indoorButton);
        stackPane.getChildren().addAll(indoorLabel, indoorButton);

        Label emergencyLabel = new Label("Emergency Exits");
        setCordinate(-280, 60, emergencyLabel);
        TextField emergencyText = new TextField();
        setCordinate(-100, 60, emergencyText);
        emergencyText.setMinWidth(200);
        emergencyText.setMaxWidth(200);
        stackPane.getChildren().addAll(emergencyLabel, emergencyText);

        Label firstAidLabel = new Label("First Aid Kits");
        setCordinate(-280, 100, firstAidLabel);
        TextField firstAidText = new TextField();
        setCordinate(-100, 100, firstAidText);
        firstAidText.setMinWidth(200);
        firstAidText.setMaxWidth(200);
        stackPane.getChildren().addAll(firstAidLabel, firstAidText);

        Button addButton = new Button("Add");
        setCordinate(0, 225, addButton);
        stackPane.getChildren().addAll(addButton);

        VBox verticalLine = new VBox();
        stackPane.getChildren().addAll(verticalLine);
        verticalLine.setStyle("-fx-background-color: #EEEEEE;");
        verticalLine.setMinSize(5, 350);
        verticalLine.setMaxSize(5, 350);
        setCordinate(100, 70, verticalLine);

        Label allStages = new Label("All Stages");
        setCordinate(200, -135, allStages);
        stackPane.getChildren().addAll(allStages);

        Button removeButton = new Button("Remove");
        setCordinate(200, 225, removeButton);
        stackPane.getChildren().addAll(removeButton);

        return stackPane;
    }

    private void setCordinate(int x, int y, Node node) {
        node.setLayoutX(x);
        node.setLayoutY(y);
        node.setTranslateX(x);
        node.setTranslateY(y);
    }
}
