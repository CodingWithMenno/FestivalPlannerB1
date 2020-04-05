package festivalPlanner.simulation;

import festivalPlanner.gui.gui_views.SimulationView;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import org.jfree.fx.FXGraphics2D;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

/**
 * This class draws and takes care of the logic for the timeline scrollbar in the simulation.
 */


public class TimelineScrollBar {

    private Canvas canvas2;
    private FXGraphics2D graphics2;
    private double timex;
    private boolean playing;
    private double speed;
    private Shape time;
    private double timeMinutes;
    private String timeString;
    private Image forward = new Image("file:resources/FastForwardButton.png");
    private Image backward = new Image("file:resources/FastBackwardButton.png");
    private Image play = new Image("file:resources/PlayButton.png");
    private Image pause = new Image("file:resources/PauseButton.png");
    private Font font = new Font("Arial", Font.PLAIN, 24);
    private ArrayList<Visitor> visitors;
    private int hour;
    private boolean on = false;



    public TimelineScrollBar(ArrayList<Visitor> visitors) {
        this.canvas2 = new Canvas();
        graphics2 =  new FXGraphics2D(canvas2.getGraphicsContext2D());
        this.canvas2.setHeight(30);
        this.canvas2.setWidth(1550);
        this.visitors = visitors;
        this.playing = true;
        this.timeMinutes = 0;
        this.timeString = "00:00";
        this.timex = 15;
        this.speed = 0;
    }


//    private void mousePressed(MouseEvent e) {
//        if(e.getX() > 206 && e.getX() < 1646 && e.getY() > 1040 && e.getY() < 1059) {
//            mouseDragged(e);
//        }
//    }
//
//    private void mouseDragged(MouseEvent e) {
//        if(e.getX() > 206 && e.getX() < 1646 && e.getY() > 1040 && e.getY() < 1059) {
//            timex = e.getX();
//            draw(graphics);
//            this.simulationView.getNpcController().update();
//        }
//    }

    public void draw(){
        graphics2.clearRect(0, 0, (int)canvas2.getWidth(), (int)canvas2.getHeight());
        graphics2.setBackground(Color.WHITE);
        Area timeLine = new Area(new Rectangle2D.Double(15,12,1440,6));
        graphics2.setPaint(Color.GRAY);
        graphics2.fill(timeLine);

        Area dragger = new Area(new Ellipse2D.Double(timex-9,7,18,18));
        graphics2.setPaint(Color.RED);
        graphics2.fill(dragger);

        Area overTime = new Area(new Rectangle2D.Double(15,12,timex-15,6));
        graphics2.setPaint(Color.RED);
        graphics2.fill(overTime);

        AffineTransform tx = new AffineTransform();
        tx.translate(1469,24);
        this.time = tx.createTransformedShape(font.createGlyphVector(graphics2.getFontRenderContext(),timeString).getOutline());
        graphics2.setPaint(Color.BLACK);
        graphics2.fill(this.time);

    }

    public HBox makehbox(){
        HBox hBox = new HBox();
        hBox.setStyle("-fx-background-color: White;");
        hBox.setMaxSize(205,30);
        hBox.setMinSize(205,30);

        hBox.setSpacing(10);
        place(hBox,-805,525);

        ImageView forwardView = new ImageView(forward);
        forwardView.setOnMousePressed(event -> {
            if(on) {
                this.hour = (int) timeMinutes / 60;
                int toTime = (this.hour + 1) * 60;
                if (toTime <= 1440) {
                    timex = toTime + 15;
                }

            }});

        ImageView backwardView = new ImageView(backward);
        backwardView.setOnMousePressed(event -> {
            if(on) {
                this.hour = (int) timeMinutes / 60;
                int toTime = (this.hour - 1) * 60;
                if (toTime >= 0) {
                    timex = toTime + 15;
                }
            }});


        ImageView pauseView = new ImageView(pause);
        pauseView.setOnMousePressed(event -> {
            if (on) {
                if (this.playing) {
                    pauseView.setImage(play);
                    this.speed = 0;
                    for (Visitor visitor : visitors) {
                        visitor.setSpeed(0);
                        visitor.setRotationSpeed(0.2);
                    }
                } else {
                    pauseView.setImage(pause);
                    this.speed = 0.015;
                    for (Visitor visitor : visitors) {
                        visitor.setSpeed(1.5);
                        visitor.setRotationSpeed(0.2);
                    }
                }
                this.playing = !this.playing;

            }});

        hBox.getChildren().addAll(backwardView,pauseView,forwardView,canvas2);
        return hBox;
    }

    public void update(){
        timex+=speed;

        if(timex >= 1455){
            timex = 1455;
        }
        if(timex <= 15){
            timex = 15;
        }
        this.timeMinutes = (int)timex -15;

        setTimeString();
    }

    /**
     * The method below converts the amount of minutes to a time string.
     */

    public void setTimeString(){

        int hours = (int) (timeMinutes / 60);
        double minutes = timeMinutes / 60;
        minutes = minutes % 1;
        minutes = Math.round(minutes * 60);
        String testString = minutes+"";
        String testString2 = hours+"";
        if(testString.length() == 3) {
            if(testString2.length() == 1){
                this.timeString = "0"+hours + ":0" + (int) minutes;
            }else {
                this.timeString = hours + ":0" + (int) minutes;
            }
        }else {
            if(testString2.length() == 1){
                this.timeString = "0"+hours + ":" + (int) minutes;
            }else {
                this.timeString = hours + ":" + (int) minutes;
            }

        }
    }

    private void place(Node node, int x, int y) {
        node.setLayoutX(x);
        node.setLayoutY(y);
        node.setTranslateX(x);
        node.setTranslateY(y);
    }

    public double getTimeMinutes() {
        return timeMinutes;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public void setTimex(int time){
        this.timex = time;
    }

}
