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

    public FileIO() {
        this.FileIOArists = FXCollections.observableArrayList();
        this.FileIOStages = FXCollections.observableArrayList();
        this.FileIOEvents = FXCollections.observableArrayList();
    }

    public void writeStringToFile(String towrite, String path) {
        try {
            FileWriter writer = new FileWriter(path, true);
            writer.write(towrite);
            writer.write("\r\n");   // write new line
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readStringFromFile(String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeArrayListArtist(ObservableList<Artist> arraylist, String path) {
        readArtistFile("/C:/Users/Davy/Documents/SavedArtists.txt");


        System.out.println("I get this list: ))) : " + arraylist);


        ArrayList<Artist> templist = new ArrayList<>();
        for (Artist artist : arraylist) {
            templist.add(artist);
            System.out.println("Added to the templist, templist is now: " + templist);
        }


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

    public ObservableList<Artist> readArtistFile(String path) {
        ArrayList<Artist> templist = new ArrayList<>();
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


        return FileIOArists;
    }


}
