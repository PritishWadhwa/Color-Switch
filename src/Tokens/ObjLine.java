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

public class ObjLine extends JPanel {
    private Group ob;

    public ObjLine(Pane ro, ArrayList<Shape> nodes, double y) {
        Rectangle rect1 = returnRect(220, y, 18, 120, 0, 20, 20);
        Rectangle rect2 = returnRect(220, y, 120, 18, 0, 20, 20);
        Rectangle rect3 = returnRect(118, y, 18, 120, 0, 20, 20);
        Rectangle rect = returnRect(220, y - 102, 120, 18, 0, 20, 20);
        rect.setFill(Color.rgb(245, 223, 15));
        rect1.setFill(Color.rgb(255, 0, 132));
        rect2.setFill(Color.rgb(141, 18, 255));
        rect3.setFill(Color.rgb(53, 226, 242));
        ob = new Group(rect, rect1, rect2, rect3);
        nodes.add(rect);
        nodes.add(rect1);
        nodes.add(rect2);
        nodes.add(rect3);
        final Rotate rotateCWCC2 = new Rotate(360, 229, y + 9);
        ob.getTransforms().add(rotateCWCC2);
        final Timeline ra = new Timeline();
        ra.getKeyFrames().add(new KeyFrame(Duration.seconds(4), new KeyValue(rotateCWCC2.angleProperty(), 0)));
        ra.setCycleCount(Animation.INDEFINITE);
        ra.play();
        ro.getChildren().add(ob);

    }

    public Group returnGrp() {
        return this.ob;
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