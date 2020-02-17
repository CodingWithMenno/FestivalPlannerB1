package festivalPlanner.data_system;

import java.io.Serializable;

public class Stage implements Serializable {

    private String name;
    private int capacity;
    private int surface;
    private boolean isIndoor;
    private int emergencyExits;
    private int firstAidKits;

    public Stage(String name, int capacity, int surface, boolean isIndoor, int emergencyExits, int firstAidKits) {
        this.name = name;
        this.capacity = capacity;
        this.surface = surface;
        this.isIndoor = isIndoor;
        this.emergencyExits = emergencyExits;
        this.firstAidKits = firstAidKits;
    }

    public Stage(String name, int capacity, boolean isIndoor, int emergencyExits, int firstAidKits) {
        this.name = name;
        this.capacity = capacity;
        this.isIndoor = isIndoor;
        this.emergencyExits = emergencyExits;
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

    public void setEmergencyExits(int emergencyExits) {
        this.emergencyExits = emergencyExits;
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

    public int getEmergencyExits() {
        return emergencyExits;
    }

    public int getFirstAidKits() {
        return firstAidKits;
    }
}
