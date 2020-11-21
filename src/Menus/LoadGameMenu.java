package Menus;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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

public class LoadGameMenu {

    private static final double HEIGHT = 850.0;
    private static final double WIDTH = 560.0;
    private final Scene mainScene;
    private final Stage mainStage;

    public LoadGameMenu() throws FileNotFoundException {
        Rectangle topRect = makeRectangle(0, 0, 100, 560, Color.rgb(28, 106, 207));
        Text headingText = makeText(50, "LOAD GAMES", 175, 68, 10, Color.WHITE);
        Circle homeCircle = makeCircle(80, 50, 35, Color.WHITE);
        ImageView topHome = makeImage("images/homeButtonBlack.png", 60, 30, 40, 40, true);
        Rectangle strip = makeRectangle(0, 130, 60, 560, Color.rgb(28, 28, 28));
        Text stripText = makeText(40, "SAVED GAMES: 4 / 10", 25, 175, 10, Color.WHITE);
        Rectangle rounded1 = makeRoundedRectangle(20, 230, 97.5, 520, Color.YELLOW, Color.RED);
        Rectangle rounded2 = makeRoundedRectangle(20, 377.5, 97.5, 520, Color.YELLOW, Color.RED);
        Rectangle rounded3 = makeRoundedRectangle(20, 525, 97.5, 520, Color.YELLOW, Color.RED);
        Rectangle rounded4 = makeRoundedRectangle(20, 672.5, 97.5, 520, Color.YELLOW, Color.RED);
        Text saveGame1Text1 = makeText(40, "Game 1", 35, 273.75, 10, Color.BLACK);
        Text saveGame1Text2 = makeText(30, "Date: 21/11/20, Score: 15", 35, 310, 10, Color.GRAY);
        Text saveGame2Text1 = makeText(40, "Game 2", 35, 421.25, 10, Color.BLACK);
        Text saveGame2Text2 = makeText(30, "Date: 21/11/20, Score: 17", 35, 457.5, 10, Color.GRAY);
        Text saveGame3Text1 = makeText(40, "Game 3", 35, 568.75, 10, Color.BLACK);
        Text saveGame3Text2 = makeText(30, "Date: 21/11/20, Score: 12", 35, 605, 10, Color.GRAY);
        Text saveGame4Text1 = makeText(40, "Game 4", 35, 716.25, 10, Color.BLACK);
        Text saveGame4Text2 = makeText(30, "Date: 21/11/20, Score: 9", 35, 752.5, 10, Color.GRAY);

        mainStage = new Stage();
        Group root = new Group(topRect, headingText, homeCircle, topHome, strip, stripText, rounded1, rounded2,
                rounded3, rounded4, saveGame1Text1, saveGame1Text2, saveGame2Text1, saveGame2Text2,
                saveGame3Text1, saveGame3Text2, saveGame4Text1, saveGame4Text2);
        mainScene = new Scene(root, WIDTH, HEIGHT, Color.rgb(41, 41, 41));
        mainStage.setScene(mainScene);
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

    public Stage getMainStage() {
        return mainStage;
    }
}
