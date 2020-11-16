package Menus;

import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.awt.*;

public class MainMenu {

    private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private static final double HEIGHT = screenSize.getHeight();
    private static final double WIDTH = screenSize.getWidth() * .4;
    private AnchorPane mainPane;
    private Scene mainScene;
    private Stage mainStage;

    public MainMenu() {
        mainPane = new AnchorPane();
        mainScene = new Scene(mainPane, WIDTH, HEIGHT, Color.rgb(44, 44, 44));
        mainStage = new Stage();
        mainStage.setScene(mainScene);
//		mainStage.setFullScreen(true);

    }

    public Stage getMainStage() {
        return mainStage;
    }
}
