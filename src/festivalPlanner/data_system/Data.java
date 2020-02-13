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

    public void fetchLocalSave(String listType){

    }

    public void addToArtists(Artist artist){
        this.artists.add(artist);
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
