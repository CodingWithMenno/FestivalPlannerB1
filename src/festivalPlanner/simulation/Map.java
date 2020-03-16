package festivalPlanner.simulation;

import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import org.jfree.fx.FXGraphics2D;

import javax.imageio.ImageIO;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

public class Map {

    private int width;
    private int height;

    private int tileHeight;
    private int tileWidth;

    private ArrayList<Layer> layers = new ArrayList<>();

    private ArrayList<BufferedImage> tiles = new ArrayList<>();

    public Map(String fileName) {
        JsonReader reader = null;
        reader = Json.createReader(getClass().getResourceAsStream(fileName));
        JsonObject root = reader.readObject();

        this.width = root.getInt("width");
        this.height = root.getInt("height");
        this.tileWidth = root.getInt("tilewidth");
        this.tileHeight = root.getInt("tileheight");
        for (JsonValue value :root.getJsonArray("layers")) {

            JsonObject object = (JsonObject)value;

            ArrayList<Integer> dataVal = new ArrayList<>();
            for (JsonValue val : object.getJsonArray("data")){
                dataVal.add(Integer.parseInt(val.toString()));
            }

            int height = object.getInt("height");
            int width = object.getInt("width");
            int id = object.getInt("id");
            int opacity = object.getInt("opacity");
            int x = object.getInt("x");
            int y = object.getInt("y");

            String name = object.getString("name");
            String type = object.getString("type");

            Boolean visible = object.getBoolean("visible");


            Layer layer = new Layer(dataVal, height, width, id, name, opacity, type, visible, x, y);

            this.layers.add(layer);

        }

        for (JsonValue value :root.getJsonArray("tilesets")){
            JsonObject object = (JsonObject)value;

            try {
                BufferedImage image = ImageIO.read(getClass().getResourceAsStream(object.getString("image")));



                Tileset set = new Tileset(
                        object.getString("name"),
                        object.getInt("columns"),
                        object.getInt("firstgid"),
                        object.getInt("imageheight"),
                        object.getInt("imagewidth"),
                        object.getInt("tilecount"),
                        object.getInt("tileheight"),
                        object.getInt("tilewidth"),
                        image);

                assureSize(tiles, set.getFirstGid() + set.getTileCount());
                for(int y = 0; y < set.getImageHeight() / tileHeight; y += 1){
                    for(int x = 0; x < set.getImageWidth()/ tileWidth; x += 1){
                        BufferedImage subImage = image.getSubimage(x * tileWidth,y * tileHeight,tileWidth, tileHeight);
                        int index = (set.getFirstGid() + (y * (set.getImageWidth()/tileWidth)) + x);
                        tiles.add(index, subImage);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }


        }

    }

    private void assureSize(ArrayList<BufferedImage> tiles, int count) {
        while (tiles.size()<count){
            tiles.add(null);
        }
    }

    public void drawMap(FXGraphics2D graphics){
        for(Layer layer : layers){

            int i = 0;

            for(int y = 0; y < layer.getHeight(); y ++) {

                for (int x = 0; x < layer.getWidth(); x ++) {

                    Integer tileId = layer.getData().get(i);
                    graphics.drawImage(tiles.get(tileId), x * tileWidth, y * tileHeight, null);

                    i++;
                }
            }
        }
    }
}
