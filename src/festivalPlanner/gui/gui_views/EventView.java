package festivalPlanner.gui.gui_views;

import festivalPlanner.gui.SceneHandler;

import festivalplanner_guiModules.buttons.FPButton;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

public class EventView extends StackPane {

    private SceneHandler sceneHandler;
    private MainView mainView;

    public EventView(SceneHandler sceneHandler){
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


        return stackPane;
    }




}

