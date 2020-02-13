package festivalPlanner;

import festivalPlanner.gui.StageManager;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Main, this class starts the program
 */

public class Main extends Application {

    public static void main(String[] args) {

        //SceneManager sceneManager = new SceneManager();

        launch(StageManager.class);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {

    }
}
