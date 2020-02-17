package festivalplanner_guiModules.buttons;

import festivalPlanner.data_system.DatabaseConnection;
import festivalPlanner.gui.gui_views.LoginView;
import festivalplanner_guiModules.inputfields.FPPasswordField;
import festivalplanner_guiModules.inputfields.FPUsernameField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;

import java.sql.SQLException;

/**
 * Custom Festival Planner login button.
 */
public class FPLoginButton extends Button implements FPButtons {

    public FPLoginButton(LoginView parent, FPUsernameField username, FPPasswordField password, DatabaseConnection databaseConnection) {

        setText("Login");

        defaultStyle();

        //Set Fixed Button Size boundaries
        setMinSize(110, 48);
        setPrefSize(110, 48);
        setMaxSize(110, 48);

        setOnMousePressed(e -> actionStyle());
        setOnMouseReleased(e -> defaultStyle());

        setAlignment(Pos.CENTER);

        if (!databaseConnection.connectionStatus()) {
            setDisable(true);
            username.setDisable(true);
            password.setDisable(true);
        }

        setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("login tried");

                try {
                    if (databaseConnection.validateUser(username.getText(), password.getText())) {
                        System.out.println("Success");

                        parent.loginSuccessful();
                    } else {
                        System.out.println("Failed");
                        username.invalidInputStyle();
                        password.invalidInputStyle();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        });

    }


    @Override
    public void actionStyle() {

        setStyle("-fx-background-color: white; " +
                "-fx-text-fill: #B76F88; " +
                "-fx-background-radius: 50; " +
                "-fx-font-size: 18; " +
                "-fx-font-family: Helvetica;" +
                "-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0 , 0 , 1.5 );");

    }

    @Override
    public void defaultStyle() {

        setStyle("-fx-background-color: #B76F88; " +
                "-fx-text-fill: white; " +
                "-fx-background-radius: 50; " +
                "-fx-font-size: 18; " +
                "-fx-font-family: Helvetica;" +
                "-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0 , 0 , 1.5 );");

    }

}
