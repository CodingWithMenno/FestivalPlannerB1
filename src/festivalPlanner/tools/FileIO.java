package festivalPlanner.tools;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * This class stores all the data (Artists, events and stages) in a file.
 */

public class FileIO {

    public void writeStringToFile(String towrite, String path){
        try {
            FileWriter writer = new FileWriter(path, true);
            writer.write(towrite);
            writer.write("\r\n");   // write new line
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readStringFromFile(String path){
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeArrayList(ArrayList<String> arraylist, String path){
        try {
            FileWriter writer = new FileWriter(path, true);

            for (int i = 0; i < arraylist.size(); i++) {
                writer.write(arraylist.get(i));
                writer.write("\r\n");   // write new line
                if (arraylist.size() == (i + 1)) {
                    writer.write("#");
                    writer.write("\r\n");
                }
            }

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> readArrayList(String path){
        ArrayList<String> returnlist = new ArrayList<String>();


        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                    returnlist.add(line);
                if (line.equals("#")) {
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    return returnlist;}




}
