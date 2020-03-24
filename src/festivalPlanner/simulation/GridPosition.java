package festivalPlanner.simulation;

import java.util.ArrayList;

public class GridPosition {

    private int xPos;
    private int yPos;

    private int routeCost; // = Cost of the path from the start node to the current node.
    private int heuristic; // = Cheapest Cost path from current node to end node.
    private int totalRouteCost; // = Total cost of the current path calculated.

    private GridPosition previousPosition;
    private ArrayList<GridPosition> neighbouringPositions ;

    private boolean walkable;

    public GridPosition(int yPos, int xPos) {

        this.walkable = false;

        this.xPos = xPos;
        this.yPos = yPos;

        this.routeCost = 0;
        this.heuristic = 0;
        this.totalRouteCost = 0;

        this.previousPosition = null;

        this.neighbouringPositions = new ArrayList<>();

    }

    public void setWalkable(boolean state){
        this.walkable = state;
    }

    public void setNeighbouringPositions(GridPosition[][] gridPosition, int width, int height ){

//        if ( xPos < height - 1 ){
//            this.neighbouringPositions.add(gridPosition[xPos + 1][yPos]);
//        }
//        if ( xPos > 0 ){
//            this.neighbouringPositions.add(gridPosition[xPos - 1][yPos]);
//        }
//        if (yPos < width - 1) {
//            this.neighbouringPositions.add(gridPosition[xPos][yPos + 1]);
//        }
//        if (yPos > 0) {
//            this.neighbouringPositions.add(gridPosition[xPos][yPos - 1]);
//        }
//        if (xPos > 0 && yPos > 0) {
//            this.neighbouringPositions.add(gridPosition[xPos - 1][yPos - 1]);
//        }
//        if (xPos < height - 1 && yPos > 0) {
//            this.neighbouringPositions.add(gridPosition[xPos + 1][yPos - 1]);
//        }
//        if (xPos > 0 && yPos < width - 1) {
//            this.neighbouringPositions.add(gridPosition[xPos - 1][yPos + 1]);
//        }
//        if (xPos < height - 1 && yPos < width - 1) {
//            this.neighbouringPositions.add(gridPosition[xPos + 1][yPos + 1]);
//        }

        if ( yPos < width - 1 ){
            this.neighbouringPositions.add(gridPosition[yPos + 1][xPos]);
        }
        if ( yPos > 0 ){
            this.neighbouringPositions.add(gridPosition[yPos - 1][xPos]);
        }
        if (xPos < height - 1) {
            this.neighbouringPositions.add(gridPosition[yPos][xPos + 1]);
        }
        if (xPos > 0) {
            this.neighbouringPositions.add(gridPosition[yPos][xPos - 1]);
        }
        if (yPos > 0 && xPos > 0) {
            this.neighbouringPositions.add(gridPosition[yPos - 1][xPos - 1]);
        }
        if (yPos < width - 1 && xPos > 0) {
            this.neighbouringPositions.add(gridPosition[yPos + 1][xPos - 1]);
        }
        if (yPos > 0 && xPos < height - 1) {
            this.neighbouringPositions.add(gridPosition[yPos - 1][xPos + 1]);
        }
        if (yPos < width - 1 && xPos < height - 1) {
            this.neighbouringPositions.add(gridPosition[yPos + 1][xPos + 1]);
        }

    }

    public ArrayList<GridPosition> getNeighbouringPositions() {
        return neighbouringPositions;
    }

    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public int getRouteCost() {
        return routeCost;
    }

    public int getHeuristic() {
        return heuristic;
    }

    public int getTotalRouteCost() {
        return totalRouteCost;
    }

    public boolean isWalkable() {
        return walkable;
    }

    public void setRouteCost(int routeCost) {
        this.routeCost = routeCost;
    }

    public void setHeuristic(int heuristic) {
        this.heuristic = heuristic;
    }

    public void setTotalRouteCost(int totalRouteCost) {
        this.totalRouteCost = totalRouteCost;
    }


    public void setPreviousPosition(GridPosition previousPosition) {
        this.previousPosition = previousPosition;
    }
}
