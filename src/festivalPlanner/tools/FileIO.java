package festivalPlanner.tools;


import festivalPlanner.data_system.Artist;
import festivalPlanner.data_system.Event;
import festivalPlanner.data_system.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.ArrayList;

/**
 * This class stores all the data (Artists, events and stages) in a file.
 */

public class FileIO implements Serializable {
    private ObservableList<Artist> FileIOArists;
    private ObservableList<Stage> FileIOStages;
    private ObservableList<Event> FileIOEvents;

    private File artistsFile;

    public FileIO() {
        this.FileIOArists = FXCollections.observableArrayList();
        this.FileIOStages = FXCollections.observableArrayList();
        this.FileIOEvents = FXCollections.observableArrayList();
    }

    public void writeArrayListStage(ObservableList<Stage> arraylist, String path) {

        ArrayList<Stage> templist = new ArrayList<>();
        templist.addAll(arraylist);

        try {
            FileOutputStream f = new FileOutputStream(new File(path));
            ObjectOutputStream obj = new ObjectOutputStream(f);

            FileWriter fwOb = new FileWriter("path", false);
            PrintWriter pwOb = new PrintWriter(fwOb, false);
            pwOb.flush();
            pwOb.close();
            fwOb.close();


            obj.writeObject(templist);

            obj.close();
            f.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        arraylist.clear();
        templist.clear();
    }

    public void writeArrayListArtist(ObservableList<Artist> arraylist, String path) {

        ArrayList<Artist> templist = new ArrayList<>();
        templist.addAll(arraylist);

        try {
            FileOutputStream f = new FileOutputStream(new File(path));
            ObjectOutputStream obj = new ObjectOutputStream(f);

            FileWriter fwOb = new FileWriter("path", false);
            PrintWriter pwOb = new PrintWriter(fwOb, false);
            pwOb.flush();
            pwOb.close();
            fwOb.close();


            obj.writeObject(templist);
            System.out.println("Ik ga writen :)");

            obj.close();
            f.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        arraylist.clear();
        templist.clear();
    }

    public void writeArrayListEvents(ObservableList<Event> arraylist, String path) {

        ArrayList<Event> templist = new ArrayList<>();
        templist.addAll(arraylist);

        try {
            FileOutputStream f = new FileOutputStream(new File(path));
            ObjectOutputStream obj = new ObjectOutputStream(f);

            FileWriter fwOb = new FileWriter("path", false);
            PrintWriter pwOb = new PrintWriter(fwOb, false);
            pwOb.flush();
            pwOb.close();
            fwOb.close();


            obj.writeObject(templist);


            obj.close();
            f.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        arraylist.clear();
        templist.clear();
    }

    public ObservableList<Artist> readArtistFile(String path) {
        ArrayList<Artist> templist = new ArrayList<>();

        this.FileIOArists.removeAll();
        try {
            FileInputStream f = new FileInputStream(new File(path));
            ObjectInputStream obj = new ObjectInputStream(f);

            try {
                templist = (ArrayList<Artist>) obj.readObject();

                for (Artist artist : templist) {
                    FileIOArists.add(artist);
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return this.FileIOArists;
    }

    public ObservableList<Stage> readStageFile(String path) {
        ArrayList<Stage> templist = new ArrayList<>();

        this.FileIOStages.removeAll();

        try {
            FileInputStream f = new FileInputStream(new File(path));
            ObjectInputStream obj = new ObjectInputStream(f);

            try {
                templist = (ArrayList<Stage>) obj.readObject();

                System.out.println(templist);

                for (Stage stage : templist) {
                    FileIOStages.add(stage);
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return this.FileIOStages ;
    }

    public ObservableList<Event> readEventFile(String path) {
        ArrayList<Event> templist = new ArrayList<>();

        this.FileIOEvents.removeAll();

        try {
            FileInputStream f = new FileInputStream(new File(path));
            ObjectInputStream obj = new ObjectInputStream(f);

            try {
                templist = (ArrayList<Event>) obj.readObject();

                for (Event event : templist) {
                    FileIOEvents.add(event);
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return this.FileIOEvents;
    }

}
