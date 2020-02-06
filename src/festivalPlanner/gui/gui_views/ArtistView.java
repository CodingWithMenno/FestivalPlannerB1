package festivalPlanner.gui.gui_views;

import festivalPlanner.gui.SceneHandler;
import festivalPlanner.gui.gui_controllers.ArtistViewController;
import festivalplanner_guiModules.buttons.FPButton;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

public class ArtistView extends StackPane {

    private SceneHandler sceneHandler;
    private MainView mainView;

    public ArtistView(SceneHandler sceneHandler){
        this.sceneHandler = sceneHandler;
        this.mainView = mainView;

        setWidth(1280);
        setHeight(800);
        setStyle("-fx-background-color: #35477D");
        getChildren().add(createStackPane());
    }

    public StackPane createStackPane(){

        StackPane stackPane = new StackPane();
        stackPane.setMinSize(800,570);
        stackPane.setMaxSize(800,570);

        stackPane.setStyle("-fx-background-color: #FFFFFF;" +
                "-fx-background-radius: 30; "
        );

        Button BackButton = new FPButton("Back",95,45);
        stackPane.getChildren().add(BackButton);
        BackButton.setOnAction(event -> {
            this.sceneHandler.toMainView();
        });
        return stackPane;
    }
}
