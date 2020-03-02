package festivalPlanner.data_system;

import festivalPlanner.tools.FileIO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.File;
import java.util.ArrayList;

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

        this.artists = (this.IO.readArtistFile("resources/SavedFiles/SavedArtists.txt"));
        this.stages = (this.IO.readStageFile("resources/SavedFiles/SavedStages.txt"));
        this.events = (this.IO.readEventFile("resources/SavedFiles/SavedEvents.txt"));
    }

    public void addToArtists(Artist artist){
        this.artists.add(artist);

        IO.writeArrayListArtist(this.artists, "resources/SavedFiles/SavedArtists.txt");

        this.artists.removeAll();
        this.artists = IO.readArtistFile("resources/SavedFiles/SavedArtists.txt");
    }


    public void addToStages(Stage stage){
        this.stages.add(stage);

        IO.writeArrayListStage(this.stages, "resources/SavedFiles/SavedStages.txt");

        this.stages.removeAll();

        this.stages = IO.readStageFile("resources/SavedFiles/SavedStages.txt");
    }

    public void addToEvents(Event event) throws Exception{

        boolean artistAvailable = true;

        for ( Event events : this.events){
            if ( event.getHeadArtist().getName().equals(events.getHeadArtist().getName()) || event.getCoArtist().getName().equals(events.getCoArtist().getName()) ||
                    event.getStage().equals(events.getStage()) || event.getHeadArtist().getName().equals(events.getCoArtist().getName()) || event.getCoArtist().getName().equals(events.getHeadArtist().getName())){
                if ( event.getEndTime() < events.getStartTime() || event.getStartTime() > events.getEndTime() ){

                }
                else {
                    artistAvailable = false;
                }
            }
        }

        if ( artistAvailable ){
            this.events.add(event);

            IO.writeArrayListEvents(this.events, "resources/SavedFiles/SavedEvents.txt");

            this.events.removeAll();

            this.events = (IO.readEventFile("resources/SavedFiles/SavedEvents.txt"));
        }
        else {
            throw new Exception("Artist is booked");
        }

    }

    public ObservableList<Artist> getArtists() {
        return this.artists;
    }


    public ObservableList<Stage> getStages() {
        return this.stages;
    }


    public ObservableList<Event> getEvents() {
        return this.events;
    }

    public void removeArtist(Artist artist){

        ArrayList<Event> tempEvents = new ArrayList<>();

        for ( Event event : this.events ){
            if ( event.getHeadArtist().getName().equals(artist.getName()) || event.getCoArtist().getName().equals(artist.getName()) ){
                tempEvents.add(event);
            }
        }

        for (Event event : tempEvents) {
            if (this.events.contains(event)){
                removeEvent(event);
            }
        }
        this.artists.remove(artist);

        IO.writeArrayListArtist(this.artists, "resources/SavedFiles/SavedArtists.txt");

        this.artists.removeAll();
        this.artists = IO.readArtistFile("resources/SavedFiles/SavedArtists.txt");
    }

    public void removeStage(Stage stage){

        ArrayList<Event> tempEvents = new ArrayList<>();

        for ( Event event : this.events ){
            if ( event.getStage().equals(stage.getName()) ){
                tempEvents.add(event);
            }
        }

        for (Event event : tempEvents) {
            if (this.events.contains(event)){
                removeEvent(event);
            }
        }
        stages.remove(stage);

        IO.writeArrayListStage(this.stages, "resources/SavedFiles/SavedStages.txt");

        this.stages.removeAll();

        this.stages = IO.readStageFile("resources/SavedFiles/SavedStages.txt");
    }

    public void removeEvent(Event event){
        this.events.remove(event);

        IO.writeArrayListEvents(this.events, "resources/SavedFiles/SavedEvents.txt");

        this.events.removeAll();

        this.events = (IO.readEventFile("resources/SavedFiles/SavedEvents.txt"));
    }

}
