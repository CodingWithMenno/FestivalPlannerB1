package festivalPlanner.simulation;

import java.awt.image.BufferedImage;

public class Tileset {

    private String name;

    private int columns;
    private int firstGid;
    private int imageHeight;
    private int imageWidth;
    private int tileCount;
    private int tileHeight;
    private int tileWidth;

    private BufferedImage image;

    public Tileset(String name, int columns, int firstGid, int imageHeight, int imageWidth, int tileCount, int tileHeight, int tileWidth, BufferedImage image) {
        this.name = name;
        this.columns = columns;
        this.firstGid = firstGid;
        this.imageHeight = imageHeight;
        this.imageWidth = imageWidth;
        this.tileCount = tileCount;
        this.tileHeight = tileHeight;
        this.tileWidth = tileWidth;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public int getFirstGid() {
        return firstGid;
    }

    public void setFirstGid(int firstGid) {
        this.firstGid = firstGid;
    }

    public int getImageHeight() {
        return imageHeight;
    }

    public void setImageHeight(int imageHeight) {
        this.imageHeight = imageHeight;
    }

    public int getImageWidth() {
        return imageWidth;
    }

    public void setImageWidth(int imageWidth) {
        this.imageWidth = imageWidth;
    }

    public int getTileCount() {
        return tileCount;
    }

    public void setTileCount(int tileCount) {
        this.tileCount = tileCount;
    }

    public int getTileHeight() {
        return tileHeight;
    }

    public void setTileHeight(int tileHeight) {
        this.tileHeight = tileHeight;
    }

    public int getTileWidth() {
        return tileWidth;
    }

    public void setTileWidth(int tileWidth) {
        this.tileWidth = tileWidth;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }
}
