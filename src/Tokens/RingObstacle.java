package Tokens;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class RingObstacle {
    public RingObstacle(Group root, Ball ball) throws InterruptedException {
        Arc arc1 = makeArc(280, 380, 0, 120, 83, Color.rgb(245, 223, 15), 15);
        Arc arc2 = makeArc(280, 380, 90, 120, 83, Color.rgb(141, 18, 255), 15);
        Arc arc3 = makeArc(280, 380, 180, 120, 83, Color.rgb(255, 0, 132), 15);
        Arc arc4 = makeArc(280, 380, 270, 120, 83, Color.rgb(53, 226, 242), 15);
        final Rotate rotateCW = new Rotate(0, 280, 380);
        arc1.getTransforms().add(rotateCW);
        arc2.getTransforms().add(rotateCW);
        arc3.getTransforms().add(rotateCW);
        arc4.getTransforms().add(rotateCW);
        final Timeline rotationAnimationCW = new Timeline();
        rotationAnimationCW.getKeyFrames().add(new KeyFrame(Duration.seconds(3), new KeyValue(rotateCW.angleProperty(), 360)));
        rotationAnimationCW.setCycleCount(Animation.INDEFINITE);
        rotationAnimationCW.play();
//        wait(100);
        System.out.println(arc1.getStartAngle()+"r");
        if(arc1.getStartAngle()<180 && ball.getY()>=(arc1.getCenterY() + arc1.getRadiusX() + arc1.getStrokeWidth()) ){
            System.out.println("touch");
        }
//        rotateCW.
//        if(arc1.intersects(getBounds()))

//        if(arc1.intersects(ball.getLayoutBounds())){
//            System.out.println("intersect1");
//        }
//
//        if(arc1.intersects(ball.getBoundsInLocal())){
//            System.out.println("intersect2");
//        }
//
//        if(arc1.intersects(ball.getBoundsInParent())){
//            System.out.println("intersect3");
//        }
//
//        if(arc1.getLayoutBounds().intersects(ball.getLayoutBounds())){
//            System.out.println("touch");
//        }


        root.getChildren().add(arc1);
        root.getChildren().add(arc2);
        root.getChildren().add(arc3);
        root.getChildren().add(arc4);
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
