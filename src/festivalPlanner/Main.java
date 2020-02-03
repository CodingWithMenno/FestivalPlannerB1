package festivalPlanner;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch ( args );

    }

    @Override
    public void start ( Stage primaryStage ) throws Exception {
        Parent root = FXMLLoader.load ( getClass ( ).getResource ( "/festivalPlanner/gui/gui_views/mainScreen.fxml" ) );
        primaryStage.setTitle ( "Festivalplanner" );
        primaryStage.setScene ( new Scene( root , 1280 , 800 ) );
        primaryStage.getIcons ( ).add ( new Image( "https://cdn3.iconfinder.com/data/icons/carnival-solid/48/circus_tent_carnival_festival-512.png" ) );
        primaryStage.show ( );

    }
}
