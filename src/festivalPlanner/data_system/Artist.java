package festivalPlanner.data_system;

import festivalPlanner.gui.gui_controllers.ArtistViewController;
import javafx.scene.image.ImageView;

public class Artist {

    private String name;
    private int age;
    private String genre;
    private String description;

    public Artist(String name, int age, String genre, String description) {
        this.name = name;
        this.age = age;
        this.genre = genre;
        this.description = description;
    }




    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.name;
    }


}
