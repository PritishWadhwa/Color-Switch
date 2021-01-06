package Tokens;

import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import sample.COLOR;

public class Ball extends Region {
    public Point2D location;
    Pane layer;
    Node view;
    Circle circle;
    int lvl;
    private Point2D acceleration;
    private double mass;
    private double maxSpeed = 10;
    private double width;
    private double height;
    private double centerX;
    private double centerY;
    private double radius;
    private Point2D velocity;
    private COLOR cl;

    public Ball(Pane layer, Point2D location, Point2D velocity, Point2D acceleration, double mass, Group ro, COLOR cl, int l) {
        this.layer = layer;
        this.location = location;
        this.velocity = velocity;
        this.acceleration = acceleration;
        this.mass = mass;
        this.cl = cl;
        width = mass;
        height = width;
        centerX = width / 2.0;
        centerY = height / 2.0;
        radius = width / 2.0;
        circle = new Circle(radius);
        circle.setCenterX(radius);
        circle.setCenterY(radius);
        lvl = l;
        switch (cl) {
            case AQUA:
                circle.setFill(Color.rgb(141, 18, 255));
                break;
            case PURPLE:
                circle.setFill(Color.rgb(53, 226, 242));
                break;
            case YELLOW:
                circle.setFill(Color.rgb(245, 223, 15));
                break;
            case PINK:
                circle.setFill(Color.rgb(255, 0, 132));
                break;
        }
        ro.getChildren().add(circle);
        ro.getChildren().add(this);
        this.view = circle;
        getChildren().add(view);

        layer.getChildren().add(this);
    }

    public void applyForce(Point2D force) {
        if (lvl == 0) {
            Point2D f = force.multiply(0.07);
            acceleration = acceleration.add(f);
        } else if (lvl == 1) {
            Point2D f = force.multiply(0.08);
            acceleration = acceleration.add(f);
        } else {
            Point2D f = force.multiply(0.1);
            acceleration = acceleration.add(f);
        }
    }

    public void move(int pause) {
        if (pause == 0) {
            velocity = velocity.add(acceleration);
            if (velocity.magnitude() > maxSpeed) {
                velocity = velocity.normalize().multiply(maxSpeed);
            }
            location = location.add(velocity);
            acceleration = new Point2D(0, 0);
        }
    }

    public void bounce() {
        double locationX = location.getX();
        double locationY = location.getY();
        double velocityX = velocity.getX();
        double velocityY = velocity.getY();
        velocityY = -10;
        location = new Point2D(locationX, locationY);
        velocity = new Point2D(velocityX, velocityY);
    }

    public void checkBounds(int cs, int pauseIt) {
        double locationX = location.getX();
        double locationY = location.getY();
        double velocityX = velocity.getX();
        double velocityY = velocity.getY();
        if (pauseIt == 1) {
            System.out.println("ceokl");
            velocityY = 0;
        }
        if (pauseIt == 2) {
            System.out.println("heol");
            velocityY = 0;
            locationY = locationY + 200;
        }
        if (locationY < 10) {
            velocityY = 5;
        }
        if (cs == 0) {
            if (locationY > 675) {
                locationY = 675;
                velocityY = 0;
            }
        } else {
            if (locationY > 820) {
                locationY = 820;
                velocityY = 0;
            }
        }
        location = new Point2D(locationX, locationY);
        velocity = new Point2D(velocityX, velocityY);
    }

    public COLOR getCl() {
        return cl;
    }

    public void setCl(COLOR cl) {
        this.cl = cl;
        switch (cl) {
            case AQUA:
                circle.setFill(Color.rgb(141, 18, 255));
                break;
            case PURPLE:
                circle.setFill(Color.rgb(53, 226, 242));
                break;
            case YELLOW:
                circle.setFill(Color.rgb(245, 223, 15));
                break;
            case PINK:
                circle.setFill(Color.rgb(255, 0, 132));
                break;
        }

    }

    public Circle retCircle() {
        return this.circle;
    }

    public void display() {
        relocate(location.getX() - centerX, location.getY() - centerY);
    }
}