package festivalPlanner.data_system;

public class Stage {

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

    public String getName(){
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
