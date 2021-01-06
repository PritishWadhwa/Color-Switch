package Tokens;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import javax.swing.*;
import java.util.ArrayList;

public class ObjDisc extends JPanel {

    private Group group;

    public ObjDisc(Pane pane, ArrayList<Shape> nodes, double y) {

        Rectangle rect = returnRect(185, y - 86, 172, 18, 0, 0, 10);
        Rectangle rect1 = returnRect(203, y + 68, 18, 172, 0, 0, 10);
        Rectangle rect2 = returnRect(185, y - 104, 18, 172, 0, 0, 10);
        Rectangle rect3 = returnRect(357, y - 104, 172, 18, 0, 0, 10);
        rect.setFill(Color.rgb(53, 226, 242));
        rect1.setFill(Color.rgb(245, 223, 15));
        rect2.setFill(Color.rgb(141, 18, 255));
        rect3.setFill(Color.rgb(255, 0, 132));
        final Rotate rotateCWCC2 = new Rotate(0, 280, y - 9);
        rect.getTransforms().add(rotateCWCC2);
        rect1.getTransforms().add(rotateCWCC2);
        rect2.getTransforms().add(rotateCWCC2);
        rect3.getTransforms().add(rotateCWCC2);
        final Timeline ra = new Timeline();
        ra.getKeyFrames().add(new KeyFrame(Duration.seconds(6), new KeyValue(rotateCWCC2.angleProperty(), 360)));
        ra.setCycleCount(Animation.INDEFINITE);
        ra.play();
        group = new Group(rect, rect1, rect2, rect3);
        nodes.add(rect);
        nodes.add(rect1);
        nodes.add(rect2);
        nodes.add(rect3);
        pane.getChildren().add(group);

    }

    public Group returnGrp() {
        return this.group;
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
}