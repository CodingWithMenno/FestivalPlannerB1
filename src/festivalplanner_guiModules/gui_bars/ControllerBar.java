package festivalplanner_guiModules.gui_bars;

import festivalplanner_guiModules.buttons.FPButton;
import festivalplanner_guiModules.buttons.FPSimulateButton;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.HBox;

public class ControllerBar extends HBox {

    public ControllerBar() {

        setMinSize(1280,70);
        setPrefSize(1280, 70);
        setMaxSize(1280, 70);

        getChildren().addAll(leftSideButtons(), rightSideButtons());

    }

    private Node rightSideButtons() {
        HBox rightSideContainer = new HBox();

        rightSideContainer.setAlignment(Pos.CENTER_RIGHT);
        rightSideContainer.setSpacing(20);
        rightSideContainer.setPadding(new Insets(0,30,0,0));

        rightSideContainer.setPrefSize(640, 70);
        rightSideContainer.setMinSize(640, 70);

        rightSideContainer.getChildren().addAll(
                new FPButton("Artists", 95,45),
                new FPButton("Stages", 95,45),
                new FPButton("Events", 95,45),
                new FPSimulateButton()
        );

        return rightSideContainer;
    }

    private Node leftSideButtons() {
        HBox leftSideContainer = new HBox();

        leftSideContainer.setAlignment(Pos.CENTER_LEFT);
        leftSideContainer.setSpacing(20);
        leftSideContainer.setPadding(new Insets(0,0,0,30));

        leftSideContainer.setPrefSize(640, 70);
        leftSideContainer.setMinSize(640, 70);

        leftSideContainer.getChildren().addAll(
                new FPButton("View", 95,45),
                new FPButton("<", 45,45),
                new FPButton(">", 45,45)
        );

        return leftSideContainer;
    }
}
