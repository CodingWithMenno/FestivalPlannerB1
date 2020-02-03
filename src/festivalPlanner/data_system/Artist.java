package festivalPlanner.data_system;

import javafx.scene.image.ImageView;

public class Artist {

    private String name;
    private int age;
    private String genre;
    private ImageView profilePhoto;
    private String description;

    public Artist(String name, String genre, String description) {
        this.name = name;
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