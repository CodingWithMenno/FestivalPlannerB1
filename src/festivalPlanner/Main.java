package festivalPlanner;

import festivalPlanner.data_system.Data;
import festivalPlanner.gui.StageManager;
import festivalPlanner.tools.FileIO;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Main, this class starts the program
 */

public class Main extends Application {

    public static void main(String[] args) {
        launch(StageManager.class);


//
//        FileIO io = new FileIO();
//        io.readArtistFile("/C:/Users/Davy/Documents/SavedArtists.txt");

    }

    @Override
    public void start(Stage primaryStage) throws Exception {

    }
}
