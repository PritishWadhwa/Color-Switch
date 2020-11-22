package Menus;

import PlayArena.Gameplay;
import javafx.animation.ScaleTransition;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class PauseGameMenu {

    private static final double HEIGHT = 850.0;
    private static final double WIDTH = 560.0;
//    private final Scene mainScene;
//    private final Stage mainStage;

    public void start(Stage stage) throws FileNotFoundException {
        Scene mainScene;
//        Stage mainStage;
        Gameplay gameplay = new Gameplay();
        MainMenu mainMenu = new MainMenu();
        LoadGameMenu loadGameMenu = new LoadGameMenu();

        Circle homeCircle = makeCircle(100, 100, 40, Color.rgb(128, 128, 128));
        Circle centerCircle1 = makeCircle(280, 212.5, 70, Color.rgb(88, 88, 88));
        Circle centerCircle2 = makeCircle(280, 425, 70, Color.rgb(88, 88, 88));
        Circle centerCircle3 = makeCircle(280, 637.5, 70, Color.rgb(88, 88, 88));
        ImageView homeImg = makeImage("images/homeButton.png", 70, 70, 60, 60, true);
        ImageView restartImg = makeImage("images/restartButton.png", 169, 122, 250, 250, true);
        ImageView playImg = makeImage("images/playButton.png", 222, 367, 125, 125, true);
        ImageView saveImg = makeImage("images/saveButton.png", 236, 593, 90, 90, true);
        resizeAnimation(centerCircle1);
        resizeAnimation(centerCircle2);
        resizeAnimation(centerCircle3);
        resizeAnimation(restartImg);
        resizeAnimation(playImg);
        resizeAnimation(saveImg);

        homeImg.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                homeCircle.setFill(Color.rgb(140,140,140));
            }
        });

        homeCircle.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                homeCircle.setFill(Color.rgb(140,140,140));
            }
        });

        homeImg.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                homeCircle.setFill(Color.rgb(128,128,128));
            }
        });

        homeCircle.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                homeCircle.setFill(Color.rgb(128,128,128));
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
                centerCircle2.setFill(Color.rgb(100,100,100));
            }
        });

        centerCircle2.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                centerCircle2.setFill(Color.rgb(100,100,100));
            }
        });

        playImg.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                centerCircle2.setFill(Color.rgb(88,88,88));
            }
        });

        centerCircle2.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                centerCircle2.setFill(Color.rgb(88,88,88));
            }
        });

        playImg.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    gameplay.start(stage);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });

        centerCircle2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    gameplay.start(stage);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });

        restartImg.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                centerCircle1.setFill(Color.rgb(100,100,100));
            }
        });

        centerCircle1.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                centerCircle1.setFill(Color.rgb(100,100,100));
            }
        });

        restartImg.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                centerCircle1.setFill(Color.rgb(88,88,88));
            }
        });

        centerCircle1.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                centerCircle1.setFill(Color.rgb(88,88,88));
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
                centerCircle3.setFill(Color.rgb(100,100,100));
            }
        });

        centerCircle3.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                centerCircle3.setFill(Color.rgb(100,100,100));
            }
        });

        saveImg.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                centerCircle3.setFill(Color.rgb(88,88,88));
            }
        });

        centerCircle3.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                centerCircle3.setFill(Color.rgb(88,88,88));
            }
        });

        saveImg.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    loadGameMenu.start(stage);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });

        centerCircle3.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    loadGameMenu.start(stage);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });


        Group root = new Group(homeCircle, homeImg, centerCircle1, restartImg, centerCircle2, playImg, centerCircle3, saveImg);
        mainScene = new Scene(root, WIDTH, HEIGHT, Color.rgb(41, 41, 41));
        stage.setScene(mainScene);
        stage.show();
        System.out.println("yo");
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

    Circle makeCircle(double xCen, double yCen, double radius, Color color) {
        Circle c = new Circle();
        c.setCenterX(xCen);
        c.setCenterY(yCen);
        c.setFill(color);
        c.setRadius(radius);
        return c;
    }

//    public Stage getMainStage() {
//        return mainStage;
//    }
}
