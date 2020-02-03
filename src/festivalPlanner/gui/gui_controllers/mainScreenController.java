package festivalPlanner.gui.gui_controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class mainScreenController implements Initializable {


    @FXML
    private Button buttonArtist;

    @FXML
    private Button buttonStage;

    @FXML
    private Button buttonEvent;

    @FXML
    private Button buttonSimulate;

    @FXML
    private Button buttonSwitchView;

    @FXML
    public void leftPaneButtonHandler(ActionEvent event) {
        if (event.getSource() == buttonArtist) {
            System.out.println(" Add buttonArtist pressed");
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/festivalPlanner/gui/gui_views/artistScreen.fxml"));
                Stage stageArtist = new Stage();
                stageArtist.setTitle("Artist");
                stageArtist.getIcons().add(new Image("https://cdn3.iconfinder.com/data/icons/carnival-solid/48/circus_tent_carnival_festival-512.png"));
                stageArtist.setScene(new Scene(root, 800, 570));
                stageArtist.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (event.getSource() == buttonStage) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/festivalPlanner/gui/gui_views/stageScreen.fxml"));
                Stage stageStage = new Stage();
                stageStage.setTitle("Stage");
                stageStage.getIcons().add(new Image("https://cdn3.iconfinder.com/data/icons/carnival-solid/48/circus_tent_carnival_festival-512.png"));
                stageStage.setScene(new Scene(root, 800, 570));
                stageStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (event.getSource() == buttonEvent) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/festivalPlanner/gui/gui_views/eventScreen.fxml"));
                Stage stageStage = new Stage();
                stageStage.setTitle("Event");
                stageStage.getIcons().add(new Image("https://cdn3.iconfinder.com/data/icons/carnival-solid/48/circus_tent_carnival_festival-512.png"));
                stageStage.setScene(new Scene(root, 800, 570));
                stageStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (event.getSource() == buttonSimulate) {
            System.out.println(" buttonSimulate pressed");
        } else if (event.getSource() == buttonSwitchView) {
            System.out.println(" buttonSwitchView pressed");
        }

    }

    @Override

    public void initialize(URL location, ResourceBundle resources) {

    }


}
