package Menus;

import javafx.animation.*;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
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
//        mainScene = new Scene(mainPane, WIDTH, HEIGHT, Color.rgb(44, 44, 44));
        mainStage = new Stage();

        Arc a1 = new Arc();
        a1.setCenterX(100.0);
        a1.setCenterY(100.0);
        a1.setStartAngle(0);
        a1.setRadiusX(30.0);
        a1.setRadiusY(30.0);
//        a1.setStrokeWidth(500.0);
        a1.setLength(90.0f);
        a1.setType(ArcType.OPEN);
        a1.setStroke(Color.YELLOW);
        a1.setStrokeWidth(5);
        a1.setFill(Color.TRANSPARENT);

        Arc a2 = new Arc();
        a2.setCenterX(100.0);
        a2.setCenterY(100.0);
        a2.setStartAngle(90.0);
        a2.setRadiusX(30.0);
        a2.setRadiusY(30.0);
//        a1.setStrokeWidth(500.0);
        a2.setLength(90.0f);
        a2.setType(ArcType.OPEN);
        a2.setStroke(Color.AQUA);
        a2.setStrokeWidth(5);
        a2.setFill(Color.TRANSPARENT);


        Arc a3 = new Arc();
        a3.setCenterX(100.0);
        a3.setCenterY(100.0);
        a3.setStartAngle(180.0);
        a3.setRadiusX(30.0);
        a3.setRadiusY(30.0);
//        a1.setStrokeWidth(500.0);
        a3.setLength(90.0f);
        a3.setType(ArcType.OPEN);
        a3.setStroke(Color.MAGENTA);
        a3.setStrokeWidth(5);
        a3.setFill(Color.TRANSPARENT);


        Arc a4 = new Arc();
        a4.setCenterX(100.0);
        a4.setCenterY(100.0);
        a4.setStartAngle(270.0);
        a4.setRadiusX(30.0);
        a4.setRadiusY(30.0);
//        a1.setStrokeWidth(500.0);
        a4.setLength(90);
        a4.setType(ArcType.OPEN);
        a4.setStroke(Color.PURPLE);
        a4.setStrokeWidth(5);
        a4.setFill(Color.TRANSPARENT);
//        Arc a1 = new Arc(100.0f, 100.0f, 100.0f, 100.0f, 0.0f, 100.0f);


        Circle c = new Circle();
        c.setCenterX(250);
        c.setCenterY(205);
        c.setFill(Color.RED);
        c.setRadius(20f);

        Image loadGameImage = new Image(new FileInputStream("images/img1.jpg"));
        ImageView viewloadGameImage = new ImageView(loadGameImage);
        viewloadGameImage.setX(50);
        viewloadGameImage.setY(25);
        viewloadGameImage.setFitHeight(455);
        viewloadGameImage.setFitWidth(500);
        viewloadGameImage.setPreserveRatio(true);

        ScaleTransition resizePic = new ScaleTransition();
        resizePic.setDuration(Duration.millis(1000));
        resizePic.setNode(viewloadGameImage);
        resizePic.setByX(.5);
        resizePic.setByY(.5);
        resizePic.setCycleCount(Integer.MAX_VALUE);
        resizePic.setAutoReverse(true);
        resizePic.play();

        final Rotate rotate1 = new Rotate(0, 100, 100);
        a1.getTransforms().add(rotate1);
        a2.getTransforms().add(rotate1);
        a3.getTransforms().add(rotate1);
        a4.getTransforms().add(rotate1);
        final Timeline rotationAnimation = new Timeline();
        rotationAnimation.getKeyFrames().add(new KeyFrame(Duration.seconds(3), new KeyValue(rotate1.angleProperty(), 360)));
        rotationAnimation.setCycleCount(Animation.INDEFINITE);
        rotationAnimation.play();

//        Group root = new Group(viewloadGameImage, c);
        Group root = new Group(a1, a2, a3, a4);
        mainScene = new Scene(root, WIDTH, HEIGHT, Color.rgb(44, 44, 44));

        mainStage.setScene(mainScene);
//		mainStage.setFullScreen(true);

    }

    public Stage getMainStage() {
        return mainStage;
    }
}
