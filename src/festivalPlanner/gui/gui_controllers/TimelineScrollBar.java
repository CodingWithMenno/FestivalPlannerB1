package festivalPlanner.gui.gui_controllers;

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


public class TimelineScrollBar {

    private Canvas canvas;

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



    public TimelineScrollBar(Canvas canvas) {
        this.canvas = canvas;
        this.playing = true;
        this.timeMinutes = 0;
        this.timeString = "00:00";
        this.timex = 206;
        this.speed = 0.05;
//        setHeight(1080);
//        setWidth(1920);
//        this.canvas.setHeight(1080);
//        this.canvas.setWidth(1920);
        this.canvas.setOnMousePressed(e -> mousePressed(e));
        this.canvas.setOnMouseDragged(e -> mouseDragged(e));
//        draw(new FXGraphics2D(canvas.getGraphicsContext2D()));
        //        getChildren().addAll(canvas,makehbox());

    }


    private void mousePressed(MouseEvent e) {
        if(e.getX() > 206 && e.getX() < 1646 && e.getY() > 995 && e.getY() < 1014) {
            mouseDragged(e);
        }
    }

    private void mouseDragged(MouseEvent e) {
        if(e.getX() > 206 && e.getX() < 1646 && e.getY() > 995 && e.getY() < 1014) {
            timex = e.getX();
            draw(new FXGraphics2D(canvas.getGraphicsContext2D()));
        }
    }

    public void draw(FXGraphics2D graphics){
//        graphics.setTransform(new AffineTransform());
//        graphics.setBackground(Color.WHITE);
//        graphics.clearRect(0, 0, (int)canvas.getWidth(), (int)canvas.getHeight());

//        graphics.setPaint(new Color(183,111,136));
//        graphics.fill(new Rectangle (0,1050,(int)this.getWidth(),30));

        Area timeLine = new Area(new Rectangle2D.Double(206,1000,1440,6));
        graphics.setPaint(Color.GRAY);
        graphics.fill(timeLine);

        Area dragger = new Area(new Ellipse2D.Double(timex-9,995,18,18));
        graphics.setPaint(Color.RED);
        graphics.fill(dragger);

        Area overTime = new Area(new Rectangle2D.Double(206,1000,timex-206,6));
        graphics.setPaint(Color.RED);
        graphics.fill(overTime);

        AffineTransform tx = new AffineTransform();
        tx.translate(1660,1009);
        this.time = tx.createTransformedShape(font.createGlyphVector(graphics.getFontRenderContext(),timeString).getOutline());
        graphics.setPaint(Color.BLACK);
        graphics.fill(this.time);

    }

    public HBox makehbox(){
        HBox hBox = new HBox();
        hBox.setMaxSize(205,30);
        hBox.setMinSize(205,30);

        hBox.setSpacing(10);
        place(hBox,-845,463);

        ImageView forwardView = new ImageView(forward);
        forwardView.setOnMousePressed(event -> {
            this.speed = 1;
        });

        ImageView backwardView = new ImageView(backward);
        backwardView.setOnMousePressed(event -> {
            this.speed = -1;
        });

        ImageView playView = new ImageView(play);
        playView.setOnMousePressed(event -> {

        });

        ImageView pauseView = new ImageView(pause);
        pauseView.setOnMousePressed(event -> {
            if(this.playing){
                pauseView.setImage(play);
                this.speed = 0;
            }else {
                pauseView.setImage(pause);
                this.speed = 0.05;
            }
            this.playing = !this.playing;

        });

        hBox.getChildren().addAll(backwardView,pauseView,forwardView);
        return hBox;
    }

    public void update(){
        timex+=speed;

        if(timex >= 1646){
            timex = 1646;
        }
        if(timex <= 206){
            timex = 206;
        }

        this.timeMinutes = (int)timex - 206;
        setTimeString();
    }

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
}
