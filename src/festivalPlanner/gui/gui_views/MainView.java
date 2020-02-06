package festivalPlanner.gui.gui_views;

import festivalPlanner.data_system.DatabaseConnection;
import festivalPlanner.gui.SceneHandler;
import festivalPlanner.gui.gui_controllers.MainViewController;
import festivalplanner_guiModules.gui_bars.ControllerBar;
import festivalplanner_guiModules.gui_bars.HeaderBar;
import javafx.scene.layout.VBox;
import planner_viewer.TimeLineView;

import java.sql.SQLException;

public class MainView extends VBox {

    private HeaderBar headerBar;
    private ControllerBar controllerBar;
    private TimeLineView timeLineView;
    private SceneHandler scenehandler;

    public MainView(SceneHandler sceneHandler, DatabaseConnection databaseConnection) throws SQLException {

        this.headerBar = new HeaderBar(databaseConnection.fetchUserOrganization());

        this.timeLineView = new TimeLineView();
        this.scenehandler = sceneHandler;
        this.controllerBar = new ControllerBar(this.timeLineView,this.scenehandler);

        getChildren().addAll(this.headerBar, this.controllerBar, this.timeLineView);

    }


}
