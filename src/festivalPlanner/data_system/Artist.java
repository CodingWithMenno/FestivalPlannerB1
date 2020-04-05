package festivalPlanner.data_system;

import java.io.Serializable;
/**
 * An artist needs a name, age, genre, descriptiom and artist photo. Here is where they
 * are stored.
 */


public class Artist implements Serializable {

    private String name;
    private int age;
    private String genre;
    private String description;
    private String artistPhoto;

    public Artist(String name, int age, String genre, String description) {
        this.name = name;
        this.age = age;
        this.genre = genre;
        this.description = description;
    }

    public Artist(String name, int age, String genre, String description, String artistPhoto) {
        this.name = name;
        this.age = age;
        this.genre = genre;
        this.description = description;
        this.artistPhoto = artistPhoto;
    }

    public void setArtistPhoto(String artistPhoto) {
        this.artistPhoto = artistPhoto;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setDescription(String description) { this.description = description; }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public String getArtistPhoto() {
        return artistPhoto;
    }

    public int getAge(){
        return this.age;
    }

    public String getGenre(){
        return this.genre;
    }

    public String getDescription(){
        return this.description;
    }
}

