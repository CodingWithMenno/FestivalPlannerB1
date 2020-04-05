package festivalPlanner.gui;

import festivalPlanner.data_system.DatabaseConnection;
import festivalPlanner.gui.gui_views.ArtistView;
import festivalPlanner.gui.gui_views.EventView;
import festivalPlanner.gui.gui_views.LoginView;
import festivalPlanner.gui.gui_views.StageView;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * This class is where the program starts when running the program, after this class you will
 * directly go to the login page.
 */

public class StageManager extends Application {

    private Stage stage;


    @Override
    public void start(Stage primaryStage) throws Exception {
        this.stage = primaryStage;

        DatabaseConnection databaseConnection = new DatabaseConnection();
        SceneHandler sceneHandler = new SceneHandler(this, databaseConnection,stage);
        LoginView loginView = new LoginView(sceneHandler, databaseConnection);


        this.stage.setWidth(1280);
        this.stage.setHeight(800);
        this.stage.setResizable(false);
        this.stage.setTitle("Festival Planner");

        this.stage.setScene(new Scene(loginView));
        this.stage.show();
    }

    public void setStageScene(Scene scene){
        this.stage.setScene(scene);
    }

}
