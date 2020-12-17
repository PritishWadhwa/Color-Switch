package Menus;

import javafx.application.Application;
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

public class Instructions extends Application {

    private static final double HEIGHT = 850.0;
    private static final double WIDTH = 560.0;

    public void start(Stage stage) throws Exception {
        Scene mainScene;
        MainMenu mainMenu = new MainMenu();
        Rectangle headingRect = makeRectangle(0, 0, 130, 560, Color.YELLOWGREEN);

        Rectangle instRect = makeRectangle(30, 160, 445, 500, Color.DARKCYAN);
        Circle homeCircle = makeCircle(280, 700, 50, Color.WHITE);
        ImageView topHome = makeImage("images/homeButtonBlack.png", 250, 670, 60, 60, true);
        Text headingText1 = makeText(70, "INSTRUCTIONS", 20, 80, 15);
        Text headingText2 = makeText(20, "(FOR NOOBS)", 400, 110, 10);
        Text l1 = makeText(30, "1.) Tap anywhere to jump", 50, 200, 12);
        Text l2 = makeText(30, "2.) Pass the obstacle when its", 50, 250, 12);
        Text l2_1 = makeText(30, "      color matches your ball", 50, 280, 12);
        Text l3 = makeText(30, "3.) If colors don't match, you die", 50, 330, 12);
        Text l4 = makeText(30, "4.) You can revive using 10 points", 50, 380, 12);
        Text l5 = makeText(30, "5.) You can revive only once", 50, 430, 12);
        Text l6 = makeText(30, "6.) You can also save games, and", 50, 480, 12);
        Text l6_1 = makeText(30, "      reload them later", 50, 510, 12);
        Text l7 = makeText(40, "      Happy Gaming :)", 50, 570, 12);
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


        Group root = new Group(headingRect, headingText1, headingText2, instRect, l1, l2, l2_1, l3, l4, l5, l6, l6_1, l7, homeCircle, topHome);
        mainScene = new Scene(root, WIDTH, HEIGHT, Color.rgb(41, 41, 41));
        stage.setScene(mainScene);
        stage.show();
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
}
