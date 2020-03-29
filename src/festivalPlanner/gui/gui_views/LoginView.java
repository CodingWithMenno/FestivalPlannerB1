package festivalPlanner.gui.gui_views;

import festivalPlanner.data_system.DatabaseConnection;
import festivalPlanner.gui.SceneHandler;
import festivalplanner_guiModules.buttons.FPLoginButton;
import festivalplanner_guiModules.inputfields.FPPasswordField;
import festivalplanner_guiModules.inputfields.FPUsernameField;
import festivalplanner_guiModules.text.titles.Logo;
import festivalplanner_guiModules.text.titles.SubTitleBold;
import festivalplanner_guiModules.text.titles.SubTitleStyle;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;

import java.sql.SQLException;

/**
 * When starting the application you start at this class. Here you need to login with a username and password
 * which are stored in a database.
 */

public class LoginView extends StackPane {

    private SceneHandler sceneHandler;

    public LoginView(SceneHandler sceneHandler, DatabaseConnection databaseConnection) {

        this.sceneHandler = sceneHandler;

        this.setMinSize(1280,800);
        this.setPrefSize(1280, 800);
        this.setMaxSize(1280,800);

        BackgroundImage backgroundImage = new BackgroundImage(
                new Image("/media_resources/loginscreenbg.jpeg", 1600, 1068, true, true),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                new BackgroundPosition(Side.RIGHT, 30,false, Side.TOP,-75,false),
                new BackgroundSize(1600,1068,false,false,false, false));

        this.setBackground(new Background(backgroundImage));

        VBox loginFields = new VBox();
        loginFields.setMinSize(360,800);
        loginFields.setMaxSize(360,800);

        loginFields.setAlignment(Pos.TOP_RIGHT);
        loginFields.setPadding(new Insets(80,50,0,0));
        loginFields.setSpacing(20);

        Logo logo = new Logo("FP");
        logo.setPadding(new Insets(0,0,90,0));

        SubTitleBold signinText = new SubTitleBold("SIGN IN");
        signinText.setPadding(new Insets(30,0,38,0));
        signinText.setTranslateY(35);



        FPUsernameField username = new FPUsernameField();
        FPPasswordField password = new FPPasswordField();

        FPLoginButton loginButton = new FPLoginButton(this, username, password, databaseConnection);

        setOnKeyPressed(event -> {
            if(event.getCode() == KeyCode.ENTER){
                loginButton.actionStyle();

                try {
                    if (databaseConnection.validateUser(username.getText(), password.getText())) {

                        this.loginSuccessful();
                    } else {
                        username.invalidInputStyle();
                        password.invalidInputStyle();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });


        loginFields.getChildren().addAll(logo, signinText, username, password, loginButton);

        this.setAlignment(Pos.CENTER_RIGHT);

        this.getChildren().addAll(linearGradientFill(), loginFields);
    }

    private Rectangle linearGradientFill() {

        Rectangle linearGradientFill = new Rectangle(0,0,1280,800);

        Stop[] stops = new Stop[] { new Stop(0, Color.rgb(246,114,128, 0.4)), new Stop(1, Color.rgb(53,71,125))};
        linearGradientFill.setFill( new LinearGradient(0, 640, 920, 640, false, CycleMethod.NO_CYCLE, stops));

        return linearGradientFill;
    }

    public void loginSuccessful() throws SQLException {
        this.sceneHandler.loginSuccessful();
    }
}
