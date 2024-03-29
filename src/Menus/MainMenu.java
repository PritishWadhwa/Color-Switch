package Menus;

import PlayArena.Gameplay;
import PlayArena.ResourceManager;
import PlayArena.SaveRandomData;
import PlayArena.SaveTotalPoints;
import javafx.animation.*;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;
import sample.Main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MainMenu extends Application {

    private static final double HEIGHT = 850.0;
    private static final double WIDTH = 560.0;
    static SettingScreen settingScreen;
    private int flag = 0;
    private int level;

    public void start(Stage stage) throws FileNotFoundException {
        String musicFile = "images/intro.mp3";     // For example
        Media sound = new Media(new File(musicFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
        Scene mainScene;
        Stage mainStage;
        settingScreen = new SettingScreen();
        LoadGameMenu loadGameMenu = new LoadGameMenu();
        RandomData randomDataScreen = new RandomData();
        Instructions instructionsScreen = new Instructions();
        Devs devsScreen = new Devs();
        Text headingC = makeText(100, "C", 100.0, 100.0, 5.0);
        Text headingL = makeText(100, "L", 250, 100, 5);
        Text headingR = makeText(100, "R", 385, 100, 5);
        Text headingSwitch = makeText(100, "SWITCH", 77.5, 190, 5);
        Arc headingC1A1 = makeArc(210, 65, 0, 30, 73, Color.rgb(245, 223, 15), 10);
        Arc headingC1A2 = makeArc(210, 65, 90, 30, 73, Color.rgb(141, 18, 255), 10);
        Arc headingC1A3 = makeArc(210, 65, 180, 30, 73, Color.rgb(255, 0, 132), 10);
        Arc headingC1A4 = makeArc(210, 65, 270, 30, 73, Color.rgb(53, 226, 242), 10);
        Arc headingC2A1 = makeArc(345, 65, 0, 30, 73, Color.rgb(245, 223, 15), 10);
        Arc headingC2A2 = makeArc(345, 65, 90, 30, 73, Color.rgb(141, 18, 255), 10);
        Arc headingC2A3 = makeArc(345, 65, 180, 30, 73, Color.rgb(255, 0, 132), 10);
        Arc headingC2A4 = makeArc(345, 65, 270, 30, 73, Color.rgb(53, 226, 242), 10);
        Arc centerC1A1 = makeArc(280, 380, 0, 160, 82.5, Color.rgb(245, 223, 15), 22);
        Arc centerC1A2 = makeArc(280, 380, 90, 160, 82.5, Color.rgb(141, 18, 255), 22);
        Arc centerC1A3 = makeArc(280, 380, 180, 160, 82.5, Color.rgb(255, 0, 132), 22);
        Arc centerC1A4 = makeArc(280, 380, 270, 160, 82.5, Color.rgb(53, 226, 242), 22);
        Arc centerC2A1 = makeArc(280, 380, 0, 135, 81, Color.rgb(53, 226, 242), 22);
        Arc centerC2A2 = makeArc(280, 380, 90, 135, 81, Color.rgb(245, 223, 15), 22);
        Arc centerC2A3 = makeArc(280, 380, 180, 135, 81, Color.rgb(141, 18, 255), 22);
        Arc centerC2A4 = makeArc(280, 380, 270, 135, 81, Color.rgb(255, 0, 132), 22);
        Arc centerC3A1 = makeArc(280, 380, 0, 110, 79.5, Color.rgb(255, 0, 132), 22);
        Arc centerC3A2 = makeArc(280, 380, 90, 110, 79.5, Color.rgb(53, 226, 242), 22);
        Arc centerC3A3 = makeArc(280, 380, 180, 110, 79.5, Color.rgb(245, 223, 15), 22);
        Arc centerC3A4 = makeArc(280, 380, 270, 110, 79.5, Color.rgb(141, 18, 255), 22);

        ImageView exitImage = makeImage("images/ExitButton.png", 222, 660, 125, 400, true);
        ImageView loadGame = makeImage("images/loadSavedGamesButton.png", 130, 510, 250, 400, true);
        ImageView leftArrow = makeImage("images/arrowleft.png", 30, 590.5, 90, 90, true);
        ImageView rightArrow = makeImage("images/arrowright.png", 438, 590.5, 90, 90, true);
        ImageView centerPlayButton = makeImage("images/playButton.png", 210, 310, 150, 150, true);

        Circle centerCircle = makeCircle(280, 380, 95, Color.rgb(88, 88, 88));

        Circle randomDataCircle = makeCircle(60, 730, 30, Color.rgb(88, 88, 88));
        Text randomData = makeText(50, "R", 44, 747.5, 10);
        resizeAnimation(randomData);
        resizeAnimation(randomDataCircle);
        Circle instructionsCircle = makeCircle(150, 730, 30, Color.rgb(88, 88, 88));
        Text instructions = makeText(50, "I", 143, 747.5, 10);
        resizeAnimation(instructions);
        resizeAnimation(instructionsCircle);
        Circle devsCircle = makeCircle(410, 730, 30, Color.rgb(88, 88, 88));
        Text devs = makeText(50, "D", 394, 747.5, 10);
        resizeAnimation(devsCircle);
        resizeAnimation(devs);
        Circle settingCircle = makeCircle(500, 730, 30, Color.rgb(88, 88, 88));
        Text setting = makeText(50, "S", 485, 747.5, 10);
        resizeAnimation(settingCircle);
        resizeAnimation(setting);

        ScaleTransition resizePic = new ScaleTransition();
        resizePic.setDuration(Duration.millis(750));
        resizePic.setNode(loadGame);
        resizePic.setByX(.2);
        resizePic.setByY(.1);
        resizePic.setCycleCount(Integer.MAX_VALUE);
        resizePic.setAutoReverse(true);
        resizePic.play();

        final Rotate rotateCWHC = new Rotate(0, 345, 65);
        headingC2A1.getTransforms().add(rotateCWHC);
        headingC2A2.getTransforms().add(rotateCWHC);
        headingC2A3.getTransforms().add(rotateCWHC);
        headingC2A4.getTransforms().add(rotateCWHC);
        final Timeline rotationAnimationCWHC = new Timeline();
        rotationAnimationCWHC.getKeyFrames().add(new KeyFrame(Duration.seconds(3), new KeyValue(rotateCWHC.angleProperty(), 360)));
        rotationAnimationCWHC.setCycleCount(Animation.INDEFINITE);
        rotationAnimationCWHC.play();

        final Rotate rotateCCWHC = new Rotate(360, 210, 65);
        headingC1A1.getTransforms().add(rotateCCWHC);
        headingC1A2.getTransforms().add(rotateCCWHC);
        headingC1A3.getTransforms().add(rotateCCWHC);
        headingC1A4.getTransforms().add(rotateCCWHC);
        final Timeline rotationAnimationCCWHC = new Timeline();
        rotationAnimationCCWHC.getKeyFrames().add(new KeyFrame(Duration.seconds(3), new KeyValue(rotateCCWHC.angleProperty(), 0)));
        rotationAnimationCCWHC.setCycleCount(Animation.INDEFINITE);
        rotationAnimationCCWHC.play();

        final Rotate rotateCCWCC1 = new Rotate(360, 280, 380);
        centerC1A1.getTransforms().add(rotateCCWCC1);
        centerC1A2.getTransforms().add(rotateCCWCC1);
        centerC1A3.getTransforms().add(rotateCCWCC1);
        centerC1A4.getTransforms().add(rotateCCWCC1);
        final Timeline rotationAnimationCCWCC1 = new Timeline();
        rotationAnimationCCWCC1.getKeyFrames().add(new KeyFrame(Duration.seconds(5), new KeyValue(rotateCCWCC1.angleProperty(), 0)));
        rotationAnimationCCWCC1.setCycleCount(Animation.INDEFINITE);
        rotationAnimationCCWCC1.play();

        final Rotate rotateCWCC2 = new Rotate(0, 280, 380);
        centerC2A1.getTransforms().add(rotateCWCC2);
        centerC2A2.getTransforms().add(rotateCWCC2);
        centerC2A3.getTransforms().add(rotateCWCC2);
        centerC2A4.getTransforms().add(rotateCWCC2);
        final Timeline rotationAnimationCWCC2 = new Timeline();
        rotationAnimationCWCC2.getKeyFrames().add(new KeyFrame(Duration.seconds(4), new KeyValue(rotateCWCC2.angleProperty(), 360)));
        rotationAnimationCWCC2.setCycleCount(Animation.INDEFINITE);
        rotationAnimationCWCC2.play();

        final Rotate rotateCCWCC3 = new Rotate(360, 280, 380);
        centerC3A1.getTransforms().add(rotateCCWCC3);
        centerC3A2.getTransforms().add(rotateCCWCC3);
        centerC3A3.getTransforms().add(rotateCCWCC3);
        centerC3A4.getTransforms().add(rotateCCWCC3);
        final Timeline rotationAnimationCCWCC3 = new Timeline();
        rotationAnimationCCWCC3.getKeyFrames().add(new KeyFrame(Duration.seconds(3), new KeyValue(rotateCCWCC3.angleProperty(), 0)));
        rotationAnimationCCWCC3.setCycleCount(Animation.INDEFINITE);
        rotationAnimationCCWCC3.play();

        TranslateTransition arrow1left = new TranslateTransition();
        arrow1left.setDuration(Duration.millis(750));
        arrow1left.setNode(leftArrow);
        arrow1left.setByX(10);
        arrow1left.setCycleCount(Integer.MAX_VALUE);
        arrow1left.setAutoReverse(true);
        arrow1left.play();

        TranslateTransition arrow2right = new TranslateTransition();
        arrow2right.setDuration(Duration.millis(750));
        arrow2right.setNode(rightArrow);
        arrow2right.setByX(-10);
        arrow2right.setCycleCount(Integer.MAX_VALUE);
        arrow2right.setAutoReverse(true);
        arrow2right.play();

        mainStage = new Stage();

        settingCircle.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                settingCircle.setFill(Color.rgb(100, 100, 100));
            }
        });

        settingCircle.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                settingCircle.setFill(Color.rgb(88, 88, 88));
            }
        });

        setting.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                settingCircle.setFill(Color.rgb(100, 100, 100));
            }
        });

        setting.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                settingCircle.setFill(Color.rgb(88, 88, 88));
            }
        });

        settingCircle.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    settingScreen.start(stage);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        setting.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    settingScreen.start(stage);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


        instructionsCircle.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                instructionsCircle.setFill(Color.rgb(100, 100, 100));
            }
        });

        instructionsCircle.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                instructionsCircle.setFill(Color.rgb(88, 88, 88));
            }
        });

        instructions.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                instructionsCircle.setFill(Color.rgb(100, 100, 100));
            }
        });

        instructions.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                instructionsCircle.setFill(Color.rgb(88, 88, 88));
            }
        });

        instructionsCircle.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    instructionsScreen.start(stage);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        instructions.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    instructionsScreen.start(stage);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        devsCircle.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                devsCircle.setFill(Color.rgb(100, 100, 100));
            }
        });

        devsCircle.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                devsCircle.setFill(Color.rgb(88, 88, 88));
            }
        });

        devs.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                devsCircle.setFill(Color.rgb(100, 100, 100));
            }
        });

        devs.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                devsCircle.setFill(Color.rgb(88, 88, 88));
            }
        });

        devsCircle.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    devsScreen.start(stage);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        devs.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    devsScreen.start(stage);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


        randomDataCircle.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                randomDataCircle.setFill(Color.rgb(100, 100, 100));
            }
        });

        randomDataCircle.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                randomDataCircle.setFill(Color.rgb(88, 88, 88));
            }
        });

        randomData.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                randomDataCircle.setFill(Color.rgb(100, 100, 100));
            }
        });

        randomData.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                randomDataCircle.setFill(Color.rgb(88, 88, 88));
            }
        });

        randomDataCircle.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    randomDataScreen.start(stage);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        randomData.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    randomDataScreen.start(stage);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        exitImage.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (flag == 0) {
                    TranslateTransition moveExit = new TranslateTransition();
                    moveExit.setDuration(Duration.millis(250));
                    moveExit.setNode(exitImage);
                    moveExit.setByX(-10);
                    moveExit.setCycleCount(6);
                    moveExit.setAutoReverse(true);
                    moveExit.play();
                    flag++;
                } else {
                    TranslateTransition moveExit = new TranslateTransition();
                    moveExit.setDuration(Duration.millis(250));
                    moveExit.setNode(exitImage);
                    moveExit.setByX(10);
                    moveExit.setCycleCount(6);
                    moveExit.setAutoReverse(true);
                    moveExit.play();
                    flag--;
                }
            }
        });

        exitImage.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                exitImage.setX(222);
            }
        });

        exitImage.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                SaveTotalPoints data = new SaveTotalPoints();
                data.totalScore = Main.getTotalScore();
                System.out.println("exit" + data.totalScore);
                try {
                    ResourceManager.save(data, "points.save");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                SaveRandomData randomDataText = new SaveRandomData();
                randomDataText.totalGames = Main.getTotalGames();
                randomDataText.totalLogin = Main.getTotalLogins();
                randomDataText.totalScore = Main.getTotalScore();
                System.out.println(" " + randomDataText.totalGames);
                try {
                    ResourceManager.save(randomDataText, "randomData.save");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.exit(0);
            }
        });

        centerPlayButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                centerCircle.setFill(Color.rgb(100, 100, 100));
            }
        });

        centerPlayButton.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                centerCircle.setFill(Color.rgb(88, 88, 88));
            }
        });

        loadGame.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    loadGameMenu.start(stage);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        centerPlayButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                //  mainStage.setScene(gameplay.getMainScene());
                try {
                    Gameplay gameplay = new Gameplay(level);
                    gameplay.start(stage);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });

        centerCircle.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                centerCircle.setFill(Color.rgb(100, 100, 100));
            }
        });

        centerCircle.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                centerCircle.setFill(Color.rgb(88, 88, 88));
            }
        });

        centerCircle.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    Gameplay gameplay = new Gameplay(level);
                    gameplay.start(stage);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });

        loadGame.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                resizePic.pause();
                arrow1left.pause();
                arrow2right.pause();
            }
        });

        loadGame.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                resizePic.play();
                arrow1left.play();
                arrow2right.play();
            }
        });

        Group root = new Group(headingC1A1, headingC1A2, headingC1A3, headingC1A4, headingC, headingL, headingC2A1,
                headingC2A2, headingC2A3, headingC2A4, headingR, headingSwitch, exitImage, loadGame, centerC1A1,
                centerC1A2, centerC1A3, centerC1A4, centerC2A1, centerC2A2, centerC2A3, centerC2A4, centerC3A1,
                centerC3A2, centerC3A3, centerC3A4, centerCircle, leftArrow, rightArrow, centerPlayButton,
                randomDataCircle, randomData, instructionsCircle, instructions, devsCircle, devs, settingCircle, setting);
        mainScene = new Scene(root, WIDTH, HEIGHT, Color.rgb(41, 41, 41));
        stage.setScene(mainScene);
        stage.show();

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

    Arc makeArc(double xPos, double yPos, double startAngle, double radius, double length, Color color, double width) {
        Arc arc = new Arc();
        arc.setCenterX(xPos);
        arc.setCenterY(yPos);
        arc.setStartAngle(startAngle);
        arc.setRadiusX(radius);
        arc.setRadiusY(radius);
        arc.setLength(length);
        arc.setType(ArcType.OPEN);
        arc.setStroke(color);
        arc.setStrokeWidth(width);
        arc.setFill(Color.TRANSPARENT);
        return arc;
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

//    public Scene getMainScene() {
//        return mainScene;
//    }

//    public Stage getMainStage() {
//        return mainStage;
//    }
}