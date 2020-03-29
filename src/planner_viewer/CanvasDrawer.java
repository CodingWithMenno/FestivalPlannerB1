package planner_viewer;

import javafx.scene.canvas.Canvas;
import org.jfree.fx.FXGraphics2D;

import java.awt.*;
import java.awt.geom.Line2D;

/**
 * this class draws the timeline.
 */


public class CanvasDrawer extends Canvas {


    private Color timeLineFill = new Color(183,111,136);
    private Color divisionFill = new Color(238,238,238);

    public CanvasDrawer() {

        setWidth(2760);
        setHeight(690);
        
        drawDivision(new FXGraphics2D(getGraphicsContext2D()));
        drawTimeLine(new FXGraphics2D(getGraphicsContext2D()));

    }

    private void drawDivision( FXGraphics2D graphics ){
        System.out.println ( "drawDivision");
        int blockWidthCounter= 0;

        for(int i = 0; i<24;i++){

            if( i % 2 == 0){
                graphics.setPaint(divisionFill);
            }
            else {
                graphics.setPaint(Color.WHITE);
            }
            graphics.fill(new Rectangle(blockWidthCounter, 0, 115, 690));
            blockWidthCounter += 115;
        }
    }

    private void drawTimeLine( FXGraphics2D graphics ){
        System.out.println ("drawTimeLine" );
        graphics.setPaint(timeLineFill);
        graphics.fill(new Rectangle(0,0, 2760,30));

        int blockWidthCounter= 0;

        graphics.setPaint(Color.white);

        for(int i = 0; i<25;i++){
            System.out.println ("drawTimeLine pt. 2" );
            graphics.draw(new Line2D.Double(blockWidthCounter, 5, blockWidthCounter, 25));

            blockWidthCounter += 115;
        }

    }

}
