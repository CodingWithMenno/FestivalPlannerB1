package planner_viewer.planner_modules;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class StageModule extends HBox {

    private Label stageTitle;

    public StageModule(String stageTitle) {

        this.stageTitle = new Label(stageTitle);

        setMinSize(150,118);
        setPrefSize(150, 118);
        setMaxSize(150,118);

        setStyle("-fx-background-color: #35477D; " +
                "-fx-background-radius: 0 20 20 0; " +
                "-fx-text-fill: white;");

        getChildren().add(this.stageTitle);

        setAlignment(Pos.CENTER);

    }

}
