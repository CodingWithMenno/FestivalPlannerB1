package festivalplanner_guiModules.buttons;

import javafx.scene.control.Button;

/**
 * Festival Planner start simulation button.
 */
public class FPSimulateButton extends Button implements FPButtons{

    public FPSimulateButton() {

        setText("Simulate");

        defaultStyle();

        setPrefSize(115,45);

        //Set Fixed Button Size boundaries
        setMinSize(115,45);
        setPrefSize(115,45);
        setMaxSize(115,45);

        setOnMousePressed(e -> actionStyle());
        setOnMouseReleased(e -> defaultStyle());

    }

    @Override
    public void actionStyle(){

        setStyle("-fx-background-color: white; " +
                "-fx-text-fill: #B76F88; " +
                "-fx-background-radius: 50; " +
                "-fx-font-size: 15; " +
                "-fx-font-family: trebuchet");
    }

    @Override
    public void defaultStyle(){

        setStyle("-fx-background-color: #B76F88; " +
                "-fx-text-fill: white; " +
                "-fx-background-radius: 50; " +
                "-fx-font-size: 15; " +
                "-fx-font-family: trebuchet");
    }

}
