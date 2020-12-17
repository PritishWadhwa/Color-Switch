package Tokens;

import javafx.animation.*;
import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import javax.swing.*;
import java.util.ArrayList;

public class ObsDisc22 extends JPanel {

    private Group group;

    public ObsDisc22(Pane pane, ArrayList<Shape> nodes,double y) {

        Rectangle rect = returnRect(185, y-86, 172, 18, 0, 0, 10);
        Rectangle rect2 = returnRect(185, y-104, 18, 172, 0, 0, 10);
        rect.setFill(Color.rgb(53, 226, 242));
        rect2.setFill(Color.rgb(141, 18, 255));
        final Rotate rotateCWCC2 = new Rotate(0, 280, y-9);
        rect.getTransforms().add(rotateCWCC2);
        rect2.getTransforms().add(rotateCWCC2);
        final Timeline ra = new Timeline();
        ra.getKeyFrames().add(new KeyFrame(Duration.seconds(6), new KeyValue(rotateCWCC2.angleProperty(), -360)));
        ra.setCycleCount(Animation.INDEFINITE);
        ra.play();
        group = new Group(rect,rect2);
        nodes.add(rect);
        nodes.add(rect2);
        pane.getChildren().add(group);
//        ro.getChildren().add(rect);
//        ro.getChildren().add(rect2);
//        ro.getChildren().add(rect3);
//        ro.getChildren().add(rect1);

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