package festivalPlanner.data_system;

import festivalPlanner.gui.gui_controllers.EventViewController;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class Event {

    private Artist headArtist;
    private ArrayList<Artist> coArtists;
    private Stage stage;
    private String time;
    private int popularity;
    private ImageView photo;

    private EventViewController eventViewController;
}
