package festivalPlanner.data_system;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Data {

    private ObservableList<Artist> artists;
    private ObservableList<Stage> stages;
    private ObservableList<Event> events;

    public Data() {
        this.artists = FXCollections.observableArrayList();
        this.stages = FXCollections.observableArrayList();
        this.events = FXCollections.observableArrayList();
    }

    public void addToArtists(Artist artist){
        this.artists.add(artist);
    }

    public void addToStages(Stage stage){
        this.stages.add(stage);
    }

    public void addToEvents(Event event){
        this.events.add(event);
    }

    public ObservableList<Artist> getArtists() {
        return artists;
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
