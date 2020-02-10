package festivalPlanner.gui.gui_controllers;

import com.sun.javafx.iio.ImageFrame;
import com.sun.javafx.iio.ImageLoader;
import festivalPlanner.data_system.Artist;
import festivalplanner_guiModules.inputfields.FPListView;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Observable;
public class ArtistViewController {

    private ObservableList<Artist> artists = FXCollections.observableArrayList();
    private String file;


    public ArtistViewController() {

    }



    public String getFile() {
        return file;
    }

    public ObservableList<Artist> getArtists() {
        return this.artists;
    }

    public void addArtist(Artist artist) {
        for (Artist artist1 : this.artists) {
            if (artist1.getName().equals(artist.getName())) {
                return;
            }
        }
        this.artists.add(artist);
    }

    public void deleteArtist(Artist artist) {
        this.artists.remove(artist);
    }

    public void uploadPhoto() {

    }



}



