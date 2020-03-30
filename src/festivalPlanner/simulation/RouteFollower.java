package festivalPlanner.simulation;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * This class manages the pathfinding.
 */

public class RouteFollower {

    private int windowHeight;
    private int windowWidth;

    private GridPosition[][] twoDArray;
    private int[][] tileMapGrid;

    private HashMap<GridPosition, GridPosition> mainStageHeatMap = new HashMap<>();
    private HashMap<GridPosition, GridPosition> northEastStageHeatMap = new HashMap<>();
    private HashMap<GridPosition, GridPosition> northWestStageHeatMap = new HashMap<>();
    private HashMap<GridPosition, GridPosition> southEastStageHeatMap = new HashMap<>();
    private HashMap<GridPosition, GridPosition> southWestStageHeatMap = new HashMap<>();
    private HashMap<GridPosition, GridPosition> toiletsHeatMap = new HashMap<>();
    private HashMap<GridPosition, GridPosition> endHeatMap = new HashMap<>();


    private GridPosition northWestPoint = null;
    private GridPosition northEastPoint = null;
    private GridPosition mainStagePoint = null;
    private GridPosition southWestPoint = null;
    private GridPosition southEastPoint = null;
    private GridPosition toiletsPoint = null;
    private GridPosition endPoint = null;




    public RouteFollower(double windowWidth, double windowHeight) {

        this.windowWidth = (int)windowWidth;
        this.windowHeight = (int)windowHeight;

    }

    public void buildRouteMap(ArrayList<Integer> pathLayer){

        tileMapGrid = new int[1088/32][];

        for ( int i = 0; i < 1088/32; i++ ){
            tileMapGrid[i] = new int[1920/32];
        }

        int positionCounter = 0;
        for ( int i = 0; i < 1088/32; i++ ){
            for ( int j = 0; j < 1920/32; j++ ){
                tileMapGrid[i][j] = pathLayer.get(positionCounter);
                positionCounter++;
            }
        }


        this.twoDArray = new GridPosition[this.windowWidth][];

        for ( int i = 0; i < this.windowWidth; i++){
            this.twoDArray[i] = new GridPosition[this.windowHeight];
        }

        for ( int i = 0; i < this.windowWidth; i++){
            for ( int j = 0; j < this.windowHeight; j++){
                this.twoDArray[i][j] = new GridPosition(i, j);
            }
        }

        for ( int i = 0; i < 1088/32; i++ ){
            for ( int j = 0; j < 1920/32; j++ ){

                if ( tileMapGrid[i][j] == 98 ){
                    for ( int tileWidth = 0; tileWidth < 32; tileWidth++ ){
                        for ( int tileHeight = 0; tileHeight < 32; tileHeight++ ){

                            this.twoDArray[i*32+tileWidth][j*32+tileHeight].setWalkable(true);

                        }
                    }
                }
            }
        }

        for ( int i = 0; i < this.windowWidth; i++){
            for ( int j = 0; j < this.windowHeight; j++){
                this.twoDArray[i][j].setNeighbouringPositions(this.twoDArray, this.windowWidth, this.windowHeight);
            }
        }

        pathMapGenerator();
    }


    private void pathMapGenerator(){

        this.northWestPoint = this.twoDArray[322][191];
        this.northEastPoint = this.twoDArray[289][1729];
        this.mainStagePoint = this.twoDArray[616][991];
        this.southWestPoint = this.twoDArray[961][191];
        this.southEastPoint = this.twoDArray[993][1695];
        this.toiletsPoint = this.twoDArray[424][756];
        this.endPoint = this.twoDArray[1060][1000];

        ArrayList<GridPosition> frontier = new ArrayList<>();

        this.mainStageHeatMap.put(mainStagePoint, null);
        this.northEastStageHeatMap.put(northEastPoint, null);
        this.northWestStageHeatMap.put(northWestPoint, null);
        this.southEastStageHeatMap.put(southEastPoint, null);
        this.southWestStageHeatMap.put(southWestPoint, null);
        this.toiletsHeatMap.put(toiletsPoint,null);
        this.endHeatMap.put(endPoint,null);

        frontier.add(mainStagePoint);

        for( int i = 0; i < frontier.size(); i++){
            GridPosition current = frontier.get(i);

            for ( GridPosition gridPosition : current.getNeighbouringPositions()){

                if (!this.mainStageHeatMap.containsKey(gridPosition) && gridPosition.isWalkable()){
                    frontier.add(gridPosition);
                    this.mainStageHeatMap.put(gridPosition, current);
                }
            }
        }

        frontier.clear();
        frontier.add(northEastPoint);

        for( int i = 0; i < frontier.size(); i++){
            GridPosition current = frontier.get(i);

            for ( GridPosition gridPosition : current.getNeighbouringPositions()){

                if (!this.northEastStageHeatMap.containsKey(gridPosition) && gridPosition.isWalkable()){
                    frontier.add(gridPosition);
                    this.northEastStageHeatMap.put(gridPosition, current);
                }
            }
        }

        frontier.clear();
        frontier.add(northWestPoint);

        for( int i = 0; i < frontier.size(); i++){
            GridPosition current = frontier.get(i);

            for ( GridPosition gridPosition : current.getNeighbouringPositions()){

                if (!this.northWestStageHeatMap.containsKey(gridPosition) && gridPosition.isWalkable()){
                    frontier.add(gridPosition);
                    this.northWestStageHeatMap.put(gridPosition, current);
                }
            }
        }

        frontier.clear();
        frontier.add(southEastPoint);

        for( int i = 0; i < frontier.size(); i++){
            GridPosition current = frontier.get(i);

            for ( GridPosition gridPosition : current.getNeighbouringPositions()){

                if (!this.southEastStageHeatMap.containsKey(gridPosition) && gridPosition.isWalkable()){
                    frontier.add(gridPosition);
                    this.southEastStageHeatMap.put(gridPosition, current);
                }
            }
        }

        frontier.clear();
        frontier.add(southWestPoint);

        for( int i = 0; i < frontier.size(); i++){
            GridPosition current = frontier.get(i);

            for ( GridPosition gridPosition : current.getNeighbouringPositions()){

                if (!this.southWestStageHeatMap.containsKey(gridPosition) && gridPosition.isWalkable()){
                    frontier.add(gridPosition);
                    this.southWestStageHeatMap.put(gridPosition, current);
                }
            }
        }

        frontier.clear();
        frontier.add(toiletsPoint);

        for( int i = 0; i < frontier.size(); i++){
            GridPosition current = frontier.get(i);

            for ( GridPosition gridPosition : current.getNeighbouringPositions()){

                if (!this.toiletsHeatMap.containsKey(gridPosition) && gridPosition.isWalkable()){
                    frontier.add(gridPosition);
                    this.toiletsHeatMap.put(gridPosition, current);
                }
            }
        }

        frontier.clear();
        frontier.add(endPoint);

        for( int i = 0; i < frontier.size(); i++){
            GridPosition current = frontier.get(i);

            for ( GridPosition gridPosition : current.getNeighbouringPositions()){

                if (!this.endHeatMap.containsKey(gridPosition) && gridPosition.isWalkable()){
                    frontier.add(gridPosition);
                    this.endHeatMap.put(gridPosition, current);
                }
            }
        }

        frontier.clear();
    }

    public ArrayList<GridPosition> routeFinder(String stageCode, int starty, int startx){

        if ( stageCode.equals("Middle")){
            GridPosition start = this.mainStagePoint;
            GridPosition end = this.twoDArray[starty][startx];

            ArrayList<GridPosition> route = new ArrayList<>();

            route.add(this.mainStageHeatMap.get(end));

            for ( int i = 0; i < route.size(); i++ ){

                if ( route.get(i) != start ){
                    route.add(this.mainStageHeatMap.get( route.get(i) ) );
                } else {
                    break;
                }

            }
            return route;
        }
        else if ( stageCode.equals("North East")){
            GridPosition start = this.northEastPoint;
            GridPosition end = this.twoDArray[starty][startx];

            ArrayList<GridPosition> route = new ArrayList<>();

            route.add(this.northEastStageHeatMap.get(end));

            for ( int i = 0; i < route.size(); i++ ){

                if ( route.get(i) != start ){
                    route.add(this.northEastStageHeatMap.get( route.get(i) ) );
                } else {
                    break;
                }

            }
            return route;
        }
        else if ( stageCode.equals("North West")){
            GridPosition start = this.northWestPoint;
            GridPosition end = this.twoDArray[starty][startx];

            ArrayList<GridPosition> route = new ArrayList<>();

            route.add(this.northWestStageHeatMap.get(end));

            for ( int i = 0; i < route.size(); i++ ){

                if ( route.get(i) != start ){
                    route.add(this.northWestStageHeatMap.get( route.get(i) ) );
                } else {
                    break;
                }

            }
            return route;
        }
        else if ( stageCode.equals("South East")){
            GridPosition start = this.southEastPoint;
            GridPosition end = this.twoDArray[starty][startx];

            ArrayList<GridPosition> route = new ArrayList<>();

            route.add(this.southEastStageHeatMap.get(end));

            for ( int i = 0; i < route.size(); i++ ){

                if ( route.get(i) != start ){
                    route.add(this.southEastStageHeatMap.get( route.get(i) ) );
                } else {
                    break;
                }

            }
            return route;
        }
        else if ( stageCode.equals("South West")){
            GridPosition start = this.southWestPoint;
            GridPosition end = this.twoDArray[starty][startx];

            ArrayList<GridPosition> route = new ArrayList<>();

            route.add(this.southWestStageHeatMap.get(end));

            for ( int i = 0; i < route.size(); i++ ){

                if ( route.get(i) != start ){
                    route.add(this.southWestStageHeatMap.get( route.get(i) ) );
                } else {
                    break;
                }

            }
            return route;
        } else if ( stageCode.equals("Toilet")){
            GridPosition start = this.toiletsPoint;
            GridPosition end = this.twoDArray[starty][startx];

            ArrayList<GridPosition> route = new ArrayList<>();

            route.add(this.toiletsHeatMap.get(end));

            for ( int i = 0; i < route.size(); i++ ){

                if ( route.get(i) != start ){
                    route.add(this.toiletsHeatMap.get( route.get(i) ) );
                } else {
                    break;
                }

            }

            return route;
        } else if ( stageCode.equals("endPoint")){
            GridPosition start = this.endPoint;
            GridPosition end = this.twoDArray[starty][startx];

            ArrayList<GridPosition> route = new ArrayList<>();

            route.add(this.endHeatMap.get(end));

            for ( int i = 0; i < route.size(); i++ ){

                if ( route.get(i) != start ){
                    route.add(this.endHeatMap.get( route.get(i) ) );
                } else {
                    break;
                }

            }
            return route;
        } else {
            return null;
        }

    }


//    public ArrayList<GridPosition> calculateRoute(Point2D endPos){
//
//       // this.startPosition = new GridPosition(5*32, 8*32);
//        this.startPosition = this.twoDArray[5*32][8*32];
//
//        this.endPosition = this.twoDArray[(int)endPos.getX()][(int)endPos.getY()];
//
//        System.out.println(this.startPosition.getyPos() + " "+ this.startPosition.getxPos() + " : "+ this.endPosition.getyPos() + " " + this.endPosition.getxPos());
//
//        this.availablePositions.add(this.startPosition);
//
//        while(true) {
//
//            //GridPosition currentPosition ;
//
//            if (this.availablePositions.size() > 0) {
//
//                int winningPath = 0;
//
//                for (int i = 0; i < this.availablePositions.size(); i++) {
//                    if (this.availablePositions.get(i).getTotalRouteCost() < this.availablePositions.get(winningPath).getTotalRouteCost()) {
//                        winningPath = i;
//                    }
//                }
//
//                GridPosition currentPosition = this.availablePositions.get(winningPath);
//
//                if (currentPosition == this.endPosition) {
//                    System.out.println("Done Finding Path");
//                    this.foundPath.add(currentPosition);
//                    break;
//                }
//
////                for ( GridPosition gridPosition : this.availablePositions ){
////                    if ( gridPosition == currentPosition ){
////                        this.availablePositions.remove(gridPosition);
////                    }
////                }
//                for ( int i = 0; i < this.availablePositions.size(); i++ ){
//                    if ( this.availablePositions.get(i) == currentPosition ){
//                        this.availablePositions.remove(i);
//                    }
//                }
//
//                this.unavailablePositions.add(currentPosition);
//
//                ArrayList<GridPosition> currentNeighbours = currentPosition.getNeighbouringPositions();
//
//                for ( GridPosition gridPosition : currentNeighbours ){
//                    GridPosition neighbour = gridPosition;
//
//                    if ( !this.unavailablePositions.contains(neighbour) && !neighbour.isWalkable() ){
//                        int tempRouteCost = currentPosition.getRouteCost() + heuristic(neighbour, currentPosition);
//
//                        boolean newPath = false;
//
//                        if ( this.availablePositions.contains(neighbour) ){
//                            if ( tempRouteCost < neighbour.getRouteCost() ) {
//                                neighbour.setRouteCost(tempRouteCost);
//                                newPath = true;
//                            }
//                        } else {
//                            neighbour.setRouteCost( tempRouteCost );
//                            newPath = true;
//                            this.availablePositions.add(neighbour);
//                        }
//
//                        if ( newPath ){
//                            neighbour.setHeuristic(heuristic(neighbour, this.endPosition));
//                            neighbour.setTotalRouteCost( neighbour.getRouteCost() + neighbour.getHeuristic() );
//                            neighbour.setPreviousPosition(currentPosition);
//                        }
//                    }
//                }
//                this.foundPath.add(currentPosition);
//
//                //System.out.println(currentPosition.getyPos()+ " " + currentPosition.getxPos() + "\n --------");
//
//            }
//            else {
//                System.out.println("No Solution Found");
//                break;
//            }
//
//
//
//        }
//
//        for ( GridPosition gridPosition : this.foundPath ){
//            System.out.println(gridPosition.getyPos()+ " " + gridPosition.getxPos() + "\n --------");
//        }
//        return this.foundPath;
//
//    }
//
//    public ArrayList<GridPosition> getFoundPath() {
//        return foundPath;
//    }
//
//    public void setStartPosition(Point2D StartPos) {
//
//        this.startPosition = new GridPosition((int)StartPos.getX(), (int)StartPos.getY());
//
//        this.availablePositions.add(this.startPosition);
//
//    }
//
//    public void setEndPosition(Point2D EndPos) {
//        this.endPosition = this.twoDArray[(int)EndPos.getX()][(int)EndPos.getY()];
//    }
//
//    private int heuristic( GridPosition neighbour, GridPosition currentPosition ){
//
//        double heuristic = Point2D.distance(neighbour.getyPos(), neighbour.getxPos(), currentPosition.getyPos(), currentPosition.getxPos());
//
//        return (int) Math.round(heuristic);
//    }

    public int[][] getTileMapGrid() {
        return tileMapGrid;
    }

    public GridPosition[][] getTwoDArray() {
        return twoDArray;
    }
}
