package festivalPlanner.gui.gui_views;

import festivalPlanner.data_system.Data;
import festivalPlanner.data_system.DatabaseConnection;
import festivalPlanner.gui.SceneHandler;
import festivalplanner_guiModules.gui_bars.ControllerBar;
import festivalplanner_guiModules.gui_bars.HeaderBar;
import javafx.scene.layout.VBox;
import planner_viewer.TimeLineView;

import java.sql.SQLException;

/**
 * This is the main view. Here you can see the agenda of all the stages, events and artists.
 */

public class MainView extends VBox {

    private HeaderBar headerBar;
    private ControllerBar controllerBar;
    private TimeLineView timeLineView;
    private SceneHandler scenehandler;

    public MainView(SceneHandler sceneHandler, DatabaseConnection databaseConnection, Data data) throws SQLException {

        this.headerBar = new HeaderBar(databaseConnection.fetchUserOrganization());

        this.timeLineView = new TimeLineView(databaseConnection,data,sceneHandler);
        this.scenehandler = sceneHandler;
        this.controllerBar = new ControllerBar(this.timeLineView,this.scenehandler);

        getChildren().addAll(this.headerBar, this.controllerBar, this.timeLineView);

    }


}
