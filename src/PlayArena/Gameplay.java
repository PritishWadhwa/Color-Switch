package PlayArena;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Tokens.Ball;
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
    public static int Ball_COUNT = 1;
    public static Point2D FORCE_GRAVITY = new Point2D(0, 9.8);
    public static double Ball_MAX_SPEED = 15;
    private final Stage mainStage;
    Group ro;
    Pane playfield;
    List<Ball> allBalls = new ArrayList<>();
    AnimationTimer gameLoop;
    Scene scene;
    public Gameplay() {
        playfield = new Pane();
        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                System.out.println("Hello World");
                allBalls.forEach(Ball::bounce);
                allBalls.forEach(Ball::display);
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
        for (int i = 0; i < Ball_COUNT; i++) {
            addBall();
        }
    }
    private void startGame() {
        gameLoop = new AnimationTimer() {
            @Override
            public void handle(long now) {
                allBalls.forEach(s -> s.applyForce(FORCE_GRAVITY));
                allBalls.forEach(Ball::move);
                allBalls.forEach(Ball::checkBounds);
                allBalls.forEach(Ball::display);
            }
        };
        gameLoop.start();
    }
    private void addBall() {
        double x = 300;
        double y = 50;
        Point2D location = new Point2D(x, y);
        Point2D velocity = new Point2D(0, 0);
        Point2D acceleration = new Point2D(0, 0);
        double mass = 20;
        Ball Ball = new Ball(playfield, location, velocity, acceleration, mass,ro);
        allBalls.add(Ball);
    }
    public Stage getMainStage() {
        return mainStage;
    }
}
