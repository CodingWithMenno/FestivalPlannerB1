package festivalPlanner.gui.gui_views;

import festivalPlanner.gui.SceneHandler;
import festivalPlanner.gui.SceneManager;
import festivalPlanner.gui.gui_controllers.MainViewController;
import festivalplanner_guiModules.gui_bars.ControllerBar;
import festivalplanner_guiModules.gui_bars.HeaderBar;
import javafx.scene.layout.VBox;
import planner_viewer.TimeLineView;

public class MainView extends VBox {

    private ArtistView artistView;
    private EventView eventView;
    private StageView stageView;
    private MainViewController mainViewController;

    private HeaderBar headerBar;
    private ControllerBar controllerBar;
    private TimeLineView timeLineView;
    private SceneHandler scenehandler;

    public MainView(SceneHandler sceneHandler) {

        this.headerBar = new HeaderBar("");
        this.controllerBar = new ControllerBar();
        this.timeLineView = new TimeLineView();

        this.scenehandler = sceneHandler;

        getChildren().addAll(this.headerBar, this.controllerBar, this.timeLineView);

    }


}
