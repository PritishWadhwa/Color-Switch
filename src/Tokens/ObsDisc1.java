package Tokens;

import javafx.animation.*;
import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;
import sample.COLOR;

import javax.swing.*;
import java.util.ArrayList;

public class ObsDisc1 extends JPanel {

    private Group group;

    public ObsDisc1(Pane pane, ArrayList<Shape> nodes,double y) {

        Rectangle rect = returnRect(185, y-86, 172, 18, 0, 0, 10);
        rect.setFill(setCl(COLOR.getRandomColor()));
        final Rotate rotateCWCC2 = new Rotate(0, 280, y-9);
        rect.getTransforms().add(rotateCWCC2);
        final Timeline ra = new Timeline();
        ra.getKeyFrames().add(new KeyFrame(Duration.seconds(6), new KeyValue(rotateCWCC2.angleProperty(), -360)));
        ra.setCycleCount(Animation.INDEFINITE);
        ra.play();
        nodes.add(rect);
        group = new Group(rect);
        pane.getChildren().add(group);
//        ro.getChildren().add(rect);
//        ro.getChildren().add(rect2);
//        ro.getChildren().add(rect3);
//        ro.getChildren().add(rect1);

    }
    public Color setCl(COLOR cl){
        switch (cl) {
            case AQUA:
                return Color.rgb(141, 18, 255);
            case PURPLE:
                return Color.rgb(53, 226, 242);
            case YELLOW:
                return (Color.rgb(245, 223, 15));
            case PINK:
                return (Color.rgb(255, 0, 132));
        }
        return Color.rgb(255, 0, 132);
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