package festivalPlanner.gui;

import festivalPlanner.data_system.Data;
import festivalPlanner.data_system.DatabaseConnection;
import festivalPlanner.data_system.Event;
import festivalPlanner.gui.gui_views.*;
import festivalPlanner.gui.gui_views.SimulationView;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.SQLException;

/**
 * This class can switch between the different views.
 */

public class SceneHandler {

    private Stage stage;
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
    private Data data;


    public SceneHandler(StageManager stageManager, DatabaseConnection databaseConnection,Stage stage) throws SQLException {
        this.stage = stage;
        this.stageManager = stageManager;
        this.databaseConnection = databaseConnection;
        this.data = new Data();


        this.eventView = new EventView(this,data);
        this.stageView = new StageView(this,this.eventView,data);
        this.artistView = new ArtistView(this,this.eventView,data);

        this.ArtistScene = new Scene(artistView);
        this.EventScene = new Scene(eventView);
        this.StageScene = new Scene(stageView);

    }

    public void loginSuccessful() throws SQLException {
        this.mainView = new MainView(this,databaseConnection,this.data);
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

    public void toInfoScene(Event event, String beginTime, String endTime){
        this.stageManager.setStageScene(new Scene(new InfoView(event,this,beginTime,endTime)));
    }

    public void toMainView() throws SQLException {
        this.stage.setWidth(1280);
        this.stage.setHeight(800);
        this.stageManager.setStageScene(new Scene(new MainView(this,databaseConnection,data)));
    }

    public void toSimulationView(){
        this.stageManager.setStageScene(new Scene(new SimulationView(data,this)));

        this.stage.setFullScreen(true);
        this.stage.setMaximized(true);
        this.stage.setWidth(1920);
        this.stage.setHeight(1080);
    }


}
