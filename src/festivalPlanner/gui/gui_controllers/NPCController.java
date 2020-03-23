package festivalPlanner.gui.gui_controllers;

import festivalPlanner.data_system.Data;
import festivalPlanner.data_system.Event;
import festivalPlanner.data_system.Stage;
import festivalPlanner.simulation.RouteFollower;
import festivalPlanner.simulation.TimelineScrollBar;
import festivalPlanner.simulation.Visitor;
import javafx.geometry.Point2D;

import java.util.ArrayList;

public class NPCController {

    private TimelineScrollBar scrollBar;
    private Data data;
    private ArrayList<Double> popularities;
    private ArrayList<Visitor> visitors;
    private ArrayList<String> positions;
    private RouteFollower routeFollower;

    public NPCController(TimelineScrollBar scrollBar, Data data, ArrayList<Visitor>visitors, RouteFollower routeFollower) {
        this.visitors = visitors;
        this.scrollBar = scrollBar;
        this.data = data;
        this.routeFollower = routeFollower;
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
           this.positions = new ArrayList<>();
           this.popularities = new ArrayList<>();
           int i = 0;
           for (Event event : data.getEvents()) {
               popularities.add(event.getPopularity());
               positions.add(getPosition(event.getStage()));
               i++;
           }
       }

        System.out.println(popularities.toString());
        System.out.println(positions.toString());

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
            directVisitorToStage(visitor,positions.get(0));
        }
            
    }

    public void divideOver2Events(){
        double percentagePerPeople = formula();

        long first = Math.round ( percentagePerPeople * popularities.get ( 0 ));
        long second = Math.round ( percentagePerPeople * popularities.get ( 1 ));

        int i = 0;
        for(Visitor visitor : visitors) {
            if (i < first) {
                directVisitorToStage(visitor,positions.get(0));
            } else if (i < second+first) {
                directVisitorToStage(visitor,positions.get(1));
            }
            i++;
        }

    }

    public void divideOver3Event(){
        double percentagePerPeople = formula();

        long first = Math.round ( percentagePerPeople * popularities.get ( 0 ));
        long second = Math.round ( percentagePerPeople * popularities.get ( 1 ));
        long third = Math.round ( percentagePerPeople * popularities.get ( 2 ));


        int i = 0;
        for(Visitor visitor : visitors) {
            if (i < first) {
                directVisitorToStage(visitor,positions.get(0));
            } else if (i < second+first) {
                directVisitorToStage(visitor,positions.get(1));
            } else if (i < third+first+second) {
                directVisitorToStage(visitor,positions.get(2));
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
                directVisitorToStage(visitor,positions.get(0));
            }else if(i<second+first){
                directVisitorToStage(visitor,positions.get(1));
            }else if(i<third+first+second){
                directVisitorToStage(visitor,positions.get(2));
            }else if(i<third+first+second+fourth){
                directVisitorToStage(visitor,positions.get(3));
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
                directVisitorToStage(visitor,positions.get(0));
            }else if(i<first+second){
                directVisitorToStage(visitor,positions.get(1));
            }else if(i<third+first+second){
                directVisitorToStage(visitor,positions.get(2));
            }else if(i<third+first+second+fourth){
                directVisitorToStage(visitor,positions.get(3));
            }else if(i<third+first+second+fourth+fifth){
                directVisitorToStage(visitor,positions.get(4));
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

    public void directVisitorToStage(Visitor visitor, String position){
        System.out.println(position);
        visitor.setPath(routeFollower.routeFinder(position,(int)visitor.getPosition().getY(),(int)visitor.getPosition().getX()));
    }

    public String getPosition(String stageName){
       String position = "";
        for(Stage stage : data.getStages()){
            if(stage.getName().equals(stageName)){
                if(stage.getPlacement().equals("Middle")){
                    position = "Middle";
                }else if(stage.getPlacement().equals("North West")){
                    position = "North West";
                }else if(stage.getPlacement().equals("North East")){
                    position = "North East";
                }else if(stage.getPlacement().equals("South West")){
                    position = "South West";
                }else if(stage.getPlacement().equals("South East")){
                    position = "South East";
                }
            }
        }
        return position;
    }
}


