package planner_viewer.planner_modules;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class StageModule extends HBox {

    /**
     * this class makes the modules on the timeline for the stages.
     */

    private Label stageTitle;

    public StageModule(String stageTitle) {

        this.stageTitle = new Label(stageTitle);

        this.stageTitle.setStyle(
                "-fx-text-fill: White;" +
                "-fx-font-size: 17;" +
                "-fx-font-family: Helvetica;");

        setMinSize(150,118);
        setPrefSize(150, 118);
        setMaxSize(150,118);

        setStyle("-fx-background-color: #35477D;");

        getChildren().add(this.stageTitle);

        setAlignment(Pos.CENTER);

    }

}
