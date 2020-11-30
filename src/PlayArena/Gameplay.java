package PlayArena;

import Menus.PauseGameMenu;
import Tokens.*;
import javafx.animation.AnimationTimer;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import sample.COLOR;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Gameplay extends Application {
    private static final double HEIGHT = 850.0;
    private static final double WIDTH = 560.0;
    public static Point2D FORCE_GRAVITY = new Point2D(0, 8);
    public Text scoreDisplay;
    public int f = 1;
    Group ro;
    Pane playfield;
    AnimationTimer gameLoop;
    Scene scene;
    private int curScore;
    private Ball ball;
    private Star star1, star2;
    private ColorSwapper swapper;

    public void start(Stage stage) throws FileNotFoundException {
        playfield = new Pane();
        PauseGameMenu pauseMenu = new PauseGameMenu();
        setCurScore(0);
        ImageView pauseButton = makeImage("images/pause.png", 480, 6, 180, 80, true);
        ImageView hand = makeImage("images/hand.png", 256, 685, 100, 100, true);
        Circle pcircle = makeCircle(519, 47, 40, Color.rgb(88, 88, 88));
        scoreDisplay = makeText(80, Integer.toString(getCurScore()), 1.0, 80.0, 5.0);
        ro = new Group(playfield, pcircle, hand, scoreDisplay, pauseButton);
        prepareStars();
        pcircle.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                pcircle.setFill(Color.rgb(100, 100, 100));
            }
        });

        pcircle.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                pcircle.setFill(Color.rgb(88, 88, 88));
            }
        });

        pauseButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                pcircle.setFill(Color.rgb(100, 100, 100));
            }
        });

        pauseButton.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                pcircle.setFill(Color.rgb(88, 88, 88));
            }
        });

        pcircle.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    pauseMenu.start(stage);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
        pauseButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    pauseMenu.start(stage);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

            }
        });
        ro.getChildren().add(star1.view);
        ro.getChildren().add(star2.view);
        prepareColorSwapper();
        ro.getChildren().add(swapper.view);
        setBall();

        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                ball.bounce();
                ball.display();
            }
        };

        new ObjLine(ro);
        new ObjDisc(ro);
        playfield.setPrefSize(WIDTH, HEIGHT);

        startGame();
        scene = new Scene(ro, WIDTH, HEIGHT, Color.rgb(41, 41, 41));
        scene.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
        //mainStage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    public void prepareStars() throws FileNotFoundException {
        Point2D l1 = new Point2D(260, 100);
        star1 = new Star(l1);
        Point2D l2 = new Point2D(260, 370);
        star2 = new Star(l2);
    }

    public void prepareColorSwapper() throws FileNotFoundException {
        Point2D l1 = new Point2D(260, 300);
        swapper = new ColorSwapper(l1);
    }


    private void startGame() {
        gameLoop = new AnimationTimer() {
            @Override
            public void handle(long now) {

                if (ball.location.getY() < 120 && f == 3) {
                    f++;
                    star1.view.setVisible(false);
                    setCurScore(getCurScore() + 1);
                    PauseTransition pause = new PauseTransition(Duration.millis(0));
                    pause.setOnFinished(et -> {
                        scoreDisplay.setText(Integer.toString(getCurScore()));
                    });
                    pause.play();
                }
                if (ball.location.getY() < 320 && f == 2) {
                    f++;
                    swapper.view.setVisible(false);
                    PauseTransition pause = new PauseTransition(Duration.millis(0));
                    pause.setOnFinished(et -> {
                        COLOR newColor = COLOR.getRandomColor();
                        while (ball.getCl() == newColor) {
                            newColor = COLOR.getRandomColor();
                        }
                        ball.setCl(newColor);

                    });
                    pause.play();
                }
                if (ball.location.getY() < 390 && f == 1) {
                    f++;
                    star2.view.setVisible(false);
                    setCurScore(getCurScore() + 1);
                    PauseTransition pause = new PauseTransition(Duration.millis(0));
                    pause.setOnFinished(et -> {
                        scoreDisplay.setText(Integer.toString(getCurScore()));
                    });
                    pause.play();
                }
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
        double y = 675;
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

    Circle makeCircle(double xCen, double yCen, double radius, Color color) {
        Circle c = new Circle();
        c.setCenterX(xCen);
        c.setCenterY(yCen);
        c.setFill(color);
        c.setRadius(radius);
        return c;
    }

    public Scene getMainScene() {
        return scene;
    }
}