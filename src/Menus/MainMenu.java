package Menus;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;

public class MainMenu extends JPanel {

    private static final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private static final double HEIGHT = screenSize.getHeight();
    private static final double WIDTH = screenSize.getWidth() * .4;
    private final AnchorPane mainPane;
    private final Scene mainScene;
    private final Stage mainStage;

    public MainMenu() throws FileNotFoundException {
        mainPane = new AnchorPane();
        mainStage = new Stage();
        Text headingC = makeText(100, "C", 100.0, 100.0, 5.0);
        Text headingL = makeText(100, "L", 245, 100, 5);
        Text headingR = makeText(100, "R", 380, 100, 5);
        Text headingSwitch = makeText(100, "SWITCH", 75, 190, 5);

        Arc headingC1A1 = makeArc(210, 65, 0, 30, 73, Color.YELLOW, 10);
        Arc headingC1A2 = makeArc(210, 65, 90, 30, 73, Color.PURPLE, 10);
        Arc headingC1A3 = makeArc(210, 65, 180, 30, 73, Color.PINK, 10);
        Arc headingC1A4 = makeArc(210, 65, 270, 30, 73, Color.CYAN, 10);

        Arc headingC2A1 = makeArc(340, 65, 0, 30, 73, Color.YELLOW, 10);
        Arc headingC2A2 = makeArc(340, 65, 90, 30, 73, Color.PURPLE, 10);
        Arc headingC2A3 = makeArc(340, 65, 180, 30, 73, Color.PINK, 10);
        Arc headingC2A4 = makeArc(340, 65, 270, 30, 73, Color.CYAN, 10);
//        Circle c = new Circle();
//        c.setCenterX(250);
//        c.setCenterY(205);
//        c.setFill(Color.RED);
//        c.setRadius(20f);

//        Image loadGameImage = new Image(new FileInputStream("images/img1.jpg"));
//        ImageView viewloadGameImage = new ImageView(loadGameImage);
//        viewloadGameImage.setX(50);
//        viewloadGameImage.setY(25);
//        viewloadGameImage.setFitHeight(455);
//        viewloadGameImage.setFitWidth(500);
//        viewloadGameImage.setPreserveRatio(true);

//        ScaleTransition resizePic = new ScaleTransition();
//        resizePic.setDuration(Duration.millis(1000));
//        resizePic.setNode(viewloadGameImage);
//        resizePic.setByX(.5);
//        resizePic.setByY(.5);
//        resizePic.setCycleCount(Integer.MAX_VALUE);
//        resizePic.setAutoReverse(true);
//        resizePic.play();

        final Rotate rotateCW = new Rotate(0, 210, 65);
        headingC1A1.getTransforms().add(rotateCW);
        headingC1A2.getTransforms().add(rotateCW);
        headingC1A3.getTransforms().add(rotateCW);
        headingC1A4.getTransforms().add(rotateCW);
        final Timeline rotationAnimationCW = new Timeline();
        rotationAnimationCW.getKeyFrames().add(new KeyFrame(Duration.seconds(3), new KeyValue(rotateCW.angleProperty(), 360)));
        rotationAnimationCW.setCycleCount(Animation.INDEFINITE);
        rotationAnimationCW.play();
        final Rotate rotateCCW = new Rotate(360, 340, 65);
        headingC2A1.getTransforms().add(rotateCCW);
        headingC2A2.getTransforms().add(rotateCCW);
        headingC2A3.getTransforms().add(rotateCCW);
        headingC2A4.getTransforms().add(rotateCCW);
        final Timeline rotationAnimationCCW = new Timeline();
        rotationAnimationCCW.getKeyFrames().add(new KeyFrame(Duration.seconds(3), new KeyValue(rotateCCW.angleProperty(), 0)));
        rotationAnimationCCW.setCycleCount(Animation.INDEFINITE);
        rotationAnimationCCW.play();

//        Group root = new Group(viewloadGameImage, c);
        Group root = new Group(headingC1A1, headingC1A2, headingC1A3, headingC1A4, headingC, headingL, headingC2A1, headingC2A2, headingC2A3, headingC2A4, headingR, headingSwitch);
        mainScene = new Scene(root, WIDTH, HEIGHT, Color.rgb(44, 44, 44));

        mainStage.setScene(mainScene);
//		mainStage.setFullScreen(true);

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

    public Stage getMainStage() {
        return mainStage;
    }
}
