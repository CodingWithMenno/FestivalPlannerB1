package festivalPlanner.gui.gui_controllers;

import festivalPlanner.data_system.Data;
import festivalPlanner.data_system.Event;

public class NPCController {

    private TimelineScrollBar scrollBar;
    private Data data;

    public NPCController(TimelineScrollBar scrollBar,Data data) {
        this.scrollBar = scrollBar;
        this.data = data;
    }

    public void update(){
       double b =  scrollBar.getTimeMinutes();
       b = b/60;
       int amountofeventrightnow = 0;

       for(Event event : data.getEvents()){
           if(event.getStartTime() <= b && event.getEndTime() >= b){
               amountofeventrightnow++;
           }
       }
        System.out.println("amount of events right now:" + amountofeventrightnow);
    }
}


