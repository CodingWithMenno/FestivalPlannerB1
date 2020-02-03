package festivalPlanner.gui.gui_controllers;

import festivalPlanner.data_system.Artist;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;

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
    private ListView<Artist> ArtistListView;

    private ObservableList<Artist> artists = FXCollections.observableArrayList();

    public ArtistScreenController() {
        Platform.runLater(() -> {
            this.ArtistListView.setItems(this.artists);
        });
    }

    public void klasse() {

        System.out.println("Ik print nu deze text uit: " + ArtistName.getSelectedText());
        System.out.println(ArtistName.getCharacters());
    }

    public void addButton() {

        Artist artist = new Artist(this.ArtistName.getText(), this.ArtistGenre.getText(), this.ArtistInfo.getText());
//        if (this.Artist) {
//            Alert dialog = new Alert(Alert.AlertType.WARNING, "Type a name");
//            dialog.setTitle("Same artist");
//            dialog.setHeaderText("");
//            dialog.show();
//        }else{
            if (this.artists.size() > 0) {
                for (Artist art : this.artists) {
                    if (art.getName().equals(artist.getName())) {
                        Alert dialog = new Alert(Alert.AlertType.WARNING, "This artist already exists");
                        dialog.setTitle("Same artist");
                        dialog.setHeaderText("");
                        dialog.show();
                        return;
                    }
                }
            }
//        }
        this.artists.add(artist);

        Alert dialog = new Alert(Alert.AlertType.INFORMATION, "Artist succesfully added");
        dialog.setTitle("Artist added");
        dialog.setHeaderText("");
        dialog.show();
        this.ArtistGenre.clear();
        this.ArtistName.clear();
        this.ArtistInfo.clear();

    }

    public void clearButton() {
        this.ArtistGenre.clear();
        this.ArtistName.clear();
        this.ArtistInfo.clear();
    }

    public void deleteButton() {
        Artist artist = this.ArtistListView.getSelectionModel().getSelectedItem();
        if (this.artists.contains(artist)) {
            this.artists.remove(artist);
            Alert dialog = new Alert(Alert.AlertType.INFORMATION, "Artist succesfully deleted");
            dialog.setTitle("Artist deleted");
            dialog.setHeaderText("");
            dialog.show();
        }

    }


}