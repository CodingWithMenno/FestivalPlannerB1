package festivalPlanner.data_system;

import festivalPlanner.tools.FileIO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.File;

/**
 * In this class is all data stored. The data consist of artistss, stages and events.
 */

public class Data {
    private FileIO IO;
    private ObservableList<Artist> artists;
    private ObservableList<Stage> stages;
    private ObservableList<Event> events;

    public Data() {
        this.artists = FXCollections.observableArrayList();
        this.stages = FXCollections.observableArrayList();
        this.events = FXCollections.observableArrayList();
        this.IO = new FileIO();
    }

    public void fetchLocalSave(String listType){

    }

    public void addToArtists(Artist artist){

        IO.writeArrayListArtist(this.artists, "/C:/Users/Davy/Documents/SavedArtists.txt");

        this.artists = IO.readArtistFile("/C:/Users/Davy/Documents/SavedArtists.txt");
        this.artists.add(artist);


        System.out.println("addToArtist method called, we got this list: " + this.artists);

        getArtists();


    }


    public void addToStages(Stage stage){
        this.stages.add(stage);
    }

    public void addToEvents(Event event) throws Exception{

        boolean artistAvailable = true;

        for ( Event events : this.events){
            if ( event.getHeadArtist() == events.getHeadArtist() || event.getStage().equals(events.getStage()) ){
                if ( event.getEndTime() < events.getStartTime() || event.getStartTime() > events.getEndTime() ){

                }
                else {
                    artistAvailable = false;
                }
            }
        }

        if ( artistAvailable ){
            this.events.add(event);
        }
        else {
            throw new Exception("Artist is booked");
        }

    }

    public ObservableList<Artist> getArtists() {

        this.artists = IO.readArtistFile("/C:/Users/Davy/Documents/SavedArtists.txt");

//        Artist yolo = new Artist("mavo", 12, "alal", "hihi");
//        this.artists.add(yolo);
        System.out.println("called getartists");
        return this.artists;
    }


    public ObservableList<Stage> getStages() {
        return stages;
    }


    public ObservableList<Event> getEvents() {
        return events;
    }

    public void removeArtist(Artist artist){
        artists.remove(artist);
    }

    public void removeStage(Stage stage){
        stages.remove(stage);
    }

    public void removeEvent(Event event){
        events.remove(event);
    }

}
