package Menus;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class LoadGameMenu {

    private static final double HEIGHT = 850.0;
    private static final double WIDTH = 560.0;
    private final Scene mainScene;
    private final Stage mainStage;

    public LoadGameMenu() {
        mainStage = new Stage();
        Group root = new Group();
        mainScene = new Scene(root, WIDTH, HEIGHT, Color.rgb(41, 41, 41));
        mainStage.setScene(mainScene);
    }

    public Stage getMainStage() {
        return mainStage;
    }
}
