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
import sample.Main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class RandomData extends Application {

    private static final double HEIGHT = 850.0;
    private static final double WIDTH = 560.0;

    public void start(Stage stage) throws Exception {
        Scene mainScene;
        MainMenu mainMenu = new MainMenu();
        Rectangle headingRect = makeRectangle(0, 0, 130, 560, Color.YELLOWGREEN);
        Rectangle fact1 = makeRectangle(30, 160, 125, 500, Color.DARKCYAN);
        Rectangle fact2 = makeRectangle(30, 315, 125, 500, Color.DARKCYAN);
        Rectangle fact3 = makeRectangle(30, 480, 125, 500, Color.DARKCYAN);
        Circle homeCircle = makeCircle(280, 700, 50, Color.WHITE);
        ImageView topHome = makeImage("images/homeButtonBlack.png", 250, 670, 60, 60, true);
        String f1 = "Total Stars: " + Main.getTotalScore();
        Text fact1Text = makeText(40, f1, 150, 235, 12.5);
        String f2 = "Total Logins: " + Main.getTotalLogins();
        Text fact2Text = makeText(40, f2, 135, 390, 12.5);
        String f3 = "Total Games Played: " + Main.getTotalGames();
        Text fact3Text = makeText(40, f3, 65, 555, 12.5);
        Text headingText1 = makeText(70, "RANDOM DATA", 20, 80, 15);
        Text headingText2 = makeText(20, "(FOR NERDS)", 400, 110, 10);

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


        Group root = new Group(headingRect, headingText1, headingText2, fact1, fact2, fact3, fact1Text, fact2Text,
                fact3Text, homeCircle, topHome);
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
