package Tokens;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import javax.swing.*;

public class ObjDisc extends JPanel {
    public ObjDisc(Group ro) {

        Rectangle rect = returnRect(180, 38, 172, 18, 0, 0, 10);
        rect.setFill(Color.rgb(53, 226, 242));
        Rectangle rect1 = returnRect(198, 192, 18, 172, 0, 0, 10);
        Rectangle rect2 = returnRect(180, 20, 18, 172, 0, 0, 10);
        Rectangle rect3 = returnRect(352, 20, 172, 18, 0, 0, 10);
        rect1.setFill(Color.rgb(245, 223, 15));
        rect2.setFill(Color.rgb(141, 18, 255));
        rect3.setFill(Color.rgb(255, 0, 132));
        final Rotate rotateCWCC2 = new Rotate(0, 275, 120);
        rect.getTransforms().add(rotateCWCC2);
        rect1.getTransforms().add(rotateCWCC2);
        rect2.getTransforms().add(rotateCWCC2);
        rect3.getTransforms().add(rotateCWCC2);
        final Timeline ra = new Timeline();
        ra.getKeyFrames().add(new KeyFrame(Duration.seconds(6), new KeyValue(rotateCWCC2.angleProperty(), 360)));
        ra.setCycleCount(Animation.INDEFINITE);
        ra.play();
        ro.getChildren().add(rect);
        ro.getChildren().add(rect2);
        ro.getChildren().add(rect3);
        ro.getChildren().add(rect1);

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
