package festivalPlanner.gui;

import festivalPlanner.data_system.DatabaseConnection;
import festivalPlanner.gui.gui_views.MainView;
import javafx.scene.Parent;

import java.sql.SQLException;

public class SceneHandler {

    private SceneManager sceneManager;
    private DatabaseConnection databaseConnection;

    public SceneHandler(SceneManager sceneManager, DatabaseConnection databaseConnection) {
        this.sceneManager = sceneManager;
        this.databaseConnection = databaseConnection;
    }

    public void setCurrentScene(Parent sceneParent){
        this.sceneManager.setStageScene(sceneParent);
    }

    public void loginSuccessful(SceneHandler sceneHandler) throws SQLException {
        this.sceneManager.setStageScene(new MainView(sceneHandler, this.databaseConnection));
    }
}
