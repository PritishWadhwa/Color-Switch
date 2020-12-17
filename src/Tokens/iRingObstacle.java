package Tokens;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Shape;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import java.util.ArrayList;

public class iRingObstacle {

    private Group group;

    public iRingObstacle(Pane pane, ArrayList<Shape> nodes,double y) {
        Arc arc1 = makeArc(280, y, 0, 100, 83, Color.rgb(245, 223, 15), 15);
        Arc arc2 = makeArc(280, y, 90, 100, 83, Color.rgb(141, 18, 255), 15);
        Arc arc3 = makeArc(280, y, 180, 100, 83, Color.rgb(255, 0, 132), 15);
        Arc arc4 = makeArc(280, y, 270, 100, 83, Color.rgb(53, 226, 242), 15);
        group = new Group(arc1, arc2, arc3, arc4);
        final Rotate rotateCW = new Rotate(0, 280, y);
        group.getTransforms().add(rotateCW);
//        arc1.getTransforms().add(rotateCW);
//        arc2.getTransforms().add(rotateCW);
//        arc3.getTransforms().add(rotateCW);
//        arc4.getTransforms().add(rotateCW);
        nodes.add(arc1);
        nodes.add(arc2);
        nodes.add(arc3);
        nodes.add(arc4);

        final Timeline rotationAnimationCW = new Timeline();
        rotationAnimationCW.getKeyFrames().add(new KeyFrame(Duration.seconds(3), new KeyValue(rotateCW.angleProperty(), -360)));
        rotationAnimationCW.setCycleCount(Animation.INDEFINITE);
        rotationAnimationCW.play();
        pane.getChildren().add(group);
    }

    public Group returnGrp() {
        return this.group;
    }

    Arc makeArc(double xPos, double yPos, double startAngle, double radius, double length, Color color, double width) {
        Arc arc = new Arc();
        arc.setCenterX(xPos);
        arc.setCenterY(yPos);
        arc.setStartAngle(startAngle);
        arc.setRadiusX(radius);
        arc.setRadiusY(radius);
        arc.setLength(length);
        arc.setType(ArcType.OPEN);
        arc.setStroke(color);
        arc.setStrokeWidth(width);
        arc.setFill(Color.TRANSPARENT);
        return arc;
    }

}