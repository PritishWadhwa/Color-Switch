package Tokens;

import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

import java.util.ArrayList;

public class InfiniteLineObstacle {

    private Group group;

    public InfiniteLineObstacle(Pane pane, ArrayList<Shape> nodes) {
        Rectangle rect1 = makeRectangle(-260, 380, 15, 90, Color.rgb(245, 223, 15));
        Rectangle rect2 = makeRectangle(-170, 380, 15, 90, Color.rgb(141, 18, 255));
        Rectangle rect3 = makeRectangle(-80, 380, 15, 90, Color.rgb(255, 0, 132));
        Rectangle rect4 = makeRectangle(10, 380, 15, 90, Color.rgb(53, 226, 242));
        Rectangle rect5 = makeRectangle(100, 380, 15, 90, Color.rgb(245, 223, 15));
        Rectangle rect6 = makeRectangle(190, 380, 15, 90, Color.rgb(141, 18, 255));
        Rectangle rect7 = makeRectangle(280, 380, 15, 90, Color.rgb(255, 0, 132));
        Rectangle rect8 = makeRectangle(370, 380, 15, 90, Color.rgb(53, 226, 242));

        group = new Group(rect1, rect2, rect3, rect4, rect5, rect6, rect7, rect8);
        nodes.add(rect1);
        nodes.add(rect2);
        nodes.add(rect3);
        nodes.add(rect4);
        nodes.add(rect5);
        nodes.add(rect6);
        nodes.add(rect7);
        nodes.add(rect8);




        TranslateTransition rect1animation = new TranslateTransition();

        rect1animation.setDuration(Duration.millis(2000));
        rect1animation.setNode(rect1);
        rect1animation.setByX(360);
        rect1animation.setCycleCount(Integer.MAX_VALUE);
        rect1animation.setAutoReverse(true);
        rect1animation.play();

        TranslateTransition rect2animation = new TranslateTransition();
        rect2animation.setDuration(Duration.millis(2000));
        rect2animation.setNode(rect2);
        rect2animation.setByX(360);
        rect2animation.setCycleCount(Integer.MAX_VALUE);
        rect2animation.setAutoReverse(true);
        rect2animation.play();

        TranslateTransition rect3animation = new TranslateTransition();
        rect3animation.setDuration(Duration.millis(2000));
        rect3animation.setNode(rect3);
        rect3animation.setByX(360);
        rect3animation.setCycleCount(Integer.MAX_VALUE);
        rect3animation.setAutoReverse(true);
        rect3animation.play();

        TranslateTransition rect4animation = new TranslateTransition();
        rect4animation.setDuration(Duration.millis(2000));
        rect4animation.setNode(rect4);
        rect4animation.setByX(360);
        rect4animation.setCycleCount(Integer.MAX_VALUE);
        rect4animation.setAutoReverse(true);
        rect4animation.play();

        TranslateTransition rect5animation = new TranslateTransition();
        rect5animation.setDuration(Duration.millis(2000));
        rect5animation.setNode(rect5);
        rect5animation.setByX(360);
        rect5animation.setCycleCount(Integer.MAX_VALUE);
        rect5animation.setAutoReverse(true);
        rect5animation.play();

        TranslateTransition rect6animation = new TranslateTransition();
        rect6animation.setDuration(Duration.millis(2000));
        rect6animation.setNode(rect6);
        rect6animation.setByX(360);
        rect6animation.setCycleCount(Integer.MAX_VALUE);
        rect6animation.setAutoReverse(true);
        rect6animation.play();

        TranslateTransition rect7animation = new TranslateTransition();
        rect7animation.setDuration(Duration.millis(2000));
        rect7animation.setNode(rect7);
        rect7animation.setByX(360);
        rect7animation.setCycleCount(Integer.MAX_VALUE);
        rect7animation.setAutoReverse(true);
        rect7animation.play();

        TranslateTransition rect8animation = new TranslateTransition();
        rect8animation.setDuration(Duration.millis(2000));
        rect8animation.setNode(rect8);
        rect8animation.setByX(360);
        rect8animation.setCycleCount(Integer.MAX_VALUE);
        rect8animation.setAutoReverse(true);
        rect8animation.play();

        pane.getChildren().add(group);


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
