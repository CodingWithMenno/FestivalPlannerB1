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

    /**
     * This methods builds the map in system memory.
     * By building the map it sets all the walkable and non-walkable pixels on the screen.
     * @param pathLayer
     */
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

    /**
     * pathMapGenerator()
     *
     * This method creates heat maps for every possible destination within the map.
     * Heat maps are stored in Hashmaps.
     * The Key being the next-best neighbouring (pixel) position and the Value being the current pixel position.
     */
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

    /**
     *
     * This method is called on to find the best possible route from the current pixel position to the destination.
     *
     * @param stageCode
     * @param starty
     * @param startx
     * @return
     */
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


    public int[][] getTileMapGrid() {
        return tileMapGrid;
    }

    public GridPosition[][] getTwoDArray() {
        return twoDArray;
    }
}
