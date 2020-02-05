package festivalPlanner.gui;

import festivalPlanner.gui.gui_views.LoginView;
import festivalPlanner.gui.gui_views.MainView;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import planner_viewer.TimeLineView;

public class SceneManager extends Application {

    private Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception {

        SceneHandler sceneHandler = new SceneHandler(this);
        LoginView loginView = new LoginView(sceneHandler);

        this.stage = primaryStage;

        this.stage.setWidth(1280);
        this.stage.setResizable(false);
        this.stage.setTitle("Festival Planner");

        this.stage.setScene(new Scene(loginView));
        this.stage.show();
    }


    public void loginSuccesful(){
        this.stage.setScene(new Scene(new TimeLineView()));
    }

    public void setStageScene(Parent sceneParent){
        this.stage.setScene(new Scene(sceneParent));
    }

}
