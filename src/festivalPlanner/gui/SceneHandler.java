package festivalPlanner.gui;

import festivalPlanner.data_system.DatabaseConnection;
import festivalPlanner.gui.gui_views.ArtistView;
import festivalPlanner.gui.gui_views.EventView;
import festivalPlanner.gui.gui_views.MainView;
import festivalPlanner.gui.gui_views.StageView;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.sql.SQLException;

public class SceneHandler {

    private StageManager stageManager;
    private DatabaseConnection databaseConnection;
    private ArtistView artistView;
    private EventView eventView;
    private StageView stageView;
    private MainView mainView;
    private Scene ArtistScene;
    private Scene EventScene;
    private Scene StageScene;
    private Scene MainScene;


    public SceneHandler(StageManager stageManager, DatabaseConnection databaseConnection) throws SQLException {
        this.stageManager = stageManager;
        this.databaseConnection = databaseConnection;

        this.eventView = new EventView(this);
        this.stageView = new StageView(this,this.eventView);
        this.artistView = new ArtistView(this,this.eventView);

        this.ArtistScene = new Scene(artistView);
        this.EventScene = new Scene(eventView);
        this.StageScene = new Scene(stageView);

    }

    public void loginSuccessful() throws SQLException {
        this.mainView = new MainView(this,databaseConnection);
        this.MainScene = new Scene(mainView);
        this.stageManager.setStageScene(MainScene);
    }

    public void toAddEvent(){
        this.stageManager.setStageScene(EventScene);
    }

    public void toAddArtist(){
        this.stageManager.setStageScene(ArtistScene);
    }

    public void toAddStage(){
        this.stageManager.setStageScene(StageScene);
    }

    public void toMainView(){
        this.stageManager.setStageScene(MainScene);
    }


}
