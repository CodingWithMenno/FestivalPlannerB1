package festivalPlanner.gui.gui_controllers;

import festivalPlanner.data_system.Data;
import festivalPlanner.data_system.Stage;
import festivalPlanner.gui.gui_views.StageView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class StageViewController {

    private ObservableList<String> places;
    private Data data;
    private ArrayList<String> placesNames;



    public StageViewController(Data data) {
        this.places = FXCollections.observableArrayList();
        this.data = data;
        this.placesNames = new ArrayList<>();
        this.placesNames.add("Middle");
        this.placesNames.add("North East");
        this.placesNames.add("North West");
        this.placesNames.add("South West");
        this.placesNames.add("South East");
    }

    public void setPlaces(){
        this.places.clear();
        for(String string : placesNames){
            int i = 0;
            for(Stage stage : data.getStages()){
                if(stage.getPlacement().equals(string)){
                    i++;
                }
            }
            if(i==0){
                this.places.add(string);
            }
        }
    }

    public ObservableList<String> getPlaces(){
        return this.places;
    }

}
