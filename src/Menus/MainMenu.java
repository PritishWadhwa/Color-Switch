package Menus;

import javafx.animation.ScaleTransition;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MainMenu {

    private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private static final double HEIGHT = screenSize.getHeight();
    private static final double WIDTH = screenSize.getWidth() * .4;
    private AnchorPane mainPane;
    private Scene mainScene;
    private Stage mainStage;

    public MainMenu() throws FileNotFoundException {
        mainPane = new AnchorPane();
//        mainScene = new Scene(mainPane, WIDTH, HEIGHT, Color.rgb(44, 44, 44));
        mainStage = new Stage();

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

        Group root = new Group(viewloadGameImage, c);
        mainScene = new Scene(root, WIDTH, HEIGHT, Color.rgb(44, 44, 44));

        mainStage.setScene(mainScene);
//		mainStage.setFullScreen(true);

    }

    public Stage getMainStage() {
        return mainStage;
    }
}
