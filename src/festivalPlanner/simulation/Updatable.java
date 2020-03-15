package festivalPlanner.simulation;

import javafx.scene.canvas.Canvas;
import org.jfree.fx.FXGraphics2D;

public interface Updatable {

    void draw(FXGraphics2D g2d);
    void update(Canvas canvas);
}
