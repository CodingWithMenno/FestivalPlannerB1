package festivalPlanner;

import festivalplanner_guiModules.gui_bars.ControllerBar;
import festivalplanner_guiModules.gui_bars.HeaderBar;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import planner_viewer.CanvasDrawer;

public class Main extends Application {

    public static void main(String[] args) {

        launch(Main.class);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setHeight(800);
        primaryStage.setWidth(1280);
        primaryStage.setResizable(false);
        primaryStage.setTitle("test_page");

        VBox blah = new VBox();
        blah.getChildren().addAll(new HeaderBar("Woohah! Festival"), new ControllerBar(), new CanvasDrawer());

        Scene testView = new Scene(blah);

        primaryStage.setScene(testView);
        primaryStage.show();
    }
}
