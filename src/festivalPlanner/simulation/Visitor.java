package festivalPlanner.simulation;

import javafx.scene.canvas.Canvas;
import javafx.scene.shape.Sphere;
import org.jfree.fx.FXGraphics2D;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Random;

public class Visitor implements Updatable{

    private Point2D position;
    private Point2D targetPos;
    private double speed;
    private double angle;
    private Ellipse2D hitbox;
    private double rotationSpeed;
    private ArrayList<Visitor> otherVisitors;
    private Point2D lastPosition;

    private ArrayList<GridPosition> path = new ArrayList<>();
    private int pathArrayIndex = 1;

    public Visitor(Point2D position) {
        this.position = position;
        this.lastPosition = new Point2D.Double(position.getX(),position.getY());
        Random random = new Random();
        //this.position = new Point2D.Double(random.nextInt(2000), random.nextInt(2000));
        this.speed = 1.4;
        this.rotationSpeed = 0.1;
        this.hitbox = new Ellipse2D.Double(this.position.getX(), this.position.getY(), 6, 6);
        this.targetPos = new Point2D.Double(this.position.getX(),this.position.getY());
        this.angle = 1;
    }


    @Override
    public void draw(FXGraphics2D g2d) {
        for(GridPosition gridPosition : this.path){
            g2d.setColor(Color.GREEN);
            g2d.fill(new Rectangle2D.Double(gridPosition.getxPos(),gridPosition.getyPos(),1,1));
        }
        g2d.draw(this.hitbox);
        g2d.fill(this.hitbox);
    }

    @Override
    public void update(Canvas canvas) {

        if (path.isEmpty()) {

        } else {
            this.targetPos = new Point2D.Double(this.path.get(this.pathArrayIndex).getxPos(), this.path.get(this.pathArrayIndex).getyPos());

            if (this.path.size() - 1 != this.pathArrayIndex) {
                this.pathArrayIndex++;
            }else {
                this.lastPosition = new Point2D.Double(this.path.get(this.pathArrayIndex).getxPos(), this.path.get(this.pathArrayIndex).getyPos());
            }


            double targetAngle = Math.atan2(this.targetPos.getY() - this.position.getY(), this.targetPos.getX() - this.position.getX());

            double angleDifference = this.angle - targetAngle;
            while (angleDifference < -Math.PI) {
                angleDifference += 2 * Math.PI;
            }
            while (angleDifference > Math.PI) {
                angleDifference -= 2 * Math.PI;
            }

            if (Math.abs(angleDifference) < this.rotationSpeed) {
                this.angle = targetAngle;
            } else if (angleDifference < 0) {
                this.angle += rotationSpeed;
            } else {
                this.angle -= this.rotationSpeed;
            }

            turn(this.angle);

            Point2D newPos = new Point2D.Double(this.position.getX() + this.speed * Math.cos(this.angle), this.position.getY() + this.speed * Math.sin(this.angle));

            if (!collision(newPos)) {
                this.position.setLocation(newPos);
            } else {
                this.angle -= this.rotationSpeed * 2;
            }

            this.hitbox = new Ellipse2D.Double(this.position.getX(), this.position.getY(), 6, 6);
        }
    }

    private boolean collision(Point2D position) {
        for (Visitor visitor : this.otherVisitors) {
            if (position.distance(visitor.getPosition()) < this.hitbox.getWidth()) {
                if (visitor != this) {
                    return true;
                }
            }
        }
        return false;
    }

    private void turn(double degrees) {
        AffineTransform tx = new AffineTransform();
        tx.translate(this.position.getX(), this.position.getY());
        //tx.rotate(degrees);
        tx.createTransformedShape(this.hitbox);
    }

    public void setOtherVisitors(ArrayList<Visitor> otherVisitors) {
        this.otherVisitors = otherVisitors;
    }

    public Point2D getPosition() {
        return position;
    }

    public Ellipse2D getHitbox() {
        return hitbox;
    }

    public void setPath(ArrayList<GridPosition> path){
        this.path = path;
        this.pathArrayIndex = 0;
    }

    public Point2D getLastPosition() {
        return lastPosition;
    }
}