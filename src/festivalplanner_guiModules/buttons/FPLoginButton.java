package festivalplanner_guiModules.buttons;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;

/**
 *  Festival Planner login button.
 */
public class FPLoginButton extends Button implements FPButtons {

    public FPLoginButton() {

        setText("Login");

        defaultStyle();

        //Set Fixed Button Size boundaries
        setMinSize(306,48);
        setPrefSize(306,48);
        setMaxSize(306,48);

        setOnMousePressed(e -> actionStyle());
        setOnMouseReleased(e -> defaultStyle());

        setAlignment(Pos.CENTER);

    }


    @Override
    public void actionStyle(){

        setStyle("-fx-background-color: white; " +
                "-fx-text-fill: #B76F88; " +
                "-fx-background-radius: 50; " +
                "-fx-font-size: 18; " +
                "-fx-font-family: Helvetica");

    }

    @Override
    public void defaultStyle(){

        setStyle("-fx-background-color: #B76F88; " +
                "-fx-text-fill: white; " +
                "-fx-background-radius: 50; " +
                "-fx-font-size: 18; " +
                "-fx-font-family: Helvetica");

    }

}
