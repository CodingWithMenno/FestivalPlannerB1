package festivalPlanner.gui.gui_controllers;

import festivalPlanner.data_system.Artist;
import festivalPlanner.data_system.Data;
import festivalPlanner.data_system.Event;
import festivalPlanner.gui.gui_views.EventView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * In this class the logic for the event view is set up.
 */

public class  EventViewController {

    private ObservableList<Double> times;
    private ObservableList<Double> endTimes;
    private ObservableList<String> popularity;
    private ObservableList<Artist> coArtists;


    public EventViewController() {
        this.times = FXCollections.observableArrayList();
        //this.endTimes = FXCollections.observableArrayList();
        //this.endTimes.add(0.0);
        this.popularity = FXCollections.observableArrayList();
        setTimes();
    }

    /**
     * this method sets the items for the combobox for the time selection.
     */
    public void setTimes(){
        for(double i = 0.0; i < 24.0; i++){
            this.times.add(i);

        }
    }

    public ObservableList<Double> getTimes(){
        return this.times;
    }


    /**
     * this method sets the items for the combobox for the end time selection.
     */
    public ObservableList<Double> getEndTimes(Double startTime){
        this.endTimes = FXCollections.observableArrayList();
        for (Double time : this.times){
            if ( startTime < time ){
                this.endTimes.add(time);
            }
        }
        return this.endTimes;
    }

    /**
     * this method sets the items for the combobox for the coArtist selection.
     */
    public ObservableList<Artist> getCoArtists(Artist mainArtist, Data data){
        this.coArtists = FXCollections.observableArrayList();
        for (Artist artist : data.getArtists()){
            if ( !(artist == mainArtist) ){
                this.coArtists.add(artist);
            }
        }
        return this.coArtists;
    }

    /**
     * this method sets the items for the combobox for the popularity selection.
     */
    public void setPopularity(){
        for(int i = 0; i<=100; i +=10){
            this.popularity.add(i+"%");
        }
    }

    public ObservableList<String> getPopularity(){
        return this.popularity;
    }


}
