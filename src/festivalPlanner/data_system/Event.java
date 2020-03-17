package festivalPlanner.data_system;

import festivalPlanner.gui.StageManager;
import festivalPlanner.gui.gui_controllers.EventViewController;
import javafx.scene.image.ImageView;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * An event needs a head artist, stage, starting time, ending time, popularity, photo, and sometimes
 * one or more co artists. This class stores these attributes.
 */

public class Event implements Serializable {

    private Artist headArtist;
    private Artist coArtist;
    private String stage;
    private double startTime;
    private double endTime;
    private String popularity;
    private String photoURL;
    private boolean hasCoArtist;



    public Event(Artist headArtist, String stage, double startTime, double endTime, String popularity) {
        this.hasCoArtist = false;
        this.headArtist = headArtist;
        this.stage = stage;
        this.startTime = startTime;
        this.endTime = endTime;
        this.popularity = popularity;
        this.photoURL = this.headArtist.getArtistPhoto();

    }

    public Event(Artist headArtist, Artist coArtist, String stage, double startTime, double endTime, String popularity) {
        this.hasCoArtist = true;
        this.headArtist = headArtist;
        this.coArtist = coArtist;
        this.stage = stage;
        this.startTime = startTime;
        this.endTime = endTime;
        this.popularity = popularity;
        this.photoURL = this.headArtist.getArtistPhoto();

    }

    public Artist getHeadArtist() {
        return headArtist;
    }

    public Artist getCoArtist() {
        return coArtist;
    }

    public String getStage() {
        return stage;
    }

    public double getStartTime() {
        return startTime;
    }

    public double getEndTime() {
        return endTime;
    }

    public double getPopularity() {
        if(popularity.equals("0%")){
            return 0.0;
        } else if(popularity.equals("100%")){
            return 100.0;
        } else {
            String a = popularity.charAt(0) +""+ popularity.charAt(1)+"";
            double b = Double.parseDouble(a);
            return Integer.parseInt(a);
        }
    }

    public String getPhotoURL() {
        return photoURL;
    }

    public String toString(){
        return this.headArtist.getName() +" "+ startTime + " - " + endTime;
    }

    public boolean HasCoArtist() {
        return hasCoArtist;
    }
}
