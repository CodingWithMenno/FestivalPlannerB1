package festivalPlanner.gui.gui_controllers;

import festivalPlanner.data_system.Artist;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;

import java.util.ArrayList;

public class ArtistScreenController {
    @FXML
    private TextField ArtistName;
    @FXML
    private TextField ArtistGenre;
    @FXML
    private TextArea ArtistInfo;
    @FXML
    private Button ArtistAddButton;
    @FXML
    private Button ArtistClearButton;
    @FXML
    private Button ArtistDeleteButton;
    @FXML
    private Button ArtistBrowseButton;
    @FXML
    private ListView ArtistListView;

    private ArrayList<Artist> artists = new ArrayList<>();


    public void klasse () {

        System.out.println("Ik print nu deze text uit: " + ArtistName.getSelectedText());
        System.out.println(ArtistName.getCharacters());
    }

    public void addButton(){
        Artist artist = new Artist(this.ArtistName.getText(), this.ArtistGenre.getText(), this.ArtistInfo.getText());
        this.artists.add(artist);
    }

    public void clearButton(){
        this.ArtistGenre.clear();
        this.ArtistName.clear();
        this.ArtistInfo.clear();
    }

    public void deleteButton(){

        System.out.println(this.artists.toString());
    }


}