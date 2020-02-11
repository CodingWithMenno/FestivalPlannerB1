package festivalPlanner.gui.gui_controllers;

import com.sun.javafx.iio.ImageFrame;
import com.sun.javafx.iio.ImageLoader;
import festivalPlanner.data_system.Artist;
import festivalPlanner.gui.gui_views.ArtistView;
import festivalplanner_guiModules.inputfields.FPListView;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import javafx.scene.image.Image;

public class ArtistViewController {

    private ObservableList<Artist> artists = FXCollections.observableArrayList();
    private String file;
    private BufferedImage test;


    public ArtistViewController(FPListView fpListView) {
        Platform.runLater(() -> {
            fpListView.setItems(this.artists);
        });
    }

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
        FileDialog dialog = new FileDialog((Frame) null, "Select File to Open");
        dialog.setMode(FileDialog.LOAD);
        dialog.setVisible(true);
        this.file = dialog.getDirectory() + dialog.getFile();
        File file = new File(this.file);
        String newString = String.valueOf(file.toURI());
        newString = newString.substring(5, newString.length());
        System.out.println(newString);
        this.test = loadImage( newString);
    }

    public static BufferedImage loadImage (String path) {
        try {
            return ImageIO.read(ImageLoader.class.getResourceAsStream(path));
        } catch (IOException e) {
            System.out.println("Er gaat iets mis bij het laden!!");
            e.printStackTrace();
            System.exit(1);

        }
        return null;
    }

}



