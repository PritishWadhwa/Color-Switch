package Menus;

import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainMenu {

    private static final int HEIGHT = 600;
    private static final int WIDTH = 800;
    private AnchorPane mainPane;
    private Scene mainScene;
    private Stage mainStage;

    public MainMenu() {
        mainPane = new AnchorPane();
        mainScene = new Scene(mainPane, HEIGHT, WIDTH);
        mainStage = new Stage();
        mainStage.setScene(mainScene);
//		mainStage.setFullScreen(true);
    }

    public Stage getMainStage() {
        return mainStage;
    }
}
