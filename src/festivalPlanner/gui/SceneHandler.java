package festivalPlanner.gui;

import festivalPlanner.data_system.DatabaseConnection;
import festivalPlanner.gui.gui_views.LoginView;
import festivalPlanner.gui.gui_views.MainView;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class SceneHandler {

    private SceneManager sceneManager;

    public SceneHandler(SceneManager sceneManager) {
        this.sceneManager = sceneManager;
    }

    public void setCurrentScene(Parent sceneParent){
        this.sceneManager.setStageScene(sceneParent);
    }

    public void loginSuccessful(SceneHandler sceneHandler){
        this.sceneManager.setStageScene(new MainView(sceneHandler));
    }
}
