package PlayArena;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javafx.animation.*;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.swing.*;

public class Gameplay extends JPanel {
    public static double SCENE_WIDTH = 800;
    public static double SCENE_HEIGHT = 700;
    public static int SPRITE_COUNT = 1;
    public static Point2D FORCE_GRAVITY = new Point2D(0, 9.8);
    public static double SPRITE_MAX_SPEED = 15;
    private final Stage mainStage;
    Group ro;
    Pane playfield;
    List<Sprite> allSprites = new ArrayList<>();
    AnimationTimer gameLoop;
    Scene scene;
    public Gameplay() {
        playfield = new Pane();
        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                System.out.println("Hello World");
                allSprites.forEach(Sprite::bounce);
                allSprites.forEach(Sprite::display);
            }
        };
        ro =new Group();

        Rectangle rect = returnRect(200,200,150,18,0,20,20);
        rect.setFill(Color.LIMEGREEN);
        Rectangle rect1 = returnRect(218,332,18,150,0,20,20);
        Rectangle rect2 = returnRect(200,200,18,150,0,20,20);
        Rectangle rect3 = returnRect(350,200,150,18,0,20,20);
        rect1.setFill(Color.RED);
        rect2.setFill(Color.BLUE);
        rect3.setFill(Color.YELLOW);
        final Rotate rotateCWCC2 = new Rotate(0, 275, 275);
        rect.getTransforms().add(rotateCWCC2);
        rect1.getTransforms().add(rotateCWCC2);
        rect2.getTransforms().add(rotateCWCC2);
        rect3.getTransforms().add(rotateCWCC2);
        final Timeline ra = new Timeline();
        ra.getKeyFrames().add(new KeyFrame(Duration.seconds(4), new KeyValue(rotateCWCC2.angleProperty(), 360)));
        ra.setCycleCount(Animation.INDEFINITE);
        ra.play();
        playfield.setPrefSize(SCENE_WIDTH, SCENE_HEIGHT);
        prepareGame();
        startGame();
        ro.getChildren().add(rect);
        ro.getChildren().add(rect1);
        ro.getChildren().add(rect2);
        ro.getChildren().add(rect3);
        ro.getChildren().add(playfield);
        scene = new Scene(ro, SCENE_WIDTH, SCENE_HEIGHT);
        scene.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
        mainStage = new Stage();
        mainStage.setScene(scene);
    }
    public Rectangle returnRect(double x,double y,double h,double w ,double strokeW,double arch,double arcw) {
        Rectangle rect =new Rectangle();
        rect.setX(x);
        rect.setY(y);
        rect.setHeight(h);
        rect.setWidth(w);
        rect.setFill(Color.LIMEGREEN);
        rect.setStrokeWidth(strokeW);
        rect.setArcHeight(arch);
        rect.setArcWidth(arcw);
        return rect;
    }
    private void prepareGame() {
        for (int i = 0; i < SPRITE_COUNT; i++) {
            addSprite();
        }
    }
    private void startGame() {
        gameLoop = new AnimationTimer() {
            @Override
            public void handle(long now) {
                allSprites.forEach(s -> s.applyForce(FORCE_GRAVITY));
                allSprites.forEach(Sprite::move);
                allSprites.forEach(Sprite::checkBounds);
                allSprites.forEach(Sprite::display);
            }
        };
        gameLoop.start();
    }
    private void addSprite() {
        double x = 300;
        double y = 50;
        Point2D location = new Point2D(x, y);
        Point2D velocity = new Point2D(0, 0);
        Point2D acceleration = new Point2D(0, 0);
        double mass = 20;
        Sprite sprite = new Sprite(playfield, location, velocity, acceleration, mass);
        allSprites.add(sprite);
    }
    public class Sprite extends Region {
        Point2D location;
        Point2D velocity;
        Point2D acceleration;
        double mass;
        double maxSpeed = SPRITE_MAX_SPEED;
        Node view;
        double width;
        double height ;
        double centerX ;
        double centerY;
        double radius;
        Pane layer;
        public Sprite( Pane layer, Point2D location, Point2D velocity, Point2D acceleration, double mass) {
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
    public Stage getMainStage() {
        return mainStage;
    }
}
