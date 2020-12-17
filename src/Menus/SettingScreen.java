package Menus;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class SettingScreen {
    private static final double HEIGHT = 850.0;
    private static final double WIDTH = 560.0;
    private int lvl = 0;

    public void start(Stage stage) throws FileNotFoundException {
        Scene mainScene;

        MainMenu mainMenu = new MainMenu();
//        Gameplay1 gameplay = new Gameplay1();
//        Gameplay1 gameplay;
        Rectangle topRect = makeRectangle(0, 0, 100, 560, Color.rgb(28, 106, 207));
        Text headingText = makeText(50, "Settings", 175, 68, 10, Color.WHITE);
        Circle homeCircle = makeCircle(80, 50, 35, Color.WHITE);
        ImageView topHome = makeImage("images/homeButtonBlack.png", 60, 30, 40, 40, true);
        Rectangle strip = makeRectangle(0, 130, 60, 560, Color.rgb(28, 28, 28));
        Text stripText = makeText(40, "Select Difficulty level", 25, 175, 10, Color.WHITE);
        Rectangle rounded1 = makeRoundedRectangle(20, 230, 97.5, 520, Color.YELLOW, Color.RED);
        Rectangle rounded2 = makeRoundedRectangle(20, 377.5, 97.5, 520, Color.YELLOW, Color.RED);
        Rectangle rounded3 = makeRoundedRectangle(20, 525, 97.5, 520, Color.YELLOW, Color.RED);
        Text saveGame1Text1 = makeText(40, "Easy", 220, 293.75, 10, Color.GREEN);
        Text saveGame2Text1 = makeText(40, "Medium", 180, 435.25, 10, Color.BLUEVIOLET);
        Text saveGame3Text1 = makeText(40, "Hard", 220, 588.75, 10, Color.RED);
        homeCircle.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                homeCircle.setFill(Color.LIGHTGRAY);
            }
        });

        homeCircle.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                homeCircle.setFill(Color.WHITE);
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

        topHome.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                homeCircle.setFill(Color.LIGHTGRAY);
            }
        });

        topHome.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                homeCircle.setFill(Color.WHITE);
            }
        });

        topHome.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    mainMenu.start(stage);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });


        rounded1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                lvl = 0;
                rounded1.setStroke(Color.GREEN);
                rounded2.setStroke(Color.RED);
                rounded3.setStroke(Color.RED);

            }
        });

        saveGame1Text1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                lvl = 0;
                rounded1.setStroke(Color.GREEN);
                rounded2.setStroke(Color.RED);
                rounded3.setStroke(Color.RED);
            }
        });

        rounded2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                lvl = 1;
                rounded1.setStroke(Color.RED);
                rounded2.setStroke(Color.GREEN);
                rounded3.setStroke(Color.RED);
            }
        });

        saveGame2Text1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                lvl = 1;
                rounded1.setStroke(Color.RED);
                rounded2.setStroke(Color.GREEN);
                rounded3.setStroke(Color.RED);
            }
        });


        rounded3.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                lvl = 2;
                rounded1.setStroke(Color.RED);
                rounded2.setStroke(Color.RED);
                rounded3.setStroke(Color.GREEN);
            }
        });

        saveGame3Text1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                lvl = 2;
                rounded1.setStroke(Color.RED);
                rounded2.setStroke(Color.RED);
                rounded3.setStroke(Color.GREEN);
            }
        });
        Group root = new Group(topRect, headingText, homeCircle, topHome, strip, stripText, rounded1, rounded2,
                rounded3, saveGame1Text1, saveGame2Text1, saveGame3Text1);
        mainScene = new Scene(root, WIDTH, HEIGHT, Color.rgb(41, 41, 41));
        stage.setScene(mainScene);
        stage.show();
    }

    public int retlvl() {
        return lvl;
    }

    Rectangle makeRoundedRectangle(double posX, double posY, double height, double width, Color shapeColor, Color boundaryColor) {
        Rectangle rect = new Rectangle();
        rect.setX(posX);
        rect.setY(posY);
        rect.setWidth(width);
        rect.setHeight(height);
        rect.setArcWidth(40.0);
        rect.setArcHeight(30.0);
        rect.setFill(shapeColor);
        rect.setStrokeWidth(5);
        rect.setStroke(boundaryColor);
        return rect;
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

    Text makeText(int size, String str, double xPos, double yPos, double width, Color color) {
        Text newText = new Text();
        newText.setFont(Font.font("gothic", FontWeight.BOLD, FontPosture.REGULAR, size));
        newText.setText(str);
        newText.setX(xPos);
        newText.setY(yPos);
        newText.setFill(color);
        newText.setStrokeWidth(width);
        return newText;
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


}