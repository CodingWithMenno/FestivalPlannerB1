package festivalPlanner.gui.gui_controllers;

import festivalPlanner.data_system.Data;
import festivalPlanner.data_system.Event;
import festivalPlanner.simulation.Visitor;

import java.util.ArrayList;

public class NPCController {

    private TimelineScrollBar scrollBar;
    private Data data;
    private ArrayList<Double> popularities;
    private ArrayList<Visitor> visitors;

    public NPCController(TimelineScrollBar scrollBar, Data data, ArrayList<Visitor>visitors) {
        this.visitors = visitors;
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

       if(amountofeventrightnow > 0) {
           popularities = new ArrayList<>();
           int i = 0;
           for (Event event : data.getEvents()) {
               popularities.add(event.getPopularity());
               i++;
           }
       }

        System.out.println(popularities.toString());

       if(amountofeventrightnow == 0){
           divideOver0Events();
       }else if(amountofeventrightnow == 1){
           divideOver1Events();
       }else if(amountofeventrightnow == 2){
           divideOver2Events();
       }else if(amountofeventrightnow == 3){
            divideOver3Event();
       }else if(amountofeventrightnow == 4){
            divideOver4Events();
       }else if(amountofeventrightnow == 5){
            divideOver5Events();
       }
    }

    public void divideOver0Events(){
        for(Visitor visitor : visitors){
        }
    }

    public void divideOver1Events(){
        for(Visitor visitor : visitors){

        }
            
    }

    public void divideOver2Events(){
        double percentagePerPeople = formula();

        long first = Math.round ( percentagePerPeople * popularities.get ( 0 ));
        long second = Math.round ( percentagePerPeople * popularities.get ( 1 ));

        int i = 0;
        for(Visitor visitor : visitors) {
            if (i < first) {

            } else if (i < second+first) {

            }
            i++;
        }

    }

    public void divideOver3Event(){
        double percentagePerPeople = formula();

        long first = Math.round ( percentagePerPeople * popularities.get ( 0 ));
        System.out.println(first);
        long second = Math.round ( percentagePerPeople * popularities.get ( 1 ));
        System.out.println(second);

        long third = Math.round ( percentagePerPeople * popularities.get ( 2 ));
        System.out.println(third);


        int i = 0;
        for(Visitor visitor : visitors) {
            if (i < first) {

            } else if (i < second+first) {

            } else if (i < third+first+second) {
            }
            i++;
        }

    }

    public void divideOver4Events(){
        double percentagePerPeople = formula();

        long first = Math.round ( percentagePerPeople * popularities.get ( 0 ));
        long second = Math.round ( percentagePerPeople * popularities.get ( 1 ));
        long third = Math.round ( percentagePerPeople * popularities.get ( 2 ));
        long fourth = Math.round ( percentagePerPeople * popularities.get ( 3 ));

        int i = 0;
        for(Visitor visitor : visitors){
            if(i < first){

            }else if(i<second+first){

            }else if(i<third+first+second){

            }else if(i<third+first+second+fourth){

            }
            i++;
        }
    }

    public void divideOver5Events(){
        double percentagePerPeople = formula();

        long first = Math.round ( percentagePerPeople * popularities.get ( 0 ));
        long second = Math.round ( percentagePerPeople * popularities.get ( 1 ));
        long third = Math.round ( percentagePerPeople * popularities.get ( 2 ));
        long fourth = Math.round ( percentagePerPeople * popularities.get ( 3 ));
        long fifth = Math.round ( percentagePerPeople * popularities.get ( 4 ));


        int i = 0;
        for(Visitor visitor : visitors){
            if(i < first){

            }else if(i<first+second){

            }else if(i<third+first+second){

            }else if(i<third+first+second+fourth){

            }else if(i<third+first+second+fourth+fifth){

            }
            i++;
        }
    }

    public double formula(){

        double totalPercentages = 0.0;
        double totalPeople = 100;

        for ( int i = 0 ; i <  popularities.size (); i++ )
        {
            totalPercentages = totalPercentages + popularities.get ( i );
        }
        return totalPeople/totalPercentages;
    }

    public void directVisitorToStage(Visitor visitor, int stage){

    }
}


