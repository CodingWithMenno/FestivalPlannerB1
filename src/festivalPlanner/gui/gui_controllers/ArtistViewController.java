package festivalPlanner.gui.gui_controllers;

import festivalPlanner.data_system.Artist;
import festivalplanner_guiModules.inputfields.FPListView;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class ArtistViewController {

    private ObservableList<Artist> artists = FXCollections.observableArrayList();


    public ArtistViewController(FPListView fpListView) {
        Platform.runLater(() ->
                fpListView.setItems(this.artists));
    }

    public void addArtist(Artist artist) {
        for (Artist artist1 : this.artists) {
            if (artist1.getName().equals(artist.getName())){
                return;
            }
        }
        this.artists.add(artist);
    }

    public void deleteArtist(Artist artist){
        this.artists.remove(artist);
    }


}
