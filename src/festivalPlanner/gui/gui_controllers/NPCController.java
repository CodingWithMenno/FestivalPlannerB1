package festivalPlanner.gui.gui_controllers;

import festivalPlanner.data_system.Data;
import festivalPlanner.data_system.Event;
import festivalPlanner.data_system.Stage;
import festivalPlanner.simulation.RouteFollower;
import festivalPlanner.simulation.TimelineScrollBar;
import festivalPlanner.simulation.Visitor;
import javafx.geometry.Point2D;

import java.util.ArrayList;

/**
 *  This class takes care of controlling the npc's.
 */

public class NPCController {

    private TimelineScrollBar scrollBar;
    private Data data;
    private ArrayList<Double> popularities = new ArrayList<>();
    private ArrayList<Visitor> visitors;
    private ArrayList<String> positions = new ArrayList<>();
    private RouteFollower routeFollower;
    private ArrayList<Event> eventsRightNow = new ArrayList<>();

    public NPCController(TimelineScrollBar scrollBar, Data data, ArrayList<Visitor>visitors, RouteFollower routeFollower) {
        this.visitors = visitors;
        this.scrollBar = scrollBar;
        this.data = data;
        this.routeFollower = routeFollower;
    }

    /**
     *The update method checks how many events are busy at a certain time.
     */
    public void update(){
       double b =  scrollBar.getTimeMinutes();
       b = (b/60 );

        int amountofeventrightnow = 0;
        eventsRightNow.clear();

       for(Event event : data.getEvents()){
           if(event.getStartTime() <= b && event.getEndTime() >= b){
               eventsRightNow.add(event);
               amountofeventrightnow++;
           }
       }
       if(amountofeventrightnow > 0) {
           this.positions.clear();
           this.popularities.clear();
           for (Event event : eventsRightNow) {
               popularities.add(event.getPopularity());
               positions.add(getPosition(event.getStage()));
           }
       }

//        System.out.println(popularities.toString());
//        System.out.println(positions.toString());

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

    /**
     * The 7 methods below divide the visitors over certain places.
     */

    public void visitorsToExit(){
        for (Visitor visitor : visitors){
            directVisitorToStage(visitor,"endPoint");
        }
    }


    public void divideOver0Events(){
        int i = 0;
        for(Visitor visitor : visitors) {
            if (i < 13) {
                directVisitorToStage(visitor,"Toilet");
            } else if (i < 60) {
                directVisitorToStage(visitor,"Middle");
            }
            i++;
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

    /**
     * The method below is a formule for dividing the npc's
     */
    public double formula(){

        double totalPercentages = 0.0;
        double totalPeople = visitors.size();

        for ( int i = 0 ; i <  popularities.size (); i++ )
        {
            totalPercentages = totalPercentages + popularities.get ( i );
        }
        return totalPeople/totalPercentages;
    }

    /**
     * The method below sends a npc to a place using pathfinding
     */

    public void directVisitorToStage(Visitor visitor, String position){
        if(!(visitor.getLastPosition().getX() == getStageCoords(position).getX() && visitor.getLastPosition().getY() == getStageCoords(position).getY())) {
            visitor.setPath(routeFollower.routeFinder(position, (int) visitor.getLastPosition().getY(), (int) visitor.getLastPosition().getX()));
        }
    }

    /**
     * The two methods below are needed to get parameters for the pathfinding.
     */

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
                }else if(stage.getPlacement().equals("endPoint")){
                    position = "endPoint";
                }
            }
        }
        return position;
    }

    public Point2D getStageCoords(String stage){
        Point2D point2D = new Point2D(0,0);
        if(stage.equals("Middle")){
            point2D = new Point2D(991,616);
        }else if(stage.equals("North West")){
            point2D = new Point2D(191,322);
        }else if(stage.equals("North East")){
            point2D = new Point2D(1729,289);
        }else if(stage.equals("South West")){
            point2D = new Point2D(191,961);
        }else if(stage.equals("South East")){
            point2D = new Point2D(1695,993);
        }else if(stage.equals("Toilet")){
            point2D = new Point2D(756,424);
        }else if(stage.equals("endPoint")){
            point2D = new Point2D(1000,1060);
        }
        return point2D;



    }
}


