package festivalPlanner;

import festivalPlanner.gui.StageManager;
import festivalPlanner.tools.FileIO;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.ArrayList;


public class Main extends Application {

    public static void main(String[] args) {

        //SceneManager sceneManager = new SceneManager();

        //launch(StageManager.class);
        ArrayList<String> testarray = new  ArrayList<String>();
        testarray.add("Een");
        testarray.add("Twee");
        testarray.add("Drie");
        testarray.add("Vier");
        testarray.add("Vijf");
        testarray.add("Zes");
        testarray.add("Nog een test");


        FileIO writer = new FileIO();
//        writer.writeStringToFile("Dit is nog een test", "/D:/Test/File.txt");
//        writer.readStringFromFile("/D:/Test/File.txt");
        writer.writeArrayList(testarray, "/D:/Test/Array.txt");
        System.out.println(writer.readArrayList("/D:/Test/Array.txt"));

    }

    @Override
    public void start(Stage primaryStage) throws Exception {

    }
}
