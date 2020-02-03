package festivalPlanner.gui.gui_controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ArtistScreenController {
    @FXML
    private TextField ArtistName;

    public void klasse () {

        System.out.println("Ik print nu deze text uit: " + ArtistName.getSelectedText());
        System.out.println(ArtistName.getCharacters());
    }


}
