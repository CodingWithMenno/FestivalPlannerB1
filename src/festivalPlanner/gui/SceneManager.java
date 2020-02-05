package festivalPlanner.gui;

import festivalPlanner.data_system.DatabaseConnection;
import festivalPlanner.gui.gui_views.LoginView;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneManager extends Application {

    private Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception {

        DatabaseConnection databaseConnection = new DatabaseConnection();
        SceneHandler sceneHandler = new SceneHandler(this, databaseConnection);
        LoginView loginView = new LoginView(sceneHandler, databaseConnection);

        this.stage = primaryStage;

        this.stage.setWidth(1280);
        this.stage.setResizable(false);
        this.stage.setTitle("Festival Planner");

        this.stage.setScene(new Scene(loginView));
        this.stage.show();
    }

    public void setStageScene(Parent sceneParent){
        this.stage.setScene(new Scene(sceneParent));
    }

}
