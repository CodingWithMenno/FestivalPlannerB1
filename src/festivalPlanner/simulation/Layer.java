package festivalPlanner.simulation;

import java.util.ArrayList;

public class Layer {
    private ArrayList<Integer> data;
    private int height;
    private int width;
    private int id;
    private String name;
    private int opacity;
    private String type;
    private boolean visible;
    private int x;
    private int y;

    public Layer(ArrayList<Integer> data, int height, int width, int id, String name, int opacity, String type, boolean visible, int x, int y) {
        this.data = data;
        this.height = height;
        this.width = width;
        this.id = id;
        this.name = name;
        this.opacity = opacity;
        this.type = type;
        this.visible = visible;
        this.x = x;
        this.y = y;
    }

    public ArrayList<Integer> getData() {
        return data;
    }

    public void setData(ArrayList<Integer> data) {
        this.data = data;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOpacity() {
        return opacity;
    }

    public void setOpacity(int opacity) {
        this.opacity = opacity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}

