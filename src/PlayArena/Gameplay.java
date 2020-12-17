package PlayArena;

import Menus.MainMenu;
import Menus.RespawnMenu;
import Menus.SaveGameMenu;
import Tokens.*;
import javafx.animation.*;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import sample.COLOR;
import sample.Main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;


public class Gameplay extends Application {
    private static final double HEIGHT = 850.0;
    private static final double WIDTH = 560.0;
    public static Point2D FORCE_GRAVITY = new Point2D(0, 8);
    public Text scoreDisplay, powerUp;
    public int f = 1;
    protected Pane playfield;
    protected Ball ball;
    RespawnMenu death;
    Group ro;
    AnimationTimer gameLoop;
    Scene scene;
    Timeline timeline = new Timeline();
    Timeline retimeline = new Timeline();
    Rectangle rect = makeRectangle(0, 0, 850, 560, Color.rgb(41, 41, 41));
    Rectangle rerect = makeRectangle(0, 0, 850, 560, Color.rgb(41, 41, 41));
    Circle homeCircle = makeCircle(100, 100, 40, Color.rgb(128, 128, 128));
    Circle centerCircle1 = makeCircle(280, 212.5, 70, Color.rgb(88, 88, 88));
    Circle centerCircle2 = makeCircle(280, 425, 70, Color.rgb(88, 88, 88));
    Circle centerCircle3 = makeCircle(280, 637.5, 70, Color.rgb(88, 88, 88));
    ImageView homeImg = makeImage("images/homeButton.png", 70, 70, 60, 60, true);
    ImageView restartImg = makeImage("images/restartButton.png", 169, 122, 250, 250, true);
    ImageView playImg = makeImage("images/playButton.png", 222, 367, 125, 125, true);
    ImageView saveImg = makeImage("images/saveButton.png", 236, 593, 90, 90, true);
    Circle rehomeCircle = makeCircle(100, 100, 40, Color.rgb(128, 128, 128));
    Circle recenterCircle2 = makeCircle(280, 425, 70, Color.rgb(88, 88, 88));
    Circle recenterCircle3 = makeCircle(280, 637.5, 70, Color.rgb(88, 88, 88));
    ImageView rehomeImg = makeImage("images/homeButton.png", 70, 70, 60, 60, true);
    ImageView rerestartImg = makeImage("images/restartButton.png", 169, 548, 250, 250, true);
    ImageView replayImg = makeImage("images/playButton.png", 222, 367, 125, 125, true);
    MainMenu mainMenu;
    Gameplay gameplay;
    private int curScore;
    private int sd;
    private int alive = 1;
    private Circle block;
    private ArrayList<Shape> nodes;
    private ArrayList<Group> obstacles;
    private Group headgroup;
    private Queue<Star> star_list;
    private Queue<ColorSwapper> swapper_list;
    private double times = 0;
    private int col = 1;
    private int ff = 1;
    private int pauseIt = 0;
    private int noOfDeath = 0;
    private ArrayList<Integer> obslist;
    private BurstBall destroyer;
    private double newball;

    public Gameplay() throws FileNotFoundException {
    }

    public void start(Stage stage) throws FileNotFoundException {
        gameplay = new Gameplay();
        mainMenu = new MainMenu();
        SaveGameMenu saveGameMenu = new SaveGameMenu();
        sd = 1;
        destroyer = new BurstBall();
        death = new RespawnMenu();
        headgroup = new Group();
        playfield = new Pane();
        star_list = new LinkedList<Star>();
        swapper_list = new LinkedList<ColorSwapper>();
        nodes = new ArrayList<>();
        setCurScore(0);
        Rectangle rectLeft = makeRectangle(0, 0, HEIGHT, 100, Color.BLACK);
        Rectangle rectRight = makeRectangle(460, 0, HEIGHT, 100, Color.BLACK);
        ImageView pauseButton = makeImage("images/pause.png", 480, 6, 180, 80, true);
        ImageView hand = makeImage("images/hand.png", 256, 685, 100, 100, true);
        Circle pcircle = makeCircle(519, 47, 40, Color.rgb(88, 88, 88));
        scoreDisplay = makeText(80, Integer.toString(getCurScore()), 1.0, 80.0, 5.0);
        powerUp = makeText(40, "", 1.0, 800.0, 5.0);
        ro = new Group(playfield);
        //prepareStars();

        obstacles = new ArrayList<Group>();
        obslist = new ArrayList<Integer>();
        double y = 380;
        Integer[] intArray = {1, 2, 3, 4};
        for (int i = 0; i < 30; i++) {
            if (i % 4 == 0) {
                List<Integer> intList = Arrays.asList(intArray);
                Collections.shuffle(intList);
                intList.toArray(intArray);
            }
            obslist.add(intArray[i % 4]);
            if (intArray[i % 4] == 1) {
                RingObstacle o = new RingObstacle(playfield, nodes, y);
                prepareStars(y - 10);
                prepareColorSwapper(y - 200);
                obstacles.add(o.returnGrp());
            } else if (intArray[i % 4] == 2) {
                InfiniteLineObstacle o = new InfiniteLineObstacle(playfield, nodes, y);
                prepareStars(y - 50);
                prepareColorSwapper(y - 150);
                obstacles.add(o.returnGrp());
            } else if (intArray[i % 4] == 3) {
                ObjDisc o = new ObjDisc(playfield, nodes, y);
                prepareStars(y - 10);
                prepareColorSwapper(y - 200);
                obstacles.add(o.returnGrp());
            } else {
                ObjLine o = new ObjLine(playfield, nodes, y);
                prepareStars(y - 10);
                prepareColorSwapper(y - 200);
                obstacles.add(o.returnGrp());
            }
            y -= 700;
            headgroup.getChildren().add(obstacles.get(i));
        }
        for (int i = 0; i < 30; i++) {
            System.out.print(obslist.get(i) + " ");
        }
        System.out.println();
        //  pane1.getChildren().addAll(star2.view,swapper.view,star1.view, hand );
        playfield.setPrefSize(WIDTH, HEIGHT);
        ro.getChildren().add(headgroup);
        ro.getChildren().add(rectLeft);
        ro.getChildren().add(rectRight);
        ro.getChildren().add(scoreDisplay);
        ro.getChildren().add(powerUp);
        ro.getChildren().add(pcircle);
        ro.getChildren().add(pauseButton);
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
                    pause(stage, mainMenu, gameplay, saveGameMenu);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
        pauseButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    pause(stage, mainMenu, gameplay, saveGameMenu);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
        setBall(0);
        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                ball.bounce();
                ball.display();
            }
        };
        startGame(stage);
        scene = new Scene(ro, WIDTH, HEIGHT, Color.rgb(41, 41, 41));
        scene.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
        //mainStage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    public void unPause() {
        timeline.play();
        ro.getChildren().remove(rect);
        ro.getChildren().remove(homeCircle);
        ro.getChildren().remove(centerCircle1);
        ro.getChildren().remove(centerCircle2);
        ro.getChildren().remove(centerCircle3);
        ro.getChildren().remove(homeImg);
        ro.getChildren().remove(restartImg);
        ro.getChildren().remove(playImg);
        ro.getChildren().remove(saveImg);
        pauseIt = 0;
        ball.bounce();
        ball.checkBounds(getCurScore(), pauseIt);
//        timeline.setDelay(Duration.millis(2000));
    }

    public void undie() {
        timeline.play();
        ro.getChildren().remove(rerect);
        ro.getChildren().remove(rehomeCircle);
        ro.getChildren().remove(recenterCircle2);
        ro.getChildren().remove(recenterCircle3);
        ro.getChildren().remove(rehomeImg);
        ro.getChildren().remove(rerestartImg);
        ro.getChildren().remove(replayImg);
        col = 1;
        alive = 1;
        pauseIt = 0;
        //ball.bounce();
//        ball.move(pauseIt);
//        ball.checkBounds(getCurScore(),pauseIt);
//        ball.setVisible(true);
        setBall(newball);
        // pauseIt=0;
        // ball.bounce();
        //ball.checkBounds(getCurScore(),pauseIt);
    }

    public void die(Stage stage, MainMenu mainMenu, Gameplay gameplay) {
        pauseIt = 2;
        retimeline.pause();
        if (noOfDeath < 2)
            resizeAnimation(recenterCircle2);
        resizeAnimation(recenterCircle3);
        resizeAnimation(rerestartImg);
        if (noOfDeath < 2)
            resizeAnimation(replayImg);

        rehomeImg.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                rehomeCircle.setFill(Color.rgb(140, 140, 140));
            }
        });

        rehomeCircle.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                rehomeCircle.setFill(Color.rgb(140, 140, 140));
            }
        });

        rehomeImg.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                rehomeCircle.setFill(Color.rgb(128, 128, 128));
            }
        });

        rehomeCircle.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                rehomeCircle.setFill(Color.rgb(128, 128, 128));
            }
        });

        rehomeImg.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    mainMenu.start(stage);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });

        rehomeCircle.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    mainMenu.start(stage);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });

        replayImg.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (noOfDeath < 2)
                    recenterCircle2.setFill(Color.rgb(100, 100, 100));
            }
        });

        recenterCircle2.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (noOfDeath < 2)
                    recenterCircle2.setFill(Color.rgb(100, 100, 100));
            }
        });

        replayImg.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (noOfDeath < 2)
                    recenterCircle2.setFill(Color.rgb(88, 88, 88));
            }
        });

        recenterCircle2.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (noOfDeath < 2)
                    recenterCircle2.setFill(Color.rgb(88, 88, 88));
            }
        });

        replayImg.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (noOfDeath < 2) {
                    destroyer.undoDestroy(ro);
                    undie();
                }
            }
        });

        recenterCircle2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    gameplay.start(stage);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });

        rerestartImg.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                recenterCircle3.setFill(Color.rgb(100, 100, 100));
            }
        });

        rerestartImg.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                recenterCircle3.setFill(Color.rgb(88, 88, 88));
            }
        });


        rerestartImg.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    gameplay.start(stage);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });


        recenterCircle3.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                recenterCircle3.setFill(Color.rgb(100, 100, 100));
            }
        });

        recenterCircle3.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                recenterCircle3.setFill(Color.rgb(88, 88, 88));
            }
        });

        recenterCircle3.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    gameplay.start(stage);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
        ro.getChildren().addAll(rerect, rehomeCircle, rehomeImg, recenterCircle2, replayImg, recenterCircle3, rerestartImg);

    }

    public void pause(Stage stage, MainMenu mainMenu, Gameplay gameplay, SaveGameMenu saveGameMenu) throws FileNotFoundException {
        timeline.pause();
        resizeAnimation(centerCircle1);
        resizeAnimation(centerCircle2);
        resizeAnimation(centerCircle3);
        resizeAnimation(restartImg);
        resizeAnimation(playImg);
        resizeAnimation(saveImg);

        homeImg.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                homeCircle.setFill(Color.rgb(140, 140, 140));
            }
        });
        homeCircle.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                homeCircle.setFill(Color.rgb(140, 140, 140));
            }
        });
        homeImg.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                homeCircle.setFill(Color.rgb(128, 128, 128));
            }
        });
        homeCircle.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                homeCircle.setFill(Color.rgb(128, 128, 128));
            }
        });
        homeImg.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    mainMenu.start(stage);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
        homeCircle.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    mainMenu.start(stage);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
        playImg.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                centerCircle2.setFill(Color.rgb(100, 100, 100));
            }
        });
        centerCircle2.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                centerCircle2.setFill(Color.rgb(100, 100, 100));
            }
        });
        playImg.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                centerCircle2.setFill(Color.rgb(88, 88, 88));
            }
        });
        centerCircle2.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                centerCircle2.setFill(Color.rgb(88, 88, 88));
            }
        });

        playImg.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                unPause();
            }
        });

        centerCircle2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                unPause();
            }
        });

        restartImg.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                centerCircle1.setFill(Color.rgb(100, 100, 100));
            }
        });

        centerCircle1.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                centerCircle1.setFill(Color.rgb(100, 100, 100));
            }
        });

        restartImg.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                centerCircle1.setFill(Color.rgb(88, 88, 88));
            }
        });

        centerCircle1.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                centerCircle1.setFill(Color.rgb(88, 88, 88));
            }
        });

        restartImg.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    gameplay.start(stage);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });

        centerCircle1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    gameplay.start(stage);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });


        saveImg.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                centerCircle3.setFill(Color.rgb(100, 100, 100));
            }
        });

        centerCircle3.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                centerCircle3.setFill(Color.rgb(100, 100, 100));
            }
        });

        saveImg.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                centerCircle3.setFill(Color.rgb(88, 88, 88));
            }
        });

        centerCircle3.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                centerCircle3.setFill(Color.rgb(88, 88, 88));
            }
        });

        saveImg.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    SaveData saveData = new SaveData();
                    saveGameMenu.start(stage, saveData);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });

        centerCircle3.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    SaveData saveData = new SaveData();
                    saveGameMenu.start(stage, saveData);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });

        ro.getChildren().add(rect);
        ro.getChildren().add(homeCircle);
        ro.getChildren().add(centerCircle1);
        ro.getChildren().add(centerCircle2);
        ro.getChildren().add(centerCircle3);
        ro.getChildren().add(homeImg);
        ro.getChildren().add(restartImg);
        ro.getChildren().add(playImg);
        ro.getChildren().add(saveImg);
    }

    public int randomnos(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    private void collide(Shape block, Stage stage, MainMenu mainMenu, Gameplay gameplay) throws InterruptedException {
        boolean collisionDetected = false;
        for (Shape static_bloc : nodes) {
            if (static_bloc != block && col == 1) {
                //static_bloc.setFill(Color.GREEN);
                Shape intersect = Shape.intersect(block, static_bloc);
                if (static_bloc instanceof Arc) {
                    if (intersect.getBoundsInLocal().getWidth() != -1 && !(static_bloc.getStroke()).equals(block.getFill())) {
                        if (ball.location.getY() <= ((Arc) static_bloc).getCenterY() + 100 && ball.location.getY() >= ((Arc) static_bloc).getCenterY() - 100) {
                            collisionDetected = false;
                        } else
                            collisionDetected = true;
                    }
                } else if (col == 1) {
                    if (intersect.getBoundsInLocal().getWidth() != -1 && !(static_bloc.getFill()).equals(block.getFill())) {
                        collisionDetected = true;
                    }
                }
            }
        }
//        if(ball.location.getY()>=750){
//            try {
//                death.start(stage);
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            }
//        }
//        }
        if ((collisionDetected && col == 1)) {
            noOfDeath++;
            alive = 0;
            col++;
            ball.setVisible(false);
            double a = ball.location.getX();
            double b = ball.location.getY();
            newball = b;
            destroyer.prepareDestroy(a, b, stage, playfield, death);
            PauseTransition pause = new PauseTransition(Duration.millis(2000));
            pause.setOnFinished(et -> {
                die(stage, mainMenu, gameplay);
            });
            pause.play();

        }
    }

    public void prepareStars(double y) throws FileNotFoundException {
        Point2D l1 = new Point2D(260, y);
        Star s = new Star(l1, headgroup);
        star_list.add(s);
    }

    public void prepareColorSwapper(double y) throws FileNotFoundException {
        Point2D l1 = new Point2D(260, y);
        ColorSwapper c = new ColorSwapper(l1, headgroup);
        swapper_list.add(c);
    }


    private void startGame(Stage stage) {
        gameLoop = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (ball.location.getY() >= 820 && ff == 1) {
                    alive = 0;
                    noOfDeath++;
                    ball.setVisible(false);
                    ff++;
                    double a = ball.location.getX();
                    double b = ball.location.getY();
                    destroyer.prepareDestroy(a, b, stage, playfield, death);
                    PauseTransition pause = new PauseTransition(Duration.millis(2000));
                    pause.setOnFinished(et -> {
                        die(stage, mainMenu, gameplay);
                    });
                    pause.play();
                }
                if (getCurScore() % 5 != 0 || getCurScore() == 0) {
                    try {
                        collide(block, stage, mainMenu, gameplay);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (ball.isVisible() == true && star_list.element().location.getY() + headgroup.getTranslateY() >= ball.location.getY() - 20) {
                    star_list.element().view.setVisible(false);
                    setCurScore(getCurScore() + 1);
                    Main.setTotalScore(1);
                    PauseTransition pause = new PauseTransition(Duration.millis(0));
                    pause.setOnFinished(et -> {
                        scoreDisplay.setText(Integer.toString(getCurScore()));
                    });
                    pause.play();
                    star_list.remove();
                }
                if (ball.isVisible() == true && ball.location.getY() < 400) {
                    headgroup.setTranslateY(headgroup.getTranslateY() + 2);
                }
                if (ball.isVisible() == true && swapper_list.element().location.getY() + headgroup.getTranslateY() >= ball.location.getY() - 20) {
                    f++;
                    swapper_list.element().view.setVisible(false);
                    PauseTransition pause = new PauseTransition(Duration.millis(0));
                    pause.setOnFinished(et -> {
                        COLOR newColor = COLOR.getRandomColor();
                        while (ball.getCl() == newColor) {
                            newColor = COLOR.getRandomColor();
                        }
                        ball.setCl(newColor);

                    });
                    swapper_list.remove();
                    pause.play();
                }
                if (alive == 1) {
                    ball.applyForce(FORCE_GRAVITY);
                    ball.move(pauseIt);
                    //System.out.println("hf");
                    ball.checkBounds(getCurScore(), pauseIt);
                    ball.display();
                }
            }
        };
        gameLoop.start();
    }

    private void setBall(double k) {
        double x = 280;
        double y = 675;
        if (k > 0) {
            if (k < 500)
                y = k + 220;
            else
                y = k - 200;
        }
        Point2D location = new Point2D(x, y);
        Point2D velocity = new Point2D(0, 0);
        Point2D acceleration = new Point2D(0, 0);
        double mass = 20;
        ball = new Ball(playfield, location, velocity, acceleration, mass, ro, COLOR.getRandomColor());
        block = ball.retCircle();
    }

    public int getCurScore() {
        return curScore;
    }

    public void setCurScore(int sc) {
        this.curScore = sc;
    }

    void resizeAnimation(Node node) {
        ScaleTransition resizePic = new ScaleTransition();
        resizePic.setDuration(Duration.millis(750));
        resizePic.setNode(node);
        resizePic.setByX(.1);
        resizePic.setByY(.1);
        resizePic.setCycleCount(Integer.MAX_VALUE);
        resizePic.setAutoReverse(true);
        resizePic.play();
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

    Arc makeArc(double xPos, double yPos, double startAngle, double radius, double length, Color color, double width) {
        Arc arc = new Arc();
        arc.setCenterX(xPos);
        arc.setCenterY(yPos);
        arc.setStartAngle(startAngle);
        arc.setRadiusX(radius);
        arc.setRadiusY(radius);
        arc.setLength(90.0f);
        arc.setType(ArcType.ROUND);
        //arc.setStroke(color);
        // arc.setStrokeWidth(width);
        arc.setFill(color);
        return arc;
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

    Rectangle makeRectangle(double xPos, double yPos, double height, double width, Color color) {
        Rectangle rect = new Rectangle();
        rect.setX(xPos);
        rect.setY(yPos);
        rect.setHeight(height);
        rect.setWidth(width);
        rect.setFill(color);
        return rect;
    }

    public Scene getMainScene() {
        return scene;
    }
}

class BurstBall {
    Arc arc1, arc2, arc3, arc4;

    public BurstBall() throws FileNotFoundException {
    }

    public void prepareDestroy(double a, double b, Stage stage, Pane playfield, RespawnMenu death) {
        arc1 = makeArc(a, b, 0, 20, 90, Color.rgb(245, 223, 15), 15);
        playfield.getChildren().add(arc1);
        arc2 = makeArc(a, b, 90, 20, 90, Color.rgb(141, 18, 255), 15);
        playfield.getChildren().add(arc2);
        arc3 = makeArc(a, b, 180, 20, 90, Color.rgb(255, 0, 132), 15);
        playfield.getChildren().add(arc3);
        arc4 = makeArc(a, b, 270, 20, 90, Color.rgb(53, 226, 242), 15);
        playfield.getChildren().add(arc4);

        TranslateTransition translate = new TranslateTransition();
        translate.setByX(400);
        translate.setDuration(Duration.millis(2000));
        translate.setCycleCount(1);
        translate.setAutoReverse(true);
        translate.setNode(arc1);
        translate.play();
        TranslateTransition translate1 = new TranslateTransition();
        translate1.setByX(-400);
        translate1.setDuration(Duration.millis(2000));
        translate1.setCycleCount(1);
        translate1.setAutoReverse(true);
        translate1.setNode(arc2);
        translate1.play();
        TranslateTransition translate2 = new TranslateTransition();
        translate2.setByY(400);
        translate2.setDuration(Duration.millis(2000));
        translate2.setCycleCount(1);
        translate2.setAutoReverse(true);
        translate2.setNode(arc3);
        translate2.play();
        TranslateTransition translate3 = new TranslateTransition();
        translate3.setByY(-400);
        translate3.setDuration(Duration.millis(2000));
        translate3.setCycleCount(1);
        translate3.setAutoReverse(true);
        translate3.setNode(arc4);
        translate3.play();

    }

    Arc makeArc(double xPos, double yPos, double startAngle, double radius, double length, Color color, double width) {
        Arc arc = new Arc();
        arc.setCenterX(xPos);
        arc.setCenterY(yPos);
        arc.setStartAngle(startAngle);
        arc.setRadiusX(radius);
        arc.setRadiusY(radius);
        arc.setLength(90.0f);
        arc.setType(ArcType.ROUND);
        //arc.setStroke(color);
        // arc.setStrokeWidth(width);
        arc.setFill(color);
        return arc;
    }

    public void undoDestroy(Group ro) {
        arc4.setVisible(false);
        arc3.setVisible(false);
        ro.getChildren().remove(arc1);
        ro.getChildren().remove(arc2);
        ro.getChildren().remove(arc3);
        ro.getChildren().remove(arc4);
    }

}