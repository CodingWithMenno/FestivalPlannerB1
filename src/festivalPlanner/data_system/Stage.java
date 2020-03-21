package festivalPlanner.data_system;

/**
 * A stage needs a name, capacity, surface (m2), some emergency exits, first aid kits and if its indoor.
 * this class stores these attributes.
 */

import festivalPlanner.gui.gui_views.StageView;
import javafx.geometry.Point2D;

import java.io.Serializable;
import java.util.ArrayList;

public class Stage implements Serializable {

    private String name;
    private int capacity;
    private int surface;
    private boolean isIndoor;
    private String placement;
    private int firstAidKits;

    public Stage(String name, int capacity, int surface, boolean isIndoor, String placement, int firstAidKits) {
        this.name = name;
        this.capacity = capacity;
        this.surface = surface;
        this.isIndoor = isIndoor;
        this.placement = placement;
        this.firstAidKits = firstAidKits;
    }

    public Stage(String name, int capacity, boolean isIndoor, String placement, int firstAidKits) {
        this.name = name;
        this.capacity = capacity;
        this.isIndoor = isIndoor;
        this.placement = placement;
        this.firstAidKits = firstAidKits;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setSurface(int surface) {
        this.surface = surface;
    }

    public void setIndoor(boolean indoor) {
        isIndoor = indoor;
    }


    public void setFirstAidKits(int firstAidKits) {
        this.firstAidKits = firstAidKits;
    }

    @Override
    public String toString() {
      return this.name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSurface() {
        return surface;
    }

    public boolean isIndoor() {
        return isIndoor;
    }

    public int getFirstAidKits() {
        return firstAidKits;
    }

    public String getPlacement() {
        return placement;
    }

    public void setPlacement(String placement) {
        this.placement = placement;
    }
}
