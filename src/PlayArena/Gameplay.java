package PlayArena;

import sample.COLOR;
import Tokens.Ball;
import Tokens.ObjDisc;
import Tokens.ObjLine;
import javafx.animation.AnimationTimer;
import javafx.animation.PauseTransition;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Gameplay extends JPanel {
    private static final double HEIGHT = 850.0;
    private static final double WIDTH = 560.0;
    public static Point2D FORCE_GRAVITY = new Point2D(0, 8);
    private final Stage mainStage;
    Group ro;
    Pane playfield;
    AnimationTimer gameLoop;
    Scene scene;
    private int curScore;
    private Ball ball;

    public Gameplay() throws FileNotFoundException {
        playfield = new Pane();
        setCurScore(0);
        ImageView hand = makeImage("images/hand.png", 267, 600, 100, 100, true);
        Text scoreDisplay = makeText(50, Integer.toString(getCurScore()), 10.0, 50.0, 5.0);
        ro = new Group(playfield, hand, scoreDisplay);
        setBall();

        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                setCurScore(getCurScore() + 1);
                ball.bounce();
                ball.display();
                PauseTransition pause = new PauseTransition(Duration.millis(0));
                pause.setOnFinished(et -> {
                    scoreDisplay.setText(Integer.toString(getCurScore()));
                });
                pause.play();

            }
        };

        new ObjLine(ro);
        new ObjDisc(ro);
        playfield.setPrefSize(WIDTH, HEIGHT);

        startGame();
        scene = new Scene(ro, WIDTH, HEIGHT, Color.rgb(41, 41, 41));
        scene.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
        mainStage = new Stage();
        mainStage.setScene(scene);
    }

    public Rectangle returnRect(double x, double y, double h, double w, double strokeW, double arch, double arcw) {
        Rectangle rect = new Rectangle();
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

    private void startGame() {
        gameLoop = new AnimationTimer() {
            @Override
            public void handle(long now) {
//                if (ball.location.getY() < 400)
//                    ball.setVisible(false);
                ball.applyForce(FORCE_GRAVITY);
                ball.move();
                ball.checkBounds();
                ball.display();
            }
        };
        gameLoop.start();
    }

    private void setBall() {
        double x = 280;
        double y = 750;
        Point2D location = new Point2D(x, y);
        Point2D velocity = new Point2D(0, 0);
        Point2D acceleration = new Point2D(0, 0);
        double mass = 20;
        ball = new Ball(playfield, location, velocity, acceleration, mass, ro, COLOR.getRandomColor());
    }

    public int getCurScore() {
        return curScore;
    }

    public void setCurScore(int sc) {
        this.curScore = sc;
    }

    ImageView makeImage(String url, double xPos, double yPos, double height, double width, boolean preserveRatio) throws FileNotFoundException {
        Image img = new Image(new FileInputStream(url));
        ImageView viewImg = new ImageView(img);
        viewImg.setX(xPos);
        viewImg.setY(yPos);
        viewImg.setFitHeight(height);
        viewImg.setFitWidth(width);
        viewImg.setPreserveRatio(preserveRatio);
        return viewImg;
    }

    Text makeText(int size, String str, double xPos, double yPos, double width) {
        Text newText = new Text();
        newText.setFont(Font.font("gothic", FontWeight.BOLD, FontPosture.REGULAR, size));
        newText.setText(str);
        newText.setX(xPos);
        newText.setY(yPos);
        newText.setFill(Color.WHITE);
        newText.setStrokeWidth(width);
        return newText;
    }

    public Scene getMainScene() {
        return scene;
    }

    public Stage getMainStage() {
        return mainStage;
    }
}
