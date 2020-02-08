package festivalPlanner.gui.gui_controllers;

import festivalPlanner.data_system.Event;
import festivalPlanner.gui.gui_views.EventView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class EventViewController {

    private ObservableList<Double> times;
    private ObservableList<String> popularity;


    public EventViewController() {
        this.times = FXCollections.observableArrayList();
        this.popularity = FXCollections.observableArrayList();
    }

    public void setTimes(){
        for(double i = 0.0; i < 24.0; i++){
            this.times.add(i);

        }
    }

    public ObservableList<Double> getTimes(){
        return this.times;
    }

    public void setPopularity(){
        for(int i = 0; i<=100; i +=10){
            this.popularity.add(i+"%");
        }
    }

    public ObservableList<String> getPopularity(){
        return this.popularity;
    }


}
