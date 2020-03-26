package festivalPlanner.gui.gui_views;

import festivalPlanner.data_system.Data;
import festivalPlanner.gui.SceneHandler;
import festivalPlanner.gui.gui_controllers.NPCController;
import festivalPlanner.simulation.RouteFollower;
import festivalPlanner.simulation.TimelineScrollBar;
import festivalPlanner.simulation.Map;
import festivalPlanner.simulation.Visitor;
import festivalplanner_guiModules.buttons.showButton;
import javafx.animation.AnimationTimer;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.image.WritableImage;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.StackPane;
import org.jfree.fx.FXGraphics2D;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;


public class SimulationView extends StackPane {

    private Data data;
    private Canvas canvas;

    private FXGraphics2D graphics;
    private SceneHandler sceneHandler;

    private TimelineScrollBar scrollBar;
    private Map map;
    private ArrayList<Visitor> visitors;
    private BufferedImage image;
    private AffineTransform affineTransform;
    private AffineTransform canvastx;
    private NPCController npcController;
    private AnimationTimer animationTimer;
    private RouteFollower routeFollower;
    private boolean zoomedIn = false;
    private boolean updateNpccontroller = true;
    private int zoomx = 960;
    private int zoomy = 540;

    public SimulationView(Data data, SceneHandler sceneHandler) {
        this.sceneHandler = sceneHandler;
        this.data = data;
        whats();
        this.canvas.setFocusTraversable(true);
        this.canvas.setOnScroll(event -> onScrolled(event));
        this.canvas.setOnKeyPressed(event -> keyPressed(event));


        this.animationTimer = new AnimationTimer() {
            long last = -1;
            @Override
            public void handle(long now) {
                if(last == -1)
                    last = now;
                update((now - last) / 1000000000.0);
                last = now;
                draw(graphics);
            }
        };
        this.animationTimer.start();
    }


    public void whats(){
        setWidth(1920);
        setHeight(1080);
        map = new Map("proftaakmap4.json");
        this.affineTransform = new AffineTransform();
        this.canvastx = new AffineTransform();
        this.canvas = new Canvas();

        graphics = new FXGraphics2D(canvas.getGraphicsContext2D());

        this.canvas.setHeight(1080);
        this.canvas.setWidth(1920);


        this.map.drawMap(graphics);

        WritableImage image = canvas.snapshot(new SnapshotParameters(), null);

        File file = new File("map.png");

        try {
           ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);

           this.image = ImageIO.read(getClass().getResource("map.png"));

        } catch (IOException e) {
        }

        this.visitors = new ArrayList<>();
        this.scrollBar = new TimelineScrollBar(this.visitors);
        this.routeFollower = new RouteFollower(1088,1920);
        this.npcController = new NPCController(scrollBar,data,visitors,routeFollower);
        this.routeFollower.buildRouteMap(map.getPathLayer("Pad").getData());


        Button BackButton = new showButton("Exit",60,35);
        BackButton.setOnAction(event -> {
            try {
                this.animationTimer.stop();
                this.sceneHandler.toMainView();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });

        BackButton.setLayoutX(925);
        BackButton.setLayoutY(-505);
        BackButton.setTranslateX(925);
        BackButton.setTranslateY(-505);


        getChildren().addAll(canvas,scrollBar.makehbox(),BackButton);

//        for (int i = 0; i < 1; i++) {
//            this.visitors.add(new Visitor(new Point2D.Double(992, 850+(i*11))));
//        }
//
        for (int b = 0; b<4; b++) {
            for (int i = 0; i < 15; i++) {
                this.visitors.add(new Visitor(new Point2D.Double(960+(b*20), 760 + (i * 20))));
            }
        }
//        for (int i = 0; i < 20; i++) {
//            this.visitors.add(new Visitor(new Point2D.Double(1003, 850+(i*11))));
//        }
//        for (int i = 0; i < 20; i++) {
//            this.visitors.add(new Visitor(new Point2D.Double(981, 850+(i*11))));
//        }

        for (Visitor visitor : this.visitors) {
            visitor.setOtherVisitors(this.visitors);
        }


    }


    public void update(double deltatime){
        for (Visitor visitor : this.visitors) {
            visitor.update(this.canvas);
        }

        this.scrollBar.update();
        if(this.scrollBar.getTimeMinutes() % 60 == 1 && this.updateNpccontroller){
            npcController.update();
            this.updateNpccontroller = false;
        }
        if (this.scrollBar.getTimeMinutes() % 60 == 2){
            this.updateNpccontroller = true;
        }

    }

    public void draw(FXGraphics2D graphics) {
        graphics.setTransform(canvastx);
        graphics.clearRect(0, 0, (int)canvas.getWidth(), (int)canvas.getHeight());
        graphics.setBackground(Color.WHITE);

        graphics.drawImage(this.image,affineTransform,null);

        for (Visitor visitor : this.visitors) {
            visitor.draw(graphics);
        }

        this.scrollBar.draw();


    }


    public void keyPressed(KeyEvent e) {
        if (this.zoomedIn) {
            if (e.getCode() == KeyCode.RIGHT) {
                if (zoomx < 1920) {
                    canvastx.translate(-20, 0);
                    this.zoomx -= -40;
                }
            }
            else if (e.getCode() == KeyCode.LEFT) {
                if (zoomx > 0) {
                    canvastx.translate(20, 0);
                    this.zoomx -= 40;
                }
            }else if (e.getCode() == KeyCode.DOWN) {
                if (zoomy < 1080) {
                    canvastx.translate(0, -15);
                    this.zoomy -= -30;
                }
            }else if (e.getCode() == KeyCode.UP) {
                if (zoomy > 0) {
                    canvastx.translate(0, 15);
                    this.zoomy -= 30;
                }
            }

        }
    }
    public void onScrolled(ScrollEvent e){
        if(e.getDeltaY() > 0 && !zoomedIn){
            canvas.setScaleX(2);
            canvas.setScaleY(2);
            zoomedIn = true;
        }else if (e.getDeltaY() < 0 && zoomedIn){
            canvas.setScaleX(1);
            canvas.setScaleY(1);
            canvastx = new AffineTransform();
            this.zoomx = 960;
            this.zoomy = 540;
            zoomedIn = false;
        }
    }
}
