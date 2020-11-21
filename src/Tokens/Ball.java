package Tokens;

import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Ball extends Region {
    Point2D location;
    Point2D velocity;
    Point2D acceleration;
    double mass;
    double maxSpeed = 15;
    Node view;
    double width;
    double height ;
    double centerX ;
    double centerY;
    double radius;
    Pane layer;
    public Ball( Pane layer, Point2D location, Point2D velocity, Point2D acceleration, double mass, Group ro) {
        this.layer = layer;
        this.location = location;
        this.velocity = velocity;
        this.acceleration = acceleration;
        this.mass = mass;
        width = mass;
        height = width;
        centerX = width / 2.0;
        centerY = height / 2.0;
        radius = width / 2.0;
        Circle circle = new Circle( radius);
        circle.setCenterX(radius);
        circle.setCenterY(radius);
        circle.setStroke(Color.BLUE);
        circle.setFill(Color.BLUE.deriveColor(1, 1, 1, 0.3));
        ro.getChildren().add(circle);
        ro.getChildren().add(this);
        this.view = circle;
        getChildren().add( view);

        layer.getChildren().add( this);
    }

    public void applyForce(Point2D force) {
        Point2D f = force.multiply( 0.09);
        acceleration = acceleration.add(f);
    }
    public void move() {
        velocity = velocity.add(acceleration);
        if( velocity.magnitude() > maxSpeed) {
            velocity = velocity.normalize().multiply(maxSpeed);
        }
        location = location.add(velocity);
        acceleration = new Point2D( 0, 0);
    }
    public void bounce() {
        double locationX = location.getX();
        double locationY = location.getY();
        double velocityX = velocity.getX();
        double velocityY = velocity.getY();
        System.out.println(velocityY);
        velocityY = -15;
        location = new Point2D( locationX, locationY);
        velocity = new Point2D( velocityX, velocityY);
    }
    public void checkBounds() {
        double locationX = location.getX();
        double locationY = location.getY();
        double velocityX = velocity.getX();
        double velocityY = velocity.getY();
        if (locationY > layer.getHeight() - radius) {
            locationY = layer.getHeight() - radius;
            velocityY=0;
        }
        location = new Point2D( locationX, locationY);
        velocity = new Point2D( velocityX, velocityY);
    }

    public void display() {
        relocate(location.getX() - centerX, location.getY() - centerY);
    }
}
